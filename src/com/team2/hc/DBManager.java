package com.team2.hc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//DB愿��젴 �옉�뾽�쓣 �븷�븣 留ㅻ쾲 �뿰寃곗퐫�뱶瑜� �벖 �씠�썑 �옉�뾽 �빐�샂.

//AOP
public class DBManager {

 public static Connection connect() throws NamingException, SQLException {
	 //context.xml
	 Context ctx = new InitialContext();
	 
	 //ex)�뒠釉� ���뿬�냼  Connection ���뿬�냼
	 DataSource ds = (DataSource)ctx.lookup("java:comp/env/kjk");
  return ds.getConnection();
}
 
	//�봽濡쒖젥�듃 -> 肄붾뱶 -> 諛고룷 -> �꽌鍮꾩뒪 �떆�옉 
    
	//�뒠釉� ���뿬�냼 �깮媛�. �슂泥��븯硫� 洹몄젣�꽌�빞 諛붾엺遺덇퀬 以�(湲곗〈)
 	//DB�꽌踰꾩뿉 �뿰寃� �슂泥��븯硫� 以�鍮꾪빐�넃�� 而ㅻ꽖�뀡(�뒠釉�) 諛붾줈 以�(異붽��궡�슜)
 
	
	
	//DB�옉�뾽�떆�뿏 �뼱姨껊뱺 �뿰寃� �빐�빞�맖
/*	public static Connection connect() throws SQLException {
		String url = "jdbc:oracle:thin:@10.211.55.3:1521:xe";
		try {
			return DriverManager.getConnection(url,"jy","jy");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
	public static void close(Connection con , PreparedStatement pstmt, ResultSet rs){
		
		try {
			rs.close();
		} catch (Exception e) {
		}
		
		try {
			pstmt.close();
		} catch (Exception e) {
		}
		
		try {
			con.close();
		} catch (Exception e) {
		}
	}
	
}