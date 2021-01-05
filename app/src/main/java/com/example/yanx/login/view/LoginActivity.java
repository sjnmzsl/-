package com.example.yanx.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yanx.bean.LoginBean;
import com.example.mylibrary.base.BaseActivity;
import com.example.yanx.R;
import com.example.yanx.login.LoginContrct;
import com.example.yanx.login.presenter.LoginPresenter;
import com.example.yanx.home.view.HomeActivity;
import com.tencent.mmkv.MMKV;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContrct.ILoginView,View.OnClickListener {

    private EditText edName;
    private EditText edPasd;
    private CheckBox chebRememberPasd;
    private Button btLogin;


    @Override
    protected void initData() {

    }

    public void initView() {
        edName = (EditText) findViewById(R.id.ed_name);
        edPasd = (EditText) findViewById(R.id.ed_pasd);
        chebRememberPasd = (CheckBox) findViewById(R.id.cheb_rememberPasd);
        btLogin = (Button) findViewById(R.id.bt_login);

        btLogin.setOnClickListener(this::onClick);
        chebRememberPasd .setOnClickListener(this::onClick);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                if (TextUtils.isEmpty(edName.getText())&&TextUtils.isEmpty(edPasd.getText())){
                    Toast.makeText(this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    String name = edName.getText().toString();
                    String pasd = edPasd.getText().toString();
                    mPresenter.login(name,pasd,chebRememberPasd.isChecked());
                }
                break;
            case R.id.cheb_rememberPasd:
//                chebRememberPasd.setChecked(!chebRememberPasd.isChecked());
                break;
        }
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}