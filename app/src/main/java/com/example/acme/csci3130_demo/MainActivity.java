package com.example.acme.csci3130_demo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button copy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        copy = (Button) findViewById(R.id.copy);

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Text",editText.getText().toString());
                clipboard.setPrimaryClip(clip);
                ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
                String pasteData = item.getText().toString();
                if(!pasteData.equals("")){
                    textView.setText(pasteData);
                }

            }
        });
    }
}
