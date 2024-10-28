package org.xpapp.userinterface.DeadlineAppication.UI.ListDeadline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import org.xpapp.userinterface.DeadlineAppication.R;
import org.xpapp.userinterface.DeadlineAppication.model.Deadline;
import org.xpapp.userinterface.DeadlineAppication.model.DeadlineManager;

import java.util.List;

public class DeadlineAdapter extends RecyclerView.Adapter<DeadlineAdapter.ViewHolder> {

    public static NavController navController;
    private List<Deadline> deadlineList;
    private Context context;

    public DeadlineAdapter(Context context, List<Deadline> userList) {
        this.deadlineList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public DeadlineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_deadline, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull DeadlineAdapter.ViewHolder holder, int position) {
        Deadline deadline = deadlineList.get(position);
        holder.nameTextView.setText(deadline.getName());
        holder.dateTextView.setText(deadline.getDeadline().toString());
        holder.timeTextView.setText(deadline.getTimeToComplete().toString());
        holder.deadline = deadline;
    }

    @Override
    public int getItemCount() {
        return deadlineList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView dateTextView;
        public TextView timeTextView;
        public Deadline deadline;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.deadline_name);
            dateTextView = itemView.findViewById(R.id.deadline_date);
            timeTextView = itemView.findViewById(R.id.deadline_time);
        }
    }

}
