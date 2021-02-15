package com.example.pruebatrabajador;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Trabajador implements Parcelable {
    String nombre;
    String apellido;
    int sueldo;
    int horas;
    String fechaNacimiento;
    String fechaIngreso;

    public Trabajador(String nombre, String apellido, int sueldo, int horas, String fechaNacimiento, String fechaIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.horas = horas;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int horasExtras() {
        int resultado = 0;

        resultado = (int) (getSueldo() * 0.02 * getHoras()) + getSueldo();

        return resultado;
    }


    public static Creator<Trabajador> getCREATOR() {
        return CREATOR;
    }

    protected Trabajador(Parcel in) {
        nombre = in.readString();
        apellido = in.readString();
        sueldo = in.readInt();
        horas = in.readInt();
        fechaNacimiento = in.readString();
        fechaIngreso = in.readString();
    }

    public static final Creator<Trabajador> CREATOR = new Creator<Trabajador>() {
        @Override
        public Trabajador createFromParcel(Parcel in) {
            return new Trabajador(in);
        }

        @Override
        public Trabajador[] newArray(int size) {
            return new Trabajador[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellido);
        dest.writeInt(sueldo);
        dest.writeInt(horas);
        dest.writeString(fechaNacimiento);
        dest.writeString(fechaIngreso);
    }
}
