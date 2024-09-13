package br.com.erudio.rest_with_spring_boot_and_java_erudio.math;

public class SimpleMath {
    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }
    
    public Double subtraction(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }
    
    public Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }
    
    public Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double mean(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo) / 2;
    }

    public Double squareRoot(Double number) {
        return Math.sqrt(number);
    }
}
