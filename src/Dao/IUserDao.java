package Dao;

import java.util.Date;
import java.util.List;

import pojo.User;

public interface IUserDao 
{
	public String registerUser(User u);
	public User getUserDetails(int id);
	public List<User> getAllUsers();
	public List<User> getSelectedUsers(String role1,Date d1);
	public String updateUserDetails(String email1,String pass1,String newpass, double incramt);
}
