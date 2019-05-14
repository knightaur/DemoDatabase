package sg.edu.rp.c346.demodatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskLayout extends ArrayAdapter{

    Context parent_context;
    int layout_id;
    ArrayList<Task>taskList;

    public TaskLayout(@NonNull Context context, int resource, @NonNull ArrayList<Task> objects) {
        super(context, resource, objects);
        this.parent_context = context;
        this.layout_id = resource;
        this.taskList = objects;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvId = rowView.findViewById(R.id.tvID);
        TextView tvDesc = rowView.findViewById(R.id.tvDesc);
        TextView tvDate = rowView.findViewById(R.id.tvDate);

        Task selected = taskList.get(position);
        tvId.setText(Integer.toString(selected.get_id()));
        tvDesc.setText(selected.getDescription());
        tvDate.setText(selected.getDate());

        return rowView;
    }
}
