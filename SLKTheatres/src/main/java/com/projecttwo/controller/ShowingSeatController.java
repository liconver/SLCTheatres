package com.projecttwo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.projecttwo.model.ShowingSeat;
import com.projecttwo.services.ShowingSeatService;

@Controller("ShowingSeatController")
@RequestMapping("/seatapi")
//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins = "*") // cors - cross origin resource sharing
public class ShowingSeatController {
	private ShowingSeatService ssServ;

	@Autowired
	public ShowingSeatController(ShowingSeatService ssServ) {
		super();
		this.ssServ = ssServ;
	}

	@GetMapping(value = "/seats.app")
	public @ResponseBody List<ShowingSeat> getSeats() {
		System.out.println("in s");
		return ssServ.getSeats();
	}

	@GetMapping(value = "/seatsshowing.app")
	public @ResponseBody List<ShowingSeat> getSeatsFromShowing(@RequestParam("id") int id) {
		System.out.println("in ss");
		return ssServ.getSeatsFromShowing(id);
	}
}