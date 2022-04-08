/*
 * Circular Array:�Implement a CircularArray class that
 * supports an array-like data structure which can be
 * efficiently rotated. If possible, the class should
 * use a generic type (also called a template), and should
 * support iteration via the standard
 * for(Obj o : circularArray) notation.*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArray<E> implements Iterable<E> {
	
	private ArrayList<E> myArray;
	
	public CircularArray() {
		this.myArray = new ArrayList<E>();
	}
	
	public void add(E elem) {
		this.myArray.add(elem);
	}
	
	public int length() {
		return myArray.size();
	}
	
	public void rotateForward() {
		E aux = null;
		for(int i = 0; i < myArray.size(); i++) {
			if(i == 0){
				aux = myArray.get(i);
				myArray.set(i, myArray.get(i+1));
			} else if(i == myArray.size()-1) {
				myArray.set(i, aux);
			} else {
				myArray.set(i, myArray.get(i+1));
			}
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new CircularArrayIterator();
	}
	
	private class CircularArrayIterator<T> implements Iterator<T>{
		
		private int current = 0;

		@Override
		public boolean hasNext() {
			return current < myArray.size();
		}

		
		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return (T) myArray.get(current++);
		}
		
	}
	
	public static void main(String[] args) {
//		ArrayList<Integer> test = new ArrayList<Integer>(10);
		CircularArray<Integer> circ = new CircularArray<Integer>();
		for(int i = 0; i < 10; i++) {
			circ.add(i);
		}
		for(int o : circ) {
			System.out.println("Element "+o+" was inside CircularArray.");
		}
		
	}

}
