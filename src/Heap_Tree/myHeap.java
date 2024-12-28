package Heap_Tree;

import java.util.Random;
/*Zifeng Wang
202515718
zifeng.wang@bellevuecollege.edu
3/1/2024
In this practice, we will be practicing replacing a data structure (array) with another (arrayList) 
in a previously developed system, so that the updated system will perform better.

Heap211java: Defined basic methods, parent() can find the parent of index, leftChild() and 
rightChild() can find the child of index, etc. Then, using basic methods, 
we designed the methods for add() and remove() that we truly tested.

Heap211Test: Use Random to test the add and remove method.
*/

public class myHeap {

	   final static int HOW_MANY_TESTs = 20;
	   
	   public static void main(String[] args) {
	
		   System.out.println("CP 16. MinHeap (Winter 2024)");
		   	
		   // create an instance of Random class
		   Random rand = new Random();
		   
		   // creat an instance of Heap211 class
		   Heap211 minHeap = new Heap211();	        
	        
		   for (int test = 1; test <= HOW_MANY_TESTs; test++) {
	        	System.out.println();        	
			   //generate an random number to decide the action is 'add' or 'remove'
			   int action = rand.nextInt(3);
	   
			   // if the action is 'add' {
			   if(action <= 1) {
				   // generate a node number using random number (eg 0~49) 
				   int node = rand.nextInt(50);
				   System.out.println("Action " + test + ": Add " + node);   
  	               
				   // add node to the heap	by calling 'add method' in Heap211 class.                                	                  
				   minHeap.add(node);
			   }
			   
	        
			   // if the action is 'remove' {
	          
			   if (action == 2) {  //if the heap is empty, skip this action, do not count this action
				   if(minHeap.isEmpty()) {
					   test = test - 1;
				   } else {
				   System.out.println("Action " + test+": Remove min");
	   		             
				   // remove node to the heap by calling 'remove method' in Heap211 class.	                    
				   minHeap.remove();
				   }
			   }
	             
		   }
	           
	   }
	   
}