package base;

import java.util.Comparator;

public class PostSortByContentLength implements Comparator<Post>{
	@Override
	public int compare(Post p1, Post p2){
		return (p1.getContent().length() > p2.getContent().length())?1:((p1.getContent().length()==p2.getContent().length())?0:-1);
	}
}
