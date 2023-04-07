package com.example.companytask;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {
    Context context;
    ArrayList<DataResponse> arrmodel;

    public MainActivityAdapter(Context context, ArrayList<DataResponse> arrmodel) {
        this.context = context;
        this.arrmodel=arrmodel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layoutrow,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(arrmodel.get(position).getName());
        holder.email.setText(arrmodel.get(position).getEmail());
        holder.body.setText(arrmodel.get(position).getBody());
        holder.postId.setText(arrmodel.get(position).getPostId().toString());

       holder.taskcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i =new Intent(context,MainActivity2.class);
                i.putExtra("name",arrmodel.get(position).getName());
                i.putExtra("email",arrmodel.get(position).getEmail());
                i.putExtra("details",arrmodel.get(position).getBody());
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|   Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrmodel.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,email,body,postId;
        CardView taskcardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
            body=itemView.findViewById(R.id.body);
            postId=itemView.findViewById(R.id.postId);
            taskcardview=itemView.findViewById(R.id.taskcardview);
        }
    }
}
