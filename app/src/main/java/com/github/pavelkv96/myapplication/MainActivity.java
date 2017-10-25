package com.github.pavelkv96.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IMyVisible {

    private static final String TAG = "MainActivity_Lifecycle";
    private EditText mFirstEditText;
    private EditText mSecondEdiText;
    private Button mAddButton;
    private Button mSubButton;
    private Button mMultButton;
    private Button mDivButton;
    private TextView mResultTextView;
    private String mOperation = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "OnCreate");

        mFirstEditText = (EditText) findViewById(R.id.etNum1);
        mSecondEdiText = (EditText) findViewById(R.id.etNum2);

        mAddButton = (Button) findViewById(R.id.btnAdd);
        mSubButton = (Button) findViewById(R.id.btnSub);
        mMultButton = (Button) findViewById(R.id.btnMult);
        mDivButton = (Button) findViewById(R.id.btnDiv);

        mResultTextView = (TextView) findViewById(R.id.tvResult);

        mAddButton.setOnClickListener(this);
        mSubButton.setOnClickListener(this);
        mMultButton.setOnClickListener(this);
        mDivButton.setOnClickListener(this);

        mSecondEdiText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mDivButton.setVisibility(Visible(charSequence.toString()));
                /*if ("INVISIBLE".equals(Visible(charSequence.toString()))) {
                    mDivButton.setVisibility(View.INVISIBLE);
                } else {
                    mDivButton.setVisibility(View.VISIBLE);
                }*/
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        if (TextUtils.isEmpty(mFirstEditText.getText().toString()) || TextUtils.isEmpty(mSecondEdiText.getText().toString())) {
            return;
        }

        num1 = Float.valueOf(mFirstEditText.getText().toString());
        num2 = Float.valueOf(mSecondEdiText.getText().toString());
        switch (v.getId()) {
            case R.id.btnAdd:
                mOperation = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                mOperation = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                mOperation = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                mOperation = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }
        mResultTextView.setText(result + "");
    }

    @Override
    public int Visible(String mZero) {
        if (!mZero.equals("") && Float.parseFloat(mZero) == 0) {
            return /*"INVISIBLE";*/View.INVISIBLE;
        } else {
            return /*"VISIBLE";*/View.VISIBLE;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "OnDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "OnResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "OnRestart");
    }
}