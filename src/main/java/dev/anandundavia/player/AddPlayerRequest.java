package dev.anandundavia.player;

import org.springframework.stereotype.Component;

@Component
public class AddPlayerRequest {
	private String name;

	public AddPlayerRequest() {
	}

	public AddPlayerRequest(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AddPlayerRequest [name=" + name + "]";
	}

}
