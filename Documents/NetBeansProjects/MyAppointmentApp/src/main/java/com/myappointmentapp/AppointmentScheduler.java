/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myappointmentapp;
/**
 *
 * @author alumno
 */
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;


public class AppointmentScheduler {
    private final String baseApiUrl = "http://localhost:8080/api";
    private HttpClient client;
    private List<Appointment> citasLocales = new ArrayList<>();
    private List<Paciente> pacientesLocales = new ArrayList<>();
    private Map<String, LocalDateTime> agendaMedicos = new HashMap<>();

    public AppointmentScheduler() {
        client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    public void registrarPaciente(String nombre, int edad, String telefono) {
        pacientesLocales.add(new Paciente(nombre, edad, telefono));
        System.out.println("Paciente registrado localmente: " + nombre);
    }

    public boolean autenticarPaciente(String nombre) {
        return pacientesLocales.stream().anyMatch(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    public boolean verificarDisponibilidadMedico(String doctor, LocalDateTime fechaHora) {
        return !agendaMedicos.containsKey(doctor) || agendaMedicos.get(doctor).isBefore(fechaHora.minusHours(1));
    }

    public String scheduleAppointment(String patient, String doctor, String specialty, String date, String time) {
        LocalDateTime fechaHora = LocalDateTime.parse(date + "T" + time);

        if (!autenticarPaciente(patient)) {
            return "Error: Paciente no registrado.";
        }

        if (!verificarDisponibilidadMedico(doctor, fechaHora)) {
            return "Error: El doctor no está disponible en esa hora.";
        }

        try {
            JsonObject appointmentRequest = new JsonObject();
            appointmentRequest.addProperty("patient", patient);
            appointmentRequest.addProperty("doctor", doctor);
            appointmentRequest.addProperty("specialty", specialty);
            appointmentRequest.addProperty("date", date);
            appointmentRequest.addProperty("time", time);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseApiUrl + "/appointments"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(appointmentRequest.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            JsonObject responseJson = gson.fromJson(response.body(), JsonObject.class);
            return responseJson.get("message").getAsString();

        } catch (Exception e) {
            System.out.println(" No se pudo conectar con la API. Guardando localmente.");
            agendaMedicos.put(doctor, fechaHora);
            citasLocales.add(new Appointment(patient, doctor, specialty, fechaHora));
            return "✅ Cita guardada localmente: " + patient + " con " + doctor + " el " + date + " a las " + time;
        }
    }

    public void mostrarDatos() {
        System.out.println("Pacientes registrados:");
        for (Paciente paciente : pacientesLocales) {
            System.out.println(paciente);
        }
        System.out.println("----------------");
        System.out.println("Citas agendadas:");
        for (Appointment cita : citasLocales) {
            System.out.println(cita);
        }
    }
}
