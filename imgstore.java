package testpackage;

import java.sql.*;
import java.io.*;

public class imgstore {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "root234";
		
		String filepath = "D:\\maharaj.jpeg";
		
		
		
		try {
			
			Connection con = DriverManager.getConnection(url,username,password);
			String sql = "insert into storeimg(name,image)values(?,?)";
			
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "Chhatrapati");
			
			FileInputStream inputStream = new FileInputStream(new File (filepath));
			statement.setBlob(2, inputStream);
			
			int row = statement.executeUpdate();
			
			if(row > 0) {
				System.out.println("Image inserted into table storeimg successfully!");
			}
			con.close();
			
		}catch(SQLException es) {
			es.getStackTrace();
		}catch(IOException es) {
			es.getStackTrace();
		}catch(Exception es) {
			es.getStackTrace();
		}
	}
}
