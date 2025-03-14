package it.rubrica.entity;

import java.util.Objects;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonDeserialize
public class Pair implements Comparable<Pair>{
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

	@Override
	public int compareTo(Pair o) {
		if((this.first + this.second).hashCode() > (o.first + o.second).hashCode())
			return 1;
		if((this.first + this.second).hashCode() == (o.first + o.second).hashCode())
			return 0;
		return -1;
	}
	
	
}
