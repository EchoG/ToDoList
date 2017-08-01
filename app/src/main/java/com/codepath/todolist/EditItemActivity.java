package com.codepath.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String content = getIntent().getStringExtra("content");
        index = getIntent().getIntExtra("index", 0);
        EditText editText = (EditText)findViewById(R.id.editText);
        editText.append(content);
    }

    public void onSubmit(View view){
        EditText etItem = (EditText) findViewById(R.id.editText);
        String editedContent = etItem.getText().toString();
        Intent data = new Intent();
        data.putExtra("editedContent", editedContent);
        data.putExtra("index", index);
        setResult(RESULT_OK, data);
        finish();
    }
}
