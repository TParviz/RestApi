package ru.main.testproblem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.main.testproblem.Model.UserModel;
import ru.main.testproblem.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Context context;
    List<UserModel> list;
    DeleteItemClicklistner deleteItemClicklistner;

    public UserAdapter(Context context, List<UserModel> list, DeleteItemClicklistner deleteItemClicklistner) {
        this.context = context;
        this.list = list;
        this.deleteItemClicklistner = deleteItemClicklistner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_get_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.url.setText(list.get(position).getUrl());
        holder.name.setText(list.get(position).getName());
        holder.startDate.setText(list.get(position).getStartDate());
        holder.endDate.setText(list.get(position).getEndDate());

//        holder.update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, UpdateData.class);
//                intent.putExtra("id", String.valueOf(list.get(position).getKey()));
//                intent.putExtra("name", String.valueOf(list.get(position).getName()));
//                intent.putExtra("url", String.valueOf(list.get(position).getUrl()));
//                intent.putExtra("startDate", String.valueOf(list.get(position).getStartDate()));
//                intent.putExtra("endDate", String.valueOf(list.get(position).getEndDate()));
//                context.startActivity(intent);
//
//            }
//        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteItemClicklistner.onItemDelete(position, list.get(position).getKey());

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, url, startDate, endDate ;
        Button update, delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            url = itemView.findViewById(R.id.url);
            name = itemView.findViewById(R.id.name);
            startDate = itemView.findViewById(R.id.startDate);
            endDate = itemView.findViewById(R.id.endDate);
            update = itemView.findViewById(R.id.updateId);
            delete = itemView.findViewById(R.id.deleteId);
        }
    }

    public interface DeleteItemClicklistner {
        void onItemDelete(int position, int id);
    }
}