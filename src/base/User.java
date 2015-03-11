package base;

public class User implements Comparable<User>{
	private int userId;
	private String userName;
	private String userEmail;
	
	public User(int userId, String userName, String userEmail){
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Override
	public String toString(){
		String info = "User [";
		info += "userId:" + userId;
		info += ", userName=" + userName;
		info += ", userEmail=" + userEmail;
		info += "]";
		return info;
	}
	
	@Override
	public boolean equals(Object o){
		if( o == this )
			return true;
		if( o == null || o.getClass() != this.getClass() )
			return false;
		
		User obj = (User) o;
		return (userId == obj.userId && userName.equals(obj.userName) && userEmail.equals(obj.userEmail));
	}
	
	@Override
	public int hashCode(){
		final int prime = 17;
		int hashCode = 1;
		hashCode = prime * hashCode + userId;
		hashCode = prime * hashCode + ((userName == null)?0:userName.hashCode());
		hashCode = prime * hashCode + ((userEmail == null)?0:userEmail.hashCode());
		return hashCode;
	}
	
	@Override
	public int compareTo(User u){
		return (this.userId > u.userId)?1:((this.userId==u.userId)?0:-1);
	}
}
