/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package succesorwithdelete;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author wilsoncastiblanco
 */
public class SuccessorWithDelete {

    static ArrayList<String> sequence;

    public static int smallestSuccessor(String entry) {
        int sequenceValue;
        int nextIndex = sequence.indexOf(entry) + 1;
        int nextValue =  nextIndex >= sequence.size() ? sequence.indexOf(entry) : nextIndex;
        int smallestSuccessor = Integer.parseInt(sequence.get(nextValue));
        for (int i = nextValue; i < sequence.size(); i++) {
            sequenceValue = Integer.parseInt(sequence.get(i));
            if (sequenceValue < smallestSuccessor) {
                smallestSuccessor = sequenceValue;
            }
        }
        return smallestSuccessor;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("successor.in"));
        String linea = bufferedReader.readLine();
        sequence = new ArrayList(Arrays.asList(linea.split(",")));
        linea = bufferedReader.readLine();
        while (linea != null) {
            if (sequence.contains(linea)) {
                int successor = smallestSuccessor(linea);
                sequence.remove(linea);
                System.out.println("Successor of " + linea + " is -> " + successor);
            } else {
                System.out.println("Entry " + linea + " doesn't exist in sequence");
            }
            linea = bufferedReader.readLine();
        }

    }

}
