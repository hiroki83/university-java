package org.example.mdp.lgenerictype2;

import java.util.Arrays;
import java.util.List;

public class LessonGenericType2 {

	public static void main(String[] args) {
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

		// Examine the exercise 5 the method intersectMultiMap().
		System.out.println("/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/");
		examine_exercise4_intersect();

		// Examine the exercise 5 the method intersectMultiMap().
		System.out.println("/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/");
		examine_exercise5_intersectMultiMap();
	}

	/**
	 * Examine the function of method intersect().
	 * 
	 * Un metodo intersect che, presa in input una chiave k e un insieme di valori
	 * set, se la chiave è presente rende l’insieme dei valori associato alla chiave
	 * uguale all’intersezione tra l’insieme originale e l’insieme set preso in
	 * input. Se set è pari a null, la chiave k viene rimossa dalla multimappa. Se
	 * la chiave non è presente, il metodo lancia l’eccezione
	 * IllegalArgumentException.
	 */
	private static void examine_exercise4_intersect() {
		// data preparation for examine_exercise4_intersect.
		// declear the variable "originalMultiplMap".
		MultiMap<String, Integer, MultiSet<Integer>> originalMultiMap = new MultiMap<>();
		originalMultiMap.put("intersect1", createMultiSet(Arrays.asList(1, 1, 1, 2, 4, 4, 5)));
		originalMultiMap.put("intersect2", createMultiSet(Arrays.asList(6, 6, 6, 7, 9, 9, 10)));

		// start to examine the function of the method intersect().
		System.out.println("start to examine the function of the method intersect()");
		System.out.println("show data prepared.");
		System.out.println("\t" + originalMultiMap);
		// case1: intersect
		originalMultiMap.intersect("intersect1", createMultiSet(Arrays.asList(1, 1, 2, 4, 7, 7)));
		System.out.println("show data executed of case1: intersect.");
		System.out.println("\t" + originalMultiMap + ", parameters: key=intersect1, MultiSet=[1,1,2,4,7,7]");
		// case2: zero intersect
		originalMultiMap.intersect("intersect2", createMultiSet(Arrays.asList(1, 1, 2, 4, 7, 7)));
		System.out.println("show data executed of case2: zero intersect.");
		System.out.println("\t" + originalMultiMap + ", parameters: key=intersect2, MultiSet=[1,1,2,4,7,7]");
		// case3: throw the IllegalArgumentException
		try {
			originalMultiMap.intersect("intersect3", null);
		} catch (IllegalArgumentException e) {
			System.out.println(
					"case3: showing this message is meaning be throwned the IllegalArgumentException.  parameters: key=intersect3, MultiSet=null");
		}

		System.out.println("e n d to examine the function of the method intersect()");
	}

	/**
	 * Examine the function of method intersectMultiMap().
	 * 
	 * Un metodo intersectMultiMappa che, presa in input una multimappa dello stesso
	 * tipo, rende la multimappa dell’oggetto su cui il metodo è invocato uguale
	 * all’intersezione delle due multimappe.
	 * 
	 * In altre parole, rimarranno in questa multimappa solamente le chiavi che sono
	 * presenti anche nella multimappa presa in input e, per ognuna di queste
	 * chiavi, l’insieme dei valori diventerà uguale all’intersezione degli insiemi
	 * dei valori associati alla chiave nelle due multimappe.
	 */
	private static void examine_exercise5_intersectMultiMap() {
		// data preparation for examine_exercise5_intersectMultiMap.
		// start to examine the function of the method intersectMultiMap().
		System.out.println("start to examine the function of the method intersectMultiMap()");
		// declear the variable "originalMultiplMap".
		MultiMap<String, Integer, MultiSet<Integer>> originalMultiMap = new MultiMap<>();
		// declear the variable "inputMultiplMap" for input parameter.
		MultiMap<String, Integer, MultiSet<Integer>> inputMultiMap = new MultiMap<>();

		// add sets to multimaps
		// case1: intersect
		originalMultiMap.put("intersect1", createMultiSet(Arrays.asList(1, 1, 1, 2, 4, 4, 5)));
		inputMultiMap.put("intersect1", createMultiSet(Arrays.asList(1, 1, 2, 4, 7, 7)));
		// case2: without intersect
		originalMultiMap.put("intersect2", createMultiSet(Arrays.asList(6, 6, 6, 7, 9, 9, 10)));
		inputMultiMap.put("intersect2", createMultiSet(Arrays.asList(1, 1, 2, 4, 8, 8)));
		// case3: NOT common key
		originalMultiMap.put("intersect3", createMultiSet(Arrays.asList(1)));
		// execute the method
		System.out.println("show data prepared.");
		System.out.println("\t" + originalMultiMap);
		System.out.println("\t" + inputMultiMap);
		originalMultiMap.intersectMultiMap(inputMultiMap);
		System.out.println("show data executed.");
		System.out.println("\t" + originalMultiMap);
		System.out.println("\t" + inputMultiMap);
		System.out.println("e n d to examine the function of the method intersectMultiMap()");
	}

	private static <P> MultiSet<P> createMultiSet(List<P> valueList) {
		MultiSet<P> rtn = new MultiSet<>();
		for (P p : valueList) {
			rtn.add(p);
		}
		return rtn;
	}
}
