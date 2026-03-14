/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.maicol.iterator;

/**
 *
 * @author Maicol
 */

public interface Iterator<T> {

    boolean hasNext();   // checks if there are more elements

    T next();            // returns the next element
}