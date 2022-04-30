package com.example.moneybot_virtual_wallet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class transactionRecyclerViewAdapter extends RecyclerView.Adapter<transactionRecyclerViewAdapter.MyViewHolder>{
    // class vars
    Context context;
    ArrayList<transactionModel> transactionModels;

    // constructor
    public transactionRecyclerViewAdapter(Context context, ArrayList<transactionModel> transactionModels){
        this.context = context;
        this.transactionModels = transactionModels;
    }// end constructor

    @NonNull
    @Override
    public transactionRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_list_item, parent, false);
        return new transactionRecyclerViewAdapter.MyViewHolder(view); // return the view
    }// gives look to rows

    @Override
    public void onBindViewHolder(@NonNull transactionRecyclerViewAdapter.MyViewHolder holder, int position) {
        Locale locale = Locale.US;
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        String currencyText = fmt.format(transactionModels.get(position).getTransactionPrice());
        holder.transactionPrice.setText(currencyText);
        holder.transactionItem.setText(transactionModels.get(position).getTransactionLineItem());
    }// binding process -- assign values to rows depending on position of view

    @Override
    public int getItemCount() {
        return 5; // adjust size if needed
    }// # of items you want displayed -- helps binding process

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        // vars for row items
        TextView transactionItem, transactionPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            transactionItem = itemView.findViewById(R.id.itemText);
            transactionPrice = itemView.findViewById(R.id.priceText);
        }
    }// similar to 'onCreate' -- grabs views from recycler view row layout

} // end transactionRecyclerViewAdapter
