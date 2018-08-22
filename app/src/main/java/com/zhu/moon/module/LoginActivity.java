package com.zhu.moon.module;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.zhu.moon.R;
import com.zhu.moon.base.BaseActivity;
import butterknife.BindView;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_user_name)
    EditText userName;

    @BindView(R.id.login_password)
    EditText password;

    @BindView(R.id.login_login)
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
}
