package com.ex.mahindratractor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private EditText userId, password; 
	private ImageButton loginButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		userId=(EditText)findViewById(R.id.userID);
		password=(EditText)findViewById(R.id.password);
		
		loginButton=(ImageButton)findViewById(R.id.loginButton);
		loginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(validateLogin()){
					Intent i=new Intent(LoginActivity.this, MainActivity.class);
					startActivity(i);
					finish();
				}
				
			}
		});
	}
	
	private boolean validateLogin(){
		if(userId.getText().toString().equals("")){
			Toast.makeText(this, "Please enter a valid user id.", Toast.LENGTH_SHORT).show();
			return false;
		}
		else if(password.getText().toString().equals("")){
			Toast.makeText(this, "Password can not be empty.", Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}
}
