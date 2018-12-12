package recordstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import recordstore.database.ChinookDatabase;
import recordstore.models.Album;
import recordstore.models.Artist;

public class AlbumDao {
	private ChinookDatabase db;
	
	
	public AlbumDao(ChinookDatabase db) {
		this.db = db;
	}
	
	  public Album findAlbum(long id) {
	        Connection connection = db.connect();
	        PreparedStatement statement = null;
	        ResultSet results = null;

	        try {
	            statement = connection.prepareStatement("SELECT * FROM Album WHERE AlbumId = ?");
	            statement.setLong(1, id);
	            results = statement.executeQuery();

	            if (results.next()) {
	                String title = results.getString("Title");
	                long artistid = results.getLong("ArtistID");
	                Album album = new Album(id, title, artistid);
	                return album;
	            } else {
	                return null;
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }finally {
	        	db.close(results, statement, connection);
	        }
	  }
	  
	  
	  public List<Album> findAlbumByArtist(long id) {
		  
		  ArrayList<Album> albumlist = new ArrayList<Album>();
		  
	        Connection connection = db.connect();
	        PreparedStatement statement = null;
	        ResultSet results = null;

	        try {
	            statement = connection.prepareStatement("SELECT AlbumId, Title, ArtistId FROM Album WHERE ArtistId = ?");
	            statement.setLong(1, id);
	            results = statement.executeQuery();

	            while (results.next()) {
	            	long albumid = results.getLong("AlbumId");
	                String title = results.getString("Title");
	                long artistid = results.getLong("ArtistID");
	                albumlist.add(new Album(albumid, title, artistid));
	                
	            } 
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }finally {
	        	db.close(results, statement, connection);
	        }
	        return albumlist;
	  }
	  
	  
	
	public List<Album> getAllAlbums() {
		ArrayList<Album> list = new ArrayList<Album>();
		
		// Kootaan kaikki albumit
		
		Connection connection = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM Album");
			results = statement.executeQuery();
			while (results.next()) {
				long id = results.getLong("AlbumId");
				String title = results.getString("Title");
				long artistid = results.getLong("ArtistId");
				list.add(new Album(id, title, artistid));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(results, statement, connection);
		}
		
		return list;
	}

}