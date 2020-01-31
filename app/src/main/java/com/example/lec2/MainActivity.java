package com.example.lec2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView_q, textView_price, textView_total;
    Button button_min, button_plus, button_ord;
    EditText editText;
    int total_price = 0;
    CheckBox checkBox1, checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_min = findViewById(R.id.btn_min);
        button_plus = findViewById(R.id.btn_plus);
        textView_q = findViewById(R.id.text_q);
        textView_price = findViewById(R.id.text_view_price);
        editText = findViewById(R.id.edit_name);
        button_ord = findViewById(R.id.oreder_btn);
        textView_total = findViewById(R.id.price);
        checkBox1 = findViewById(R.id.checkbox_whipped);
        checkBox2 = findViewById(R.id.checkbox_chocolate);
        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = textView_q.getText().toString();
                int x = (Integer.parseInt(s) + 1);
                total_price = (x * 5);
                textView_q.setText(x + "");
                textView_price.setText((x * 5) + "");


            }
        });

        button_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s = textView_q.getText().toString();

                int x = (Integer.parseInt(s) - 1);

                if (x < 0) {
                    textView_q.setText("0");
                    textView_price.setText("0");
                } else {
                    textView_q.setText(x + "");
                    textView_price.setText((x * 5) + "");
                    total_price = (x * 5);
                }

            }
        });

        button_ord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();

                textView_total.setText(s + "\n");

                if (checkBox1.isChecked()) {
                    total_price++;
                }
                if (checkBox2.isChecked()) {
                    total_price += 2;
                }
                textView_total.setText(s + "\n" + total_price);

            }
        });


    }
}
