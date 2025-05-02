/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alumno
 */
package com.myappointmentapp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class AppointmentScheduler {

    // URL base de la API. Puedes actualizar esta URL según la API real o el servicio mock.
    private final String baseApiUrl = "http://localhost:8080/api";

    public String scheduleAppointment(String patient, String doctor, String specialty, String date, String time)
            throws IOException, InterruptedException {

        // Construcción del objeto JSON con los datos de la cita.
        JsonObject appointmentRequest = new JsonObject();
        appointmentRequest.addProperty("patient", patient);
        appointmentRequest.addProperty("doctor", doctor);
        appointmentRequest.addProperty("specialty", specialty);
        appointmentRequest.addProperty("date", date);
        appointmentRequest.addProperty("time", time);

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseApiUrl + "/appointments"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(appointmentRequest.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Se espera que la API retorne un JSON con un campo "message".
        Gson gson = new Gson();
        JsonObject responseJson = gson.fromJson(response.body(), JsonObject.class);
        return responseJson.get("message").getAsString();
    }
}
