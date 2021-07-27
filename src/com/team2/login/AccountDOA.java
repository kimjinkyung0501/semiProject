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
				request.setAttribute("r", "회원가입 감사합니다");
			} else {
				request.setAttribute("r", "회원가입에 실패했습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "서버오류");
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
			// 실행도구로 실행

			if (rs.next()) {
				String db_pw = rs.getString("a_pw");
				System.out.println(db_pw);
				// db에서 pw 값이 잘난오는지 확인

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

					request.setAttribute("r", "안녕하세요");

					
				
					
				} else {
					request.setAttribute("r", "비밀번호가 틀립니다");

				}

			} else {
				request.setAttribute("r", "없는 아이디입니다");

			}

		} catch (Exception e) {
			request.setAttribute("R", "서버에 문제가 있습니다");
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

			System.out.println("입력된값" + id);
			System.out.println("입력된값" + pw);
			System.out.println("입력된값" + name);
			System.out.println("입력된값" + birth);

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
			pstmt.setString(5, exId); // where 절의 PK용

			System.out.println("기존의값" + exId);
			System.out.println("기존의값" + exPw);
			System.out.println("기존의값" + exName);
			System.out.println("기존의값" + exBirth);

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
				request.setAttribute("updateResult", "수정된 정보입니다!");
			} else {

				request.setAttribute("updateResult", "회원정도는 수정되지 않았습니다!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("updateResult", "서버에 오류가 있습니다!");
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
			// 여기서 실행도구 작동
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
				request.setAttribute("sr", "아이디로 검색한 결과입니다");

			} else {
				String sql = "select * from account where a_name like '%'||?||'%'";
				pstmt = con.prepareStatement(sql);
				request.setAttribute("sr", "이름으로 검색한 결과입니다");

			}

			String src = request.getParameter("search");
			System.out.println(src);

			pstmt.setString(1, src);

			rs = pstmt.executeQuery();
			// pstmt.executeQuery(); 실행한 결과를 --> rs에 담음

			accounts = new ArrayList<Account>();
			while (rs.next()) {
				a = new Account();
				// 객체에 들어있는 항목을 밑에서 하나하나 실행하고
				// array리스트에 담음 하나하나
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

			System.out.println("입력된값" + id);
			System.out.println("입력된값" + pw);
			System.out.println("입력된값" + name);
			System.out.println("입력된값" + birth);

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
			pstmt.setString(5, exId); // where 절의 PK용

			System.out.println("기존의값" + exId);
			System.out.println("기존의값" + exPw);
			System.out.println("기존의값" + exName);
			System.out.println("기존의값" + exBirth);

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
				request.setAttribute("updateResult", "수정된 정보입니다!");
			} else {

				request.setAttribute("updateResult", "회원정도는 수정되지 않았습니다!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("updateResult", "서버에 오류가 있습니다!");
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
				request.setAttribute("result", "삭제 성공");

			} else {

				request.setAttribute("result", "삭제 실패");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("result", "서버 오류");

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
				request.setAttribute("ROUP", "사유가 등록되었습니다");
			} else {
				request.setAttribute("ROUP", "사유등록에 실패했습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("ROUP", "서버오류");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public void AccountPageing(int page, HttpServletRequest request) {

		request.setAttribute("curPageNo", page);

		// 총페이지 수
		int cnt = 3; // 한페이지당 보여줄 개수
		int total = accounts.size();// 총데이터 개수 {}
 
		System.out.println("total:" + total);
		
		int pageCount = (int) Math.ceil(total / (double) cnt);
		request.setAttribute("pageCount", pageCount);

		System.out.println("pageCount : " + pageCount);
		System.out.println("page :" + page);
		
		
		
		int start = total - (cnt * (page - 1));

		
		System.out.println("start: " + start);
		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		System.out.println("end :" + end);
		// start를 계산하면 총 데이터의 계수가 나옴
		// 그숫자의 맨 마지막 부터 하나직 내려가기에 최신정보가 가장 앞에 나옴
		// 그래서 getAll에서 order dy desc 가 필요 없어짐
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