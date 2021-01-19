package com.forbitbd.task.ui.main.buttonFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.myplayer.models.Category;
import com.forbitbd.task.R;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<Category> categoryList;
    private ButtonContract.View listener;

    public CatAdapter(Context context,ButtonContract.View listener) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.categoryList = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_cat,parent,false);
        return new CatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.bind(category);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void addCategory(Category category){
        categoryList.add(category);
        int position = categoryList.indexOf(category);
        notifyItemInserted(position);
    }

    class CatHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        MaterialButton button;

        public CatHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
            button.setOnClickListener(this);
        }

        public void bind(Category category){
            button.setText(category.getName());
        }

        @Override
        public void onClick(View v) {
            listener.catClick(categoryList.get(getAdapterPosition()));
        }
    }
}
