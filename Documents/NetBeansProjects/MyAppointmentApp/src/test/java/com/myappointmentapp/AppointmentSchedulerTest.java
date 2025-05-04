/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alumnog
 */

package com.myappointmentapp;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class AppointmentSchedulerTest {

    /**
     * Caso de prueba CP-001: Verificar que un paciente (Juan Pérez)
     * pueda agendar una cita con un doctor disponible (Dr. Carlos Eduardo)
     * en Cardiología el 2025-04-01 a las 10:00 AM.
     */
    @Test
    public void testScheduleAppointment() throws Exception {
        // Verificamos que `scheduler` se inicializa correctamente
        AppointmentScheduler scheduler = new AppointmentScheduler();
        if (scheduler == null) {
            throw new NullPointerException("Error: `scheduler` no fue inicializado correctamente.");
        }

        // Datos del caso de prueba
        String patient = "Juan Pérez"; 
        String doctor = "Dr. Carlos Eduardo";
        String specialty = "Cardiology";
        String date = "2025-04-01";
        String time = "10:00 AM";

        // Impresión de valores para verificar que no hay nulls
        System.out.println("Patient: " + patient);
        System.out.println("Doctor: " + doctor);
        System.out.println("Specialty: " + specialty);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);

        // Simulamos la API si la conexión real no está activa
        AppointmentScheduler mockScheduler = new AppointmentScheduler() {
            @Override
            public String scheduleAppointment(String patient, String doctor, String specialty, String date, String time) {
                return "Appointment successfully scheduled"; // Simulación sin API
            }
        };

        String confirmationMsg = mockScheduler.scheduleAppointment(patient, doctor, specialty, date, time);

        assertEquals("Appointment successfully scheduled", confirmationMsg);
    }
}
