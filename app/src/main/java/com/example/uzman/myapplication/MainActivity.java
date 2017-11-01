package com.example.uzman.myapplication;

import android.os.Environment;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    static String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = (EditText) findViewById(R.id.txt_name);
        final EditText first_name = (EditText) findViewById(R.id.txt_firstName);
        final EditText last_name = (EditText) findViewById(R.id.txt_lastName);
        final EditText address = (EditText) findViewById(R.id.txt_adres);
        final EditText sonuc = (EditText) findViewById(R.id.txt_result);

        Button btn_ekle = (Button) findViewById(R.id.btn_ekle);
        btn_ekle.setOnClickListener( new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                result = "";
                result = sonuc.getText().toString();
                result += name.getText() + " " + first_name.getText() + " " + last_name.getText() + " " + address.getText()+ "\n";
                sonuc.setText(result);
            }
        });

        Button btn_gonder = (Button) findViewById(R.id.btn_gonder);
        btn_gonder.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try
                {
                    File myFile = new File("/storage/emulated/0/data.txt");

                    if(!myFile.exists())
                    {
                        myFile.createNewFile();
                    }

                    FileOutputStream fOut = new FileOutputStream(myFile);
                    OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                    myOutWriter.append(result);
                    myOutWriter.close();
                    fOut.close();
                }
                catch (Exception e)
                {
                    Log.e("error", e.getMessage());
                }
            }
        });
    }
}
