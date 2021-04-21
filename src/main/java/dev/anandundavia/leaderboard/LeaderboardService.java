package dev.anandundavia.leaderboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.anandundavia.player.PlayerService;

@Service
public class LeaderboardService {

	@Autowired
	private PlayerService playerService;

	public String generate() {
		Leaderboard board = new Leaderboard();
		board.setPlayers(playerService.getAll());
		return board.display();
	}
}
