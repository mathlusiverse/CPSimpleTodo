package com.mathlusiverse.cpsimpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    EditText etEditText;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etEditText = findViewById(R.id.etEditItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");
        etEditText.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an empty intent to pas data back to main activity:
                Intent intent = new Intent();
                // pass data (result of editing) back to main activity
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etEditText.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION,
                        getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                // set result of intent:
                setResult(RESULT_OK, intent);
                // finish activity, close the screen and go back
                finish();
            }
        });
    }

}
