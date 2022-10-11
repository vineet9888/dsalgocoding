package com.ds.algo.problem.solving.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Map<String , String> map = new HashMap<>();
        List<TestItem> items = new ArrayList<>();
        items.add(new TestItem("vineet",null,27));
        items.add(new TestItem("anmol","anmolsharma",21));
        items.add(new TestItem("kusam lata",null,21));

        map = items.stream().collect(Collectors.toMap(TestItem::getName, item -> item.getValue() != null ? item.getValue() : "N/A"));

        for(Map.Entry<String , String> item : map.entrySet()) {
            System.out.println(item.getKey() + " -> " + item.getValue());
        }




    }
}


class TestItem {
    String name;
    String value;
    Integer age;
    TestItem(String name , String value ,Integer age) {
        this.name = name;
        this.value = value;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}