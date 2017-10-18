package com.demo.simplenote.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.demo.simplenote.R;
import com.demo.simplenote.auth.AccountChecker;

/**
 * Created by mrsimple on 18/10/17.
 */
public class LoginActivity extends AppCompatActivity  {

    EditText mAccountEdit;
    EditText mPwdEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isValid = AccountChecker.isValidAccount(mAccountEdit.getText().toString()) ;
                Toast.makeText(LoginActivity.this, isValid ? "有效账户名" : "无效账户名", Toast.LENGTH_LONG).show();
                if ( isValid ) {
                    finish();
                }
            }
        });
        mAccountEdit = (EditText) findViewById(R.id.account_edit) ;
        mPwdEdit = (EditText) findViewById(R.id.pwd_edit) ;
    }
}
