package br.com.sysmi.desafio01.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.sysmi.desafio01.model.CompositionWagon;
import br.com.sysmi.desafio01.model.Wagon;

public class TrainComposition {

	CompositionWagon first;
	CompositionWagon last;
	Wagon removed;
	int sizeComposition;

	public int getSizeComposition() {
		return sizeComposition;
	}

	public void setStartWagon(Wagon wagon) {
		if (null == wagon) throw new IllegalArgumentException("Don't insert NULL in the composition.");
		
		CompositionWagon newWagon = new CompositionWagon(wagon);
		
		if (this.sizeComposition == 0) {
			this.first = newWagon;
			this.last = this.first;			
		} else {
			newWagon.setNext(this.first);
			this.first.setPrevious(newWagon);
			this.first = newWagon;
		}

		this.sizeComposition++;
	}

	public Wagon removeStartWagon() {
		if (this.sizeComposition == 0) {
			throw new IllegalArgumentException("First wagon not occuped.");
		}		

		removed = this.first.getWagon();

		if (this.sizeComposition == 1) {
			this.first = this.last = null;
		} else if (this.sizeComposition >= 1) {
			this.first = this.first.getNext();
			this.first.setPrevious(null);
		}
		
		this.sizeComposition--;
		return removed;
	}

	public void setEndWagon(Wagon wagon) {
		if (null == wagon) throw new IllegalArgumentException("Don't insert NULL in the composition.");
		
		if (this.sizeComposition == 0) {
			this.setStartWagon(wagon);
		} else {
			CompositionWagon newWagon = new CompositionWagon(wagon);
			newWagon.setPrevious(this.last);
			this.last.setNext(newWagon);
			this.last = newWagon;
			this.sizeComposition++;
		}
	}

	public Wagon removeEndWagon() {
		if (this.sizeComposition == 0) {
			throw new IllegalArgumentException("Last wagon not occuped.");
		}

		removed = this.last.getWagon();

		if (this.sizeComposition == 1) {
			this.removeStartWagon();
		} else {
			this.last.getPrevious().setNext(null);
			this.last = this.last.getPrevious();
			this.sizeComposition--;
		}
		
		return removed;
	}
	
	public List<Wagon> getComposition() {
		List<Wagon> list = new ArrayList<>();
		
		if (this.sizeComposition == 0) return list;
		
		CompositionWagon actualWagon = this.first;
		
		do {
			list.add(actualWagon.getWagon());
			actualWagon = actualWagon.getNext();
		} while (null != actualWagon);
		
		return Collections.unmodifiableList(list);
	}
}
