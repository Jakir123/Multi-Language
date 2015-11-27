package com.rfsoftlab.jakir.multi_language;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @version 1.3.0
 * @Author Jakir Hossain
 * @desc description of the class
 * @link n/a
 * @created on 26-Nov-15.
 * @updated on
 * @modified by
 * @updated on
 * @since 1.0
 */
public class Contact_Adapter extends RecyclerView.Adapter<Contact_Adapter.ContactViewHolder> {

    private ArrayList<Contact_Model> contactList;
    private Context context;
    public Contact_Adapter(Context context,ArrayList<Contact_Model> persons) {
        this.context=context;
        this.contactList =persons;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_view,parent,false);
        ContactViewHolder pvh=new ContactViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.tvPersonName.append(" "+contactList.get(position).getName());
        holder.tvPhone.append(" "+contactList.get(position).getPhone());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView tvPersonName;
        TextView tvPhone;

        public ContactViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView.findViewById(R.id.cv);
            tvPhone= (TextView) itemView.findViewById(R.id.tvPhone);
            tvPersonName= (TextView) itemView.findViewById(R.id.tvPersonName);



        }
    }
}