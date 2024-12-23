package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int likecount1 = 0;
    private String lastemail = "";
    private TextView likesa;
    private TextView textd;
    private EditText email;
    private EditText password;
    private EditText confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        likesa = findViewById(R.id.likes);
        textd = findViewById(R.id.textd);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirm = findViewById(R.id.confirmp);
        Button likeButton = findViewById(R.id.likesb);
        Button unlikeButton = findViewById(R.id.likesb2);
        Button saveButton = findViewById(R.id.saveb);
        Button showParticipantButton = findViewById(R.id.button2);


        likeButton.setOnClickListener(v -> {
            likecount1++;
            updateLikesDisplay();
        });

        unlikeButton.setOnClickListener(v -> {
            if (likecount1 > 0) {
                likecount1--;
                updateLikesDisplay();
            }
        });

        saveButton.setOnClickListener(v -> {
            String email = this.email.getText().toString();
            String password = this.password.getText().toString();
            String confirmPassword = confirm.getText().toString();

            if (!email.contains("@")) {
                textd.setText("Nieprawidłowy adres e-mail");
            } else if (!password.equals(confirmPassword)) {
                textd.setText("Hasła się różnią");
            } else {
                lastemail = email;
                textd.setText("Zarejestrowano: " + email);
            }
        });

        showParticipantButton.setOnClickListener(v -> {
            if (!lastemail.isEmpty()) {
                textd.setText(lastemail);
            }
        });
    }

    private void updateLikesDisplay() {
        likesa.setText(likecount1 + " polubień");
    }
}