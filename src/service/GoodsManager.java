package service;

import org.hibernate.HibernateException;

import pojo.Goods;
import pojo.Goodsinfo;

/** 
 * @author Lucifer 
 * @date 2017��3��15�� ����4:18:25 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public interface GoodsManager {
	public boolean onSale(Goods goods,Goodsinfo goodsinfo) throws HibernateException;
	public boolean unSale(Goods goods) throws HibernateException;
}
