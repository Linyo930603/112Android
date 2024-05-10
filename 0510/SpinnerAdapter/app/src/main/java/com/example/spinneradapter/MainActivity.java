package com.example.spinneradapter;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private  String[]course,desserts;
    private Spinner spCourse,spDesserts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        course=getResources().getStringArray(R.array.courses);
        desserts=getResources().getStringArray(R.array.desserts);


        spCourse=(Spinner)findViewById(R.id.spinner);
        spDesserts=(Spinner) findViewById(R.id.spinner2);


        ArrayAdapter<String>adpCourse=new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,course);
        ArrayAdapter<String>adpDessets=new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,desserts);


        spCourse.setAdapter(adpCourse);
        spDesserts.setAdapter(adpDessets);


        Button btnConfirm=(Button)findViewById(R.id.button);
        btnConfirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String course = spCourse.getSelectedItem().toString();
                String dessert = spDesserts.getSelectedItem().toString();
                TextView output=(TextView) findViewById(R.id.lblOutput);
                output.setText("主餐"+course+"\n甜點:"+dessert);


            }
        });
        Button btnModify=(Button)findViewById(R.id.btnModify);
        btnModify.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                desserts[4]="草莓蛋糕";
                adpDessets.notifyDataSetChanged();
            }
        });
    }
}
