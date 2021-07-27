package com.team2.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.team2.hc.DBManager;

public class Admin {

	private ArrayList<Reasone> reasones;
	
	private static final Admin ADAO = new Admin();
	


	public static Admin getAdao() {
		return ADAO;
	}


	



	public void getDropList(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DBManager.connect();
			String sql = "select * from dropOutReasone order by dr_date";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			Reasone r = null;

			reasones = new ArrayList<Reasone>();

			while (rs.next()) {

				r = new Reasone();
				r.setR_id(rs.getString("dr_id"));
				r.setR_pw(rs.getString("dr_pw"));
				r.setR_text(rs.getString("dr_reasone"));
				r.setR_date(rs.getString("dr_date"));

				reasones.add(r);

			}

			request.setAttribute("reasones", reasones);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		// TODO Auto-generated method stub
		
	}
	public void ReasonePageing(int page, HttpServletRequest request) {

		request.setAttribute("curPageNo", page);

		
		int cnt = 3; 
		int total = reasones.size();
		if (total != 0) {
			
		
		int pageCount = (int) Math.ceil(total / (double) cnt);
		request.setAttribute("pageCount", pageCount);

		int start = total - (cnt * (page - 1));

		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		
		ArrayList<Reasone> items = new ArrayList<Reasone>();
		for (int i = start - 1; i > end; i--) {

			items.add(reasones.get(i));

		}
		request.setAttribute("reasones", items);
	}
	}
}
