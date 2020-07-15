package admin;

import java.io.Serializable;

public class AdminVo implements Serializable{
	
	private String id;
	private String password;
	private String name;

	public AdminVo(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public String toString() {
		return "\n- 관리자 " + id + "의 정보 -\n" +id+"\n"+password+"\n"+name+"\n";
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
