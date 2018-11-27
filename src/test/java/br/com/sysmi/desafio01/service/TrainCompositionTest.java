package br.com.sysmi.desafio01.service;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.sysmi.desafio01.model.Wagon;
import br.com.sysmi.desafio01.service.TrainComposition;

public class TrainCompositionTest {
	
	TrainComposition composition;
	Wagon wagon1, wagon2, wagon3, wagon4;	
	List<Wagon> wagonList;
	
	@Before
	public void init() {
		composition = new TrainComposition();
		wagon1 = new Wagon(1);
		wagon2 = new Wagon(2);
		wagon3 = new Wagon(3);
		wagon4 = new Wagon(4);			
	}	

	@Test(expected = IllegalArgumentException.class)
	public void dontSet_Null_Wagon_AtStart() {
		composition.setStartWagon(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void dontSet_Null_Wagon_AtEnd() {
		composition.setEndWagon(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void dontRemove_First_Empty_Wagon() {
		composition.removeStartWagon();
	}

	@Test(expected = IllegalArgumentException.class)
	public void dontRemove_Last_Empty_Wagon() {
		composition.removeEndWagon();
	}

	@Test
	public void insert_First_Wagon() {
		composition.setStartWagon(wagon1);
		composition.setEndWagon(wagon2);
		
		wagonList = composition.getComposition();
		
		assertEquals(wagonList.get(0), wagon1);
		assertThat(wagonList, hasSize(2));
	}

	@Test
	public void delete_First_Wagon() {
		composition.setStartWagon(wagon1);	
		composition.setEndWagon(wagon2);		
		composition.removeStartWagon();
		
		wagonList = composition.getComposition();
		
		assertThat(wagonList, not(hasItem(wagon1)));		
		assertEquals(wagonList.get(0), wagon2);
		assertThat(wagonList, hasSize(1));
	}

	@Test
	public void insert_Last_Wagon() {
		composition.setStartWagon(wagon1);
		composition.setEndWagon(wagon2);
		
		wagonList = composition.getComposition();
		
		assertEquals(wagonList.get(wagonList.size()-1), wagon2);
		assertThat(wagonList, hasSize(2));
	}

	@Test
	public void delete_Last_Wagon() {
		composition.setStartWagon(wagon1);	
		composition.setEndWagon(wagon2);
		composition.removeEndWagon();
		
		wagonList = composition.getComposition();
		
		assertThat(wagonList, not(hasItem(wagon2)));
		assertEquals(wagonList.get(wagonList.size()-1), wagon1);
		assertThat(wagonList, hasSize(1));
	}

	@Test
	public void insert_Many_First_Wagon() {
		composition.setStartWagon(wagon1);
		composition.setStartWagon(wagon2);
		composition.setStartWagon(wagon3);
		composition.setEndWagon(wagon4);

		wagonList = composition.getComposition();
		
		assertEquals(wagonList.get(0), wagon3);
		assertThat(wagonList, hasSize(4));
	}

	@Test
	public void delete_Many_First_Wagon() {
		composition.setStartWagon(wagon1);
		composition.setStartWagon(wagon2);
		composition.setStartWagon(wagon3);
		composition.setEndWagon(wagon4);
		
		composition.removeStartWagon();
		composition.removeStartWagon();
		
		wagonList = composition.getComposition();
		
		assertThat(wagonList, not(hasItem(wagon2)));
		assertThat(wagonList, not(hasItem(wagon3)));
		assertEquals(wagonList.get(0), wagon1);
		assertThat(wagonList, hasSize(2));
	}

	@Test
	public void insert_Many_Last_Wagon() {
		composition.setStartWagon(wagon1);
		composition.setEndWagon(wagon4);
		composition.setEndWagon(wagon3);
		composition.setEndWagon(wagon2);
		
		wagonList = composition.getComposition();
		
		assertEquals(wagonList.get(wagonList.size()-1), wagon2);
		assertThat(wagonList, hasSize(4));
	}

	@Test
	public void delete_Many_Last_Wagon() {
		composition.setStartWagon(wagon1);
		composition.setEndWagon(wagon4);
		composition.setEndWagon(wagon3);
		composition.setEndWagon(wagon2);
		
		composition.removeEndWagon();
		composition.removeEndWagon();
		
		wagonList = composition.getComposition();
		
		assertThat(wagonList, not(hasItem(wagon2)));
		assertThat(wagonList, not(hasItem(wagon3)));
		assertEquals(wagonList.get(wagonList.size()-1), wagon4);
		assertThat(wagonList, hasSize(2));
	}
}
