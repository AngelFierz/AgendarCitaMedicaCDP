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
import java.util.HashMap;
import java.util.Map;

public class DoctorManager {
    private Map<String, LocalDateTime> agenda = new HashMap<>();

    public boolean verificarDisponibilidad(String doctor, LocalDateTime fechaHora) {
        return !agenda.containsKey(doctor) || agenda.get(doctor).isBefore(fechaHora.minusHours(1));
    }

    public void agendarCita(String doctor, LocalDateTime fechaHora) {
        agenda.put(doctor, fechaHora);
    }
}
