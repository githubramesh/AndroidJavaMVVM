package com.mvvm.sample.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mvvm.sample.R;
import com.mvvm.sample.data.model.User;
import com.mvvm.sample.databinding.UserItemViewBinding;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewHolder> {

    private List<User> userList = new ArrayList<>();

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout using Data Binding
        UserItemViewBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.user_item_view,
                parent,
                false
        );
        return new UserListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {
        // Bind the user data to the view
        User user = userList.get(position);
        holder.binding.setUser(user);

        // Use Glide to load the image
        Glide.with(holder.binding.userImageView.getContext())
                .load(user.getImageURL())
                .placeholder(R.drawable.ic_launcher_background) // Optional placeholder
                .error(R.drawable.ic_launcher_background)       // Optional error image
                .into(holder.binding.userImageView);

        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    // ViewHolder for binding
    static class UserListViewHolder extends RecyclerView.ViewHolder {
        final UserItemViewBinding binding;

        public UserListViewHolder(UserItemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
