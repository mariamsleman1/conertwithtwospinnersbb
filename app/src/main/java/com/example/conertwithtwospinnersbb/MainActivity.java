package com.example.conertwithtwospinnersbb;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.security.KeyStore;

public class MainActivity extends AppCompatActivity {
    private EditText etnumberfrom;
    private Spinner selectedspinner1 , selectedspinner2 ;
    private ImageView imagespinner1 , imagespinner2;
   private TextView toastMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conenection();
    }



    //connection
    private void conenection() {
        etnumberfrom=findViewById(R.id.num);
        selectedspinner1=findViewById(R.id.spinner1);
        selectedspinner2=findViewById(R.id.spinner2);
       // imagespinner1=findViewById(R.id.imageView);
        imagespinner2=findViewById(R.id.imageView2);
    }



//buttom click
    public void calculate(View view) {
        String mablagfrom;
        mablagfrom = etnumberfrom.getText().toString();


        if (mablagfrom.trim().isEmpty()) {
           Toast.makeText(this, "somthing falied" + "", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double smablag = new Double(mablagfrom).doubleValue();

            if (smablag == 0) {
                Toast.makeText(this, "0" + "", Toast.LENGTH_LONG).show();
                return;
            }
            Toast.makeText(this, tahweel(smablag) + "", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(this, "error" + "", Toast.LENGTH_SHORT).show();
            return;
        }
    }


        public double tahweel (double numberfrom ) {
            String spinner1 = selectedspinner1.getSelectedItem().toString();
            String spinner2 = selectedspinner2.getSelectedItem().toString();

            if (spinner1.equals("shekel") && spinner2.equals("dollar")) {
              // imagespinner1.setImageResource(R.drawable.shekel);
                imagespinner2.setImageResource(R.drawable.dolar);

                return (numberfrom*3.51);}

            if (spinner1.equals("dollar") && spinner2.equals("shekel")) {
              // imagespinner1.setImageResource(R.drawable.dolar);
                imagespinner2.setImageResource(R.drawable.shekel);

                return (numberfrom/3.51);}

            if (spinner1.equals("dollar") && spinner2.equals("euro")) {
               // imagespinner1.setImageResource(R.drawable.dolar);
                imagespinner2.setImageResource(R.drawable.euro2);

                return (numberfrom*1.11);}

            if (spinner1.equals("euro") && spinner2.equals("dollar")) {
               // imagespinner1.setImageResource(R.drawable.euro2);
                imagespinner2.setImageResource(R.drawable.dolar);

                return (numberfrom/1.11);}


            if (spinner1.equals("shekel") && spinner2.equals("euro")) {
              // imagespinner1.setImageResource(R.drawable.shekel);
                imagespinner2.setImageResource(R.drawable.euro2);

                return (numberfrom/0.28);}

            if (spinner1.equals("euro") && spinner2.equals("shekel")) {
              //  imagespinner1.setImageResource(R.drawable.euro2);
               imagespinner2.setImageResource(R.drawable.shekel);

                return (numberfrom*0.28);}

            return 0;
    }


}