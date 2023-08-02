// bookser

package com.argyriou.iocdi;

public class BookService {
    private final IssnGenerator generator;

    public BookService() {
        this.generator = new IssnGenerator();
    }

    public int generateIdentifier() {
        return generator.generate();
    }
}