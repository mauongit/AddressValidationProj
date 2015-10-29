package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.vo.AddressVO;

public class DBUtility {
	private static Connection connection = null;

	public static Connection getConnection() throws Exception {
		/*
		 * if (connection != null) return connection; else { // Store the
		 * database URL in a string String serverName = "113.128.164.85"; String
		 * portNumber = "3306"; String sid = "XE"; String dbUrl =
		 * "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
		 * Class.forName("oracle.jdbc.driver.OracleDriver");
		 * 
		 * // set the url, username and password for the databse connection =
		 * DriverManager.getConnection(dbUrl, "system", "admin"); return
		 * connection; } }
		 */

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/address_schema","root","admin");
			System.out.println("connection successful");
			/*String query = "SELECT * FROM address";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Output"+rs);
			System.out.println(rs.getString(1));
			//ResultSetMetaData rsmd = rs.getMetaData();
			//int columnsNumber = rsmd.getColumnCount();
			AddressVO  addressVO = new AddressVO();
			Map<String, Set<AddressVO>> resultMap= new HashMap<String, Set<AddressVO>>();
			while (rs.next()) {
				addressVO.setId(rs.getString(1));
				addressVO.setAddress1(rs.getString("address"));
				
			   //resultMap.put
				
			        if (i > 1) System.out.print(",  ");
			        String columnValue = rs.getString(i);
			        System.out.print(columnValue + " " + rsmd.getColumnName(i));
			    
			    System.out.println("");
			}*/
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
					 e.printStackTrace();
		}
		return connection;
	}
	/*public static void main(String[] args) {
		System.out.println("tesat");
		try {
			getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
