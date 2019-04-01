package com.retrofit_example.anddevolver.geniusplaza;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.retrofit_example.anddevolver.geniusplaza.Adapters.UsersListAdapter;
import com.retrofit_example.anddevolver.geniusplaza.Model.APIResponse;
import com.retrofit_example.anddevolver.geniusplaza.Model.User;
import com.retrofit_example.anddevolver.geniusplaza.ViewModels.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    List<User> mUsers = new ArrayList<>();
    UserViewModel mUsersViewModel;
    RecyclerView mRecylerView;
    UsersListAdapter mAdapter;
    private static final String TAG="MainActivity";
    int mCurrPage,mTotalPages;
    Button mLeftButton,mRightButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecylerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecylerView.setHasFixedSize(true);
        mRecylerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mUsersViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        mCurrPage=1;
        mLeftButton=(Button)findViewById(R.id.prev);
        mRightButton=(Button)findViewById(R.id.next);
        mLeftButton.setOnClickListener(this);
        mRightButton.setOnClickListener(this);
        mAdapter = new UsersListAdapter(this);
        observeViewModel(mCurrPage);
    }

    public void observeViewModel(final int page){
        mUsersViewModel.getUsers(page).observe(this, new Observer<APIResponse>() {
            @Override
            public void onChanged(@Nullable final APIResponse apiResponse) {
                Log.i(TAG,"OnChanged:");
                if(apiResponse!=null){
                    if(apiResponse.getmUsers()!=null && apiResponse.getmUsers().size()>0) {
                        mCurrPage = apiResponse.getmPage();
                        mTotalPages=apiResponse.getGetmTotalPages();
                        mUsers =apiResponse.getmUsers();
                        mAdapter.setUserList(mUsers);
                        mAdapter.notifyDataSetChanged();
                        updateUI();

                    }
                    Log.i(TAG, "Observable Changed :" + mUsers.size());
                }
            }

        });
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.next:observeViewModel(++mCurrPage);break;
            case R.id.prev:observeViewModel(--mCurrPage);break;
        }
    }
    public void updateUI(){
        mRecylerView.setAdapter(mAdapter);
        if(mCurrPage==1){
            mLeftButton.setVisibility(View.INVISIBLE);
        }else if(mCurrPage==mTotalPages){
            mRightButton.setVisibility(View.INVISIBLE);
        }else{
            mLeftButton.setVisibility(View.VISIBLE);
            mRightButton.setVisibility(View.VISIBLE);
        }

    }
}
