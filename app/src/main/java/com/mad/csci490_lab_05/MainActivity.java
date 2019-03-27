package com.mad.csci490_lab_05;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText pass;
    EditText email;
    Button save;

    String mySHAREDPREFERENCES = "sp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editText);
        pass = findViewById(R.id.editText2);
        email = findViewById(R.id.editText3);
        save = findViewById(R.id.button);

        final SharedPreferences sharedPreferences = getSharedPreferences(mySHAREDPREFERENCES, Context.MODE_PRIVATE);

        name.setText(sharedPreferences.getString("Name",""));
        pass.setText(sharedPreferences.getString("Pass",""));
        email.setText(sharedPreferences.getString("Email",""));

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String n = name.getText().toString();
                String p = pass.getText().toString();
                String e = email.getText().toString();

                editor.putString("Name", n);
                editor.putString("Pass", p);
                editor.putString("Email", e);
                editor.apply();
                Toast.makeText(MainActivity.this, "Information has been saved", Toast.LENGTH_LONG).show();
            }
        });
    }
}
