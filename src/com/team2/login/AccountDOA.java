package com.team2.login;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.team2.admin.Reasone;
import com.team2.hc.DBManager;

public class AccountDOA {

	private ArrayList<Account> accounts;

	private static final AccountDOA ADAO = new AccountDOA();

	public static AccountDOA getAdao() {

		return ADAO;
	}

	private AccountDOA() {
		// TODO Auto-generated constructor stub
	}

	public void accountJoin(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBManager.connect();

			String sql = "insert into account values (?, ?, ?,?)";
			pstmt = con.prepareStatement(sql);

			System.out.println(pstmt);

			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String birth = request.getParameter("birth");

			System.out.println(id);
			System.out.println(pw);
			System.out.println(name);
			System.out.println(birth);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, birth);

			Account a = null;
			a = new Account();

			a.setA_id(id);
			a.setA_pw(pw);
			a.setA_name(name);
			a.setA_birth(birth);

			request.setAttribute("a", a);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "ȸ������ �����մϴ�");
			} else {
				request.setAttribute("r", "ȸ�����Կ� �����߽��ϴ�");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "��������");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void idCheck(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean check = false;


		try {

			con = DBManager.connect();

			String sql = "select * from account where a_id= ?";
			pstmt = con.prepareStatement(sql);

			String id = request.getParameter("id");
			pstmt.setString(1, id);
			System.out.println(id);
			pstmt.executeQuery();
			rs = pstmt.executeQuery();
              
			check = rs.next();
			if (check == true) {
	            request.setAttribute("result", "f");
	         }else {
	            request.setAttribute("result", "t");
	         }
			request.setAttribute("id", id);
			request.setAttribute("check", check);
			System.out.println(check);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void Login(HttpServletRequest request) throws UnsupportedEncodingException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		try {

			con = DBManager.connect();
			String sql = "select * from account where a_id= ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			pstmt.executeQuery();

			rs = pstmt.executeQuery();
			// ���൵���� ����

			if (rs.next()) {
				String db_pw = rs.getString("a_pw");
				System.out.println(db_pw);
				// db���� pw ���� �߳������� Ȯ��

				if (pw.equals(db_pw)) {

					Account a = new Account();

					a.setA_name(rs.getString("a_name"));
					a.setA_id(rs.getString("a_id"));
					a.setA_pw(rs.getString("a_pw"));
					a.setA_birth(rs.getString("a_birth"));

					HttpSession hs = request.getSession();
					hs.setAttribute("accountInfo", a);
					hs.setMaxInactiveInterval(3600);

					request.setAttribute("a", a);

					request.setAttribute("r", "�ȳ��ϼ���");

					
				
					
				} else {
					request.setAttribute("r", "��й�ȣ�� Ʋ���ϴ�");

				}

			} else {
				request.setAttribute("r", "���� ���̵��Դϴ�");

			}

		} catch (Exception e) {
			request.setAttribute("R", "������ ������ �ֽ��ϴ�");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void loginCheck(HttpServletRequest request) {

		HttpSession hs = request.getSession();
		Account a = (Account) hs.getAttribute("accountInfo");

		if (a !=null) {
			
			request.setAttribute("contentPage", "home.jsp");
		}else {
			request.setAttribute("contentPage", "login/logJoin.jsp");
		}

	}

	public void Updat(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		HttpSession hs = request.getSession();

		try {

			con = DBManager.connect();
			String sql = "update account set a_id = ?, a_pw = ?, a_name = ?, a_birth = ? where a_id= ?";
			pstmt = con.prepareStatement(sql);

			String id = request.getParameter("idUP");
			String pw = request.getParameter("pwUP");
			String name = request.getParameter("nameUP");
			String birth = request.getParameter("birthUP");

			System.out.println("�ԷµȰ�" + id);
			System.out.println("�ԷµȰ�" + pw);
			System.out.println("�ԷµȰ�" + name);
			System.out.println("�ԷµȰ�" + birth);

			String exId = request.getParameter("ex_id");
			String exPw = request.getParameter("ex_pw");
			String exName = request.getParameter("ex_name");
			String exBirth = request.getParameter("ex_birth");

			Account a = new Account();
			a.setA_id(id);
			a.setA_pw(pw);
			a.setA_name(name);
			a.setA_birth(birth);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, birth);
			pstmt.setString(5, exId); // where ���� PK��

			System.out.println("�����ǰ�" + exId);
			System.out.println("�����ǰ�" + exPw);
			System.out.println("�����ǰ�" + exName);
			System.out.println("�����ǰ�" + exBirth);

			if (id.equals("")) {
				pstmt.setString(1, exId);
				a.setA_id(exId);
			}

			if (pw.equals("")) {
				pstmt.setString(2, exPw);
				a.setA_pw(exPw);

			}

			if (name.equals("")) {
				pstmt.setString(3, exName);
				a.setA_name(exName);
			}

			if (birth.equals("")) {
				pstmt.setString(4, exBirth);
				a.setA_birth(exBirth);

			}

			hs.setAttribute("accountInfo", a);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("updateResult", "������ �����Դϴ�!");
			} else {

				request.setAttribute("updateResult", "ȸ�������� �������� �ʾҽ��ϴ�!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("updateResult", "������ ������ �ֽ��ϴ�!");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void getAllUser(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DBManager.connect();
			String sql = "select * from account order by a_id";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			// ���⼭ ���൵�� �۵�
			Account a = null;

			accounts = new ArrayList<Account>();

			while (rs.next()) {

				a = new Account();
				a.setA_id(rs.getString("a_id"));
				a.setA_pw(rs.getString("a_pw"));
				a.setA_name(rs.getString("a_name"));
				a.setA_birth(rs.getString("a_birth"));

				accounts.add(a);

			}

			request.setAttribute("accounts", accounts);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void search(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account a = null;

		try {
			con = DBManager.connect();

			String way = request.getParameter("searchWay");
			// System.out.println(way);

			if (way.equalsIgnoreCase("byID")) {
				String sql = "select * from account where a_id like '%'||?||'%'";
				pstmt = con.prepareStatement(sql);
				request.setAttribute("sr", "���̵�� �˻��� ����Դϴ�");

			} else {
				String sql = "select * from account where a_name like '%'||?||'%'";
				pstmt = con.prepareStatement(sql);
				request.setAttribute("sr", "�̸����� �˻��� ����Դϴ�");

			}

			String src = request.getParameter("search");
			System.out.println(src);

			pstmt.setString(1, src);

			rs = pstmt.executeQuery();
			// pstmt.executeQuery(); ������ ����� --> rs�� ����

			accounts = new ArrayList<Account>();
			while (rs.next()) {
				a = new Account();
				// ��ü�� ����ִ� �׸��� �ؿ��� �ϳ��ϳ� �����ϰ�
				// array����Ʈ�� ���� �ϳ��ϳ�
				a.setA_id(rs.getString("a_id"));
				a.setA_pw(rs.getString("a_pw"));
				a.setA_name(rs.getString("a_name"));
				a.setA_birth(rs.getString("a_birth"));

				accounts.add(a);

			}
			request.setAttribute("accounts", accounts);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void UserInfoLoad(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account a = null;

		try {

			con = DBManager.connect();
			String sql = "select * from account where a_id=?";
			pstmt = con.prepareStatement(sql);

			String id = request.getParameter("id");
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				a = new Account();

				a.setA_id(rs.getString("a_id"));
				a.setA_pw(rs.getString("a_pw"));
				a.setA_name(rs.getString("a_name"));
				a.setA_birth(rs.getString("a_birth"));
			}

			request.setAttribute("account", a);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void ADUserInfoLoad(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			request.setCharacterEncoding("utf-8");

			con = DBManager.connect();
			String sql = "update account set a_id = ?, a_pw = ?, a_name = ?, a_birth = ? where a_id= ?";
			pstmt = con.prepareStatement(sql);

			String id = request.getParameter("adId");
			String pw = request.getParameter("adPw");
			String name = request.getParameter("adName");
			String birth = request.getParameter("adBirth");

			System.out.println("�ԷµȰ�" + id);
			System.out.println("�ԷµȰ�" + pw);
			System.out.println("�ԷµȰ�" + name);
			System.out.println("�ԷµȰ�" + birth);

			String exId = request.getParameter("ex_id");
			String exPw = request.getParameter("ex_pw");
			String exName = request.getParameter("ex_name");
			String exBirth = request.getParameter("ex_birth");

			Account a = new Account();
			a.setA_id(id);
			a.setA_pw(pw);
			a.setA_name(name);
			a.setA_birth(birth);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, birth);
			pstmt.setString(5, exId); // where ���� PK��

			System.out.println("�����ǰ�" + exId);
			System.out.println("�����ǰ�" + exPw);
			System.out.println("�����ǰ�" + exName);
			System.out.println("�����ǰ�" + exBirth);

			if (id.equals("")) {
				pstmt.setString(1, exId);
				a.setA_id(exId);
			}

			if (pw.equals("")) {
				pstmt.setString(2, exPw);
				a.setA_pw(exPw);

			}

			if (name.equals("")) {
				pstmt.setString(3, exName);
				a.setA_name(exName);
			}

			if (birth.equals("")) {
				pstmt.setString(4, exBirth);
				a.setA_birth(exBirth);

			}

			request.setAttribute("adminPage", a);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("updateResult", "������ �����Դϴ�!");
			} else {

				request.setAttribute("updateResult", "ȸ�������� �������� �ʾҽ��ϴ�!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("updateResult", "������ ������ �ֽ��ϴ�!");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void DropOut(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBManager.connect();
			String sql = "delete account where a_id=? and a_pw =?";
			pstmt = con.prepareStatement(sql);

			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			System.out.println(id);
			System.out.println(pw);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			//

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "���� ����");

			} else {

				request.setAttribute("result", "���� ����");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("result", "���� ����");

		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void UpReasone(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBManager.connect();

			String sql = "insert into dropOutReasone values (?, ?, ?,sysdate)";
			pstmt = con.prepareStatement(sql);

			System.out.println(pstmt);

			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String text = request.getParameter("reasone");

			System.out.println(id);
			System.out.println(pw);
			System.out.println(text);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, text);

			Reasone r = null;
			r = new Reasone();

			r.setR_id(id);
			r.setR_pw(pw);
			r.setR_text(text);

			request.setAttribute("RR", r);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("ROUP", "������ ��ϵǾ����ϴ�");
			} else {
				request.setAttribute("ROUP", "������Ͽ� �����߽��ϴ�");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("ROUP", "��������");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void AccountPageing(int page, HttpServletRequest request) {

		request.setAttribute("curPageNo", page);

		// �������� ��
		int cnt = 3; // ���������� ������ ����
		int total = accounts.size();// �ѵ����� ���� {}
 
		System.out.println("total:" + total);
		
		int pageCount = (int) Math.ceil(total / (double) cnt);
		request.setAttribute("pageCount", pageCount);

		System.out.println("pageCount : " + pageCount);
		System.out.println("page :" + page);
		
		
		
		int start = total - (cnt * (page - 1));

		
		System.out.println("start: " + start);
		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		System.out.println("end :" + end);
		// start�� ����ϸ� �� �������� ����� ����
		// �׼����� �� ������ ���� �ϳ��� �������⿡ �ֽ������� ���� �տ� ����
		// �׷��� getAll���� order dy desc �� �ʿ� ������
		ArrayList<Account> items = new ArrayList<Account>();
		for (int i = start - 1; i > end; i--) {

			items.add(accounts.get(i));

		}
		request.setAttribute("accounts", items);
	}
	public void LogOut(HttpServletRequest request) {
		HttpSession hs = request.getSession();
		hs.invalidate();
		
		
	}

	

}