package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bloggpost {
	
	private static int ID = 0;
	private String id;
	
	private String name;
	private String post;
	private Date date;
	private List<Comment> comments = new ArrayList<Comment>();
	
	public Bloggpost( String name, String post, Date date ) {
		ID++;
		setName(name);
		setPost(post);
		setDate(date);
		setId(Integer.toString(ID));
	}
	
	public void addComment(Comment com){
		comments.add(com);
	}
	
	public List<Comment> getComments(){
		return comments;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
