/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortimp.interfaces;

import java.util.Arrays;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sortimp.interfaces.impl.*;

/**
 *
 * @author candan
 */
public class SorterTest {
    
    Sorter sorter;
    
    int [] expectedArray ={2, 1, 9, 6, 4};
    int [] resultArray ={2, 1, 9, 6, 4};
    
    public SorterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Arrays.sort(expectedArray);
    }
    
    @After
    public void tearDown() {
    }
    
    private boolean matchArrays(int [] arr1, int [] arr2){
        for (int i=0; i<arr1.length; i++){
            if (arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
    private long getTimeStamp() {
        return (new Date()).getTime();
    }

    /**
     * Test of sort method, of class Sorter.
     */
    @Test
    public void testBubbleSort() {
        System.out.println("Bubble Sort");
        sorter = new BubbleSort();
        assertEquals("Bubble Sort",  sorter.getType());
        long timestamp=getTimeStamp();
        sorter.sort(resultArray);
        timestamp=getTimeStamp()-timestamp;
        boolean result=matchArrays(expectedArray, resultArray);
        assertEquals(true, result);
        System.out.println("Done in "+timestamp+" ms");
    }
    
    @Test
    public void testQuickSort() {
        System.out.println("Quick Sort");
        sorter = new QuickSort();
        assertEquals("Quick Sort",  sorter.getType());
        long timestamp=getTimeStamp();
        sorter.sort(resultArray);
        timestamp=getTimeStamp()-timestamp;
        boolean result=matchArrays(expectedArray, resultArray);
        assertEquals(true, result);
        System.out.println("Done in "+timestamp+" ms");
    }

    @Test
    public void testInsertionSort() {
        System.out.println("Insertion Sort");
        sorter = new InsertionSort();
        assertEquals("Insertion Sort",  sorter.getType());
        long timestamp=getTimeStamp();
        sorter.sort(resultArray);
        timestamp=getTimeStamp()-timestamp;
        boolean result=matchArrays(expectedArray, resultArray);
        assertEquals(true, result);
        System.out.println("Done in "+timestamp+" ms");
    }
    
    @Test
    public void testSelectionSort() {
        System.out.println("Selection Sort");
        sorter = new SelectionSort();
        assertEquals("Selection Sort",  sorter.getType());
        long timestamp=getTimeStamp();
        sorter.sort(resultArray);
        timestamp=getTimeStamp()-timestamp;
        boolean result=matchArrays(expectedArray, resultArray);
        assertEquals(true, result);
        System.out.println("Done in "+timestamp+" ms");
    }

    @Test
    public void testShellSort() {
        System.out.println("Shell Sort");
        sorter = new ShellSort();
        assertEquals("Shell Sort",  sorter.getType());
        long timestamp=getTimeStamp();
        sorter.sort(resultArray);
        timestamp=getTimeStamp()-timestamp;
        boolean result=matchArrays(expectedArray, resultArray);
        assertEquals(true, result);
        System.out.println("Done in "+timestamp+" ms");
    }
   
    @Test
    public void testMergeSort() {
        System.out.println("Merge Sort");
        sorter = new MergeSort();
        assertEquals("Merge Sort",  sorter.getType());
        long timestamp=getTimeStamp();
        sorter.sort(resultArray);
        timestamp=getTimeStamp()-timestamp;
        boolean result=matchArrays(expectedArray, resultArray);
        assertEquals(true, result);
        System.out.println("Done in "+timestamp+" ms");
    }
    @Test
    public void testHeapSort() {
        System.out.println("Heap Sort");
        sorter = new HeapSort();
        assertEquals("Heap Sort",  sorter.getType());
        long timestamp=getTimeStamp();
        sorter.sort(resultArray);
        timestamp=getTimeStamp()-timestamp;
        boolean result=matchArrays(expectedArray, resultArray);
        //if(result==true)
        assertEquals(true, result);
        System.out.println("Done in "+timestamp+" ms");
    }
}
