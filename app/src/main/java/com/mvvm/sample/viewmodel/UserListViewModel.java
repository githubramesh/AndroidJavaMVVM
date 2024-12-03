package com.mvvm.sample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mvvm.sample.data.model.User;
import com.mvvm.sample.data.network.APIService;
import com.mvvm.sample.data.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListViewModel extends ViewModel {
    private MutableLiveData<List<User>> userList;

    public UserListViewModel() {
        userList = new MutableLiveData<>();
    }

    public LiveData<List<User>> getUserListLiveData() {
        return userList;
    }

    public void getUserList() {
        APIService apiService = RetroInstance.getRetrofitClient()
                .create(APIService.class);

        Call<List<User>> call = apiService.getUserList();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                userList.postValue(null);
            }
        });
    }
}
