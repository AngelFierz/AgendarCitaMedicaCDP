/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myappointmentapp;

import java.util.Scanner;

/**
 *
 * @author Propietario
 */


public class Main {
    public static void main(String[] args) {
        AppointmentScheduler scheduler = new AppointmentScheduler();
        Scanner scanner = new Scanner(System.in);

        String usuario;
        
        // 🔹 Registro obligatorio antes de cualquier acción
        System.out.print("Ingrese su nombre de usuario: ");
        usuario = scanner.nextLine();

        while (!scheduler.autenticarPaciente(usuario)) {
            System.out.println("Usuario no registrado, Registrate ahora");
            System.out.print(" Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            scheduler.registrarPaciente(usuario, edad, telefono);
            System.out.println("Usuario registrado correctamente!");
        }

        System.out.println("Bienvenido, " + usuario + "!");

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1 registrar paciente");
            System.out.println("2 Agendar Cita");
            System.out.println("3 Mostrar datos actuales");
            System.out.println("0 Salir");
            System.out.print("!! Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    scheduler.registrarPaciente(nombre, edad, telefono);
                    break;

                case 2:
                    System.out.print(" Nombre del doctor: ");
                    String doctor = scanner.nextLine();
                    System.out.print(" Especialidad: ");
                    String especialidad = scanner.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Hora (HH:MM): ");
                    String hora = scanner.nextLine();
                    System.out.println(scheduler.scheduleAppointment(usuario, doctor, especialidad, fecha, hora));
                    break;

                case 3:
                    scheduler.mostrarDatos();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema windows uuauooo");
                    scanner.close();
                    return;

                default:
                    System.out.println("No eso no tonto, hazlo bien");
            }
        }
    }
}
