package action.auction;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;
import pojo.Auction;
import pojo.Goods;
import pojo.User;
import service.AuctionProcessManagerImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

/**
 *
 *
 * *   出价
 *
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��15�� ����4:32:02
 * @parameter
 * @return
 */

@Controller
public class UserAuctionAction implements Action, SessionAware {
    private int goods_id;
    private Map<String, Object> seesion;
    private double price;

    private String id;//json
    private String amt;//json
    private InputStream inputStream;


    private User user;
    private Goods goods;
    private Auction auction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public AuctionProcessManagerImpl getAuctionProcessManager() {
        return auctionProcessManager;
    }

    public void setAuctionProcessManager(AuctionProcessManagerImpl auctionProcessManager) {
        this.auctionProcessManager = auctionProcessManager;
    }

    private AuctionProcessManagerImpl auctionProcessManager;

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public Map<String, Object> getSeesion() {
        return seesion;
    }

    public void setSeesion(Map<String, Object> seesion) {
        this.seesion = seesion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        setGoods_id(Integer.parseInt(getId()));
        setPrice(Double.parseDouble(getAmt()));

        user = new User();
        goods = new Goods();
        auction = new Auction();
//        user.setUser_id(Integer.parseInt(seesion.get("USER_ID").toString()));
        user.setUser_id(1);//test
        goods.setGoods_id(getGoods_id());
//        if (auctionProcessManager.checkMargin(user, goods)) {
//            //判断是否缴纳保证金
//            inputStream = new ByteArrayInputStream("请先缴纳押金！".getBytes("UTF-8"));
//            return SUCCESS;
//        } else {
            auction.setGoods_id(goods_id);
            auction.setPrice(price);
            if (auctionProcessManager.joinAuction(user, goods, auction)) {
                inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
            } else {
                inputStream = new ByteArrayInputStream("出价失败！".getBytes("UTF-8"));
            }
//        }
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.seesion = map;
    }
}
