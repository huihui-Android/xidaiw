package xidaiw.index.entity.adapter;

import java.util.ArrayList;

import xidaiw.index.entity.Banner;
import xidaiw.index.entity.Product;

/**
 * Created by admin on 2017/11/6.
 *  bannerList	Array
    product	Object
 */
public class BannerAndData2 {
    private ArrayList<Banner> bannerList;
    private ArrayList<Product> product;

    public ArrayList<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(ArrayList<Banner> bannerList) {
        this.bannerList = bannerList;
    }

    public ArrayList<Product> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }
}
