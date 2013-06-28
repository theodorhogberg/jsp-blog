package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Bloggpost;
import entities.Comment;


@WebServlet(value={"/", "/Postcomment", "/Postblog", "/Gotopost", "/Login", "/Logout"})
public class Blogg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Bloggpost> blogposts = new ArrayList<Bloggpost>();
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String postParam = request.getParameter("blog");
		if (null != postParam){
			for (Bloggpost pst : blogposts){
				if(pst.getId().equals(postParam)){
					List<Comment> kommentarer = pst.getComments();
					request.setAttribute("comments", kommentarer);
					request.setAttribute("postid", pst.getId());
					request.getServletContext().getRequestDispatcher("/Comment.jsp").forward(request,response);
					return;
				}
			}
		}
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		request.setCharacterEncoding("utf-8");
		String action = request.getRequestURI().replaceFirst(".*\\/", "");
		request.setAttribute("bloglist", blogposts);
		
		if("Postblog".equals(action)){
			request.setAttribute("bloglist", null);
			Date dt = new Date();
			String blogstr = request.getParameter("blogpost");
			String rubrikstr = request.getParameter("rubrik");
			if (blogstr != null || rubrikstr != null ){
				Bloggpost post = new Bloggpost(rubrikstr, blogstr, dt);
				blogposts.add(post);
			}
			request.setAttribute("bloglist", blogposts);
			request.getServletContext().getRequestDispatcher("/Blogg.jsp").forward(request,response);
			return;
		}
		
		else if ("Postcomment".equals(action)){
			//Theo!! gå och klipp dig din jävel!!
			String name = request.getParameter("name");
			String commentText = request.getParameter("comment");
			Date date = new Date();
			Comment comment = new Comment(name, commentText, date);
			String pid = (String) request.getParameter("post_id");
			
			//En array i en array som innehåller comments. Sezar fattar ingenting. En Inception array.
			Bloggpost curretBlgPost = findPostById(pid);
			List<Comment> commentlist = curretBlgPost.getComments();
			commentlist.add(comment);
			
			request.setAttribute("comments", commentlist);
			request.setAttribute("postid", curretBlgPost.getId());
			request.getServletContext().getRequestDispatcher("/Comment.jsp").forward(request,response);
			return;
		}

		else if ("Login".equals(action)){
			String namnam = (String) request.getSession().getAttribute("username");
			if (null == namnam){
				String handen = request.getParameter("username");
				request.getSession().setAttribute("username", handen);
			}
			request.getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);
			return;
		}

		else if ("Logout".equals(action)){
			request.getSession().setAttribute("username", null);
			request.getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);	
			return;
		}
				
		else {
			request.getServletContext().getRequestDispatcher("/Blogg.jsp").forward(request,response);
			return;
		}
	}
	
	public Bloggpost findPostById(String id){
		for (Bloggpost p: blogposts){
			if (p.getId().equals(id))
				return p;	
		}
		return null;
	}
	
	
}

