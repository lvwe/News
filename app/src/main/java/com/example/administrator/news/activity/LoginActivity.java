package com.example.administrator.news.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.news.R;

public class LoginActivity extends AppCompatActivity {
    private EditText mEdtPhone;
    private Button mBtnGetCode;
    private EditText mEdtCode;
    private Button mBtnLogin;
    private String phone;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        mEdtPhone = (EditText) findViewById(R.id.id_login_phone);
        mBtnGetCode = (Button) findViewById(R.id.id_login_getCode);
        mEdtCode = (EditText) findViewById(R.id.id_login_inputCode);
        mBtnLogin = (Button) findViewById(R.id.id_login_btnLogin);

        mBtnGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 phone = mEdtPhone.getText().toString();
                if (phone.length() == 11){

                }else {
                    Toast.makeText(LoginActivity.this, "输入正确的手机号", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = mEdtCode.getText().toString();
                if (phone.length() ==11 && code.length() > 0){

                }else {
                    Toast.makeText(LoginActivity.this, "输入数据有误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
