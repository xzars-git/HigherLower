package com.example.higherlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    public void randomNUmberGenerator(){
        Random rand = new Random();
        randomNumber = rand.nextInt();
    }
    public void onGuess(View view){
        String massege = "";
        try {
            EditText editTextNumber = (EditText) findViewById(R.id.desimal);

        int guessedNumber = Integer.parseInt(editTextNumber.getText().toString());
        if(guessedNumber < 1 || guessedNumber > 20){
            massege = "Please Input Number Between 1 to 20";
        }else if(guessedNumber > randomNumber){
            massege = "Lower !!!";
        }else if (guessedNumber < randomNumber){
            massege = "Higher !!!";
        }
        else {
            massege = "You Got Me !!!";
            randomNUmberGenerator();
        }
        }catch (Exception e){
            massege = "Feild cannot empty";
        }finally {
            Toast.makeText(this, massege, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(20)+ 1;
    }
}