package com.example.raghu.contactsdashboard_raghunandan;

/**
 * Created by raghu on 10/5/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ContactsCallLogAdapter extends RecyclerView.Adapter<ContactsCallLogAdapter.MyViewHolder> {

    private List<Contacts> contactsList;
    private Context mContext;

    public void setContactsList(List<Contacts> list) {
        this.contactsList.addAll(list);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, number, email,total_duration,date;
        public ImageView photo;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.user_name);
            number = (TextView) view.findViewById(R.id.user_number);
            email = (TextView) view.findViewById(R.id.user_email);
            total_duration = (TextView) view.findViewById(R.id.total_duration);
            date = (TextView) view.findViewById(R.id.date);
            photo = (ImageView) view.findViewById(R.id.user_photo);
        }
    }


    public ContactsCallLogAdapter(Context context) {
        this.contactsList = new ArrayList<>();
        Log.d("Adapter size",""+contactsList.size());
        mContext =context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contacts contacts = contactsList.get(position);
        holder.name.setText(contacts.getName());
        holder.number.setText("Mobile - "+contacts.getNumber());
        if(Utils.checkNotEmpty(contacts.getEmail()))
         holder.email.setText("Email - "+contacts.getEmail());
        else
            holder.email.setVisibility(View.GONE);
        holder.total_duration.setText(Utils.timeConversion(contacts.getDuration()));
        holder.date.setText(contacts.getCallDate());
        if(Utils.checkNotEmpty(contacts.getPhoto()))
        {
            Glide.with(mContext)
                    .load(contacts.getPhoto())
                    .bitmapTransform(new CropCircleTransformation(mContext))
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.photo);

        }else
        {
            // make sure Glide doesn't load anything into this view until told otherwise
            Glide.clear(holder.photo);
            // remove the placeholder (optional); read comments below
            //viewHolder.profilePic.setImageDrawable(null);
        }


    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }
}