package recordstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recordstore.dao.ArtistDao;
import recordstore.database.ChinookDatabase;
import recordstore.models.Artist;

@WebServlet("/artists")
public class ArtistListServlet extends HttpServlet {
	
	private ChinookDatabase db = new ChinookDatabase();
	private ArtistDao artistDao = new ArtistDao(db);
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		
		List<Artist> list = artistDao.getAllArtists();
		
		for (int i=0; i < list.size(); i++) {
			Artist artist = list.get(i);
			writer.println(artist.getName());
		}
			
		writer.println("Hello");
		
	
		
	}
}


