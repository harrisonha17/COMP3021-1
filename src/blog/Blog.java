package blog;

import base.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Blog implements Serializable{
	private User user;
	private ArrayList<Post> allPosts;
	
	/**
	 * Constructor
	 * @param user
	 */
	public Blog(User user){
		this.user = user;
		allPosts = new ArrayList<Post>();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Post> getAllPosts() {
		return allPosts;
	}

	public void setAllPosts(ArrayList<Post> allPosts) {
		this.allPosts = allPosts;
	}
	
	/**
	 * create a new post in your blog
	 * @param p
	 */
	public void post(Post p){
		if(allPosts.add(p)){
			System.out.println("A new Post:");
			System.out.println(p);
		}
	}
	
	/**
	 * list all posts in the blog
	 */
	public void list(){
		System.out.println("Current posts:");
		if( allPosts.size() == 0 ){
			System.out.println("There are no posts yet.");
		}
		for(int i = 0; i < allPosts.size(); ++i){
			System.out.println("Post[" + (i+1) + "]:" + allPosts.get(i));
		}
	}
	
	/**
	 * delete a post from the blog
	 * @param index
	 */
	public void delete(int index){
		if( index > -1 && index < allPosts.size() ){
			allPosts.remove(index);
		} else {
			System.out.println("Illegal deletion.");
		}
	}
	
	@Override
	public String toString(){
		String posts = "Current posts:";
		if( allPosts.size() == 0 ){
			return posts + "\nThere are no posts yet.";
		}
		for(int i = 0; i < allPosts.size(); ++i){
			posts += "\nPost[" + (i+1) + "]:" + allPosts.get(i);
		}
		return posts;
	}
	
	@Override
	public boolean equals(Object o){
		if( o == this )
			return true;
		if( o == null || o.getClass() != this.getClass() )
			return false;
		
		Blog obj = (Blog) o;
		return (user.equals(obj.user) && allPosts.equals(obj.allPosts));
	}
	
	@Override
	public int hashCode(){
		final int prime = 43;
		int hashCode = 1;
		hashCode = prime * hashCode + user.hashCode();
		hashCode = prime * hashCode + allPosts.hashCode();
		return hashCode;
	}
	
	public void search(int month, String someone){
		Calendar cal = Calendar.getInstance();
		for(Post p : allPosts){
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH);
			
			if( postMonth == month-1 && p.getContent().contains(someone))
				System.out.println(p);
		}
	}
	
	public void save(String filepath){
		try{
			FileOutputStream fout = new FileOutputStream(filepath);
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(this);
			oout.close();
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void load(String filepath){
		try{
			FileInputStream fin = new FileInputStream(filepath);
			ObjectInputStream oin = new ObjectInputStream(fin);
			Blog object = (Blog) oin.readObject();
			oin.close();
			setUser(object.user);
			setAllPosts(object.allPosts);
		} catch ( FileNotFoundException ex ){
			System.out.println("Wait! There is something wrong. I cannot find the file.");
		} catch ( Exception ex ){
			ex.printStackTrace();
		}
	}
}
