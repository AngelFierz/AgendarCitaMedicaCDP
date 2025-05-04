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
import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class AppointmentSchedulerTest {

    /**
     * Caso de prueba CP-001: Verificar que un paciente (Juan Pérez)
     * pueda agendar una cita con un doctor disponible (Dr. Carlos Eduardo)
     * en Cardiología el 2025-04-01 a las 10:00 AM.
     */
    @Test
    public void testScheduleAppointment() throws Exception {
        AppointmentScheduler scheduler = new AppointmentScheduler();
        
        // Datos del caso de prueba
        String patient = "Juan Pérez"; 
        String doctor = "Dr. Carlos Eduardo";
        String specialty = "Cardiology";
        String date = "2025-04-01";
        String time = "10:00 AM";

       
        String confirmationMsg = scheduler.scheduleAppointment(patient, doctor, specialty, date, time);

        
        assertEquals("Appointment successfully scheduled", confirmationMsg);
    }
}
