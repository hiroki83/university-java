package org.example.mdp.lgenerictype1;

public class Orange extends Fruts {

	public Orange(String taste) {
		super(taste);
	}

	
	public Orange(String taste, String name) {
		super(taste);
		this.name = name;
	}


	private String name;
	
	@Override
	public String toString() {
		return "This frut is " + name + ", so " + getTaste() + " !";
	}
}
