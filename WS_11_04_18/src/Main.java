import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {

		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://10.152.200.125:5432/postgres", "postgres", "12345");
			System.out.println("Database open ok");
			
			String sql1 = "select count(*) FROM enterpreneur;";
			String sql2 = "select count(*) FROM enterpreneur WHERE city =?;";
			String sql3 = "select bus_name FROM business;";
			
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			PreparedStatement statement3 = connection.prepareStatement(sql3);
			
			statement2.setString(1, "London");
			
			ResultSet rs1 = statement1.executeQuery();
			ResultSet rs2 = statement2.executeQuery();
			ResultSet rs3 = statement3.executeQuery();
			
			while(rs1.next()) {
				int noEntrepreneurs = rs1.getInt(1);
				System.out.println("There are " + noEntrepreneurs + " entrepreneurs");
			}
			
			while(rs2.next()) {
				int noEntrepreneursFromLondon = rs2.getInt(1);
				System.out.println("There are " + noEntrepreneursFromLondon + " entrepreneurs from London");
			}
			
			while(rs3.next()) {
				String noEntrepreneursOfBusinesses = rs3.getString(1);
				System.out.println("There are " + noEntrepreneursOfBusinesses + " businesses");
			}
			
			statement1.close();
			statement2.close();
			statement3.close();
			connection.close();
			
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
			System.out.println("Database table ok");
	}
}