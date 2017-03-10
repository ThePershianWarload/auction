package test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import pojo.User;
import service.UserManager;

public class HibernateTest {

    public static void main(String[] args) {
        //��ȡhibernate.cfg.xml�ļ�  
        Configuration cfg = new Configuration().configure();  

        //����SessionFactory  
        SessionFactory factory = cfg.buildSessionFactory();  

        //ȡ��session  
        Session session = null;  
        try {  
            session = factory.openSession();  
            //��������  
            session.beginTransaction();  
            User user = new User();  
            user.setUser_name("zzw"); 
            user.setUser_password("zzw");  
            user.setUser_email("123@qq.com");
            user.setUser_type(1);
            user.setRegister_time(new Timestamp(new Date().getTime()));
            user.setSign_time(new Timestamp(new Date().getTime()));
            user.setSign_ip("127.0.0.1");
            //����User����  
            session.save(user);   
            String hql = "from User";  
            Query query = session.createQuery(hql);  
            List<User> roles = query.list();
            for(int i=0;i<roles.size();i++){
                System.out.print("�����ݿ�������ݵ��û���Ϊ"+roles.get(i).getUser_name());  
            }
            //�ύ����  
            session.getTransaction().commit();  
        }catch(Exception e) {  
            e.printStackTrace();  
            //�ع�����  
            session.getTransaction().rollback();  
        }finally {  
            if (session != null) {  
                if (session.isOpen()) {  
                    //�ر�session  
                    session.close();  
                }  
            }  
        }  

    }

}