package br.edu.ifsp.dmo.conversormonetario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final double DOLLAR_VALUE = 5.0;

    private EditText inputEditText;
    private Button toDollarButton;
    private Button toRealButton;
    private TextView outputTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findById();
        setClick();
    }

    @Override
    public void onClick(View view) {
        if(view == toDollarButton){
            converterParaDolar();
        }else if(view == toRealButton){
            converterParaReal();
        }
    }

    private void findById(){
        inputEditText = findViewById(R.id.edittext_value);
        toDollarButton = findViewById(R.id.button_2_dollar);
        toRealButton = findViewById(R.id.button_2_real);
        outputTextView = findViewById(R.id.textview_output);
    }
    private void setClick(){
        toDollarButton.setOnClickListener(this);
        toRealButton.setOnClickListener(this);
    }

    private double leituraValor(){
        double value = 0;
        String stringValue;

        stringValue = inputEditText.getText().toString();
        try {
            value = Double.valueOf(stringValue);
        }catch (NumberFormatException exception){
            value = 0;
        }
        return value;
    }

    private void converterParaDollar(){
        double value = leituraValor();
        value = value / DOLLAR_VALUE;
        outputTextView.setText(String.valueOf(value));
    }

    private void converterParaReal(){
        double value = leituraValor();
        value *= DOLLAR_VALUE;
        outputTextView.setText(String.valueOf(value));
    }
}