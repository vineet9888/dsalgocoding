package com.com.threading;

import java.util.Iterator;
import java.util.LinkedList;

public class TrickyOOPs {


    private static int val;

    public TrickyOOPs() {
        this.val++;
    }

    public int getVal() {
        return this.val;
    }

    static int get(int x, int y, int z)
    {

        // remainder can't be larger
        // than the largest number,
        // if so then answer doesn't exist.
        if (x > z)
            return -1;

        // reduce number by x
        int val = z - x;

        // finding the possible
        // number that is divisible by y
        int div = (z - x) / y;

        // this number is always <= x
        // as we calculated over z - x
        int ans = div * y + x;

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(get(3,2,9));
        TrickyOOPs o1 = new TrickyOOPs();
        TrickyOOPs o2 = new TrickyOOPs();
        TrickyOOPs o3 = new TrickyOOPs();
        o3.val++;
        System.out.println(o3.val);
        Foo foo= new Bar();
        foo.impl();
        LinkedList<String> list = new LinkedList<>();
        list.add("vineet");

        list.add("anmol");
        list.add(2,"adesh");
        list.add("iwaan");


        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}


interface Foo {
    String name = "Vineet";
    public void impl();
}

class Bar implements Foo {

    String name = "vineet sharma";

    @Override
    public void impl() {
        System.out.println(name);
    }
}
