package dev.anandundavia.leaderboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/leaderboard")
public class LeaderboardController {

	@Autowired
	private LeaderboardService service;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public String display() {
		return service.generate();
	}

}
