package dev.anandundavia.player;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/player")
public class PlayerController {

	@Autowired
	private PlayerService service;

	@RequestMapping(path = "", method = RequestMethod.POST)
	public Player addPlayer(@RequestBody AddPlayerRequest addPlayerRequest) {
		final Player player = Player.from(addPlayerRequest);
		return service.add(player);
	}

	@RequestMapping(path = "", method = RequestMethod.GET)
	public ArrayList<Player> getAllPlayers() {
		return service.getAll();
	}

	@RequestMapping(path = "{id}/score/{score}", method = RequestMethod.POST)
	public Player addScore(@PathVariable("id") String ID, @PathVariable("score") Integer score) {
		return service.addScore(ID, score);
	}

}
