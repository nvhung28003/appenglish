package com.example.yuroko.appfood.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.yuroko.appfood.entity.Information;
import com.example.yuroko.appfood.R;

import java.util.ArrayList;
import java.util.List;

public class InformationAdapter  extends  RecyclerView.Adapter<InformationAdapter.ViewHolder>{
    private Context context;
    private LayoutInflater inflater;
    private List<Information> informationList;
    private OnitemClickListener onitemClickListener;
    public  InformationAdapter (Context context)
    {
        this.context = context;
        informationList =new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = inflater.inflate(R.layout.open_item_english,viewGroup,false);

        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final Information information =informationList.get(i);

        viewHolder.txtsttfirst.setText(information.getStt());
        viewHolder.txtnoidungfirst.setText(information.getNoidung());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemClickListener.OnitemClicked(information);

            }
        });

    }

    @Override
    public int getItemCount() {
        return informationList.size();
    }
     public void setOnitemClickListener(OnitemClickListener onitemClickListener)
     {
         this.onitemClickListener = onitemClickListener;
     }
    public void setInformationList(List<Information> informationList)
    {
        this.informationList = informationList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtsttfirst;
        private TextView txtnoidungfirst;
        private Button btnnext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtsttfirst = itemView.findViewById(R.id.txtsttfirst);
            txtnoidungfirst= itemView.findViewById(R.id.txtnoidungfirst );

        }
    }
   public interface OnitemClickListener
   {
       void OnitemClicked(Information information);
   }
}
