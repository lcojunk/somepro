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
//Klasse Bubblesort implementiert Schnittstelle Sorter
public class BubbleSort implements Sorter {

    @Override
    public String getType() {
        return "Bubble Sort";
    }

    @Override
    //Elemente von Array values,die  zum Sortieren sind
    public boolean sort(int[] values) { 
       if (values==null || values.length==0) return false;
        int i;
        int j;
        int tmp;
        //durch das ganze Feld laufen
        for (i = (values.length - 1); i >= 0; i--) {  
            //beginnend am Anfang des Elements das kleinste Element zu suchen
            for (j = 1; j <= i; j++) {
                //Prüfen,ob das Element größer als der Vorgänger ist
                if (values[j - 1] > values[j]) {  
                    //Werte tauschen                             
                    tmp = values[j - 1];
                    values[j - 1] = values[j];
                    values[j] = tmp;
                }
            }
        }       
       return true;
    }
    
}
