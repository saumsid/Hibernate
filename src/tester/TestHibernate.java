package tester;

import pojo.User;
import pojo.User.*;
import pojo.UserType;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import Dao.UserDaoImp;
import Dao.UserDaoImp.*;

import org.hibernate.SessionFactory;

public class TestHibernate 
{
	
	public static void main(String[] args)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		
		int ch;
		try (Scanner sc=new Scanner(System.in);
			SessionFactory sf=getSf())
		{
			UserDaoImp dao=new UserDaoImp();
			
			System.out.println("hibernate started...");
			
			do
		{
			System.out.println("*********");
			System.out.println("\n1. Register user \n2.UserDetails by ID \n3.List of Users \n4.user by ROLE and DATE \n5.Update User \n6.Exit");
			System.out.println("enter your choice...");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("enter user  details");
				User u=new User(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sdf.parse(sc.next()),UserType.valueOf(sc.next()) );
				System.out.println(dao.registerUser(u));
				break;
			case 2:
				System.out.println("enter the id...");
				System.out.println(dao.getUserDetails(sc.nextInt()));
				break;
			case 3:
				System.out.println("to return list of all user");
				for(User s:dao.getAllUsers())
				{
					System.out.println(s);
				}
				break;
			case 4:
				System.out.println("enter role and date");
				for(User s:dao.getSelectedUsers(sc.next(), sdf.parse(sc.next())))
				{
					System.out.println(s);
				}
				break;
			case 5:
				System.out.println("enter details to be updated");
				System.out.println(dao.updateUserDetails(sc.next(), sc.next(), sc.next(), sc.nextDouble()));
				break;
			case 6:
				System.exit(0);
				break;
			
			}
			
			}while(ch!=6);

					}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
