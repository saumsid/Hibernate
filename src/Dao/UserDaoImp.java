package Dao;

import pojo.User;
import static utils.HibernateUtils.*;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.cj.xdevapi.SessionFactory;
public class UserDaoImp implements IUserDao 
{
	
	@Override
	public String registerUser(User u)
	{
		Session hs=getSf().getCurrentSession();
		Transaction tx=hs.beginTransaction();
		
		try
		{
			Integer id=(Integer) hs.save(u);
			System.out.println("id "+id);
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return "user reg succeded with ID"+u.getId();
	}

	@Override
	public User getUserDetails(int id)
	{
		User u=null;
		Session hs=getSf().getCurrentSession();
		Transaction tx=hs.beginTransaction();
		try
		{
			u=hs.get(User.class, id);
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		
		return u;
	}

	@Override
	public List<User> getAllUsers() 
	{
		List<User> l1=null;
		String jpql="select u from User u";
		
		Session hs=getSf().getCurrentSession();
		Transaction tx=hs.beginTransaction();
		try
		{
			l1=hs.createQuery(jpql, User.class).getResultList();
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return l1;
	}

	@Override
	public List<User> getSelectedUsers(String role1, Date d1) 
	{
		List<User> l1=null;
		String jpql="select u from User u where u.role=:r1 and u.regDate=:dt";
		
		Session hs=getSf().getCurrentSession();
		Transaction tx=hs.beginTransaction();
		try
		{
			l1=hs.createNamedQuery(jpql, User.class).setParameter("r1", role1).setParameter("dt", d1).getResultList();
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		
		return l1;
	}

	@Override
	public String updateUserDetails(String email1, String pass1, String newpass, double incramt) 
	{
		String jpql="select u from User u where u.email=:e1 and e.pass=p1";
		Session hs=getSf().getCurrentSession();
		Transaction tx=hs.beginTransaction();
		try
		{
			User u=hs.createNamedQuery(jpql, User.class).setParameter("e1", email1).setParameter("p1", pass1).getSingleResult();
			u.setPassword(newpass);
			u.setRegAmount(u.getRegAmount()+incramt);
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return "user details updated...";
	}

}
