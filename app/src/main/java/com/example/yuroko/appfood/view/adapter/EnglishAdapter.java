package com.example.yuroko.appfood.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuroko.appfood.entity.English;
import com.example.yuroko.appfood.R;

import java.util.ArrayList;
import java.util.List;

public class EnglishAdapter extends RecyclerView.Adapter<EnglishAdapter.ViewHoder> {
    private Context context;
    private LayoutInflater inflater;
    private List<English> englishes;
    private OnitemClickListener onitemClickListener;

    public EnglishAdapter(Context context,List<English> englishes) {
        this.context = context;
        this.englishes = englishes;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = inflater.inflate(R.layout.item_english, viewGroup, false);

        return new ViewHoder(itemview);
    }
        @Override
        public void onBindViewHolder (@NonNull ViewHoder viewHoder,int i){
            final English english = englishes.get(i);
            Glide.with(context).load(english.getFirstAvatar())
                    .into(viewHoder.imgFirstAvatar);
            viewHoder.txttitle.setText(english.getTitle());

            viewHoder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onitemClickListener.OnitemClicked(english);
                }
            });

        }

        @Override
        public int getItemCount() {
            return englishes.size();
        }

        public void setOnitemClickListener (OnitemClickListener onitemClickListener)
        {
            this.onitemClickListener = onitemClickListener;
        }
        public void setEnglishes (List < English > englishes) {
            this.englishes = englishes;
            notifyDataSetChanged();
        }

        public class ViewHoder extends RecyclerView.ViewHolder {
            private ImageView imgFirstAvatar;
            private TextView txttitle;

            public ViewHoder(@NonNull View itemView) {
                super(itemView);
                imgFirstAvatar = itemView.findViewById(R.id.imgFirstAvatar);
                txttitle = itemView.findViewById(R.id.txtTitle);
            }
        }
        public interface OnitemClickListener {
            void OnitemClicked(English english);
        }
    }

