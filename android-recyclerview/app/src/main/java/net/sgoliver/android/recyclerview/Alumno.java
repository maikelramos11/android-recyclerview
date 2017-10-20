package net.sgoliver.android.recyclerview;

public class Alumno
{
    private String nombre;
    private String apellidos;

    public Alumno(String nom, String apell){
        nombre = nom;
        apellidos = apell;
    }

    public String getTitulo(){
        return nombre;
    }

    public String getSubtitulo(){
        return apellidos;
    }
}
