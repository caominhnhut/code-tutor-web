package com.vn.green.rest.test;

public class Summary {

    private int firstNumber;
    private int secondNumber;
    private int sum;

    public Summary() {

    }

    public Summary(int firstNumber, int secondNumber, int sum) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.sum = sum;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

}


