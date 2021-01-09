package com.example.yanx.bean;

import java.util.List;

public class DeleteCartBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"cartList":[],"cartTotal":{"goodsCount":0,"goodsAmount":0,"checkedGoodsCount":0,"checkedGoodsAmount":0}}
     */

    private Integer errno;
    private String errmsg;
    private DataDTO data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        /**
         * cartList : []
         * cartTotal : {"goodsCount":0,"goodsAmount":0,"checkedGoodsCount":0,"checkedGoodsAmount":0}
         */

        private CartTotalDTO cartTotal;
        private List<?> cartList;

        public CartTotalDTO getCartTotal() {
            return cartTotal;
        }

        public void setCartTotal(CartTotalDTO cartTotal) {
            this.cartTotal = cartTotal;
        }

        public List<?> getCartList() {
            return cartList;
        }

        public void setCartList(List<?> cartList) {
            this.cartList = cartList;
        }

        public static class CartTotalDTO {
            /**
             * goodsCount : 0
             * goodsAmount : 0
             * checkedGoodsCount : 0
             * checkedGoodsAmount : 0
             */

            private Integer goodsCount;
            private Integer goodsAmount;
            private Integer checkedGoodsCount;
            private Integer checkedGoodsAmount;

            public Integer getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(Integer goodsCount) {
                this.goodsCount = goodsCount;
            }

            public Integer getGoodsAmount() {
                return goodsAmount;
            }

            public void setGoodsAmount(Integer goodsAmount) {
                this.goodsAmount = goodsAmount;
            }

            public Integer getCheckedGoodsCount() {
                return checkedGoodsCount;
            }

            public void setCheckedGoodsCount(Integer checkedGoodsCount) {
                this.checkedGoodsCount = checkedGoodsCount;
            }

            public Integer getCheckedGoodsAmount() {
                return checkedGoodsAmount;
            }

            public void setCheckedGoodsAmount(Integer checkedGoodsAmount) {
                this.checkedGoodsAmount = checkedGoodsAmount;
            }
        }
    }
}
