package com.retrofit_example.anddevolver.geniusplaza.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.retrofit_example.anddevolver.geniusplaza.Model.APIResponse;
import com.retrofit_example.anddevolver.geniusplaza.Model.User;
import com.retrofit_example.anddevolver.geniusplaza.Networking.RetrofitInstance;
import com.retrofit_example.anddevolver.geniusplaza.Networking.UserRepository;
import com.retrofit_example.anddevolver.geniusplaza.Networking.UserWebService;

import java.util.List;
import java.util.concurrent.Executors;

public class UserViewModel extends AndroidViewModel {
    LiveData<List<User>> mUsers;
    UserRepository mUserRepository;
    public UserViewModel(@NonNull Application application) {
        super(application);
        mUserRepository= new UserRepository(RetrofitInstance.getInstance().create(UserWebService.class),
                Executors.newFixedThreadPool(3));
    }
    public MutableLiveData<APIResponse> getUsers(int page){
        return mUserRepository.fetchFromNetwork(page);
    }
}
