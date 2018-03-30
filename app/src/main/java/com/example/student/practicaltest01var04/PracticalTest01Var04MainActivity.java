package com.example.student.practicaltest01var04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    Button topLeft;
    Button topRight;
    Button botLeft;
    Button botRight;
    Button navigate;
    Button center;
    public static TextView textView;
    long clicks;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button button = ((Button)view);
            clicks++;
            textView.setText(textView.getText().toString()+"\n"+ clicks + button.getText().toString());
        }
    }

    private NavigateListener navigateListener = new NavigateListener();
    private class NavigateListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04SecondaryActivity.class);
            intent.putExtra("text", textView.getText().toString());
            startActivity(intent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);
        topLeft = (Button)findViewById(R.id.button2);
        topLeft.setOnClickListener(buttonClickListener);
        topRight = (Button)findViewById(R.id.button3);
        topRight.setOnClickListener(buttonClickListener);
        botLeft = (Button)findViewById(R.id.button5);
        botLeft.setOnClickListener(buttonClickListener);
        botRight = (Button)findViewById(R.id.button6);
        botRight.setOnClickListener(buttonClickListener);
        navigate = (Button)findViewById(R.id.button1);
        navigate.setOnClickListener(buttonClickListener);
        navigate.setOnClickListener(navigateListener);
        center = (Button)findViewById(R.id.button4);
        center.setOnClickListener(buttonClickListener);
        textView = (TextView)findViewById(R.id.textView);
        textView.setText("");
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("clicks")) {
                clicks = savedInstanceState.getLong("clicks");
            }
        }
        textView.setText(getIntent().getStringExtra("text"));
        if (getIntent().getStringExtra("message") != null && !getIntent().getStringExtra("message").equals("")) {
            Toast.makeText(this, getIntent().getStringExtra("message"), Toast.LENGTH_LONG).show();
            /*if(getIntent().getStringExtra("message").equals("Cancel(clicks = 0)")) {
                clicks = 0;
                Toast.makeText(this, "Clicks reset", Toast.LENGTH_LONG).show();
            }*/

        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Clicks = " + clicks, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putLong("clicks", clicks);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("clicks")) {
            clicks = savedInstanceState.getLong("clicks");
        }

    }
}
