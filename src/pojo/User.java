package pojo;

import java.beans.Transient;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="hib_users")
public class User 
{
	private Integer id;
	private String name,email,password,role,confirmPassword;
	private double regAmount;
	private Date date;
	private UserType usertype;
	private byte[] img;
	
	
	public User()
	{
		System.out.println("default constructor...");
	}


	public User(String name, String email, String password, String role, String confirmPassword, double regAmount,
			Date date, UserType usertype) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.confirmPassword = confirmPassword;
		this.regAmount = regAmount;
		this.date = date;
		this.usertype = usertype;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uid")
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Column(name="email",unique=true)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="pass",length=30)
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="role")
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	@Transient
	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Column(name="amount")
	public double getRegAmount() {
		return regAmount;
	}


	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="reg_date")
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	@Enumerated(EnumType.STRING)
	public UserType getUsertype() {
		return usertype;
	}


	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}

	@Lob
	public byte[] getImg() {
		return img;
	}


	public void setImg(byte[] img) {
		this.img = img;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", confirmPassword=" + confirmPassword + ", regAmount=" + regAmount + ", date=" + date + ", usertype="
				+ usertype + ", img=" + Arrays.toString(img) + "]";
	}
	
	

}
