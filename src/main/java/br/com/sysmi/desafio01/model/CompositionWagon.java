package br.com.sysmi.desafio01.model;

public class CompositionWagon {

	private CompositionWagon next;
	private CompositionWagon previous;
	private Wagon wagon;

	public CompositionWagon(Wagon wagon) {
		this.wagon = wagon;
		this.next = this.previous = null;
	}

	public void setNext(CompositionWagon next) {
		this.next = next;
	}

	public CompositionWagon getNext() {
		return next;
	}

	public CompositionWagon getPrevious() {
		return previous;
	}

	public void setPrevious(CompositionWagon previous) {
		this.previous = previous;
	}

	public Wagon getWagon() {
		return wagon;
	}
}
