package com.example.tutorialchirpcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText countEditText;
    TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countEditText = findViewById(R.id.chirp_count_edview);
        resultTextView = findViewById(R.id.temp_result_tv);
        Button cTempButton = findViewById(R.id.c_temp_btn);
        Button fTempButton = findViewById(R.id.f_temp_btn);

        cTempButton.setOnClickListener(this);
        fTempButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int count = Integer.getInteger(String.valueOf(countEditText.getText()), 0);
        String result = "The approximate temperature outside is %f degree %s.";
        if (R.id.c_temp_btn == view.getId()) {
            resultTextView.setText(String.format(result, count + 40, "Fahrenheit"));
        } else {
            resultTextView.setText(String.format(result, (count / 3.0) + 4, "Celsius"));
        }
    }
}