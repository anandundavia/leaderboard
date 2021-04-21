package dev.anandundavia.player;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Player {

	private String ID;
	private String name;
	private ArrayList<Integer> scores;

	private Integer max;
	private Integer secondMax;



	public static Player from(AddPlayerRequest addPlayerRequest) {
		final Player player = new Player(addPlayerRequest.getName());
		player.setID(UUID.randomUUID().toString());
		return player;
	}

	public Player() {
		this.scores = new ArrayList<>();
	}

	public Player(String name) {
		this.name = name;
		this.scores = new ArrayList<>();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Integer> getScores() {
		return scores;
	}

	public void setScores(ArrayList<Integer> scores) {
		this.scores = scores;
	}

	public void addScore(Integer score) {
		this.scores.add(score);
		updateMaximums(score);
	}

	public Integer getQualifiedScore() {
		if (this.max == null) {
			return 0;
		}

		if (this.secondMax == null) {
			return this.max / 2;
		}

		return (this.max + this.secondMax) / 2;
	}

	private void updateMaximums(Integer lastAdded) {
		if (this.max == null) {
			this.max = lastAdded;
			return;
		}

		if (this.secondMax == null) {
			this.secondMax = lastAdded;
			return;
		}

		if (lastAdded > this.max) {
			this.secondMax = this.max;
			this.max = lastAdded;
		} else if (lastAdded > this.secondMax) {
			this.secondMax = lastAdded;
		}
	}

	@Override
	public String toString() {
		return "Player [ID=" + ID + ", name=" + name + ", scores=" + scores + "]";
	}

	public String toBeautifiedString() {
		return this.getID() + "\t" + this.getName() + "\t" + this.getQualifiedScore();
	}
}
