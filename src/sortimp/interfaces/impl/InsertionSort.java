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
public class InsertionSort implements Sorter {

    @Override
    public String getType() {
        return "Insertion Sort";
    }

    @Override
    //Elemente von Array values,die zum Sortieren sind
    public boolean sort(int[] values) { 
        if (values==null || values.length==0) return false;
        int i;
        int j;
        //aktuelle Variable von unsortierte Array-Element
        int index;
        //Schleife durch unsortierte  Array
        for (i = 1; i < values.length; i++)
        {
            //aktuelle Position speichern
            index = values[i];
            //den Index des letzten sortierten Element enthalten
            j = i;

            while ((j > 0) && (values[j - 1] > index))
            {
                values[j] = values[j - 1];
                j = j - 1;
            }
            //Element fügen
            values[j] = index;
            }        
        return true;
    }
    
    
}
