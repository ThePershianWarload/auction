package action;

import java.io.PrintWriter;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{
	
	private String contentType = "text/html;charset=utf-8";     
    public String execute() throws Exception
    {
        //ָ������������ͺͱ���  
        ServletActionContext.getResponse().setContentType(contentType);   
        //��ȡ�������Ȼ��ʹ��  
        PrintWriter out = ServletActionContext.getResponse().getWriter();   
        try{  
            //����ı���Ϣ  
            out.print("Hello World");  
            out.print("Time: " + (new Date()).getTime());   
            out.flush();  
            out.close();  
        }catch(Exception ex){  
            out.println(ex.toString());  
        }
        return SUCCESS;  
    }
}
