package test;

import java.io.*;
import java.util.Date;

import base.*;
import blog.*;

public class TestBlog {
	public String getInput(){
		String line = "";
		System.out.println("Enter the prompt:");
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		} catch (IOException e){
			e.printStackTrace();
		}
		return line;
	}
	
	public static void main(String[] args){
		TestBlog testBlog = new TestBlog();
		User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		Blog myblog = new Blog(user);
		String prompt = null;
		
		while(!(prompt = testBlog.getInput()).equals("exit")){
			if(prompt.startsWith("list")){
				myblog.list();
			}
			else if(prompt.startsWith("post ")){
				Date date = new Date();
				String content = prompt.substring(5);
				
				Post post = new Post(date,content);
				myblog.post(post);
			}
			else if(prompt.startsWith("delete ")){
				int index = Integer.parseInt(prompt.substring(7));
				myblog.delete((index-1));
			}
			else if (prompt.equals("help")){
				System.out.println("\"list\" : list all posts in blog.");
				System.out.println("\"post \" + content: post a new post.");
				System.out.println("\"delete \" + index: delete the post having index.");
			}
			else{
				System.out.println("Illegal command. Try \"help\" for help.");
			}
		}
	}
}
