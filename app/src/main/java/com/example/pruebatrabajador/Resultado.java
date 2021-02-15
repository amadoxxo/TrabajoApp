package com.example.pruebatrabajador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private TextView nombreVis;
    private TextView apellidoVis;
    private TextView sueldoVis;
    private TextView horasVis;
    private TextView sueldoExtra;
    private TextView fechaNacimientoVis;
    private TextView fechaIngresoVis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        nombreVis = (TextView) findViewById(R.id.tvNombre);
        apellidoVis = (TextView) findViewById(R.id.tvApellido);
        sueldoVis = (TextView) findViewById(R.id.tvSueldo);
        horasVis = (TextView) findViewById(R.id.tvHoras);
        sueldoExtra = (TextView) findViewById(R.id.tvSueldoExtra);
        fechaNacimientoVis = (TextView) findViewById(R.id.tvFechaNacimiento1);
        fechaIngresoVis = (TextView) findViewById(R.id.tvFechaIngreso);
        imprimir();
    }

    public void imprimir() {
        Trabajador trabajador = getIntent().getParcelableExtra("trabajador");

        nombreVis.setText("El nombre es: "+trabajador.getNombre());
        apellidoVis.setText("El apellido es: "+trabajador.getApellido());
        sueldoVis.setText("El sueldo es: "+trabajador.getSueldo());
        horasVis.setText("Las horas trabajadas son: "+trabajador.getHoras());
        sueldoExtra.setText("El sueldo por horas extras es: "+trabajador.horasExtras());
        fechaNacimientoVis.setText("La fecha de nacimiento es: "+trabajador.getFechaNacimiento());
        fechaIngresoVis.setText("La fecha de ingreso es :"+trabajador.getFechaIngreso());
    }
}