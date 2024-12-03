package com.mvvm.sample.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mvvm.sample.R;
import com.mvvm.sample.adapters.UserListAdapter;
import com.mvvm.sample.data.model.User;
import com.mvvm.sample.databinding.ActivityUserListBinding;
import com.mvvm.sample.viewmodel.UserListViewModel;

import java.util.List;

public class UserListActivity extends AppCompatActivity {
    private ActivityUserListBinding binding;
    private UserListViewModel userListViewModel;
    private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        binding.userListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        userListAdapter = new UserListAdapter();
        binding.userListRecyclerView.setAdapter(userListAdapter);

        //userListViewModel = ViewModelProviders.of(this).get(UserListViewModel.class);
        userListViewModel = new ViewModelProvider(this).get(UserListViewModel.class);
        userListViewModel.getUserListLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                if (users != null) {
                    userListAdapter.setUserList(users);
                }
            }
        });
        userListViewModel.getUserList();
    }
}
