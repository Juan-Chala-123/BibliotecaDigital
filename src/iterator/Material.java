/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maicol.iterator;

/**
 *
 * @author Maicol
 */
public class Material {

    private String code;
    private String title;
    private String author;

    public Material(String code, String title, String author) {
        this.code = code;
        this.title = title;
        this.author = author;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}