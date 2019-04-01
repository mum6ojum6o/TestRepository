package com.retrofit_example.anddevolver.geniusplaza.Networking;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.retrofit_example.anddevolver.geniusplaza.Model.APIResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private static final String TAG = "UserRepo";
    private final UserWebService mUserWebService;
    private final Executor mExecutor;

    public UserRepository(UserWebService mUserWebService, Executor mExecutor) {
        this.mUserWebService = mUserWebService;
        this.mExecutor = mExecutor;
    }

    public MutableLiveData<APIResponse> fetchFromNetwork(int page) {
        final MutableLiveData<APIResponse> data = new MutableLiveData<>();
        final List<MutableLiveData<APIResponse>> totalResponse = new ArrayList<>();
        Log.i(TAG, "");
        mUserWebService.getAllUsersInPage(page).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, final Response<APIResponse> response) {
                mExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        if (response.body() != null) {
                            Log.i(TAG, response.body().toString());
                            //data.setValue(response.body());
                            data.postValue(response.body());
                            //totalResponse.add(data);

                        }
                        //Log.i(TAG,users.toString());
                    }
                });
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Log.i(TAG, "onFailure!! " + t.getMessage());
                //Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
        return data;
    }
}