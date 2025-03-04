package it.rubrica.utility;

import java.util.Objects;


public class Pair {
	private String first;
	private String second;
	
	public Pair() {}
	
	public  Pair(String first, String second) {
		this.first = first;
		this.second = second;
	}
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, second);
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		Pair pair = (Pair) o;
		if(pair.first == this.first && this.second == pair.second)
			return true;
		return false;
	}
}
