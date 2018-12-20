package com.example.luca.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class RowAdapter extends RecyclerView.Adapter {

    private ArrayList<Food> data = new ArrayList<>();
    private OnQuantityChange onQuantityChange;
    private LayoutInflater mInflater;

    public RowAdapter (Context c, ArrayList<Food> data){
        mInflater = LayoutInflater.from(c);
        this.data = data;
    }
    public interface OnQuantityChange {
        public void OnItemAdded(float price);

        public void OnItemRemoved(float price);
    }

    public void setOnQuantityChange(OnQuantityChange onQuantityChange){
        this.onQuantityChange = onQuantityChange;
    }
    public void FoodViewAdapter(Context context, ArrayList<Food> data){
        this.data = data;

    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        FoodViewHolder foodViewHolder = (FoodViewHolder)viewHolder;
        Food currentFood = data.get(i);
        foodViewHolder.productName.setText(currentFood.getName());
        foodViewHolder.productQuantity.setText(currentFood.getQuantity());
        foodViewHolder.productPrice.setText(String.valueOf(currentFood.getPrice()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView productName, productPrice, productQuantity;
        public Button addBtn, rmvBtn;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.milk);
        }

        public void setProductName(TextView productName) {
            this.productName = productName;
        }

        public void setProductPrice(TextView productPrice) {
            this.productPrice = productPrice;
        }

        public void setProductQuantity(TextView productQuantity) {
            this.productQuantity = productQuantity;
        }

        public TextView getProductName() {

            return productName;
        }

        public TextView getProductPrice() {
            return productPrice;
        }

        public TextView getProductQuantity() {
            return productQuantity;
        }

        @Override
        public void onClick(View view) {
            Food food = data.get(getAdapterPosition());
            if (view.getId() == R.id.plus1){
                food.increaseQuantity();
                notifyItemChanged(getAdapterPosition());
                onQuantityChange.OnItemAdded(food.getPrice());

            } else if (view.getId() == R.id.minus1){
                onQuantityChange.OnItemRemoved(food.getPrice());
            }
        }
    }
}




