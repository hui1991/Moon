package com.zhu.moon.login.ui;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zhu.moon.R;
import com.zhu.moon.base.ui.BaseActivity;
import com.zhu.moon.login.entity.LoginModel;
import com.zhu.moon.login.viewModel.LoginViewModel;
import com.zhu.moon.main.ui.MainActivity;
import com.zhu.moon.utils.StringUtils;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.login_user_name)
    EditText mEditUserName;

    @BindView(R.id.login_password)
    EditText mEditPassword;

    @BindView(R.id.login_login)
    Button mLoginButton;

    @BindView(R.id.login_user_name_delete)
    ImageView mUserNameDelete;

    @BindView(R.id.login_password_delete)
    ImageView mPasswordDelete;

    private String mUserName;

    private String mPassword;

    private LoginViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListener();
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        mViewModel.getLoginLiveData().observe(this, new Observer<LoginModel>() {
            @Override
            public void onChanged(@Nullable LoginModel loginModel) {
                if (loginModel.success.equals("true")){
                    startActivity(MainActivity.class);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,loginModel.data,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initListener(){
        mLoginButton.setOnClickListener(this);
        mUserNameDelete.setOnClickListener(this);
        mPasswordDelete.setOnClickListener(this);
        mEditUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mUserName = s.toString();
                mUserNameDelete.setVisibility(StringUtils.isEmpty(mUserName)?View.GONE:View.VISIBLE);
            }
        });
        mEditPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPassword = s.toString();
                mPasswordDelete.setVisibility(StringUtils.isEmpty(mPassword)?View.GONE:View.VISIBLE);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.login_actvity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_user_name_delete:
                mUserName = "";
                mEditUserName.setText(mUserName);
                break;
            case R.id.login_password_delete:
                mPassword = "";
                mEditPassword.setText(mPassword);
                break;
            case R.id.login_login:
                if (!StringUtils.isEmpty(mUserName)&&!StringUtils.isEmpty(mPassword)){
                    mViewModel.requestLoginData(mUserName,mPassword);
                }
                break;
        }
    }
}
