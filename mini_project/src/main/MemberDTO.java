package main;

public class MemberDTO {  // DB에 값을 저장하는 메서드
	
	
	String email;
	String password;
	String nickName;
	
	
	

	public String getEmail() { // DB에 이메일 받아오기
		return email;
	}
	public void setEmail(String id) { // DB에 이메일 저장
		this.email= id;
	}
	public String getPassword() {	// DB에 패스워드 받아오기
		return password;
	}
	public void setPassword(String password) {	 // DB에 패스워드 저장
		this.password = password;
	}
	public String getNickName() {	// DB에 닉네임 받아오기
		return nickName;
	}
	public void setNickName(String nickName) { // DB에 닉네임 저장
		this.nickName = nickName;
	}
	
	
}
