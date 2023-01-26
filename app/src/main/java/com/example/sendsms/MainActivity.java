package com.example.sendsms;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText phone, message;
    private Button sentbtn;
    private String phoneNo, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = findViewById(R.id.mobile_no);
        sentbtn = findViewById(R.id.sent_btn);
        message = findViewById(R.id.message);

        sentbtn.setOnClickListener(v -> {
            sendSMSMessage();
        });
    }

    private void sendSMSMessage() {
        //Getting phone number and message.
        phoneNo = phone.getText().toString();
        msg = message.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again later!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
