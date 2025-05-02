package org.example.mdp.lgenerictype1;

public class Apple extends Fruts {

	public Apple(String taste) {
		super(taste);
	}

	
	public Apple(String taste, String name) {
		super(taste);
		this.name = name;
	}


	private String name;
	
	@Override
	public String toString() {
		return "This frut is " + name + ", so " + getTaste() + " !";
	}
}
