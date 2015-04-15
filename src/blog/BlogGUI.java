package blog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import base.Post;
import base.User;

public class BlogGUI{
	private final int width = 600;
	private final int height = 800;
	private final int inputLimit = 140;
	
	private JFrame mainFrame;
	private JPanel userPanel, buttonPanel;
	private JLabel postLabel;
	private JTextArea postTextArea, postContent;
	private JButton refresh, post;
	private static Blog myBlog;
	
	public BlogGUI(){
		myBlog = new Blog(new User(20122206, "WKK", "kkwongar"));
	}
	
	private void initUserPanel(){
		userPanel = new JPanel(new BorderLayout());
		
		postLabel = new JLabel();
		postLabel.setText("You can still input " + inputLimit + " Characters");
		postTextArea = new JTextArea();
		postTextArea.setLineWrap(true);
		postTextArea.setWrapStyleWord(true);
		postTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		postTextArea.addKeyListener(new lengthListener());
		
		buttonPanel = new JPanel(new GridLayout(1,2));
		post = new JButton("Post");
		post.addActionListener(new postListener());
		refresh = new JButton("Refresh");
		refresh.addActionListener(new refreshListener());
		buttonPanel.add(post);
		buttonPanel.add(refresh);
		
		userPanel.add(postLabel, BorderLayout.PAGE_START);
		userPanel.add(postTextArea, BorderLayout.CENTER);
		userPanel.add(buttonPanel, BorderLayout.PAGE_END);
		
		userPanel.setVisible(true);
	}
	
	public void setWindow(){
		mainFrame = new JFrame("User");
		mainFrame.setSize(width, height);
		mainFrame.setLayout(new GridLayout(2, 1));
		
		initUserPanel();
		postContent = new JTextArea();
		postContent.setEditable(false);
		postContent.setLineWrap(true);
		postContent.setWrapStyleWord(true);
		mainFrame.add(userPanel);
		mainFrame.add(postContent);
		
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args){
		BlogGUI bloGUI = new BlogGUI();
		bloGUI.setWindow();
	}
	
	class postListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			String content = postTextArea.getText();
			if( content == null || content.length() == 0 || content.length() > 140 ){
				System.err.println("Input is empty or exceeds word limit.");
			}
			Post p = new Post(new Date(), content);
			myBlog.post(p);
			postContent.append(p.toString() + '\n');
			myBlog.save("D:/" + myBlog.getUser().getUserId() + ".blog");
		}
	}

	class refreshListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			myBlog.load("D:/" + myBlog.getUser().getUserId() + ".blog");
			ArrayList<Post> allPosts = myBlog.getAllPosts();
			postContent.setText("");
			for(Post p : allPosts){
				postContent.append(p.toString() + '\n');
			}
		}
	}
	
	class lengthListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			postLabel.setText("You can still input " + 
					(inputLimit - postTextArea.getText().length()) + " Characters");
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
		}
	}
}
