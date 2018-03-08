package xidaiw.licai.bean;

import com.google.gson.Gson;

/**
 * Created by admin on 2018/2/5.
 */

public class Loan2 {

    /**
     * carId : 1
     * cityId : 1
     * id : 159
     * productId : 230
     */

    private int carId;
    private int cityId;
    private int id;
    private int productId;

    public static Loan2 objectFromData(String str) {

        return new Gson().fromJson(str, Loan2.class);
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
