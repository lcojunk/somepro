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
public class HeapSort implements Sorter {
    @Override
    public String getType() {
        return "Heap Sort";
    }

    @Override
    //Elemente von Array values,die zum Sortieren sind
    public boolean sort(int[] values) { 
        if (values==null || values.length==0) return false;
        //starte von der Mitte
        for (int i=(values.length-1)/2; i >= 0;i--)
            fuegen (values, i, values.length - 1);
        //durch das ganze Feld laufen
        for (int i = values.length - 1; i >= 1; i--) {
            //Elemente vertauschen
            int Temp = values[0];
            values[0] = values[i];
            values[i] = Temp;
            //setzen die Haufen in die Reihenfolgen
            fuegen (values, 0, i - 1);
        }        
        return true;
    }
    //sortiert eine Array in dem jedes Element zwischen i und m ist
    private void fuegen(int[] arr, int i, int m) {
            int tmp = arr[i];
            int j = i * 2 + 1;

            while (j <= m) {
                if (j < m)
                    if (arr[j] < arr[j + 1])
                        j = j + 1;

                if (tmp < arr[j]) {
                    arr[i] = arr[j];
                    i = j;
                    j = 2 * i + 1;
                }
                else {
                    j = m + 1;   
                }
            }

            arr[i] = tmp;
        }
    
}
