package p20241129_DataStructure;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;

public class Esercizio {

	public static LinkedList<Integer> AddToLinkedList(int n) {
		LinkedList<Integer> li = new LinkedList<Integer>();
		for(int i=0; i < n; i++) {
			li.add(i);
		}
		return li;
	}
	
	public static ArrayList<Integer> AddToArrayList(int n) {
		ArrayList<Integer> li = new ArrayList<Integer>();
		for(int i=0; i < n; i++) {
			li.add(i);
		}
		return li;
	}
	
	public static LinkedList<Integer> AddFirstToLinkedList(int n) {
		LinkedList<Integer> li = new LinkedList<Integer>();
		for(int i=0; i < n; i++) {
			li.addFirst(i);
		}
		return li;
	}
	
	public static ArrayList<Integer> AddFirstToArrayList(int n) {
		ArrayList<Integer> li = new ArrayList<Integer>();
		for(int i=0; i < n; i++) {
			li.addFirst(i);
		}
		return li;
	}
	
	public static NostraLL<Integer> AddFirstToNostraLL(int n) {
		NostraLL<Integer> li = new NostraLL<Integer>(0,null);
		for(int i=0; i < n; i++) {
			li.AddFirst(i);
		}
		return li;
	}
	
	public static NostraLL<Integer> AddToNostraLL(int n) {
		NostraLL<Integer> li = new NostraLL<Integer>(0,null);
		for(Integer i=0; i < n; i++) {
			li.AddLast(i);
		}
		return li;
	}
	
	public static void main(String[] args) {
		// Set, Map, Queue, Stack, Arrays, List
		
		// 1
		var start = System.nanoTime();

		int n = 1000000;
		
		AddToLinkedList(n);
		
		var end = System.nanoTime();
		
		System.out.println("tempo trascorso: " + (end - start)/1000000000.0);
		
//		// 2 
//		start = System.nanoTime();
//
//		n = 1000000;
//		
//		AddToArrayList(n);
//		
//		end = System.nanoTime();
//		
//		System.out.println("tempo trascorso: " + (end - start)/1000000000.0);
//		
//		// 3
//		start = System.nanoTime();
//
//		n = 1000000;
//		
//		AddFirstToArrayList(n);
//		
//		end = System.nanoTime();
//		
//		System.out.println("tempo trascorso: " + (end - start)/1000000000.0);
//		
		// 4
		start = System.nanoTime();

		n = 1000000;
		
		AddFirstToLinkedList(n);
		
		end = System.nanoTime();
		
		System.out.println("tempo trascorso: " + (end - start)/1000000000.0);
		
		
		// 5 
		start = System.nanoTime();

		n = 1000000;
		
		AddFirstToNostraLL(n);
		
		end = System.nanoTime();
		
		System.out.println("tempo trascorso: " + (end - start)/1000000000.0);
		
		
		// 6
		start = System.nanoTime();

		n = 1000000;
		
		AddToNostraLL(n);
		
		end = System.nanoTime();
		
		System.out.println("tempo trascorso: " + (end - start)/1000000000.0);
		
		
		
	}

}
