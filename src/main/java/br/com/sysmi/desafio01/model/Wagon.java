package br.com.sysmi.desafio01.model;

public class Wagon {

	private int index;

	public Wagon(int index) {
		this.index = index;
	}
	
	@Override
	public String toString() {
		return "Wagon: " + index;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wagon other = (Wagon) obj;
		if (index != other.index)
			return false;
		return true;
	}
	
	
}
