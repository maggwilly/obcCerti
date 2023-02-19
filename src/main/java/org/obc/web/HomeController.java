package org.obc.web;

import java.time.Duration;
import java.time.LocalDateTime;

import org.obc.entity.Period;
import org.obc.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import static java.util.stream.Collectors.groupingBy;
@Controller
public class HomeController {
	@Autowired
	private PeriodService periodService;
	@Value("${period.generate.interval}")
	private Duration duration;
	@GetMapping("")
	public String index(Model model) {
		final var localDate = LocalDateTime.now().plus(duration);
		final var periods = periodService.findAvailable(localDate.toLocalDate());
		final var localTimeMap = periods.stream().collect(groupingBy(Period::getDate,groupingBy(Period::getStartTime)));
		model.addAttribute("periods", localTimeMap);
		return "index";
	}
}
