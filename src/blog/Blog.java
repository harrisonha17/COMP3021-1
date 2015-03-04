package blog;

import base.*;

import java.util.ArrayList;

public class Blog {
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
}
