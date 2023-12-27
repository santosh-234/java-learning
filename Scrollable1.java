package testpackage;
import java.sql.*;

public class Scrollable1 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "root234";
		try (Connection con = DriverManager.getConnection(url,username,password)){
			
			String sql = "select * from emp";
			
			Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = statement.executeQuery(sql);
			
			rs.first();
			
			readEmpInfo("first",rs);
			
			rs.relative(3);
			
			readEmpInfo("relative(3)",rs);
			
			rs.previous();
			
			readEmpInfo("previous",rs);
			
			rs.absolute(4);
			
			readEmpInfo("absolute(4)",rs);
			
			rs.last();
			
			readEmpInfo("last",rs);
			
			rs.relative(-2);
			
			readEmpInfo("relative(-2)",rs);

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void readEmpInfo(String position, ResultSet rs) throws SQLException{
		String empid = rs.getString("empid");
		String ename = rs.getString("empname");
		String salary = rs.getString("salary");
		
		String empInfo = "%s: %s  -  %s  -  %s\n";
		System.out.format(empInfo,position,empid,ename,salary);
	}
}
