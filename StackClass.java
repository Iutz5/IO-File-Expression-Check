/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author ianut
 */
public class StackClass {
    // member data
    private ArrayList<Character> _stack;
    private int _counter;
    
    // Constructor
    public StackClass(){
        _stack = new ArrayList<Character>();
    }
    public boolean isEmpty(){
        return _stack.isEmpty();
    }
    public ArrayList<Character> push(Character c){
           _stack.add(c); 
        return _stack;
    }
    public Character pop(){
        Character toReturn = null;
        if(!_stack.isEmpty()){
            toReturn = _stack.remove(_stack.size()-1);
        }
        return toReturn;
    }
    @Override
    public boolean equals(Object a){ // Overriding boolean to check deep equality between different objects
        // self check
        if (this == a){
            return true;
        }
        // null check
        if (a == null){
            return false;
        }
        // type check and cast
        if (getClass() != a.getClass()){
            return false;
        }
        StackClass s1 = (StackClass) a;
        // field comparison
        boolean toReturn = false;
        if (Objects.equals(_stack, s1._stack) && Objects.equals(_counter, s1._counter)){
            toReturn = true;
        }
        return toReturn;
    }
    public int getSize(ArrayList<Character> stack){
        for (Character _stack1 : _stack) {
            _counter++;
        }
        return _counter;
    }
    @Override
    public String toString(){
        String stackString = "";
        for(int i = 0; i < _stack.size(); i++){
            stackString = stackString + _stack.get(i);
        }
        return stackString;
    }
}

