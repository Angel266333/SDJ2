import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) {

		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://10.152.212.116:5432/postgres", "postgres", "12345");
			System.out.println("Database open ok");
			
			String sql1 = "select * FROM students WHERE name = ? AND study_line = ? AND subject_id = ? AND average = ?";
			

			PreparedStatement statement1 = connection.prepareStatement(sql1);
			
			statement1.setString(1, "Angelica");
			statement1.setString(2, "Chemical Engineering and Food Technology");
			statement1.setInt(3, 34386);		
			statement1.setDouble(4, 8.10);
			
			ResultSet rs1 = statement1.executeQuery();
			
			while(rs1.next()) {
				int noAngelicas = rs1.getInt(1);
				System.out.println("There are " + noAngelicas + " Angelicas");
			}
			
			statement1.close();
			connection.close();
			
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
			System.out.println("Database table ok");
	}
}