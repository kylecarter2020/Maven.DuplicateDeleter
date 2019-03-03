package com.zipcodewilmington.looplabs;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by leon on 1/29/18.
 *
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer[] copyOfOriginal = Arrays.copyOf(super.array, super.array.length);
        for (Integer i: copyOfOriginal) {
            int occurs = numberOfOccurrences(copyOfOriginal, i);
            if(occurs >= maxNumberOfDuplications){
                copyOfOriginal = removeAll(copyOfOriginal, i);
            }
        }
        return createNewArray(copyOfOriginal);
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer[] copyOfOriginal = Arrays.copyOf(super.array, super.array.length);
        for (Integer i: copyOfOriginal) {
            int occurs = numberOfOccurrences(copyOfOriginal, i);
            if(occurs == exactNumberOfDuplications){
                removeAll(copyOfOriginal, i);
            }
        }
        return createNewArray(copyOfOriginal);
    }

    public int numberOfOccurrences(Integer[] arr, Integer val) {
        int numOccurrences = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == val){
                numOccurrences++;
            }
        }
        return numOccurrences;
    }

    public Integer[] removeAll(Integer[] arr, Integer valueToRemove) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i] == valueToRemove) {
                arr[i] = null;
            }
        }
        return arr;
    }

    public Integer[] createNewArray(Integer[] arr) {
        int numElements = numberOfElements(arr);
        int newArrayIndex = 0;
        Integer[] newArray = new Integer[numElements];
        for (Integer i: arr) {
            if(i != null){
                newArray[newArrayIndex] = i;
                newArrayIndex++;
            }
        }

        return newArray;
    }

    private int numberOfElements(Integer[] arr) {
        int numElements = 0;
        for (Integer i: arr) {
            if(!(i == null)){
                numElements++;
            }
        }
        return numElements;
    }
}
