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
public class ShellSort implements Sorter {

    @Override
    public String getType() {
        return "Shell Sort";
    }

    @Override
    //Elemente von Array values,die zum Sortieren sind 
    public boolean sort(int[] values) {
        if (values==null || values.length==0) return false;
        //Zähl-Indexen
        int i, j, Increment, TempV;
        // in 3er Schrittweite
        Increment = 3;
        //während Schrittweite zu  ein einziegerem Schrittweite werden
        while (Increment > 0)
        {
            //das ganze Feld durchlaufen
            for (i = 0; i < values.length; i++)
            {
                j = i;
                TempV = values[i];

                while ((j >= Increment) && (values[j - Increment] > TempV))
                {
                    //Arraylänge von Schrittlänge abziehen
                    values[j] = values[j - Increment];
                    //gespeicherte Elementlänge von Schrittweiten abziehen
                    j = j - Increment;
                }

                values[j] = TempV;
            }

            if (Increment / 2 != 0)
            {
                //Schrittlänge so halbieren bis Schrittlänge zu einzigem Element  wird
                Increment = Increment / 2;
            }
            else if (Increment == 1)
            {
                Increment = 0;
            }
            else
            {
                Increment = 1;
            }
        }

                
        return true;
    }
    
}

    
    
    
