package org.example.mdp.lgenerictype1;

public class Fruts {

	public String getTaste() {
		return taste;
	}

	public Fruts(String taste) {
		super();
		this.taste = taste;
	}

	private String taste;
	
	@Override
	public String toString() {
		return "I don't know what fruts but it is " + taste + " .";
	}
}
