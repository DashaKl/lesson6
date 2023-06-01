package com.mirea.klinevskayadm.employeedb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import com.mirea.klinevskayadm.employeedb.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDataBase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();

        binding.findById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee;
                employee = employeeDao.getById(Long.parseLong(String.valueOf(binding.id.getText())));
                binding.Name.setText(employee.getName());
                binding.salary.setText(employee.getSalary());
            }
        });

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee = new Employee();
                employee.id = Long.parseLong(String.valueOf(binding.id.getText()));
                employee.name = String.valueOf(binding.Name.getText());
                employee.salary = Integer.parseInt(String.valueOf(binding.salary.getText()));
                employeeDao.insert(employee);
            }
        });
    }
}