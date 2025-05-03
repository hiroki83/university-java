package org.example.mdp.lgenerictype2;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class MultiSet<T> {

	private List<T> multiset;

	public MultiSet() {
		this.multiset = new ArrayList<T>();
	}
	
	/**
	 * dato un valore, lo aggiunge al multiinsieme, restituendo true se il
valore non era già contenuto nel multiinsieme, false altrimenti.
	 * @param element
	 * @return boolean
	 */
	public boolean add(T element) {
		Set<T> elementSet = new HashSet<T>(multiset);
		multiset.add(element);
		return elementSet.add(element);
	}
	
	/**
	 * preso in input un valore, restituisce il numero di copie di tale valore
nel multinsieme (0 se il valore non è contenuto).
	 * @param element
	 * @return il numero di copie di tale valore
nel multinsieme (0 se il valore non è contenuto).
	 */
	public int get(T element) {
		if (multiset.contains(element)) {
			int cnt = 0;
			for (T e : multiset)
				if (element.equals(e))
					cnt++;
			return cnt;
		} else
			return 0;
	}
	
	/**
	 * preso in input un valore, restituisce true se il valore è contenuto
nel multiinsieme, false altrimenti.
	 * @param element
	 * @return true se il valore è contenuto
nel multiinsieme, false altrimenti.
	 */
	public boolean contains(T element) {
		return multiset.contains(element);
	}
	
	/**
	 * restituisce l’insieme dei valori contenuti nel multiinsieme, ovvero
senza duplicati.
	 * @return l’insieme dei valori contenuti nel multiinsieme, ovvero
senza duplicati.
	 */
	public Set<T> toSet() {
		return new HashSet<T>(multiset);
	}

	/**
	 * preso in input un multiinsieme set dello stesso tipo dell’oggetto
su cui il metodo è invocato, modifica il multiinsieme di quest’ultimo in modo da contenere
l’intersezione tra se stesso e set. Ad esempio, dato il multinsieme { 1, 1, 1, 2, 4, 4, 5 },
l’intersezione con il multiinsieme { 1, 1, 2, 4, 7, 7 } modifica il primo in { 1, 1, 2, 4 }
	 * @param multiset
	 * @return multiset intersected
	 */
	public List<T> intersect(List<T> multiset) {
		List<T> intersect = new ArrayList<T>();
		for (T element : this.multiset) {
			if (multiset.contains(element)) {
				intersect.add(element);
			}
		}
		return intersect;
	}
	
	
	public List<T> getMultiset() {
		return multiset;
	}

	@Override
	public String toString() {
		return "MultiSet [multiset=" + multiset + "]";
	}

	public static void main(String ... args) {
		MultiSet<Integer> mInt = new MultiSet<>();
		System.out.println("add(1): " + mInt.add(1) + ", "+ mInt);
		System.out.println("add(1): " + mInt.add(1) + ", "+ mInt);
		System.out.println("add(2): " + mInt.add(2) + ", "+ mInt);
		System.out.println("add(3): " + mInt.add(3) + ", "+ mInt);
		System.out.println("add(3): " + mInt.add(3) + ", "+ mInt);
		System.out.println("get(1): " + mInt.get(1));
		System.out.println("containt(1): " + mInt.contains(1));
		System.out.println("toSet(): " + mInt.toSet());
		System.out.println("add(4): " + mInt.add(4) + ", "+ mInt);
		System.out.println("add(7): " + mInt.add(7) + ", "+ mInt);
		System.out.println("add(7): " + mInt.add(7) + ", "+ mInt);
		System.out.println("intersect([1, 1, 1, 2, 4, 4, 5]): " + mInt.intersect(Arrays.asList(1,1,1,2,4,4,5)));

		System.out.println();
		MultiSet<String> mStr = new MultiSet<>();
		System.out.println("add(\"one\"): " + mStr.add("one") + ", "+ mStr);
		System.out.println("add(\"one\"): " + mStr.add("one") + ", "+ mStr);
		System.out.println("add(\"two\"): " + mStr.add("two") + ", "+ mStr);
		System.out.println("add(\"three\"): " + mStr.add("three") + ", "+ mStr);
		System.out.println("add(\"three\"): " + mStr.add("three") + ", "+ mStr);
		System.out.println("get(\"one\"): " + mStr.get("one"));
		System.out.println("containt(\"one\"): " + mStr.contains("one"));
		System.out.println("toSet(): " + mStr.toSet());
		System.out.println("add(\"four\"): " + mStr.add("four") + ", "+ mStr);
		System.out.println("add(\"seven\"): " + mStr.add("seven") + ", "+ mStr);
		System.out.println("add(\"seven\"): " + mStr.add("seven") + ", "+ mStr);
		System.out.println("intersect([\"one\",\"one\",\"one\",\"two\",\"four\",\"four\",\"five\"]): " + mStr.intersect(Arrays.asList("one","one","one","two","four","four","five")));
}
}
