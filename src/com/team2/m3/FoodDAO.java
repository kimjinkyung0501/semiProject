package com.team2.m3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.team2.hc.DBManager;

public class FoodDAO {

	
	public static void random(HttpServletRequest request) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		Food food=null;
		Random r = new Random();
		int no = r.nextInt(30)+1;
		
		try {
			con=DBManager.connect();
			String sql = "select * from food where f_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			food= new Food();
			if (rs.next()) {
				food.setName(rs.getString("f_name"));
				food.setImg(rs.getString("f_img"));
				request.setAttribute("food", food);
			}
		} catch (Exception e) {
			
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}
}
