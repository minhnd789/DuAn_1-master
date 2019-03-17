package com.cao.nang.duan.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cao.nang.duan.ListCategoryDrug;
import com.cao.nang.duan.model.ListListDrug;

import java.util.ArrayList;

public class ListListDrugAdapter extends RecyclerView.Adapter<ListListDrugAdapter.MyViewHolder> {
    Context context;
    ArrayList<ListListDrug> list;


    public ListListDrugAdapter(Context c, ArrayList<ListListDrug> p) {
        context = c;
        list = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       final ListListDrug listListDrug=list.get(position);
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClickItem(int pos) {
           openDetailActivity(listListDrug.getListdrug());
            }

            @Override
            public void onLongClickItem(int pos) {

            }
        });

    }
    private void openDetailActivity(String...details)
    {
        Intent i=new Intent(context, ListCategoryDrug.class);

        i.putExtra("List_drug",details[0]);

        // i.putExtra("DESC_KEY",details[1]);
        //  i.putExtra("PROP_KEY",details[2]);

        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private ItemClickListener mListener;
        TextView name, email;
        ImageView profilePic;

        // Button btn;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener((View.OnClickListener) this);


            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mListener.onClickItem(getLayoutPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            mListener.onClickItem(getLayoutPosition());
            return true;
        }

        public void setClickListener(ItemClickListener listener) {
            this.mListener = listener;
        }



    }


    public interface ItemClickListener {
        void onClickItem(int pos);

        void onLongClickItem(int pos);
    }

}
