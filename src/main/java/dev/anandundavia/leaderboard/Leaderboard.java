package dev.anandundavia.leaderboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import dev.anandundavia.player.Player;

public class Leaderboard {

	private ArrayList<Player> players;

	public Leaderboard() {
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public String display() {

		if (this.players == null || this.players.isEmpty()) {
			return "No Players available";
		}

		this.ensurePlayersSorted();

		final StringBuilder sb = new StringBuilder();
		for (final Player player : this.players) {
			sb.append(player.toBeautifiedString() + "\n");
		}

		return sb.toString();

	}

	private void ensurePlayersSorted() {
		Collections.sort(this.players, new Comparator<Player>() {
			@Override
			public int compare(Player p0, Player p1) {
				return Integer.compare(p1.getQualifiedScore(), p0.getQualifiedScore());
			}
		});
	}

	@Override
	public String toString() {
		return "Leaderboard [players=" + players + "]";
	}

}
