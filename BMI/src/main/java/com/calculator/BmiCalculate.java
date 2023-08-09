package com.calculator;

import java.util.Scanner;

public class BmiCalculate {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please input yur weight in Kg:  ");
        float weight = input.nextFloat();
        System.out.println("Please enter your height in Centimeters:  ");
        float height = input.nextFloat();
        float bmiCal = (weight / (height * height)) * 10000;
        System.out.println("------------");

        if (bmiCal > 25) {
            System.out.format("%.2f", bmiCal);
            System.out.print("  You are Over Weight");
        } else if (bmiCal > 18.5 && bmiCal < 24.5) {
            System.out.format("%.2f", bmiCal);
            System.out.println("  You have a Normal Weight");
        } else {
            System.out.format("%.2f", bmiCal);
            System.out.println("  You are Under_Weight");
        }
    }
}
