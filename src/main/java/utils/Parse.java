package utils;

import models.Polynom;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {

    public static Polynom parsePolynomial(String poly) {
        Polynom one=new Polynom();
        Pattern pattern = Pattern.compile("([+-]?\\d*)x\\^(\\d+)");
        Matcher matcher = pattern.matcher(poly);

        while (matcher.find()) {

            int exponent = 0;
            double coefficient = 0;
            if (!matcher.group(1).isEmpty()) {
                coefficient = Integer.parseInt(matcher.group(1));
            }
            if (!matcher.group(2).isEmpty()) {
                exponent = Integer.parseInt(matcher.group(2));
            }
            one.getMonomials().put(exponent, coefficient);
        }

        return one;
    }

}

