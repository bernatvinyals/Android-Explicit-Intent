package com.example.intentsexplicitsexemple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    TextView act2Nom,act2Apellido,act2Edad,act2Ya;
    Button btnBack;
    CheckBox checkAp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle container = getIntent().getExtras();
        act2Nom = findViewById(R.id.act2Nom);
        act2Apellido = findViewById(R.id.act2Apellido);
        act2Edad = findViewById(R.id.act2Edad);
        act2Ya = findViewById(R.id.act2Ya);
        act2Nom.setText("Nombre: " + container.getString("nom").toString());
        act2Apellido.setText("Apellido: " + container.getString("apellido").toString());
        act2Edad.setText("Edad: " + container.getString("edad").toString());
        if (container.getBoolean("matricula")){
            act2Ya.setText("Si");
        }else{
            act2Ya.setText("No");
        }
        btnBack=findViewById(R.id.btnBack);
        checkAp=findViewById(R.id.checkAp);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                //posarem dada a retornar directament sobre intent
                i.putExtra("tornada",checkAp.isChecked());
                setResult(RESULT_OK,i);
                finish();
            }
        });

    }
}