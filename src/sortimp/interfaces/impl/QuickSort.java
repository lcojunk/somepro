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
public class QuickSort implements Sorter {

    @Override
    public String getType() {
        return "Quick Sort";
    }

    @Override
    public boolean sort(int[] values) {
        if (values==null || values.length==0) return false;
//legen rekursiven Aufruf,0 ist start Wert,values.length-1 ist Endwert,
//values ist Array von zu sortierenden  Elementen 
        quickSort(0, values.length-1, values);

        return true;
    }
    //rekursive Methode
    private void quickSort(int leftS, int rightS,int[] values)
        {
            int PivotValue, leftStehV, rightStehV;

            leftStehV = leftS;
            rightStehV = rightS;
            PivotValue = values[leftS];
            //so lange leftS an rightS vorbei galaufen ist
            while (leftS < rightS)
            {
               //suche die  Zahl ,die kleiner  als  Pivot-Element ist ,von oben nach unten                
                while ((values[rightS] >= PivotValue) && (leftS < rightS))
                {
                    rightS--;
                }

                if (leftS != rightS)
                {
                    values[leftS] = values[rightS];
                    leftS++;
                }
                //suche die Zahl ,die größer als Pivot-Element ist,von unten nach oben
                while ((values[leftS] <= PivotValue) && (leftS < rightS))
                {
                    leftS++;
                }

                if (leftS != rightS)
                {
                    values[rightS] = values[leftS];
                    rightS--;
                }
            }
           //Pivot-Element  links wählen
            values[leftS] = PivotValue;
            //Pivot-Element am linken Seiten erhalten
            PivotValue = leftS;
            //linke Seite erhalten
            leftS = leftStehV;
            rightS = rightStehV;

            if (leftS < PivotValue)
            {
                //Rekurtion
                quickSort(leftS, PivotValue - 1,values);
            }

            if (rightS > PivotValue)
            {
                //Rekurtion
                quickSort(PivotValue + 1, rightS,values);
            }
        }
    
}
