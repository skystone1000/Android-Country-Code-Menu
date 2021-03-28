package com.example.countrycodedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {

    private CountryCodePicker ccp;
    private TextView phoneTextView;
    private Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        listeners();
    }

    private void initializeViews(){
        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        phoneTextView = (EditText) findViewById(R.id.editTextPhone);
        sendBtn = (Button) findViewById(R.id.btnSend);
    }

    private void listeners(){
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Variable
                String code = ccp.getSelectedCountryCode();
                String country = ccp.getSelectedCountryEnglishName();
                String number = phoneTextView.getText().toString();

                // Create Toast
                Context context = getApplicationContext();
                CharSequence text = "Country - " + country + ", Value Sent: " + code + " " + number;
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}