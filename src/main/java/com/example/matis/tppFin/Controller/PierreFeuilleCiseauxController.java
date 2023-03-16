package com.example.matis.tppFin.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class PierreFeuilleCiseauxController {
	
	@GetMapping("/play/{action}")
	public String jouerFigure(@PathVariable("action") String action) {
		String actionOrdinateur = "pierre";
		
		if(actionOrdinateur == "pierre") {
			return "Vous avez jouer "+action+", l'ordinateur à joué pierre, egalité";
		}
		
		return "Vous avez jouer "+action +", l'ordinateur à joué " + actionOrdinateur+", vous avez perdu";
	}
	
	@PostMapping("/game/restart")
	public String restartGame() {
		return "0";
	}

}
