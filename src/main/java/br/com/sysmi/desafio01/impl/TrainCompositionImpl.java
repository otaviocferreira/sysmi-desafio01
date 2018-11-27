package br.com.sysmi.desafio01.impl;

import br.com.sysmi.desafio01.model.Wagon;
import br.com.sysmi.desafio01.service.TrainComposition;

public class TrainCompositionImpl {
	
	public static void main(String[] args) {
		TrainComposition composition;
		Wagon wagon1, wagon3, wagon5, wagon7, wagon9, wagon11, wagon13;
		
		composition = new TrainComposition();
		wagon1 = new Wagon(1);
		wagon3 = new Wagon(3);
		wagon5 = new Wagon(5);
		wagon7 = new Wagon(7);
		wagon9 = new Wagon(9);
		wagon11 = new Wagon(11);
		wagon13 = new Wagon(13);
		
		composition.setStartWagon(wagon7);
		composition.setStartWagon(wagon13);
		
		System.out.println(composition.getComposition());
		System.out.println("Removendo do início - " + composition.removeStartWagon());
		System.out.println(composition.getComposition());
		
		composition.setEndWagon(wagon1);
		composition.setEndWagon(wagon3);
		composition.setEndWagon(wagon5);
		
		System.out.println("Removendo do Final - " + composition.removeEndWagon());		
		System.out.println("Removendo do Final - " + composition.removeEndWagon());
		
		System.out.println(composition.getComposition());
		
		composition.setStartWagon(wagon9);
		composition.setStartWagon(wagon11);
		
		System.out.println(composition.getComposition());
	}

}
