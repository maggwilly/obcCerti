package org.obc.web;

import org.obc.entity.Tutorial;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {
	@GetMapping("/schedule/{date}/{startTime}")
	public String createReservation(Model model) {
		Tutorial tutorial = new Tutorial();
		tutorial.setPublished(true);

		model.addAttribute("tutorial", tutorial);
		model.addAttribute("pageTitle", "Create new Tutorial");

		return "tutorial_form";
	}
}
