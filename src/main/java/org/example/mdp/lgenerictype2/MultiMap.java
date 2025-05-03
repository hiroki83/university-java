package org.example.mdp.lgenerictype2;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultiMap<K, T, V extends MultiSet<T>> {

	private Map<K, V> multimap;

	public MultiMap() {
		this.multimap = new HashMap<K, V>();
	}

	public MultiMap(K key, V value) {
		this.multimap = new HashMap<K, V>();
		this.multimap.put(key, value);
	}

	/**
	 * presa in input una chiave e un valore, aggiunge l’associazione alla
	 * multimappa, restituendo true se il valore non era già contenuto nell’insieme
	 * associato alla chiave, false altrimenti. Il metodo gestisce la situazione in
	 * cui la chiave specificata non esista, creando la nuova associazione.
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean put(K key, V value) {
		boolean rtn = true;
		// check is there the same value in map.
		if (multimap.containsValue(value)) {
			rtn = false;
		}
		multimap.put(key, value);
		return rtn;
	}

	public V get(K key) {
		return multimap.get(key);
	}

	public boolean contains(K key, V value) {
		return multimap.get(key).equals(value);
	}

	/**
	 * Un metodo intersect che, presa in input una chiave k e un insieme di valori set, 
	 * 1. Se la chiave è presente rende l’insieme dei valori associato alla chiave uguale 
	 *    all’intersezione tra l’insieme originale e l’insieme set preso in input. 
	 * 2. Se set è pari a null, la chiave k viene rimossa dalla multimappa. 
	 * 3. Se la chiave non è presente, il metodo lancia l’eccezione IllegalArgumentException.
	 * @param key
	 * @param value
	 */
	public void intersect(K key, V value) {
		// exist the input key in multimap ?
		if (multimap.containsKey(key)) {
			V original = multimap.get(key);
			List<T> intersected = original.intersect(value.getMultiset());
			// intersected between original and input vlaue ?
			if (intersected != null && !intersected.isEmpty()) {
				original.getMultiset().clear();
				original.getMultiset().addAll(intersected);
				// put intersected set
				multimap.put(key, original);
			} else {
				// remove multimap
				multimap.remove(key);
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Un metodo intersectMultiMappa che, presa in input una multimappa dello stesso
	 * tipo, rende la multimappa dell’oggetto su cui il metodo è invocato uguale
	 * all’intersezione delle due multimappe.
	 * 
	 * In altre parole, rimarranno in questa multimappa solamente le chiavi che sono
	 * presenti anche nella multimappa presa in input e, per ognuna di queste
	 * chiavi, l’insieme dei valori diventerà uguale all’intersezione degli insiemi
	 * dei valori associati alla chiave nelle due multimappe.
	 * @param inputMap
	 */
	public void intersectMultiMap(MultiMap<K, T, V> inputMap) {
		List<K> intersectKeys = new ArrayList<>();
		// extract common key values
		for (K key : inputMap.multimap.keySet()) {
			if (multimap.containsKey(key))
				intersectKeys.add(key);
		}
		// remove NOT common keys from original
		if (intersectKeys.isEmpty()) {	// if zero common key remove all element of multimap.
			multimap.clear();
			return;
		} else {
			for (K key : multimap.keySet())
				if (!intersectKeys.contains(key))// if the key of original multimap is not common between origina and input remove it.
					multimap.remove(key);
		}
		
		// intersects sets
		for (K commonKey : intersectKeys) {
			V val1 = multimap.get(commonKey);
			V input = inputMap.get(commonKey);
			List<T> intersected = new ArrayList<>();
			for (T v : val1.getMultiset()) {
				if (input.getMultiset().contains(v))
					intersected.add(v);
			}
			val1.getMultiset().clear();
			val1.getMultiset().addAll(intersected);
			multimap.put(commonKey, val1);
		}
	}

	public static void main(String... args) {
		// MultiMap1<Integer, MultiSet<String>> mKIntVStr = new MultiMap1<>();
		MultiMap<Integer, String, MultiSet<String>> mKIntVStr = new MultiMap<>();
		MultiSet<String> mSetStr = new MultiSet<>();
		mSetStr.add("HIROKI");
		System.out.println(mKIntVStr.put(1, mSetStr));
		System.out.println(mKIntVStr.put(1, mSetStr));
		System.out.println(mKIntVStr);
		System.out.println(mKIntVStr.get(1));
		System.out.println();

		MultiMap<String, Integer, MultiSet<Integer>> mKStrVInt = new MultiMap<>();
		MultiSet<Integer> mSetInt = new MultiSet<>();
		mSetInt.add(1);
		mSetInt.add(1);
		mSetInt.add(1);
		mSetInt.add(1);
		mSetInt.add(1);
		mSetInt.add(11);
		mSetInt.add(111);
		System.out.println(mKStrVInt.put("onlyOne", mSetInt));
		System.out.println(mKStrVInt.put("onlyOne", mSetInt));
		System.out.println(mKStrVInt);
		System.out.println(mKStrVInt.get("onlyOne"));

		MultiSet<Integer> mSetInt2 = new MultiSet<>();
		mSetInt2.add(2);
		mSetInt2.add(22);
		mSetInt2.add(222);

		System.out.println(mKStrVInt.contains("onlyOne", mSetInt));
		System.out.println(mKStrVInt.contains("onlyOne", mSetInt2));

		mKStrVInt.put("onlyTwo", mSetInt2);
		System.out.println(mKStrVInt);
		mKStrVInt.intersect("onlyTwo", mSetInt2);
		System.out.println(mKStrVInt);
		try {
			mKStrVInt.intersect("onlyThree", mSetInt2);
		} catch (IllegalArgumentException e) {
			System.out.println("catched IllegalArgumentException!");
		}
	}

	@Override
	public String toString() {
		return "MultiMap [multimap=" + multimap + "]";
	}
}
