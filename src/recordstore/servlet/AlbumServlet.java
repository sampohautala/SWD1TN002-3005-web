package recordstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recordstore.dao.AlbumDao;
import recordstore.dao.ArtistDao;
import recordstore.database.ChinookDatabase;
import recordstore.models.Album;
import recordstore.models.Artist;

@WebServlet("/album")
public class AlbumServlet extends HttpServlet {
	
	private ChinookDatabase db = new ChinookDatabase();
	private AlbumDao albumDao = new AlbumDao(db);
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		long id = Long.parseLong(req.getParameter("id"));
		Album album = albumDao.findAlbum(id);
		
		req.setAttribute("albums", album);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/album.jsp");
		dispatcher.include(req, resp);
		
	
		
	}
}

