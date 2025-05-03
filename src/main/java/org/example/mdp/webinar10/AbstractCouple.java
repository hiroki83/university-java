package org.example.mdp.webinar10;

public abstract class AbstractCouple {

	Object a, b;

	public AbstractCouple(Object a, Object b) {
		super();
		this.a = a;
		this.b = b;
	}

	public Object getA() {
		return a;
	}

	public void setA(Object a) {
		this.a = a;
	}

	public Object getB() {
		return b;
	}

	public void setB(Object b) {
		this.b = b;
	}
	
	
}
