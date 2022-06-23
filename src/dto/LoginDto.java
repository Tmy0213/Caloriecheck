package dto;

public class LoginDto {
	private String username;
	private String pass;

	public LoginDto(){
	}

	public LoginDto(String username, String pass) {
		this.username = username;
		this.pass = pass;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void setpass(String pass) {
		this.pass= pass;
	}
	public String getUsername() {
		return this.username;
	}
	public String getPass() {
		return this.pass;
	}

}
