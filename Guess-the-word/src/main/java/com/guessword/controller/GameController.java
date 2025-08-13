package com.guessword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.guessword.service.GameService;

@Controller
public class GameController {
	@Autowired
	GameService gameService;
	
//	# this will provide the Container(ApplicationContext) ....with this container we can GetBeans from container......
	@Autowired
	ConfigurableApplicationContext context;

	@GetMapping("/game-home")
	public String guesstheword(Model model , @RequestParam(value = "guesseschar", required = false) String guesseschar) {
		model.addAttribute("randomword", gameService.toString(guesseschar));
		model.addAttribute("count" , gameService.chances);
		model.addAttribute("successmsg" , gameService.successmsg);
		return "game-home-page";
	}
	
	@GetMapping("/reload")
	public String reloadPage() {
//		# Here "GameService" Scope of this is "Prototype" ---> So whenever we will request Bean from Container ...it will create new Bean Each Time.....
		this.gameService=context.getBean(GameService.class);
//		After reloading the "GameService" this Bean we are redirecting to ("/game-home")....
		return "redirect:/game-home";
	}
}
