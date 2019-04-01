package com.retrofit_example.anddevolver.geniusplaza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;


public class CreateUserActivity extends AppCompatActivity implements View.OnClickListener{
    Button mSubmitButton;
    EditText mFirstNameText,mLastNameText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);
        mFirstNameText = (EditText)findViewById(R.id.newFirstNameEditText);
        mLastNameText = (EditText)findViewById(R.id.newLastNameEditText);
        mSubmitButton = (Button)findViewById(R.id.submitButton);
        mSubmitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.submitButton: if(validateInput()) submitUserDetails();
                break;
        }
    }
    public boolean validateInput(){
        return mFirstNameText.getText()!=null && mLastNameText.getText()!=null;
    }
    public void submitUserDetails(){
        Map<String,String> queryParams = new HashMap<>();

    }
}
