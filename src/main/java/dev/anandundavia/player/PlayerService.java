package dev.anandundavia.player;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class PlayerService {

	private ArrayList<Player> players;

	public PlayerService() {
		this.players = new ArrayList<>();
	}

	public Player add(Player player) {
		this.players.add(player);
		return player;
	}

	public ArrayList<Player> getAll() {
		return this.players;
	}

	public Player findById(String ID) {
		for (final Player p : this.players) {
			if (p.getID().equals(ID)) {
				return p;
			}
		}

		return null;
	}

	public Player addScore(Player player, Integer score) {
		if (player == null)
			return null;
		player.addScore(score);
		return player;
	}

	public Player addScore(String ID, Integer score) {
		return addScore(findById(ID), score);
	}
}
