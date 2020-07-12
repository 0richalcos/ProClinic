package com.proclinic.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping({ "/", "/index.html" })
    public String login() {
	return "index";
    }

    @RequestMapping({ "/404.html" })
    public String notDound() {
	return "404";
    }

    @RequestMapping({ "/about-appointment.html" })
    public String aboutAppointment() {
	return "about-appointment";
    }

    @RequestMapping({ "/about-doctor.html" })
    public String aboutDoctor() {
	return "about-doctor";
    }

    @RequestMapping({ "/about-patient.html" })
    public String aboutPatient() {
	return "about-patient";
    }

    @RequestMapping({ "/about-payment.html" })
    public String aboutPayment() {
	return "about-payment";
    }

    @RequestMapping({ "/add-appointment.html" })
    public String addAppointment() {
	return "add-appointment";
    }

    @RequestMapping({ "/add-doctor.html" })
    public String addDoctor() {
	return "add-doctor";
    }

    @RequestMapping({ "/add-patient.html" })
    public String addPatient() {
	return "add-patient";
    }

    @RequestMapping({ "/add-payment.html" })
    public String addPayment() {
	return "add-payment";
    }

    @RequestMapping({ "/add-room.html" })
    public String addRoom() {
	return "add-room";
    }

    @RequestMapping({ "/appointments.html" })
    public String appointments() {
	return "appointments";
    }

    @RequestMapping({ "/blank-page.html" })
    public String blankPage() {
	return "blank-page";
    }

    @RequestMapping({ "/doctors.html" })
    public String doctors() {
	return "doctors.html";
    }

    @RequestMapping({ "/edit-appointment.html" })
    public String editAppointment() {
	return "edit-appointment";
    }

    @RequestMapping({ "/edit-doctor.html" })
    public String editDoctor() {
	return "edit-doctor";
    }

    @RequestMapping({ "/edit-patient.html" })
    public String editPatient() {
	return "edit-patient";
    }

    @RequestMapping({ "/edit-room.html" })
    public String editRoom() {
	return "edit-room";
    }

    @RequestMapping({ "/patients.html" })
    public String patients() {
	return "patients";
    }

    @RequestMapping({ "/payments.html" })
    public String payments() {
	return "payments";
    }

    @RequestMapping({ "/rooms.html" })
    public String rooms() {
	return "rooms";
    }

}
