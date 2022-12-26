package com.cera.task.java;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.Arrays;

import com.cera.task.java.models.Response;

@Controller @RestController
public class CarerController {

    String[] WorkingDays = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

	@RequestMapping("/carer")
	public Response Sample(@RequestParam(value = "date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date) {
		Response response = new Response();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE");
		//I assigned a default value to workdays= false in CarerController to see if the given date is not inside working days
		boolean workingday=false;
		workingday = Arrays.asList(WorkingDays).contains(date.format(format));
		response.setWorkingDay(workingday);
		return response;
	}
}