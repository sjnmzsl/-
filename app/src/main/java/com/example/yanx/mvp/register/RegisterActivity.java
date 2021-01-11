package com.example.yanx.mvp.register;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylibrary.utils.RetrofitHelper;
import com.example.yanx.R;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edNameRegister;
    private EditText edPasdRegister;
    private Button btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        edNameRegister = (EditText) findViewById(R.id.ed_name_register);
        edPasdRegister = (EditText) findViewById(R.id.ed_pasd_register);
        btRegister = (Button) findViewById(R.id.bt_register);

        btRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_register:
//                HashMap<String, String> heads = new HashMap<>();
//                HashMap<String, String> map = new HashMap<>();
//                heads.put("Client-Type","ANDROID");
//                String name = edNameRegister.getText().toString();
//                String pasd = edPasdRegister.getText().toString();
//                map.put("nickname",name);
//                map.put("password",pasd);
//                RetrofitHelper.getInstance().post();
                break;
        }
    }
}