package com.mirea.klinevskayadm.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.mirea.klinevskayadm.lesson6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sharedPref = getSharedPreferences("klinevskaya_settings",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        binding.group.setText(sharedPref.getString("GROUP", "unknown"));
        binding.list.setText(sharedPref.getString("NUMBER", "unknown"));
        binding.film.setText(sharedPref.getString("FILM ", "unknown"));

        binding.btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("GROUP", String.valueOf(binding.group.getText()));
                editor.putInt("NUMBER", Integer.parseInt(String.valueOf(binding.list.getText())));
                editor.putString("FILM", String.valueOf(binding.film.getText()));
                editor.putBoolean("IS_EXCELLENT", true);
                editor.apply();
            }
        });
    }
}