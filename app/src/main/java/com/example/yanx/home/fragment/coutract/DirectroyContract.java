package com.example.yanx.home.fragment.coutract;

import com.example.yanx.bean.DirectroyBean;
import com.example.yanx.bean.DetailsDataBean;

public class DirectroyContract {
    public interface IDirectroyView{
        void getData(DetailsDataBean bean);
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
