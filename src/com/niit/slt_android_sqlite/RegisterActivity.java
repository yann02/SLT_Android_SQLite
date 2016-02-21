package com.niit.slt_android_sqlite;

import com.niit.bll.UserBll;
import com.niit.model.UserModel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	private EditText username;
	private EditText userpwd;
	private Button registerBtn;
	private Button loginBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		username=(EditText) findViewById(R.id.editText1);
		userpwd=(EditText) findViewById(R.id.editText2);
		registerBtn=(Button) findViewById(R.id.button2);
		loginBtn=(Button) findViewById(R.id.button1);
		
		loginBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(RegisterActivity.this,MainActivity.class));
				
			}
		});
		
		registerBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name=username.getText().toString().trim();
				String pwd=userpwd.getText().toString().trim();
				
				UserModel model=new UserModel();
				model.setUsername(name);
				model.setUserpwd(pwd);
				
				UserBll bll=new UserBll(RegisterActivity.this);
				bll.Register(model);
				Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
			}
		});
	}
}
