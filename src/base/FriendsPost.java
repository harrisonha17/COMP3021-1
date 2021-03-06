package base;

import java.util.Date;

public class FriendsPost extends Post{
	private User friend;
	
	public FriendsPost(Date date, String content, User friend) {
		super(date, content);
		this.friend = friend;
	}
	
	public User getFriend() {
		return friend;
	}

	public void setFriend(User friend) {
		this.friend = friend;
	}

	@Override
	public String toString(){
		return friend.toString() + '\n' + super.toString();
	}
	
	@Override
	public boolean equals(Object o){
		if( o == this )
			return true;
		if( o == null || o.getClass() != this.getClass() || !super.equals(o))
			return false;
		FriendsPost obj = (FriendsPost) o;
		return (friend.equals(obj.friend)&&super.equals((Post)o));
	}
	
	@Override
	public int hashCode(){
		final int prime = 19;
		int hashCode = 1;
		hashCode = prime * hashCode + super.hashCode();
		hashCode = prime * hashCode + ((friend == null)?0:friend.hashCode());
		return hashCode;
	}
}
