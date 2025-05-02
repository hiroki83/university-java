package org.example.mdp.lgenerictype1;

import java.util.ArrayList;
import java.util.Arrays;

public class LessonGenericType1 {

	public static void main(String[] args) {
		Fruts f = new Fruts("sweet");
		Orange o = new Orange("sweet", "Orange");
		ArrayList<Fruts> fl = new ArrayList<>();
		fl.add(f);
		examine(fl);
		fl.add(o);
		examineAlsoGeneric(fl);
		Orange[] fAry = {new Orange("very sweet", "Australian Orange"), null, null, null};
		examineWithArray(fAry);
	}
	
	private static void examine(ArrayList<Fruts> frutsList) {
		System.out.println("START examine(ArrayList<Fruts> frutsList)");
		for (Fruts f : frutsList)
			System.out.println(f);
	}
	
	private static <T extends Fruts> void examineAlsoGeneric(ArrayList<T> genericFrutsList) {
		System.out.println("START examineAlsoGeneric(ArrayList<T> genericFrutsList)");
		for (T g : genericFrutsList)
			System.out.println(g);
		//genericFrutsList.add(new Orange("a little sweet","Mexican Orange"));//Compile Error
	}

	private static void examineWithArray(Fruts[] genericFrutsArray) {
		System.out.println("START examineWithArray(Fruts[] genericFrutsArray)");
		for (Fruts g : genericFrutsArray)
			System.out.println(g);
		genericFrutsArray[genericFrutsArray.length-2] = new Orange("strange", "Japanese Orange");
		genericFrutsArray[genericFrutsArray.length-3] = new Fruts("sour");// RuntimeException ArrayStoreException
		genericFrutsArray[genericFrutsArray.length-2] = new Apple("sweet too", "Japanese Apple");// RuntimeException ArrayStoreException
		
	}
}
