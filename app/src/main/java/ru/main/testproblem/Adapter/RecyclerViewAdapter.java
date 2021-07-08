package ru.main.testproblem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.main.testproblem.DatabaseClass;
import ru.main.testproblem.Model.Textmodel;
import ru.main.testproblem.Model.UserModel;
import ru.main.testproblem.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<Textmodel.Dates> dates;
    private final Context context;
    private static ClickListener clickListener;

    public RecyclerViewAdapter(List<Textmodel.Dates> dates, Context context) {
        this.dates = dates;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview,
                parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerViewHolder holder, int position) {
//        String strDatesThumb = dates.get(position).getStrDatesThumb();
//        Picasso.get().load(strDatesThumb);

        String strDatesName = dates.get(position).getIdName();
        holder.url.setText(strDatesName);

        String strDatesUrl = dates.get(position).getIdUrl();
        holder.startDate.setText(strDatesUrl);

        String strDatesStartDate = dates.get(position).getIdStartDate();
        holder.endDate.setText(strDatesStartDate);

        String strDatesEndDate = dates.get(position).getIdEndDate();
        holder.name.setText(strDatesEndDate);

        String iconview = dates.get(position).getIdIcon();
        Picasso.get().load(iconview).into(holder.iconview);

        UserModel model = new UserModel();
        model.setUrl(strDatesUrl);
        model.setStartDate(strDatesStartDate);
        model.setEndDate(strDatesEndDate);
        model.setName(strDatesName);
        DatabaseClass.getDatabase(context).getDao().insertAllData(model);

        Toast.makeText(context, "DATA SAVED", Toast.LENGTH_LONG).show();


    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        @BindView(R.id.iconview)
        ImageView iconview;

        @BindView(R.id.startDate)
        TextView startDate;

        @BindView(R.id.endDate)
        TextView endDate;

        @BindView(R.id.url)
        TextView url;

        @BindView(R.id.name)
        TextView name;

        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            clickListener.onClick(v, getAdapterPosition());

        }
    }


    public void setOnItemClickListener(ClickListener clickListener) {
        RecyclerViewAdapter.clickListener = clickListener;
    }


    public interface ClickListener {
        void onClick(View view, int position);
//        Intent intent = new Intent(, Webview.class);
//            intent.putExtra("url", url.get(position));
//            mContext.startActivity(intent);


    }


}



