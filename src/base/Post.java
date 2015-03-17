package base;

import java.io.Serializable;
import java.util.Date;

public class Post implements Comparable<Post>, Serializable{
	private Date date;
	private String content;
	
	public Post(Date date, String content){
		this.date = date;
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString(){
		return date.toString() + "\n" + content;
	}
	
	@Override
	public boolean equals(Object o){
		if( o == this )
			return true;
		if( o == null || o.getClass() != this.getClass() )
			return false;
		
		Post obj = (Post) o;
		return (date.equals(obj.date) && content.equals(obj.content));
	}
	
	@Override
	public int hashCode(){
		final int prime = 23;
		int hashCode = 1;
		hashCode = prime * hashCode + ((date == null)?0:date.hashCode());
		hashCode = prime * hashCode + ((content == null)?0:content.hashCode());
		return hashCode;
	}
	
	/**
	 * check whether this post contains some keyword
	 * @param keyword
	 * @return boolean
	 */
	public boolean contains(String keyword){
		return content.contains(keyword);
	}
	
	@Override
	public int compareTo(Post p){
		return this.date.compareTo(p.date);
	}
}
