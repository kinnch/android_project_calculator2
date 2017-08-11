package com.example.tngp17_001.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String operator = "";
    private String showNum = "";
    private int sum = 0;
    private TextView tv_showNum;
    private TextView tv_operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_operator = (TextView) findViewById(R.id.tv_operator);
        tv_showNum = (TextView) findViewById(R.id.tv_shownum);
        tv_operator.setText("");
        tv_showNum.setText("");
        sum = 0;

    }

    public void buttonClicked(View v) {
        Button button = (Button) v;
        Log.d("buttonClicked", "" + button.getText());
        switch (button.getTag().toString()) {
            case "number":
//                Toast.makeText(MainActivity.this,""+ button.getText(),Toast.LENGTH_SHORT).show();
                if (operator.equals("")) {
                    Toast.makeText(MainActivity.this, "Operator must be selectd before number", Toast.LENGTH_SHORT).show();
                    break;
                }
                process(Integer.parseInt(button.getText().toString()));
                tv_showNum.setText(""+sum);

                break;
            case "operator":
//                Toast.makeText(MainActivity.this, "" + button.getText(), Toast.LENGTH_SHORT).show();
                operator=button.getText().toString();
                tv_operator.setText(operator);
                break;
            case "Clear":
//                Toast.makeText(MainActivity.this, "" + button.getText(), Toast.LENGTH_SHORT).show();
                tv_operator.setText("");
                tv_showNum.setText("");
                break;
            default:
//                Toast.makeText(MainActivity.this, "default", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void process(int input) {
        switch (operator) {
            case "+":
                sum = sum + input;
                break;
            case "-":
                sum = sum - input;
                if(sum <0 ) sum=0;
        }
    }

}
