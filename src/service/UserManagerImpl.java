package service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import daoImpl.UserDaoImpl;
import pojo.User;

@Service
public class UserManagerImpl implements UserManager{
    private UserDaoImpl dao;  

    public UserManagerImpl(){
        dao = new UserDaoImpl();
        System.out.println("UserManager IN");
    }
    
    public UserDaoImpl getDao() {
    	return dao;
	}

    public void setDao(UserDaoImpl dao) {
        this.dao = dao;
    }

    public List<User> getUsers() throws HibernateException {  
        return dao.getUsers();
    }
    
    public boolean register(User user) throws HibernateException{
    	dao.saveObject(user);
    	return true;
    }
    
    public String login(User user) throws HibernateException{
    	User userSql = dao.findUser(user);
    	if(userSql!=null)
    		if(userSql.getUser_password().equals(user.getUser_password())){
    			userSql.setSign_ip(user.getSign_ip());
    			userSql.setSign_time(user.getSign_time());
    			dao.updateObject(userSql);
    			System.out.println("�û�"+userSql.getUser_name()+"��½�ɹ�");
    			return "success";
    		}
    		else
    			return "error";
    	else
    		return "null";
    }
	
}
