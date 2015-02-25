package base;

public class User {
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
		info += "userId:" + getUserId();
		info += ", userName=" + getUserName();
		info += ", userEmail=" + getUserEmail();
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
		return (getUserId() == obj.getUserId() && getUserName() == obj.getUserName() && getUserEmail() == obj.getUserEmail());
	}
	
	@Override
	public int hashCode(){
		final int prime = 17;
		int hashCode = 1;
		hashCode = prime * hashCode + getUserId();
		hashCode = prime * hashCode + ((getUserName() == null)?0:getUserName().hashCode());
		hashCode = prime * hashCode + ((getUserEmail() == null)?0:getUserEmail().hashCode());
		return hashCode;
	}
}
