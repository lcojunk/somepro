/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortimp.interfaces.impl;

import sortimp.interfaces.Sorter;

/**
 *
 * @author candan
 */ 
public class MergeSort implements Sorter {

    @Override
    public String getType() {
        return "Merge Sort";
    }

    
    private int[] numbers;
    private int[] helper;
    private int number;
    
    @Override
    public boolean sort(int[] values) {
        if (values==null || values.length==0) return false;
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
        return true;
    }

    private void mergesort(int low, int high) {
      
         // int j=0;
        //Prüfen ,ob low  (linke Seite )kleiner high (rechte Seite)ist
      if (low < high) {
       //Index  des Elements   in der Mitte bestimmen
        int middle = low + (high - low) / 2;
        //Sortieren  die linke Seite 
        mergesort(low, middle);   
       //Sortiren die rchte Seite
        mergesort(middle + 1, high);
        // Elemente kombinieren 
        merge(low, middle, high);
      }
      
      //int n=1;
    }

    private void merge(int low, int middle, int high) {

     //kopieren  beide Teile in die helper Array
      for (int i = low; i <= high; i++) {
        helper[i] = numbers[i];
      }

      int i = low;
      int j = middle + 1;
      int k = low;
      
     
      //kopieren die kleinsten  Werte von entweder der linken oder der rechten
      // Seite, zurück zu dem ursprunglichen Array
      while (i <= middle && j <= high) {
        if (helper[i] <= helper[j]) {
          numbers[k] = helper[i];
          i++;
        } else {
          numbers[k] = helper[j];
          j++;
        }
        k++;
      }
      
      //kopieren den Rest der linken Seite des Feldes
      // in das Ziel-Array
      while (i <= middle) {
        numbers[k] = helper[i];
        k++;
        i++;
      }
    }       
}
