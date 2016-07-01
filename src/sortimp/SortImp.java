/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortimp;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import sortimp.interfaces.Sorter;
import sortimp.interfaces.impl.BubbleSort;
import sortimp.interfaces.impl.HeapSort;
import sortimp.interfaces.impl.InsertionSort;
import sortimp.interfaces.impl.MergeSort;
import sortimp.interfaces.impl.QuickSort;
import sortimp.interfaces.impl.SelectionSort;
import sortimp.interfaces.impl.ShellSort;

/**
 *
 * @author candan
 */
public class SortImp {

    /**
     * @param args the command line arguments
     */
    //Anzahl  der  Elemente
    static int dataSizes[] = {1000, 2000, 5000, 10000, 15000, 20000, 30000, 40000, 50000, 60000};
    static int numberOfTests = 10;
    private static int maxNumber = 1000000;

    //überprüfen ,ob die Arrays dasselbe Elemente auf denselben Stellen haben
    private static boolean matchArrays(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private void doNothing() {

    }

    private static long getTimeStamp() {
        Date date = new Date();
        return date.getTime();
    }

    //die Methode macht eine Sortierung,
    //berechnet,wie viel Zeit für Sortierung verbraucht hat,und
    //überprüft ,ob die Sortierung richtig gemacht wurde(sind die Zahlen wirklich sortiert
    private static long findDelay(Sorter sorter, int[] testArr) {
        if (sorter == null || testArr == null || testArr.length == 0) {
            return -1;
        }
        if (testArr.length == 1) {
            return 0;
        }
        int[] sortedArr = new int[testArr.length];
        int[] etalonArr = new int[testArr.length];
        for (int i = 0; i < testArr.length; i++) {
            sortedArr[i] = testArr[i];
            etalonArr[i] = testArr[i];
        }
        Arrays.sort(etalonArr);
        long before = getTimeStamp();
        sorter.sort(sortedArr);
        long after = getTimeStamp();
        if (matchArrays(etalonArr, sortedArr) == false) {
            return -2;
        }
        return after - before;
    }

    //erzeugen Array-Element
    private static int[] createRandomArray(Random random, int arraySize) {
        if (random == null || arraySize < 0) {
            return null;
        }
        int[] result = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            result[i] = random.nextInt(maxNumber);
        }
        return result;
    }

