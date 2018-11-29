package recordstore.models;

public class Album {

	private long id;
	private String title;
	private long artistid;
	
	public Album(long id, String title, long artistid) {
		this.id = id;
		this.title = title;
		this.artistid = artistid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public long getId() {
		return id;
	}
	
	public long getArtistId() {
		return artistid;
	}
	
}
