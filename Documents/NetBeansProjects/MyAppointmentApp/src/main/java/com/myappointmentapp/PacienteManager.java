/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myappointmentapp;

/**
 *
 * @author Propietario
 */
import java.util.ArrayList;
import java.util.List;

public class PacienteManager {
    private List<Paciente> pacientes = new ArrayList<>();

    public void registrarPaciente(String nombre, int edad, String telefono) {
        pacientes.add(new Paciente(nombre, edad, telefono));
        System.out.println("✅ Paciente registrado: " + nombre);
    }

    public boolean autenticarPaciente(String nombre) {
        return pacientes.stream().anyMatch(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    public void mostrarPacientes() {
        System.out.println("🩺 Pacientes registrados:");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }
}
