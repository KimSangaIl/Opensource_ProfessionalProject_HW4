package com.example.week4_mission_4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtMessage;
    TextView txtCount;
    Button btnSend, btnExit;
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMessage = (EditText) findViewById(R.id.edtMessage);
        txtCount = (TextView) findViewById(R.id.txtCount);
        btnSend = (Button) findViewById(R.id.btnSend);
        btnExit = (Button) findViewById(R.id.btnExit);

        edtMessage.addTextChangedListener(new TextWatcher() {
            String temp = "";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                txtCount.setText(editable.length()+"");

                if(editable.length() > 80) {
                    Toast.makeText(getApplicationContext(), "80자를 초과했습니다!", Toast.LENGTH_SHORT).show();
                    edtMessage.setText(temp);
                }
                else if(editable.length() == 80) {
                    txtCount.setTextColor(Color.RED);
                }
                else {
                    temp = editable.toString();
                    txtCount.setTextColor(Color.BLUE);
                }
                content = editable.toString();
            }

        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
                edtMessage.setText("");
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });

    }
}