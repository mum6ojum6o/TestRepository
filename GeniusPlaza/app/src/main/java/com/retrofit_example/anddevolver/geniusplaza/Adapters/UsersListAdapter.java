package com.retrofit_example.anddevolver.geniusplaza.Adapters;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.retrofit_example.anddevolver.geniusplaza.Model.User;
import com.retrofit_example.anddevolver.geniusplaza.R;
import java.util.List;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.ViewHolder> {
    private int mCurrPage;
    private List<User> mUsers;
    private Context mContext;
    public UsersListAdapter(Context context){
        this.mContext=context;
    }
    public void setUserList(List<User> users){
        this.mUsers=users;
        getItemCount();
    }
    public UsersListAdapter(List<User> user,int currPage){
        this.mCurrPage=currPage;
        this.mUsers=user;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view,mContext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setUser(mUsers.get(i));
    }

    @Override
    public int getItemCount() {
        if(mUsers!=null)
            return mUsers.size();
        return 0;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        User mUser;
        Context mContext;
        TextView mFirstNameTextView,mLastNameTextView;
        ImageView mImageView;

        public ViewHolder(View viewType,Context context){
            super(viewType);
            this.mContext=context;
            mFirstNameTextView = (TextView)viewType.findViewById(R.id.firstName);
            mLastNameTextView = (TextView)viewType.findViewById(R.id.lastName);
            mImageView = (ImageView)viewType.findViewById(R.id.imageView);

        }

        public User getUser() {
            return mUser;
        }

        public void setUser(User mUser) {
            this.mUser = mUser;
            mFirstNameTextView.setText(mUser.getmFirstName());
            mLastNameTextView.setText(mUser.getmLastName());
            Glide.with(mContext)
                    .load(mUser.getmAvatarUrl())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mImageView);
        }

        public Context getContext() {
            return mContext;
        }

        public void setContext(Context mContext) {
            this.mContext = mContext;
        }
    }
}
