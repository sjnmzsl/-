package com.example.yanx.contract;

import com.example.yanx.bean.DirectroyBean;
import com.example.yanx.bean.DirectroyDataBean;

public class DirectroyContract {
    public interface IDirectroyView{
        void getData(DirectroyDataBean bean);
        void getDirectroy(DirectroyBean bean);
    }
    public interface IDirectroyPresenter{
        void getData(String url);
        void getDirectroy();
    }
    public interface IDirectroyModel{
        void getData();
    }
}
