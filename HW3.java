/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

import Structures.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ianut
 */
public class HW3 {

    /**
     * @param c the character in the String
     * @return whether or not the character is an open bracket, brace, or parenthesis (,{,[
     */
    public static boolean isOpenChar(char c){
        boolean toReturn; // standard local boolean, will change within the code depending on the conditional
        if (c=='['||c=='{'||c=='('){
            toReturn = true;
        } else { // if it is any other character besides these 3, then it is not an open character
            toReturn = false;
        }
        return toReturn;
    }
    /**
     * 
     * @param c the character in the String
     * @return whether or not the character is a closed bracket, brace, or parenthesis ),},]
     */
    public static boolean isClosedChar(char c){
        boolean toReturn;
        if (c==']'||c=='}'||c==')'){  // standard local boolean, will change within the code depending on the conditional
            toReturn = true;
        } else { // if it is any other character besides these 3, then it is not a closed character
            toReturn = false;
        }
        return toReturn;
    }
    /**
     * 
     * @param c the previous open character in the stack
     * @param holder the current closed character
     * @return whether or not the two characters match (),{},[]
     */
    public static boolean isPair(char c, char holder){
        boolean toReturn;
        if(c=='('&&holder==')'){
            toReturn = true;
        } else if (c=='{'&&holder=='}'){
            toReturn = true;
        } else if (c=='['&& holder == ']'){
            toReturn = true;
        } else {
            toReturn = false;
        }
        return toReturn;
    }
    /**
     * 
     * @param expString the expression that the user inputs
     * @return whether or not the expression is balanced (has the same amount of paired brackets, braces, and/or parenthesis
     */
    public static String isBalanced(String expString){
        String charAtI = "";
        for(int i = 0; i< expString.length(); i++){
            char character = expString.charAt(i);
            if(isOpenChar(character)||isClosedChar(character)){
               charAtI = charAtI + character; 
            }
        }
        boolean toReturn = true;
        StackClass expStack = new StackClass();
        int i = 0;
        while (toReturn && i < charAtI.length()){
                char c = charAtI.charAt(i);
                if (isOpenChar(c)){
                    expStack.push(c);
                } else if (isClosedChar(c)){
                    if (expStack.isEmpty()){
                        toReturn = false;
                    }else if (!isPair(expStack.pop(),c)){
                        toReturn = false;
                    }
                }
                i++;
            }
        if(!expStack.isEmpty()){
            toReturn = false;
        }
        String answer;
        if(toReturn){
            answer = "Balanced";
        } else {
            answer = "Unbalanced";
        }
        return answer;
    }
    public static ArrayList<String> read(String filePath) {
        ArrayList<String> lines = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = br.readLine()) != null) {
                // only add the line if it has non-whitespace content
                // strip() removes leading and trailing whitespace
                if(line.strip().length() > 0) { 
                    lines.add(line);
                }
            }
        } catch(IOException e) { // if an error occurs, do this!
            System.err.println("Error reading file!");

            // System.err is like System.out but is used for errors
            // This allows us to separate program output from 
            // error output.
            e.printStackTrace(System.err);
        }

        return lines;
    }

    /* Given a comma separated String, return an 
     *  array of its tokens.  For example:
     *  
     *  String[] letters = commaSeparate("A,B,C,D");
     *  
     *  will return letters = { "A", "B", "C", "D" }
     */
    public static String[] colonSeparate(String line) {
        // Splitting a String is also known as tokenizing it!
        String[] tokens = line.split(":");

        return tokens;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        StackClass a = new StackClass();
        
        String filePath = "data/expressions.txt";
        ArrayList<String> textDoc = new ArrayList<String>();
        textDoc = read(filePath);
        
        for (int i = 0 ; i < textDoc.size() ; i++) {
            String line = textDoc.get(i);
            String[] tokens = colonSeparate(line);
            System.out.println(tokens[0] + ": " + tokens[1] + ": " + isBalanced(tokens[1]));
        }
        
    }
    
}
