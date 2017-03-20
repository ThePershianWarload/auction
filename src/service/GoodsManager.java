package service;

import java.util.List;

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
	//������Ʒ
	public List<?> searchGoods(Goodsinfo goodsinfo) throws HibernateException;
	//������Ʒ��Ϣ
	public boolean updateGoodsInfo(Goods goods) throws HibernateException;
	//�鿴��Ʒ��Ϣ
	public List<?> getGoodsInfo(Goods goods) throws HibernateException;
	//�鿴������������Ʒ
	public List<?> getOnSaleGoods() throws HibernateException;
	//ɾ����Ʒ
	public boolean deleteGoods(Goods goods) throws HibernateException; 
}
