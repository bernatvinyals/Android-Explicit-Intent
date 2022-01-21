package com.example.intentsexplicitsexemple;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnValidar;
    boolean matricula;
    EditText txtNombre,txtApellido,txtEdad;
    TextView txtConfidielidad;
    private final int FIRMA1=1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        matricula = false;
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEdad = findViewById(R.id.txtEdad);

        btnValidar=findViewById(R.id.btnValidar);
        btnValidar.setOnClickListener(this);
        txtConfidielidad=findViewById(R.id.txtConfidielidad);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnValidar: cridaActivity2(true); break;
        }
    }

    public void cridaActivity2(boolean retorn){
        //1.- Definir INTENT per anar de Activity origen a desti (EXPLICIT)
        Intent i = new Intent(MainActivity.this, Activity2.class);
        //2.-Creem un Bundle (container) per passar la info
        Bundle container = new Bundle();
        container.putString("nom",txtNombre.getText().toString());
        container.putString("apellido",txtApellido.getText().toString());
        container.putString("edad", txtEdad.getText().toString());
        container.putBoolean("matricula",matricula);
        //3.- Posar el Bundle en el intent
        i.putExtras(container);
        //4.- Posar en marxa l'INTENT
        if (retorn){
            startActivityForResult(i,FIRMA1);
        }
        else {
            startActivity(i);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case FIRMA1:
                boolean dadaTornada= data.getBooleanExtra("tornada",false);
                    if (dadaTornada){
                        txtConfidielidad.setText("Acceptado");
                    }else  {
                        txtConfidielidad.setText("Denegat");
                    }

                break;
        }

    }


    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radioNo:
                matricula=false;
                break;
            case R.id.radioYes:
                matricula=true;
                break;
        }
    }
}