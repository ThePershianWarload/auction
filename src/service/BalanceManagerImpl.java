package service;

import org.hibernate.HibernateException;

import pojo.User;

/** 
 * @author Lucifer 
 * @date 2017��3��20�� ����9:22:22 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class BalanceManagerImpl implements BalanceManager {

	@Override
	public boolean recharge(User user, Double amount) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reflect(User user, Double amount) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

}
