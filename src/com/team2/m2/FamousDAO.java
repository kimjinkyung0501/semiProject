package com.team2.m2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team2.hc.DBManager;
import com.team2.m4.Comment;

public class FamousDAO {
	
	private ArrayList<FamousShop> shops;
	
	private FamousDAO() {
		// TODO Auto-generated constructor stub
	}
	public static final FamousDAO FDAO = new FamousDAO();

	public static FamousDAO getFdao() {
		return FDAO;
	}



	public void Search(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DBManager.connect();
			String sql = "select * from famous_shop";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			shops = new ArrayList<FamousShop>();
			FamousShop s = null;
			while (rs.next()) {
				s = new FamousShop();
				s.setF_no(rs.getInt("f_no"));
				s.setF_name(rs.getString("f_name"));
				s.setF_place(rs.getString("f_place"));
				s.setF_text(rs.getString("f_text"));
				s.setF_img(rs.getString("f_img"));
				shops.add(s);
			}
				request.setAttribute("shops", shops);
			
				request.setAttribute("shopsSize", shops.size());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}



	public void shopDetail(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String place_name = request.getParameter("place_name");
			request.setAttribute("place_name", place_name);
			
			con = DBManager.connect();
			String sql = "select * from famous_shop where f_no = ?";
			pstmt = con.prepareStatement(sql);
			int f_no = Integer.parseInt(request.getParameter("f_no"));
			pstmt.setInt(1, f_no);
			rs = pstmt.executeQuery();
			
			FamousShop s = null;
			if (rs.next()) {
				s = new FamousShop();
				s.setF_no(rs.getInt("f_no"));
				s.setF_name(rs.getString("f_name"));
				s.setF_place(rs.getString("f_place"));
				s.setDate(rs.getDate("f_time"));
				s.setF_text(rs.getString("f_text"));
				s.setF_img(rs.getString("f_img"));
			}
				request.setAttribute("shop", s);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}



	public void update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			String path = request.getSession().getServletContext().getRealPath("img");
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			
			
			con = DBManager.connect();
			String sql = "update famous_shop set "
					+ "f_name = ?, "
					+ "f_place = ?, "
					+ "f_img = ?, "
					+ "f_text = ?, "
					+ "f_time = ? "
					+ "where f_no = ? ";
			pstmt = con.prepareStatement(sql);
			int f_no = Integer.parseInt(mr.getParameter("f_no"));
			String f_name = mr.getParameter("name");
			String f_place = mr.getParameter("place");
			String f_img = mr.getFilesystemName("img");
			String f_text = mr.getParameter("text");
			
			java.util.Date utilDate = new java.util.Date();
			Date sqlDate = new Date(utilDate.getTime());
			
			
			
			pstmt.setString(1, f_name);
			pstmt.setString(2, f_place);
			pstmt.setString(3, f_img);
			pstmt.setString(4, f_text);
			pstmt.setDate(5, sqlDate);
			pstmt.setInt(6, f_no);
			
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
		
	}


	public void showGroup(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String f_place = request.getParameter("place_name");
			request.setAttribute("f_place", f_place);
			con = DBManager.connect();
			String sql = "select * from famous_shop where f_place like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+f_place+"%");
			rs = pstmt.executeQuery();
			
			shops = new ArrayList<FamousShop>();
			FamousShop s = null;
			while (rs.next()) {
				s = new FamousShop();
				s.setF_no(rs.getInt("f_no"));
				s.setF_name(rs.getString("f_name"));
				s.setF_place(rs.getString("f_place"));
				s.setF_text(rs.getString("f_text"));
				s.setF_img(rs.getString("f_img"));
				s.setDate(rs.getDate("f_time"));
				shops.add(s);
			}
				request.setAttribute("shops", shops);
			
				request.setAttribute("shopsSize", shops.size());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		
	}



	public void searchShop(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String f_shop = request.getParameter("shop_place");
			
			con = DBManager.connect();
			String sql = "select * from famous_shop where f_place like ? or f_name like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+f_shop+"%");
			pstmt.setString(2, "%"+f_shop+"%");
			rs = pstmt.executeQuery();
			
			shops = new ArrayList<FamousShop>();
			FamousShop s = null;
			while (rs.next()) {
				s = new FamousShop();
				s.setF_no(rs.getInt("f_no"));
				s.setF_name(rs.getString("f_name"));
				s.setF_place(rs.getString("f_place"));
				s.setF_text(rs.getString("f_text"));
				s.setF_img(rs.getString("f_img"));
				s.setDate(rs.getDate("f_time"));
				shops.add(s);
			}
				request.setAttribute("shops", shops);
			
				request.setAttribute("shopsSize", shops.size());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}



	public void regShop(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			String path = request.getSession().getServletContext().getRealPath("img");
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			
			con = DBManager.connect();
			String sql = "insert into famous_shop values(shop_seq.nextval, ?, ?, sysdate, ?, ?)";
			pstmt = con.prepareStatement(sql);
			String shopName = mr.getParameter("shopName");
			String shopPlace = mr.getParameter("shopPlace");
			String shopFood = mr.getFilesystemName("shopFood");
			String shopInfo = mr.getParameter("shopInfo");
			
			pstmt.setString(1, shopName);
			pstmt.setString(2, shopPlace);
			pstmt.setString(3, shopInfo);
			pstmt.setString(4, shopFood);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
			
		}
		
	}



	public void deleteShop(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			int f_no = Integer.parseInt(request.getParameter("f_no"));
			System.out.println(f_no);
			con = DBManager.connect();
			String sql = "delete from famous_shop where f_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, f_no);
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
			
		}
		
		
	}
	public void paging(int page, HttpServletRequest request) {

		request.setAttribute("curPageNO", page);
		int cnt = 5; // 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
		int total = shops.size(); // 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
		if (total != 0) {

		int pageCount = (int) Math.ceil(total / (double) cnt);

		request.setAttribute("pageCount", pageCount);

		int start = total - (cnt * (page - 1));

		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<FamousShop> items = new ArrayList<FamousShop>();
		for (int i = start - 1; i > end; i--) {
			items.add(shops.get(i));
		}

		request.setAttribute("shops", items);
		}
	
	}


	
}
