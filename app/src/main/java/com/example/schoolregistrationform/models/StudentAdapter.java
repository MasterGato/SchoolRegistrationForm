package com.example.schoolregistrationform.models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolregistrationform.R;
import com.example.schoolregistrationform.StudentInformation;
import com.example.schoolregistrationform.database.Instance;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cvStudent;
        private Context context;

        private TextView tvName;
        private TextView tvId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvStudent = itemView.findViewById(R.id.cv_student);
            tvName = itemView.findViewById(R.id.et_rec_name);
            tvId = itemView.findViewById(R.id.et_rec_id);
            context = itemView.getContext();
        }
    }

    private List<Student> students;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view  = layoutInflater.inflate(R.layout.layout_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = students.get(position);

        TextView name = holder.tvName;
        TextView id = holder.tvId;
        CardView cv = holder.cvStudent;

        cv.setOnClickListener(e -> {
            Intent intent = new Intent(holder.context, StudentInformation.class);
            intent.putExtra("student_id", String.valueOf(student.getStudentId()));
            holder.context.startActivity(intent);
        });

        name.setText(student.getFirstName() + " " + student.getLastName());
        id.setText(String.valueOf(student.getStudentId()));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
