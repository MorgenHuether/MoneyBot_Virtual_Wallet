package com.example.moneybot_virtual_wallet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class friendRecyclerViewAdapter extends RecyclerView.Adapter<friendRecyclerViewAdapter.MyViewHolder>{
    // class vars
    Context context;
    ArrayList<friendModel> friendModel;

    // constructor
    public friendRecyclerViewAdapter(Context context, ArrayList<friendModel> friendModel){
        this.context = context;
        this.friendModel = friendModel;
    }// end constructor

    @NonNull
    @Override
    public friendRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.friend_list_line, parent, false);
        return new friendRecyclerViewAdapter.MyViewHolder(view); // return the view
    }// gives look to rows

    @Override
    public void onBindViewHolder(@NonNull friendRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.friend.setText(friendModel.get(position).getName());
        holder.friendOptions.setText("Pay");
    }// binding process -- assign values to rows depending on position of view

    @Override
    public int getItemCount() {
        return friendModel.size();
    }// # of items you want displayed -- helps binding process

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        // vars for row items
        TextView friend;
        Button friendOptions;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            friend = itemView.findViewById(R.id.friendName);
            friendOptions = itemView.findViewById(R.id.friendOptions);
        }
    }// similar to 'onCreate' -- grabs views from recycler view row layout
}// end friendRecyclerViewAdapter