    private static void testAlgorithm() {
        Sorter bubbleSort = new BubbleSort();
        Sorter quickSort = new QuickSort();
        Sorter heapSort = new HeapSort();
        Sorter insertionSort = new InsertionSort();
        Sorter mergeSort = new MergeSort();
        Sorter selectionSort = new SelectionSort();
        Sorter shellSort = new ShellSort();
        double[] bubbleDelays = new double[dataSizes.length];
        double[] quickDelays = new double[dataSizes.length];
        double[] heapDelays = new double[dataSizes.length];
        double[] insertionDelays = new double[dataSizes.length];
        double[] mergeDelays = new double[dataSizes.length];
        double[] selectionDelays = new double[dataSizes.length];
        double[] shellDelays = new double[dataSizes.length];
        Random random = new Random();
        int arraySize, testArray[];
        long delay;
        System.out.println("Maximale Zufallzall: " + maxNumber);
        System.out.println("Anzahl der Tests: " + numberOfTests);
        System.out.println(" Groesse I  Bubble I Quick   I   Heap  IInsertionI  Merge  ISelectionI Shell ");
        System.out.println("---------I---------I---------I---------I---------I---------I---------I---------");
        for (int sizeIdx = 0; sizeIdx < dataSizes.length; sizeIdx++) {
            arraySize = dataSizes[sizeIdx];
            bubbleDelays[sizeIdx] = 0;
            quickDelays[sizeIdx] = 0;
            heapDelays[sizeIdx] = 0;
            insertionDelays[sizeIdx] = 0;
            mergeDelays[sizeIdx] = 0;
            selectionDelays[sizeIdx] = 0;
            shellDelays[sizeIdx] = 0;
            for (int testNumber = 0; testNumber < numberOfTests; testNumber++) {
                testArray = createRandomArray(random, arraySize);
                delay = findDelay(bubbleSort, testArray);
                if (delay < 0) {
                    System.err.println("Error duiring sort operation");
                    return;
                }
                bubbleDelays[sizeIdx] += delay * 1.0 / numberOfTests;
                delay = findDelay(quickSort, testArray);
                if (delay < 0) {
                    System.err.println("Error duiring sort operation");
                    return;
                }
                quickDelays[sizeIdx] += delay * 1.0 / numberOfTests;
                delay = findDelay(heapSort, testArray);
                if (delay < 0) {
                    System.err.println("Error duiring sort operation");
                    return;
                }
                heapDelays[sizeIdx] += delay * 1.0 / numberOfTests;
                delay = findDelay(insertionSort, testArray);
                if (delay < 0) {
                    System.err.println("Error duiring sort operation");
                    return;
                }
                insertionDelays[sizeIdx] += delay * 1.0 / numberOfTests;
                delay = findDelay(mergeSort, testArray);
                if (delay < 0) {
                    System.err.println("Error duiring sort operation");
                    return;
                }
                mergeDelays[sizeIdx] += delay * 1.0 / numberOfTests;
                delay = findDelay(selectionSort, testArray);
                if (delay < 0) {
                    System.err.println("Error duiring sort operation");
                    return;
                }
                selectionDelays[sizeIdx] += delay * 1.0 / numberOfTests;
                delay = findDelay(shellSort, testArray);
                if (delay < 0) {
                    System.err.println("Error duiring sort operation");
                    return;
                }
                shellDelays[sizeIdx] += delay * 1.0 / numberOfTests;
            }
            System.out.printf("%8d I%8.2f I%8.2f I%8.2f I%8.2f I%8.2f I%8.2f I%8.2f%n",
                    arraySize, bubbleDelays[sizeIdx], quickDelays[sizeIdx],
                    heapDelays[sizeIdx], insertionDelays[sizeIdx],
                    mergeDelays[sizeIdx], selectionDelays[sizeIdx], shellDelays[sizeIdx]);
        }

    }

    private static void testQuickAlgorithm() {
        Sorter quickSort = new QuickSort();
        Sorter heapSort = new HeapSort();
        Sorter mergeSort = new MergeSort();
        double[] quickDelays = new double[dataSizes.length];
        double[] heapDelays = new double[dataSizes.length];
        double[] mergeDelays = new double[dataSizes.length];
        Random random = new Random();
        int arraySize, testArray[];
        long delay;
        System.out.println("Maximale Zufallzall: " + maxNumber);
        System.out.println("Anzahl der Tests: " + numberOfTests);
        System.out.println(" Groesse I  Bubble I Quick   I   Heap  IInsertionI  Merge  ISelectionI Shell ");
        System.out.println("---------I---------I---------I---------I---------I---------I---------I---------");
        for (int sizeIdx = 0; sizeIdx < dataSizes.length; sizeIdx++) {
            arraySize = dataSizes[sizeIdx] * 20;
            quickDelays[sizeIdx] = 0;
            heapDelays[sizeIdx] = 0;
            mergeDelays[sizeIdx] = 0;
            for (int testNumber = 0; testNumber < numberOfTests; testNumber++) {
                testArray = createRandomArray(random, arraySize);
                delay = findDelay(quickSort, testArray);
                if (delay < 0) {
                    System.err.println("Error duiring sort operation");
                    return;
                }
                quickDelays[sizeIdx] += delay * 1.0 / numberOfTests;
                delay = findDelay(heapSort, testArray);
                if (delay < 0) {
                    System.err.println("Error duiring sort operation");
                    return;
                }
                heapDelays[sizeIdx] += delay * 1.0 / numberOfTests;
                delay = findDelay(mergeSort, testArray);
                if (delay < 0) {
                    System.err.println("Error duiring sort operation");
                    return;
                }
                mergeDelays[sizeIdx] += delay * 1.0 / numberOfTests;
            }
            System.out.printf("%8d I n/a     I%8.2f I%8.2f I  n/a    I%8.2f I    n/a  I  n/a \n",
                    arraySize, quickDelays[sizeIdx],
                    heapDelays[sizeIdx],
                    mergeDelays[sizeIdx]);
        }

    }

    public static void main(String[] args) {
        testAlgorithm();
        testQuickAlgorithm();
    }

}
