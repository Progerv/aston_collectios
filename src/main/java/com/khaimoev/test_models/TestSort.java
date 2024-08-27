package com.khaimoev.test_models;

public class TestSort implements Comparable {
    public int getNum() {
        return num;
    }

    public String getStr() {
        return str;
    }

    private int num;
    private String str;

    public TestSort(int num, String str) {
        this.num = num;
        this.str = str;
    }

    @Override
    public String toString() {
        return "TestSort{" +
                "num=" + num +
                ", str='" + str + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.getNum() - ((TestSort) o).getNum();
    }
}