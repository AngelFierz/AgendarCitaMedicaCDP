/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myappointmentapp;

/**
 *
 * @author Propietario
 */
import java.time.LocalDateTime;

public class Appointment {
    private String paciente;
    private LocalDateTime fechaHora;
    private String doctor;
    private String especialidad;

    public Appointment(String paciente, String doctor, String especialidad, LocalDateTime fechaHora) {
        this.paciente = paciente;
        this.doctor = doctor;
        this.especialidad = especialidad;
        this.fechaHora = fechaHora;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    @Override
    public String toString() {
        return "Cita con " + paciente + " | Médico: " + doctor + " | Especialidad: " + especialidad + " | Fecha: " + fechaHora;
    }
}
