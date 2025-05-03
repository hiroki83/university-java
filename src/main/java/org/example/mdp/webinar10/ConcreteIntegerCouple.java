package org.example.mdp.webinar10;

public class ConcreteIntegerCouple extends AbstractCouple {

	public ConcreteIntegerCouple(Object a, Object b) {
		super(a, b);
	}

	/** non si compila, perché c'è un method public Object getA() da soprascrivvere(override) nella classe astratta.
	 *  Il compilatore aspetta che esista un method con stessa firma nella classe ereditaria.
	@Override
	public int getA() {
		return (Integer) super.getA();;
	}
	*/
}
