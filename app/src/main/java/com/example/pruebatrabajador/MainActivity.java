package com.example.pruebatrabajador;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText sueldo;
    private EditText horas;
    Calendar myCalendar = Calendar.getInstance();
    private EditText fechaNacimiento;
    private EditText fechaIngreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.etNombre);
        apellido = (EditText) findViewById(R.id.etApellido);
        sueldo = (EditText) findViewById(R.id.etSueldo);
        horas = (EditText) findViewById(R.id.etHoras);
        fechaNacimiento = (EditText) findViewById(R.id.etFechaNacimiento);
        fechaIngreso = (EditText) findViewById(R.id.etFechaIngreso);

        fechaIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, dat,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });

        fechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, dat,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }

    DatePickerDialog.OnDateSetListener dat = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarCampos();

        }
    };

    private void actualizarCampos() {
        String formatoDeFecha = "MM/dd/YY";
        SimpleDateFormat formato = new SimpleDateFormat(formatoDeFecha, Locale.US);
        fechaNacimiento.setText(formato.format(myCalendar.getTime()));
        fechaIngreso.setText(formato.format(myCalendar.getTime()));
    }

    public void calcular(View view) {

        String nombre1 = nombre.getText().toString();
        String apellido1 = apellido.getText().toString();
        int sueldo1 = Integer.parseInt(sueldo.getText().toString());
        int horas1 = Integer.parseInt(horas.getText().toString());
        String fechaNacimiento1 = fechaNacimiento.getText().toString();
        String fechaIngreso1 = fechaIngreso.getText().toString();

        Trabajador trabajador = new Trabajador(nombre1, apellido1, sueldo1, horas1, fechaNacimiento1, fechaIngreso1);

        Intent intent = new Intent(this, Resultado.class);
        intent.putExtra("trabajador", trabajador);
        startActivity(intent);
    }
}