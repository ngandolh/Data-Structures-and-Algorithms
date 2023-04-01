/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmap_demo;

import java.io.FileReader;  // for reading characters in a file
import java.util.HashMap;

/**
 *
 * @author DELL
 */

//                                        <ASCII   count>
public class CharCounter extends HashMap<Integer, Integer> {
    int numOfChars = 0;  //number of characters in a file
    public CharCounter() {
        super();
    }
    public CharCounter(String filename) {
        super();
        try {
            // open the file for read characters
            FileReader fr = new FileReader(filename);
            int code; //code of character read
            // while a character is still read from a file
            while((code=fr.read())!=-1) {  //process the character
                // if c is not in the table, put <code. count =1> to the table
                // else increase its count
                if(!this.containsKey(code))
                    this.put(code,1);
                else this.replace(code, this.get(code)+1);
                numOfChars++;  //increase number of characters read
            }
            fr.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void print() {
        // Access each code in the keySet of the table
        for(Integer cObj: this.keySet()) {
            // Print out, format: character, its count, its probability
            System.out.println((char)cObj.intValue()+", "+this.get(cObj)+", "+1.0*this.get(cObj)/numOfChars);
        }
    }
    public static void main(String[] args) {
        CharCounter counter = new CharCounter("laychong.txt");
        counter.print();
    }
}
