package assignment4;
import java.util.*;
//Andoni Arias
//SWE619
//2/20/2018
//Homework 4
//  GrowList is a mutable list that only gets longer.
public class GrowList <E> {

  private Map<Integer,E> values;

  public GrowList() { values = new HashMap<Integer,E>();}
 
  // add to the end of the list
  public void add(E o) {
	 //****THE FOLLOWING LINE MUTATES THE PROGRAM AND VIOLATES THE .add CONTRACT WHEN DELETED****
     values.put(size(), o);
  }
  //rep-invariant is that the list cannot have any null values
  public boolean repOk() {
	  int listSize = this.size();
	  for (int i = 0; i < listSize; i++) {
		  if (this.get(i) == null) {
			  return false;
		  }
	  }
	  return true;
  }

  // number of values in list
  public int size() { return values.size(); }

  // get ith value in list
  public E get(int i) { 
     if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.get");
     return values.get(i);
  }

  // update ith value in list;  return previous value or null if none
  public E set(int i, E o) {
	 //*****IF THE FOLLOWING STATEMENT IS DELETED, THE REP-INVARIANT IS VIOLATED
     if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.set");
     return values.put(i, o);
  }
  
  // private helper method
  private boolean inRange(int i) { return (i >= 0) && (i < size()); }

  public String toString() {
      if (size() == 0) return "[]";
      String result = "[";
      for (int i = 0; i < size()-1; i++) {
          result += values.get(i) + ",";
      }
      return result + values.get(size() - 1) + "]";
  }

  public static void main(String[] args) {
     GrowList<String> list = new GrowList<String>();

     System.out.println("list is:" + list);
     list.add("cat");
     System.out.println("list is:" + list);
     list.add("dog");
     System.out.println("list is:" + list);
     System.out.println("repOK check: " + list.repOk());
  }
}

