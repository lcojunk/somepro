package sortimp.interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author candan
 */
//Schnittstelle   Sorter,damit die Klassen miteinander Gemeinsamkeiten geben
public interface Sorter {               
    public String getType();
 //Methodendeklaration, in der der Wert übergegeben wird ,den wir in unseren  Klassen 
//(Sortier-Algoritmen )
//anwenden
    public boolean sort(int [] values);    
}
