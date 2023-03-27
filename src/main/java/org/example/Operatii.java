package org.example;

import javax.swing.*;
import java.util.HashMap;

public class Operatii {
    private static String simplifyPolynomial(HashMap<Integer, Double> map) {
        StringBuilder sb = new StringBuilder();
        for (int exponent : map.keySet()) {
            Double coefficient = map.get(exponent);
            if (coefficient == 0) {
                continue;
            }
            if (coefficient > 0 && sb.length() > 0) {
                sb.append("+");
            }
            if (coefficient != 1 || exponent == 0) {
                sb.append(coefficient);
            }
            if (exponent > 0) {
                sb.append("x");
                if (exponent > 1) {
                    sb.append("^").append(exponent);
                }
            }
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }

    static String addPolynomials(String poly1, String poly2) {
        HashMap<Integer, Double> map1 = PolynomialCalculator.parsePolynomial(poly1);
        HashMap<Integer, Double> map2 = PolynomialCalculator.parsePolynomial(poly2);
        HashMap<Integer, Double> result = new HashMap<>();

        map1.forEach((exponent, coefficient) -> result.put(exponent, coefficient));

        map2.forEach((exponent, coefficient) -> {
            if (result.containsKey(exponent)) {
                coefficient += result.get(exponent);
            }
            result.put(exponent, coefficient);
        });

        return simplifyPolynomial(result);
    }
    static String subtractPolynomials(String poly1, String poly2) {
        HashMap<Integer, Double> map1 = PolynomialCalculator.parsePolynomial(poly1);
        HashMap<Integer, Double> map2 = PolynomialCalculator.parsePolynomial(poly2);
        HashMap<Integer, Double> result = new HashMap<>();

        map1.forEach((exponent, coefficient) -> result.put(exponent, coefficient));

        map2.forEach((exponent, coefficient) -> {
            if (result.containsKey(exponent)) {
                coefficient -= result.get(exponent);
            }
            result.put(exponent, coefficient);
        });

        return simplifyPolynomial(result);
    }


    static String multipPolynomials(String poly1, String poly2) {
        HashMap<Integer, Double> map1 = PolynomialCalculator.parsePolynomial(poly1);
        HashMap<Integer, Double> map2 = PolynomialCalculator.parsePolynomial(poly2);
        HashMap<Integer, Double> result = new HashMap<>();

        map1.forEach((exponent, coefficient) -> result.put(exponent, coefficient));

        map2.forEach((exponent, coefficient) -> {
            if (result.containsKey(exponent)) {
                coefficient *= result.get(exponent);
            }
            result.put(exponent, coefficient);
        });

        return simplifyPolynomial(result);
    }
    public static String derivativePolynomials(String polynomial) {
        HashMap<Integer, Double> map = PolynomialCalculator.parsePolynomial(polynomial);
        HashMap<Integer, Double> result = new HashMap<>();

        map.forEach((exponent, coefficient) -> {
            if (exponent > 0) {
                double newCoefficient = exponent * coefficient;
                result.put(exponent - 1, newCoefficient);
            }
        });

        return simplifyPolynomial(result);
    }

    static String integratePolynomials(String polynomial) {
        HashMap<Integer, Double> map = PolynomialCalculator.parsePolynomial(polynomial);
        HashMap<Integer, Double> result = new HashMap<>();

        map.forEach((exponent, coefficient) -> {
            double newCoefficient = coefficient / (exponent + 1.0);
            result.put(exponent + 1, newCoefficient);
        });

        return simplifyPolynomial(result);
    }
}
