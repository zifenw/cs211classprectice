package Heap_Tree;

import java.util.ArrayList;

//Winter 2024

public class Heap211 {

    static public ArrayList <Integer> heap = new ArrayList<>();
    
    Heap211() {
    	heap.add(0);  
    }
          
    int parent(int index) {
        return index / 2;
    }
    
    int leftChild(int index) {
        return 2 * index;
    }
    
    int rightChild(int index) {
        return 2 * index + 1;
    }
    
    boolean hasParent(int index) {
        return index > 1;
    }
    
    boolean hasLeftChild(int index) {
        return 2 * index < heap.size() ;
    }
    
    boolean hasRightChild(int index) {
        return 2 * index + 1 < heap.size();
    }   
    
    void swap(int a, int b) {
        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b,temp);
    }

    int peekMin() {
        return heap.get(1);
    }
       
    boolean isEmpty() {
        return heap.size() == 1;
    }
 
    void add(int value) {
    	
    	heap.add(value); // add as rightmost leaf
      
       	System.out.println("   heap: " +printHeap());
       	System.out.println("   bubble-up: start");
           	
       	//  bubble-up here
        int index = heap.size() - 1;
        boolean found = false;
       	while(!found && hasParent(index)) {
       		int parent = parent(index);
       		if (heap.get(index) < heap.get(parent)){
       			System.out.println("   swap: " + heap.get(index) + " <-> " + heap.get(parent));
       			swap(index,parent(index));
       			index = parent(index);
       		}else {
       			found = true;
       		}
       	}   
       
        System.out.println("   bubble-up: end");
    	System.out.println("   new heap: " + printHeap());
    }

    int remove() {  
    	
    	System.out.println("   heap: " +printHeap());         
    	
    	int min = peekMin();  // peek min value by calling peekMin()
    	int last = heap.size() - 1;
        heap.set(1, heap.get(last)); // move the last node to the first. tip: use one of the ArrayList methods
        System.out.println("   Removed: " + min);
        System.out.println("last node (" + heap.get(last) + ") is moved to the root");
        heap.remove(last); // delete the last node from the heap. The heap is reduced.
        
       	System.out.println("   heap: " +printHeap());   
     	System.out.println("   bubble-down: start");
     	
        // bubble-down here
     	int index = 1;
     	while(hasLeftChild(index)) {
     		int left_index = leftChild(index);
     		int right_index = rightChild(index);
     		
     		int smallChild =  left_index;
     		if(hasRightChild(index) && heap.get(right_index)<heap.get(left_index)) {
     			smallChild = right_index;
     		}
     		if(heap.get(smallChild) < heap.get(index)) {
     			System.out.println("swap: " + heap.get(index) + " <-> " + heap.get(smallChild));
     			swap(index, smallChild);
     			index = smallChild;
     		}else {
     			break;
     		}
     	}       
     	
        System.out.println("   bubble-down: end");
    	System.out.println("   new heap: " +printHeap());
    	
    	return min;
    }
    
    //use this method as is
    public String printHeap(){
    	
        StringBuilder result = new StringBuilder("["); 
        
        if (heap.size()>1) {
         result.append(heap.get(1));
        }
        
        for (int i = 2; i < heap.size(); i++){
            result.append(", ").append(heap.get(i));
        }
                     
        return result + "]";
    }
    
}
