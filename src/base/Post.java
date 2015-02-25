package base;

import java.util.Date;

public class Post {
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
		return getDate().toString() + "\n" + getContent();
	}
	
	@Override
	public boolean equals(Object o){
		if( o == this )
			return true;
		if( o == null || o.getClass() != this.getClass() )
			return false;
		
		Post obj = (Post) o;
		return (getDate() == obj.getDate() && getContent() == obj.getContent());
	}
	
	@Override
	public int hashCode(){
		final int prime = 23;
		int hashCode = 1;
		hashCode = prime * hashCode + ((getDate() == null)?0:getDate().hashCode());
		hashCode = prime * hashCode + ((getContent() == null)?0:getContent().hashCode());
		return hashCode;
	}
	
	/**
	 * check whether this post contains some keyword
	 * @param keyword
	 * @return boolean
	 */
	public boolean contains(String keyword){
		return getContent().contains(keyword);
	}
}
