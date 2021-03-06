/**
 * Graphical Sorter - HeapSort
 * @author Hunter Quant
 * @version rev001
 */

 package com.rath.sorts;

 import com.rath.elem.ArrayMemberList;
 import com.rath.sortext.RathSort;

 public class HeapSort extends RathSort {

   /**
   * Default constructor
   * @param argArray a reference to the ArrayMemberList to be sorted
   * All sorts must have a constructor Constructor(ArrayMemberList) to be considered valid.
   */
   public HeapSort(ArrayMemberList argArray) {
     array = argArray;
   }

   /**
    * Preforms a HeapSort algorithm.
    */
   public void sort() {
     super.sort();
     //Build the heap.
     createHeap();
     //Lowest value in the heap.
     int last = array.getSize() - 1;

     while (last > 0) {
       //Swap the lowest value in the heap with the root.
       array.swap(last--, 0);
       //Pack the heap.
       moveDown(0, last);
     }
   }

   /**
    * Creates the heap.
    */
   public void createHeap() {
     //The last parent in the tree.
     int first = (array.getSize() - 2)/2;

     while (first >= 0) {
       //Pack the heap.
       moveDown(first--, array.getSize() - 1);
     }
   }

   /**
    * @Param The index of the last parent.
    */
   public void moveDown(int first, int last) {
     //The root of current subheap.
     int root = first;
     //While root has a left child.
     while (root * 2 + 1 <= last) {
       int child = root * 2 + 1;
       int temp = root;
       //If the childs value is less than that of the root. reassign temp.
       if (array.compare(temp, child) == -1) {
         temp = child;
       }
       //If we aren't at the end of the tree and the right child is bigger.
       if (child + 1 <= last && array.compare(temp, child+1) == -1) {
         temp = child + 1;
       }
       //If they are equal at this point do nothing.
       if (temp == root) {
         return;
       } else { //Else swap them.
          array.swap(root, temp);
          //Temp is the new root.
          root = temp;
       }
     }
   }
}
