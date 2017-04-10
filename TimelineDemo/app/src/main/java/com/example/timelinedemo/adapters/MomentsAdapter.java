package com.example.timelinedemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.timelinedemo.R;
import com.example.timelinedemo.models.Moment;
import com.example.timelinedemo.models.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MomentsAdapter extends RecyclerView.Adapter<MomentsAdapter.MomentsViewHolder> {
    private List<Moment> momentList;
    private Context context;

    public MomentsAdapter(Context context, List<Moment> momentList) {
        this.context = context;
        this.momentList = momentList;
    }

    @Override
    public MomentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_moment, parent, false);
        MomentsViewHolder viewHolder = new MomentsViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MomentsViewHolder holder, int position) {
        Moment moment = momentList.get(position);
        if (moment != null) {
            holder.tvDate.setText(moment.getDate());
            holder.tvDescription.setText(moment.getDescription());
            holder.tvLocation.setText(moment.getLocation());

            Picasso.with(context)
                    .load(moment.getMediaUrl())
                    .into(holder.ivMedia);

            User user = moment.getUser();
            if (user != null) {
                Picasso.with(context)
                        .load(user.getProfileUrl())
                        .into(holder.ivProfile);
                holder.tvName.setText(user.getName());
            }
        }
    }

    @Override
    public int getItemCount() {
        return momentList.size();
    }

    public class MomentsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvDate)
        TextView tvDate;
        @BindView(R.id.tvDescription)
        TextView tvDescription;
        @BindView(R.id.ivMedia)
        ImageView ivMedia;
        @BindView(R.id.ivProfile)
        ImageView ivProfile;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvLocation)
        TextView tvLocation;
        @BindView(R.id.ivLocation)
        ImageView ivLocation;

        public MomentsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
