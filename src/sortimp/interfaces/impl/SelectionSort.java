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
public class SelectionSort implements Sorter {

    @Override
    public String getType() {
        return "Selection Sort";
    }

    @Override
    public boolean sort(int[] values) {
    if (values==null || values.length==0) return false;
        int i, j;
        //Index für das kleine Element und Hilfsvariable
        int MinV, TempV;
        // alle Elemente durchlaufen
        for (i = 0; i < values.length - 1; i++)
        {
            MinV = i;

            for (j = i + 1; j < values.length; j++)
            { 
                //mit dem Minimum vergleichen 
                if (values[j] < values[MinV])
                {
                    MinV = j;
                }
            }
             //Elemente vertauschen
            TempV = values[i];
            values[i] = values[MinV];
            values[MinV] = TempV;
        }
        return true;
    }
    
}