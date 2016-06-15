import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.5:3306/test", "root", "mtokmtok");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM test");
			while (rs.next()) {
				System.out.println("USERID：" + rs.getInt(1));
				System.out.println("USERPASSWORD：" + rs.getInt(2));
			}
			rs.close();
			stmt.close();
			conn.close();
			System.exit(0);
		} catch (ClassNotFoundException e) {
			System.out.println("ドライバを読み込めませんでした");
		} catch (SQLException e) {
			System.out.println("データベース接続エラー");
			e.printStackTrace();
		}
	}
}
