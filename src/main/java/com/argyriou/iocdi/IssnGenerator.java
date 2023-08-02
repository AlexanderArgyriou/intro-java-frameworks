// issngen

package com.argyriou.iocdi;

public class IssnGenerator implements Generator {
    @Override
    public int generate() {
        System.out.println("issn generator");
        return 100;
    }
}