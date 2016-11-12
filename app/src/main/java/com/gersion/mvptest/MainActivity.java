package com.gersion.mvptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gersion.mvptest.bean.User;
import com.gersion.mvptest.dagger2.component.DaggerPresenterComponent;
import com.gersion.mvptest.dagger2.module.PresenterModule;
import com.gersion.mvptest.presenter.Presenter;
import com.gersion.mvptest.view.ILoginView;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {

    private EditText mEtUserName;
    private EditText mEtPwd;
    private Button mLogin;
    private Button mClear;
    private ProgressBar mPbLoading;

    @Inject
    Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerPresenterComponent.builder().presenterModule(new PresenterModule(this)).build().inject(this);
        initView();
    }

    private void initView() {
        mEtUserName = (EditText) findViewById(R.id.et_userName);
        mEtPwd = (EditText) findViewById(R.id.et_pwd);
        mLogin = (Button) findViewById(R.id.login);
        mClear = (Button) findViewById(R.id.clear);
        mPbLoading = (ProgressBar) findViewById(R.id.pb_loading);

        mLogin.setOnClickListener(this);
        mClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                mPresenter.login();
                break;
            case R.id.clear:
                mPresenter.clearData();
                break;
        }
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.userName + "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUserName() {
        return mEtUserName.getText().toString();
    }

    @Override
    public String getPwd() {
        return mEtPwd.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUserName.setText("");
    }

    @Override
    public void clearPwd() {
        mEtPwd.setText("");
    }
}
