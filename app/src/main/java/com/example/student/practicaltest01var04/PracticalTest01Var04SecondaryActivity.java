package com.example.student.practicaltest01var04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {
    TextView textView;

    Button verify;
    Button cancel;
    TextView textView2;
    long clicks;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button button = ((Button)view);
            if(button.getText().toString().equals("Cancel")) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04MainActivity.class);
                intent.putExtra("message", "Cancel(clicks = 0)");
                startActivity(intent);
            } else {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04MainActivity.class);
                intent.putExtra("text", textView2.getText().toString());
                intent.putExtra("message", "Verify");
                startActivity(intent);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setText(getIntent().getStringExtra("text"));
        verify = (Button)findViewById(R.id.button11);
        verify.setOnClickListener(buttonClickListener);
        cancel = (Button)findViewById(R.id.button12);
        cancel.setOnClickListener(buttonClickListener);
    }
}
