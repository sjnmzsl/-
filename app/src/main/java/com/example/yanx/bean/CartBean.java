package com.example.yanx.bean;

import java.util.List;

public class CartBean extends Object{

    /**
     * errno : 0
     * errmsg :
     * data : {"cartList":[{"id":1911,"user_id":0,"session_id":"1","goods_id":1134032,"goods_sn":"1134032","product_id":199,"goods_name":"趣味粉彩系列记忆棉坐垫","market_price":49,"retail_price":49,"number":3,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/8b30eeb17c831eba08b97bdcb4c46a8e.png"},{"id":1919,"user_id":0,"session_id":"1","goods_id":1097014,"goods_sn":"1097014","product_id":128,"goods_name":"原素系列实木多抽柜","market_price":4199,"retail_price":4199,"number":1,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/308184b7b1965470d58b5c92e9bcc4b0.png"},{"id":1947,"user_id":0,"session_id":"1","goods_id":1009024,"goods_sn":"1009024","product_id":16,"goods_name":"日式和风懒人沙发","market_price":599,"retail_price":599,"number":10,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/149dfa87a7324e184c5526ead81de9ad.png"},{"id":1954,"user_id":0,"session_id":"1","goods_id":1127047,"goods_sn":"1127047","product_id":182,"goods_name":"趣味粉彩系列笔记本","market_price":29,"retail_price":29,"number":2,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/6c03ca93d8fe404faa266ea86f3f1e43.png"},{"id":1955,"user_id":0,"session_id":"1","goods_id":1116011,"goods_sn":"1116011","product_id":167,"goods_name":"蔓越莓曲奇 200克","market_price":36,"retail_price":36,"number":3,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/767b370d07f3973500db54900bcbd2a7.png"}],"cartTotal":{"goodsCount":19,"goodsAmount":10502,"checkedGoodsCount":6,"checkedGoodsAmount":4365}}
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
         * cartList : [{"id":1911,"user_id":0,"session_id":"1","goods_id":1134032,"goods_sn":"1134032","product_id":199,"goods_name":"趣味粉彩系列记忆棉坐垫","market_price":49,"retail_price":49,"number":3,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/8b30eeb17c831eba08b97bdcb4c46a8e.png"},{"id":1919,"user_id":0,"session_id":"1","goods_id":1097014,"goods_sn":"1097014","product_id":128,"goods_name":"原素系列实木多抽柜","market_price":4199,"retail_price":4199,"number":1,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/308184b7b1965470d58b5c92e9bcc4b0.png"},{"id":1947,"user_id":0,"session_id":"1","goods_id":1009024,"goods_sn":"1009024","product_id":16,"goods_name":"日式和风懒人沙发","market_price":599,"retail_price":599,"number":10,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/149dfa87a7324e184c5526ead81de9ad.png"},{"id":1954,"user_id":0,"session_id":"1","goods_id":1127047,"goods_sn":"1127047","product_id":182,"goods_name":"趣味粉彩系列笔记本","market_price":29,"retail_price":29,"number":2,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/6c03ca93d8fe404faa266ea86f3f1e43.png"},{"id":1955,"user_id":0,"session_id":"1","goods_id":1116011,"goods_sn":"1116011","product_id":167,"goods_name":"蔓越莓曲奇 200克","market_price":36,"retail_price":36,"number":3,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/767b370d07f3973500db54900bcbd2a7.png"}]
         * cartTotal : {"goodsCount":19,"goodsAmount":10502,"checkedGoodsCount":6,"checkedGoodsAmount":4365}
         */

        private CartTotalDTO cartTotal;
        private List<CartListDTO> cartList;

        public CartTotalDTO getCartTotal() {
            return cartTotal;
        }

        public void setCartTotal(CartTotalDTO cartTotal) {
            this.cartTotal = cartTotal;
        }

        public List<CartListDTO> getCartList() {
            return cartList;
        }

        public void setCartList(List<CartListDTO> cartList) {
            this.cartList = cartList;
        }

        public static class CartTotalDTO {
            /**
             * goodsCount : 19
             * goodsAmount : 10502
             * checkedGoodsCount : 6
             * checkedGoodsAmount : 4365
             */

            private String goodsCount;
            private String goodsAmount;
            private String checkedGoodsCount;
            private String checkedGoodsAmount;

            public String getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(String goodsCount) {
                this.goodsCount = goodsCount;
            }

            public String getGoodsAmount() {
                return goodsAmount;
            }

            public void setGoodsAmount(String goodsAmount) {
                this.goodsAmount = goodsAmount;
            }

            public String getCheckedGoodsCount() {
                return checkedGoodsCount;
            }

            public void setCheckedGoodsCount(String checkedGoodsCount) {
                this.checkedGoodsCount = checkedGoodsCount;
            }

            public String getCheckedGoodsAmount() {
                return checkedGoodsAmount;
            }

            public void setCheckedGoodsAmount(String checkedGoodsAmount) {
                this.checkedGoodsAmount = checkedGoodsAmount;
            }
        }

        public static class CartListDTO {
            @Override
            public String toString() {
                return "CartListDTO{" +
                        "id=" + id +

                        ", goods_name='" + goods_name + '\'' +

                        '}';
            }

            /**
             * id : 1911
             * user_id : 0
             * session_id : 1
             * goods_id : 1134032
             * goods_sn : 1134032
             * product_id : 199  productIds
             * goods_name : 趣味粉彩系列记忆棉坐垫
             * market_price : 49
             * retail_price : 49
             * number : 3
             * goods_specifition_name_value :
             * goods_specifition_ids :
             * checked : 0
             * list_pic_url : http://yanxuan.nosdn.127.net/8b30eeb17c831eba08b97bdcb4c46a8e.png
             */


            private Integer id;
            private Integer user_id;
            private String session_id;
            private Integer goods_id;
            private String goods_sn;
            private Integer product_id;
            private String goods_name;
            private String market_price;
            private String retail_price;
            private Integer number;
            private String goods_specifition_name_value;
            private String goods_specifition_ids;
            private Integer checked;
            private String list_pic_url;

            private boolean isDelete=false;
            public boolean isDelete() {
                return isDelete;
            }
            public void setDelete(boolean delete) {
                isDelete = delete;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getUser_id() {
                return user_id;
            }

            public void setUser_id(Integer user_id) {
                this.user_id = user_id;
            }

            public String getSession_id() {
                return session_id;
            }

            public void setSession_id(String session_id) {
                this.session_id = session_id;
            }

            public Integer getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(Integer goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public Integer getProduct_id() {
                return product_id;
            }

            public void setProduct_id(Integer product_id) {
                this.product_id = product_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getMarket_price() {
                return market_price;
            }

            public void setMarket_price(String market_price) {
                this.market_price = market_price;
            }

            public String getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(String retail_price) {
                this.retail_price = retail_price;
            }

            public Integer getNumber() {
                return number;
            }

            public void setNumber(Integer number) {
                this.number = number;
            }

            public String getGoods_specifition_name_value() {
                return goods_specifition_name_value;
            }

            public void setGoods_specifition_name_value(String goods_specifition_name_value) {
                this.goods_specifition_name_value = goods_specifition_name_value;
            }

            public String getGoods_specifition_ids() {
                return goods_specifition_ids;
            }

            public void setGoods_specifition_ids(String goods_specifition_ids) {
                this.goods_specifition_ids = goods_specifition_ids;
            }

            public Integer getChecked() {
                return checked;
            }

            public void setChecked(Integer checked) {
                this.checked = checked;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }
        }
    }
}
