/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myappointmentapp;

/**
 *
 * @author Propietario
 */
public class Paciente {
    private String nombre;
    private int edad;
    private String telefono;

    public Paciente(String nombre, int edad, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Paciente: " + nombre + ", Edad: " + edad + ", Teléfono: " + telefono;
    }
}
