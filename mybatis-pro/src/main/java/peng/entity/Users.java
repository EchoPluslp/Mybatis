package peng.entity;

import java.util.Date;
import java.util.List;
/*
 * 地址表，一个用户包含多个地址，并由一个默认地址
 */
public class Users {
	private Integer id;// 用户id
	//!!测试自定义映射关系集合
	//private String username;// 用户名
	private String name;
	private String userpass;//用户密码
	private String nickname;// 用户昵称
	private Integer age;// 年龄
	private String gender;// 性别
	private String phone;// 手机
	private String email;// 邮箱
	private Date createTime;// 用户创建时间
	private Date updateTime;// 最后一次修改时间
	private Date lastLogin;// 最后一次登陆时间
	private Integer userStatus;//用户状态
	private String remark;// 用户描述
	private List<Address> address;
	public Integer getId() {
		return id;
	}
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Users() {
		super();
	}

	public Users(Integer id) {
		super();
		this.id = id;
	}
	public Users(String name, String userpass, String nickname, Integer age, String gender, String phone,
			String email, Date createTime, Date updateTime, Date lastLogin, Integer userStatus,String remark) {
		super();
		this.name = name;
		this.userpass = userpass;
		this.nickname = nickname;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.lastLogin = lastLogin;
		this.userStatus = userStatus;
		this.remark = remark;
	}

	public Users(Integer id, String nickname, Integer age, String gender, String email, String phone,
			String remark, Date updateTime) {
		this.id = id;
		this.nickname = nickname;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.updateTime = updateTime;
		this.remark = remark;
	}

	//为了配合动态sql语句，而创建的有ID参数构造方法
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}*/
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
}
