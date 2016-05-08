package mulecart;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Main {
 
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//64.251.10.132
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password=IN$01$SRI$CI;DataBaseName=KWRI");
		System.out.println("test");
		Statement sta = conn.createStatement();
		String Sql = "select * from [dbo].[DM_FORCST_MNTH_CACHE]";
		ResultSet rs = sta.executeQuery(Sql);
		while (rs.next()) {
			System.out.println(rs.getString("txt_title"));
		}
	}
}