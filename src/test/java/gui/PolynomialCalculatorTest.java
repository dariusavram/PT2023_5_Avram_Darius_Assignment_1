package gui;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import models.Polynom;
import utils.Parse;

import static logic.Operatii.*;
import static gui.PolynomialCalculator.*;
import static org.junit.jupiter.api.Assertions.*;

public class PolynomialCalculatorTest extends TestCase {


    public PolynomialCalculatorTest( String testName )
    {
        super( testName );
    }
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PolynomialCalculatorTest.class );
    }
    public void testApp()
    {
        //addition
        String addition1="1x^2 +2x^1 +1x^0";
        String addition2="2x^3 +2x^2 +6x^0";

        String resultTrue=addPolynomials(addition1,addition2);
        String resultExpected="7.0+2.0x+3.0x^2+2.0x^3";



        assertEquals(resultExpected,resultTrue);

        //subtraction
        String subtraction1="1x^2 +2x^1 +1x^0";
        String subtraction2="2x^3 +2x^2 +6x^0";

        String resultTrue1=subtractPolynomials(subtraction1,subtraction2);
        String resultExpected1="5.0+2.0x+x^2+2.0x^3";



        assertEquals(resultExpected1,resultTrue1);
        //multiplication
        String multiplication1="1x^2 +2x^1 +1x^0";
        String multiplication2="2x^3 +2x^2 +6x^0";

        String resultTrue2=multipPolynomials(multiplication1,multiplication2);
        String resultExpected2="6.0+2.0x+2.0x^2+2.0x^3";



        assertEquals(resultExpected2,resultTrue2);

        //derivation
        String derivation1="1x^2 +2x^1 +1x^0";

        String resultTrue3=derivativePolynomials(derivation1);
        String resultExpected3="2.0+2.0x";

        assertEquals(resultExpected3,resultTrue3);

        //integration
        String integration1="1x^2 +2x^1 +1x^0";

        String resultTrue4=integratePolynomials(integration1);
        String resultExpected4="x+x^2+0.33x^3";



        assertEquals(resultExpected4,resultTrue4);
    }
}