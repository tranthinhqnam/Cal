package com.example.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resultTextView;
    private Button buttonClear, buttonDivide, buttonMultiply, buttonSubtract, buttonAdd,
            buttonNine, buttonEight, buttonSeven, buttonSix, buttonFive, buttonFour,
            buttonThree, buttonTwo, buttonOne, buttonZero, buttonEqual;

    private String currentText = "";
    private float currentNumber = 0;
    private float result = 0;
    private String currentOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView
                // Thiết lập các button
                buttonClear = findViewById(R.id.buttonClear);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonNine = findViewById(R.id.buttonNine);
        buttonEight = findViewById(R.id.buttonEight);
        buttonSeven = findViewById(R.id.buttonSeven);
        buttonSix = findViewById(R.id.buttonSix);
        buttonFive = findViewById(R.id.buttonFive);
        buttonFour = findViewById(R.id.buttonFour);
        buttonThree = findViewById(R.id.buttonThree);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonOne = findViewById(R.id.buttonOne);
        buttonZero = findViewById(R.id.buttonZero);
        buttonEqual = findViewById(R.id.buttonEqual);

        // Đăng ký sự kiện cho các button
        buttonClear.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonNine.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonSeven.setOnClickListener(this);
        buttonSix.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonOne.setOnClickListener(this);
        buttonZero.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
    }

    // Xử lý sự kiện khi người dùng nhấn một button
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonClear:
                currentText = "";
                currentNumber = 0;
                result = 0;
                currentOperator = "";
                break;
            case R.id.buttonDivide:
                if (!currentText.equals("")) {
                    currentNumber = Float.parseFloat(currentText);
                    currentText = "";
                    currentOperator = "/";
                }
                break;
            case R.id.buttonMultiply:
                if (!currentText.equals("")) {
                    currentNumber = Float.parseFloat(currentText);
                    currentText = "";
                    currentOperator = "*";
                }
                break;
            case R.id.buttonSubtract:
                if (!currentText.equals("")) {
                    currentNumber = Float.parseFloat(currentText);
                    currentText = "";
                    currentOperator = "-";
                }
                break;
            case R.id.buttonAdd:
                if (!currentText.equals("")) {
                    currentNumber = Float.parseFloat(currentText);
                    currentText = "";
                    currentOperator = "+";
                }
                break;
            case R.id.buttonNine:
                currentText += "9";
                break;
            case R.id.buttonEight:
                currentText += "8";
                break;
            case R.id.buttonSeven:
                currentText += "7";
                break;
            case R.id.buttonSix:
                currentText += "6";
                break;
            case R.id.buttonFive:
                currentText += "5";
                break;
            case R.id.buttonFour:
                currentText += "4";
                break;
            case R.id.buttonThree:
                currentText += "3";
                break;
            case R.id.buttonTwo:
                currentText += "2";
                break;
            case R.id.buttonOne:
                currentText += "1";
                break;
            case R.id.buttonZero:
                currentText += "0";
                break;
            case R.id.buttonEqual:
                if (!currentText.equals("")) {
                    float secondNumber = Float.parseFloat(currentText);
                    switch (currentOperator) {
                        case "+":
                            result = currentNumber + secondNumber;
                            break;
                        case "-":
                            result = currentNumber - secondNumber;
                            break;
                        case "*":
                            result = currentNumber * secondNumber
                            break;
                        case "/":
                            if (secondNumber != 0) {
                                result = currentNumber / secondNumber;
                            } else {
                                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        default:
                            break;
                    }
                    currentText = Float.toString(result);
                    currentNumber = result;
                }
                break;
            default:
                break;
        }
        textViewResult.setText(currentText);
    }
