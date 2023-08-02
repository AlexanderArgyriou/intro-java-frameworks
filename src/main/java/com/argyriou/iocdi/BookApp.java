// bookapp

package com.argyriou.iocdi;

public class BookApp {
    public static void main(String[] args) {
        BookService bookServiceIssn = new BookService();
        System.out.println(bookServiceIssn.generateIdentifier());
    }
}