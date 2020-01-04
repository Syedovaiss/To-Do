package com.ovais.quizsqlitetry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MyDatabaseHelper myDatabaseHelper;
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText =findViewById(R.id.myTask);
        textView=findViewById(R.id.textToSet);
        myDatabaseHelper=new MyDatabaseHelper(this,null,null,1);
        printDB();


    }

    public void AddTask(View view) {
        Tasks tasks=new Tasks(editText.getText().toString());
        myDatabaseHelper.addTask(tasks);
    }
    public void RemoveTask(View view) {
        String input=editText.getText().toString();
        myDatabaseHelper.removeTask(input);
    }
    public void printDB(){

        String dbString=myDatabaseHelper.databaseToString();
        textView.setText(dbString);


    }


}
