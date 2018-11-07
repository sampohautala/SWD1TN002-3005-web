package recordstore.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import recordstore.database.ChinookDatabase;

public class PrintTitles {
	
	public static void main(String[] args) throws SQLException {
		
		//Yhteyden avaus
		ChinookDatabase db = new ChinookDatabase();
		Connection connection = db.connect();
		
		// Muodostetaan kysely
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM Artist");
		
		// Suoritetaan kysely
		ResultSet results = statement.executeQuery();
		
		// K‰yd‰‰n tulokset l‰pi
		while (results.next()) {
			System.out.println(results.getString("Name"));
		
		}
		
		// Suljetaan kaikki resurssit
		db.close(results, statement, connection);
		
	}
	

	

}
