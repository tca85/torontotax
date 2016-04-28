package com.github.tca85.torontotax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txvTotal;
    private EditText edtPercentage;
    private EditText edtNumber;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        edtPercentage = (EditText) findViewById(R.id.edtPercentage);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        txvTotal = (TextView) findViewById(R.id.txvTotal);

        edtPercentage.setTag(edtPercentage.getKeyListener());
        edtPercentage.setKeyListener(null);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float percentage = Float.parseFloat(edtPercentage.getText().toString());
                float dec = percentage / 100;
                float total = Float.parseFloat(edtNumber.getText().toString()) + (dec * Float.parseFloat(edtNumber.getText().toString()));

                txvTotal.setText(Float.toString(total));
            }
        });
    }
}
