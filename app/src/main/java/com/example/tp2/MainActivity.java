package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtlongueur;
    EditText txtlargeur;
    Button click;
    TextView peri;
    TextView air;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtlongueur = findViewById(R.id.txtLongueur);
        txtlargeur = findViewById(R.id.txtLargeur);
        click = findViewById(R.id.button);
        peri = findViewById(R.id.textPeri);
        air = findViewById(R.id.textAir);
    }

    public void calculate(View view) {
        if(txtlongueur.getText().toString().matches("") || txtlargeur.getText().toString().matches("")){
            Toast.makeText(this, "Entrez des mesures!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        int longueur = Integer.parseInt(txtlongueur.getText().toString());
        int largeur = Integer.parseInt(txtlargeur.getText().toString());

        peri.setText(String.valueOf((longueur + largeur)*2));
        air.setText(String.valueOf(longueur*largeur));
    }

    public void reset(View view) {
        txtlongueur.setText("");
        txtlargeur.setText("");
        peri.setText("");
        air.setText("");
    }
}
