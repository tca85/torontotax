package com.github.tca85.torontotax;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * tca85
 * <p/>
 * Just an idiot app to calculate Toronto taxes
 */
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
                float value = Float.parseFloat(edtNumber.getText().toString());

                float total = value + ((percentage / 100) * value);

                txvTotal.setText(Float.toString(total));
            }
        });
    }
}
