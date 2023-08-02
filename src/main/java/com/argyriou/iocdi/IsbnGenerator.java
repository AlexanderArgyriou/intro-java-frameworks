// isbngen

package com.argyriou.iocdi;

public class IsbnGenerator implements Generator {
    @Override
    public int generate() {
        System.out.println("isbn generator");
        return 10;
    }
}
