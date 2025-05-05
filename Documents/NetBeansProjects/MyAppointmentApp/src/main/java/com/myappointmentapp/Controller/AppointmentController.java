package com.myappointmentapp.controller;

import com.myappointmentapp.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/status")
    public String getStatus() {
        return appointmentService.getStatus();
    }
}
