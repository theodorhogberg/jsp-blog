package entities;

import java.util.Date;

public class Comment {

	private String name;
	private String comment;
	private Date date;
		
	public Comment( String name, String comment, Date date ) {
		setName(name);
		setComment(comment);
		setDate(date);
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
