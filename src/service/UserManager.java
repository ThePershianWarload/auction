package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.User;

/** 
 * UserManager��ҵ��ӿڶ��壬
 * 
 * 
 * @author Lucifer 
 * @date 2017��3��15�� ����9:42:27 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public interface UserManager {
	public String login(User user) throws HibernateException;
	public boolean register(User user) throws HibernateException;
	public List<User> getUsers() throws HibernateException;
	public boolean recharge(User user,Double amount) throws HibernateException;
	public boolean reflect(User user,Double amount) throws HibernateException;
}
