package com.java.oops.exception.handling;

import java.io.IOException;

public class Child extends  Parent {

    public Child() {
        super("vineet" , 88);
    }

    @Override
    public void test1() throws Exception {
        super.test1();
    }

    @Override
    public void test3() throws ArrayIndexOutOfBoundsException  {

    }
}
