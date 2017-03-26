package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Goods;
import pojo.Goodsinfo;

/** 
 * @author Lucifer 
 * @date 2017��3��20�� ����8:50:31 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return
 * �������̹���  
 */
public interface AuctionProcessManager {
	//��������
	public boolean onSale(Goods goods,Goodsinfo goodsInfo) throws HibernateException;
	//��������
	public boolean joinAuction(Goods goods) throws HibernateException;
	//�鿴�����б�
	public List<?> getAuctionList(Goods goods) throws HibernateException;
}
