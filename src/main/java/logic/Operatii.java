package logic;
import models.Polynom;
import utils.Parse;

import java.text.NumberFormat;
import java.util.HashMap;

public class Operatii {
    private static String simplifyPolynomial(Polynom one) {
        StringBuilder sb = new StringBuilder();
        for (int exponent : one.getMonomials().keySet()) {
            Double coefficient = one.getMonomials().get(exponent);
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


    public static String addPolynomials(String one, String two) {
        Polynom map1 = Parse.parsePolynomial(one.toString());
        Polynom map2 = Parse.parsePolynomial(two.toString());
        Polynom result = new Polynom();

        map1.getMonomials().forEach((exponent, coefficient) -> result.getMonomials().put(exponent, coefficient));

        map2.getMonomials().forEach((exponent, coefficient) -> {
            if (result.getMonomials().containsKey(exponent)) {
                coefficient += result.getMonomials().get(exponent);
            }
            result.getMonomials().put(exponent, coefficient);
        });

        return simplifyPolynomial(result);
    }
    public static String subtractPolynomials(String one, String two) {
        Polynom map1 = Parse.parsePolynomial(one.toString());
        Polynom map2 = Parse.parsePolynomial(two.toString());
        Polynom result = new Polynom();

        map1.getMonomials().forEach((exponent, coefficient) -> result.getMonomials().put(exponent, coefficient));

        map2.getMonomials().forEach((exponent, coefficient) -> {
            if (result.getMonomials().containsKey(exponent)) {
                coefficient -= result.getMonomials().get(exponent);
            }
            result.getMonomials().put(exponent, coefficient);
        });

        return simplifyPolynomial(result);
    }


    public static String multipPolynomials(String one, String two) {
        Polynom map1 = Parse.parsePolynomial(one.toString());
        Polynom map2 = Parse.parsePolynomial(two.toString());
        Polynom result = new Polynom();

        map1.getMonomials().forEach((exponent, coefficient) -> result.getMonomials().put(exponent, coefficient));

        map2.getMonomials().forEach((exponent, coefficient) -> {
            if (result.getMonomials().containsKey(exponent)) {
                coefficient *= result.getMonomials().get(exponent);
            }
            result.getMonomials().put(exponent, coefficient);
        });

        return simplifyPolynomial(result);
    }
    public static String derivativePolynomials(String one) {
        Polynom map1 = Parse.parsePolynomial(one.toString());
        Polynom result = new Polynom();

        map1.getMonomials().forEach((exponent, coefficient) -> {
            if (exponent > 0) {
                double newCoefficient = exponent * coefficient;
                result.getMonomials().put(exponent - 1, newCoefficient);
            }
        });

        return simplifyPolynomial(result);
    }

    public static String integratePolynomials(String one) {
        Polynom map1 = Parse.parsePolynomial(one.toString());
        Polynom result = new Polynom();

        map1.getMonomials().forEach((exponent, coefficient) -> {
            double newCoefficient = coefficient / (exponent + 1.0);
            NumberFormat nf= NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            result.getMonomials().put(exponent + 1, Double.valueOf(nf.format(newCoefficient)));
        });

        return simplifyPolynomial(result);
    }
}
