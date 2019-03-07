package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email ,password;
    Button button;
    String Namec,Passwordc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.editText3);
        password=findViewById(R.id.editText5);
        button=findViewById(R.id.button);


        Namec=email.getText().toString().trim();
        Passwordc=password.getText().toString().trim();



        SharedPreferences sharedPreferences=getSharedPreferences("Myfile",MODE_PRIVATE);
        SharedPreferences.Editor editor1=sharedPreferences.edit();
        SharedPreferences.Editor editor2=sharedPreferences.edit();

        editor1.putString("name","ashwani");
        editor2.putString("password","12345");
        editor1.apply();






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               // SharedPreferences sharedPreferences
                SharedPreferences sharedPreferences=getSharedPreferences("Myfile",MODE_PRIVATE);
                String Name=sharedPreferences.getString("name","ashwani");
                String Password=sharedPreferences.getString("password","12345");


                Namec=email.getText().toString().trim();
                Passwordc=password.getText().toString().trim();

                Toast.makeText(MainActivity.this, ""+Password, Toast.LENGTH_SHORT).show();
                if(Namec.equals(Name) && Passwordc.equals(Password)){
                    startActivity(new Intent(MainActivity.this,Main2Activity.class));
                }
                else
                {
                    Toast.makeText(MainActivity.this, "mismatch", Toast.LENGTH_SHORT).show();
                }





















            }
        });




    }



}
