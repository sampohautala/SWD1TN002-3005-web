package recordstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import recordstore.database.ChinookDatabase;
import recordstore.models.Artist;

public class ArtistDao {
	private ChinookDatabase db;
	
	public ArtistDao(ChinookDatabase db) {
		this.db = db;
	}
	
	public List<Artist> getAllArtists() {
		ArrayList<Artist> list = new ArrayList<Artist>();
		
		// Kootaan kaikki artistit
		
		Connection connection = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM Artist ORDER BY Name ASC");
			results = statement.executeQuery();
			while (results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("Name");
				list.add(new Artist(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(results, statement, connection);
		}
		
		return list;
	}

}
