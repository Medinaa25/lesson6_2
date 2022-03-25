package com.example.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.button);
        EditText etFirst = findViewById(R.id.edit_text);
        EditText etSecond = findViewById(R.id.edit_text2);
        TextView textView = findViewById(R.id.text_view);
        TextView f_passord = findViewById(R.id.f_password);
        TextView vhod = findViewById(R.id.vhod);
        LinearLayout container1 = findViewById(R.id.container1);
        LinearLayout container2 = findViewById(R.id.container2);

        etFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                btn1.setBackgroundColor(getResources().getColor(R.color.gray));
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                btn1.setBackgroundColor(getResources().getColor(R.color.orange));
            }
        });

        etSecond.setTransformationMethod(new PasswordTransformationMethod());

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etFirst.getText().toString().equals("admin") && etSecond.getText().toString().equals("admin") ) {
                    Toast.makeText(MainActivity.this, "Вы вошли успешно", Toast.LENGTH_SHORT).show();
                    vhod.setVisibility(View.GONE);
                    container1.setVisibility(View.GONE);
                    container2.setVisibility(View.GONE);
                }else {
                    Toast.makeText(MainActivity.this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}