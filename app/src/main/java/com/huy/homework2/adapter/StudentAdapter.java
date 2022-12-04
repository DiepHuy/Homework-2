package com.huy.homework2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huy.homework2.R;
import com.huy.homework2.model.Student;
import com.huy.homework2.model.Teacher;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> mStudentList;
    private static final int STUDENT_TYPE = 2;
    private static final int TEACHER_TYPE = 1;

    public StudentAdapter(List<Object> mStudentList) {
        this.mStudentList = mStudentList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == STUDENT_TYPE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
            return new StudentViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher, parent, false);
            return new StudentAdapter.TeacherViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Object message = mStudentList.get(position);
        if (message instanceof Student) {
            return STUDENT_TYPE;
        } else {
            return TEACHER_TYPE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Object student = mStudentList.get(position);
        if (student == null) {
            return;
        }
        if (student instanceof Student) {
            if (holder instanceof StudentViewHolder) {
                ((StudentViewHolder) holder).name_student.setText("Student : " + ((Student) student).getStudent_name());
                ((StudentViewHolder) holder).email_student.setText("Email : " + ((Student) student).getEmail_student());
                ((StudentViewHolder) holder).age_student.setText("Age : " + String.valueOf(((Student) student).getAge_student()));
            }
        }

        Object teacher = mStudentList.get(position);
        if (teacher == null) {
            return;
        }
        if (teacher instanceof Teacher) {
            if (holder instanceof TeacherViewHolder) {
                ((TeacherViewHolder) holder).name_teacher.setText("Teacher : " + ((Teacher) teacher).getName());
                ((TeacherViewHolder) holder).email_teacher.setText("Email : " + ((Teacher) teacher).getEmail());
                ((TeacherViewHolder) holder).salary_teacher.setText("Salary : " + String.valueOf(((Teacher) teacher).getSalary()));
            }
        }

    }

    @Override
    public int getItemCount() {
        if (mStudentList != null) {
            return mStudentList.size();
        }
        return 0;
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        private TextView name_student, email_student, age_student;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            name_student = itemView.findViewById(R.id.name_student);
            email_student = itemView.findViewById(R.id.email_student);
            age_student = itemView.findViewById(R.id.age_student);
        }
    }

    class TeacherViewHolder extends RecyclerView.ViewHolder {
        private TextView name_teacher, email_teacher, salary_teacher;

        public TeacherViewHolder(@NonNull View itemView) {
            super(itemView);
            name_teacher = itemView.findViewById(R.id.tvName);
            email_teacher = itemView.findViewById(R.id.tvEmail);
            salary_teacher = itemView.findViewById(R.id.tvSalary);
        }
    }
}
