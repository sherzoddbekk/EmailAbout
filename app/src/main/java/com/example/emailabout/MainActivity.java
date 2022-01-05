package com.example.emailabout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextTo;
    private EditText mEditTextSubject;
    private EditText mEditTextMassage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextTo = findViewById(R.id.Edit_Adress);
        mEditTextSubject  = findViewById(R.id.Edit_Subject);
        mEditTextMassage = findViewById(R.id.Edit_Massage);

        Button buttonSend = findViewById(R.id.button_Send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailAbout();
            }
        });
    }
    void  emailAbout(){
        String recipientList  = mEditTextTo.getText().toString();
        String[] recipients = recipientList.split(",");

        String subject  = mEditTextSubject.getText().toString();
        String message = mEditTextMassage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"choose an email client"));
    }

}