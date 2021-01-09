package com.example.yanx.utils;

import com.example.yanx.bean.LoginBean;
import com.tencent.mmkv.MMKV;

import java.util.HashMap;

public class JudgeHelper {

    private static volatile JudgeHelper judgeHelper;

    public static JudgeHelper getInstance() {
        if (judgeHelper==null){
            synchronized (JudgeHelper.class){
                if (judgeHelper==null){
                    judgeHelper=new JudgeHelper();
                }
            }
        }
        return judgeHelper;
    }

    public HashMap<String,String> isHeadsEmpty(HashMap<String,String> heads){
        if (heads==null){
            heads=new HashMap<String,String>();
            MMKV mmkv = MMKV.defaultMMKV();
            LoginBean.DataDTO data = mmkv.decodeParcelable("data", LoginBean.DataDTO.class);
            String token = data.getToken();
            heads.put("X-Nideshop-Token",token);
            return heads;
        }
      return heads;
    }

}
