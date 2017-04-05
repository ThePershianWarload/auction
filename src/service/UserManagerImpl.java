package service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import daoImpl.UserDaoImpl;
import pojo.User;

@Service
public class UserManagerImpl implements UserManager {
    private UserDaoImpl dao;

    public UserManagerImpl() {
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

    public boolean register(User user) throws HibernateException {

        dao.saveObject(user);
        return true;
    }

    public String login(User user) throws HibernateException {
        User userSql = dao.findUser(user);
        if (userSql != null)
            if (userSql.getUser_password().equals(user.getUser_password())) {
                userSql.setSign_ip(user.getSign_ip());
                userSql.setSign_time(user.getSign_time());
                user.setUser_id(userSql.getUser_id());
                dao.updateObject(userSql);
                System.out.println("�û�" + userSql.getUser_name() + "��½�ɹ�");
                return "success";
            } else
                return "error";
        else
            return "null";
    }

    @Override
    public User findUserInfo(User user) throws HibernateException {
        // TODO Auto-generated method stub
        return dao.findUserByName(user.getUser_name());
    }

    @Override
    public boolean updateUserInfo(User user) throws HibernateException {
        // TODO Auto-generated method stub
        User userSql = dao.findUser(user);
        if (!user.getUser_password().equals(userSql.getUser_password()))
            return false;
        if (user.getUser_name() != null)
            userSql.setUser_name(user.getUser_name());
        if (user.getUser_email() != null)
            userSql.setUser_email(user.getUser_email());
        dao.updateObject(userSql);
        return false;
    }

    @Override
    public boolean updateUserPW(User user,String oldPassword) throws HibernateException {
        // TODO Auto-generated method stub
        User userSql = dao.findUser(user);
        if (!userSql.getUser_password().equals(oldPassword))
            return false;// 密码错误

        userSql.setUser_password(user.getUser_password());
        try {
            dao.updateObject(userSql);
        } catch (HibernateException e) {
            return false;
        }
        return true;
    }

    @Override
    public User findUserByName(String userName) throws HibernateException {
        User userSql = dao.findUserByName(userName);
        return userSql;
    }

	@Override
	public String adminLogin(User user) throws HibernateException {
		// TODO Auto-generated method stub
        User userSql = dao.findUser(user);
        if (userSql != null)
            if (userSql.getUser_password().equals(user.getUser_password())) {
                userSql.setSign_ip(user.getSign_ip());
                userSql.setSign_time(user.getSign_time());
                user.setUser_id(userSql.getUser_id());
                dao.updateObject(userSql);
                System.out.println("用户" + userSql.getUser_name() + "登陆成功");
                return "success";
            } else
                return "error";
        else
            return "null";
	}


}
