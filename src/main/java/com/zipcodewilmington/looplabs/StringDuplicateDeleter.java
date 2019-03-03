package com.zipcodewilmington.looplabs;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] stringArray) {
        super(stringArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String[] copyOfOriginal = Arrays.copyOf(super.array, super.array.length);
        for (String i: copyOfOriginal) {
            int occurs = numberOfOccurrences(copyOfOriginal, i);
            if(occurs >= maxNumberOfDuplications){
                copyOfOriginal = removeAll(copyOfOriginal, i);
            }
        }
        return createNewArray(copyOfOriginal);
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] copyOfOriginal = Arrays.copyOf(super.array, super.array.length);
        for (String i: copyOfOriginal) {
            int occurs = numberOfOccurrences(copyOfOriginal, i);
            if(occurs == exactNumberOfDuplications){
                removeAll(copyOfOriginal, i);
            }
        }
        return createNewArray(copyOfOriginal);
    }

    public int numberOfOccurrences(String[] arr, String val) {
        int numOccurrences = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == val){
                numOccurrences++;
            }
        }
        return numOccurrences;
    }

    public String[] removeAll(String[] arr, String stringToRemove) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i] == stringToRemove) {
                arr[i] = null;
            }
        }
        return arr;
    }

    public String[] createNewArray(String[] arr) {
        int numElements = numberOfElements(arr);
        int newArrayIndex = 0;
        String[] newArray = new String[numElements];
        for (String i: arr) {
            if(i != null){
                newArray[newArrayIndex] = i;
                newArrayIndex++;
            }
        }

        return newArray;
    }

    private int numberOfElements(String[] arr) {
        int numElements = 0;
        for (String i: arr) {
            if(!(i == null)){
                numElements++;
            }
        }
        return numElements;
    }
}

