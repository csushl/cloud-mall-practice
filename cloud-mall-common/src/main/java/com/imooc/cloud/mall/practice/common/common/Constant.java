package com.imooc.cloud.mall.practice.common.common;

import com.google.common.collect.Sets;
import com.imooc.cloud.mall.practice.common.exception.ImoocMallException;
import com.imooc.cloud.mall.practice.common.exception.ImoocMallExceptionEnum;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 描述：     常量值
 */
@Component
public class Constant {

    public static final String IMOOC_MALL_USER = "imooc_mall_user";
    public static final String SALT = "8svbsvjkweDF,.03[";


    public interface ProductListOrderBy {

        Set<String> PRICE_ORDER_ENUM = Sets.newHashSet("price desc", "price asc");
    }

    public interface SaleStatus {

        int NOT_SALE = 0;//商品下架状态
        int SALE = 1;//商品上架状态
    }

    public interface Cart {

        Integer NOT_SELECTED = 0;//购物车未选中
        Integer SELECTED = 1;//购物车已选中
    }

    public enum OrderStatusEnum {
        CANCELED(0, "用户已取消"),
        NOT_PAID(10, "未付款"),
        PAID(20, "已付款"),
        DELIVERED(30, "已发货"),
        FINISHED(40, "交易完成");

        private String value;
        private int code;

        OrderStatusEnum(int code, String value) {
            this.value = value;
            this.code = code;
        }

        public static OrderStatusEnum codeOf(int code) {
            for (OrderStatusEnum orderStatusEnum : values()) {
                if (orderStatusEnum.getCode() == code) {
                    return orderStatusEnum;
                }
            }
            throw new ImoocMallException(ImoocMallExceptionEnum.NO_ENUM);
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_ROLE = "user_role";

    public static final Integer ADMIN_ROLE =2;
}
