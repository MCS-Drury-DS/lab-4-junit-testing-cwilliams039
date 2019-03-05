package cs.csmath.complexnumber;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexNumberTest {
    double DELTA = 0.1;
    @Test
    public void getRealPart() {
        ComplexNumber test = new ComplexNumber(1, 2);
        assertEquals(1, test.getRealPart(), DELTA);
    }

    @Test
    public void setRealPart() {
        ComplexNumber test = new ComplexNumber(1, 2);
        test.setRealPart(2.0);
        assertEquals(2, test.getRealPart(), DELTA);
    }

    @Test
    public void getImagPart() {
        ComplexNumber test = new ComplexNumber(1, 2);
        assertEquals(2, test.getImagPart(), DELTA);
    }

    @Test
    public void setImagPart() {
        ComplexNumber test = new ComplexNumber(1, 2);
        test.setRealPart(3.0);
        assertEquals(3, test.getRealPart(), DELTA);
    }
    //Adds 4+2i and 6+i
    @Test
    public void testAdd() {
        ComplexNumber test = new ComplexNumber(4,2 );
        ComplexNumber otherTest = new ComplexNumber(6, 1);
        test.add(otherTest);
        assertEquals(10, test.getRealPart(), DELTA);
        assertEquals(3, test.getImagPart(), DELTA);
    }

    @Test
    public void add1() {
        ComplexNumber test = new ComplexNumber(4,2 );
        ComplexNumber otherTest = new ComplexNumber(6, 1);
        ComplexNumber combo = ComplexNumber.add(test, otherTest);
        assertEquals(10, combo.getRealPart(), DELTA);
        assertEquals(3, combo.getImagPart(), DELTA);
    }

    @Test
    public void sub() {
        ComplexNumber test = new ComplexNumber(4, 2);
        ComplexNumber otherTest = new ComplexNumber(3, 1);
        test.sub(otherTest);
        assertEquals(1, test.getRealPart(), DELTA);
        assertEquals(1, test.getImagPart(), DELTA);
    }

    @Test
    public void sub1() {
        //ComplexNumber test = new ComplexNumber(4,2 );
        //ComplexNumber otherTest = new ComplexNumber(3, 1);
        //ComplexNumber combo = new ComplexNumber.sub(test, otherTest);
        //assertEquals(1, combo.getRealPart(), DELTA);
        //assertEquals(1, combo.getImagPart(), DELTA);
    }

    @Test
    public void mult() {
        ComplexNumber test = new ComplexNumber(3, 2);
        ComplexNumber otherTest = new ComplexNumber(1, 4);
        test.mult(otherTest);
        assertEquals(-5, test.getRealPart(), DELTA);
        assertEquals(14, test.getImagPart(), DELTA);
    }

    @Test
    public void mult1() {
        ComplexNumber test = new ComplexNumber(3,2 );
        ComplexNumber otherTest = new ComplexNumber(1, 4);
        ComplexNumber combo = ComplexNumber.mult(test, otherTest);
        assertEquals(-5, combo.getRealPart(), DELTA);
        assertEquals(14, combo.getImagPart(), DELTA);
    }

    @Test
    public void div() {
        ComplexNumber test = new ComplexNumber(5, 2);
        ComplexNumber otherTest = new ComplexNumber(7, 4);
        test.div(otherTest);
        assertEquals(.6615384615384615, test.getRealPart(), DELTA);
        assertEquals(-.092, test.getImagPart(), DELTA);
    }

    @Test
    public void divByZero(){
        ComplexNumber test = new ComplexNumber(5, 2);
        ComplexNumber otherTest = new ComplexNumber(0, 0);
        try {
            test.div(otherTest);
            fail();
        }
        catch(ArithmeticException e)
        {
            System.out.println("Threw arithmetic exception:");
            e.printStackTrace();
        }
    }
    @Test
    public void div1() {
        ComplexNumber test = new ComplexNumber(5, 2);
        ComplexNumber otherTest = new ComplexNumber(7, 4);
        ComplexNumber results = ComplexNumber.div(test, otherTest);
        assertEquals(.6615, results.getRealPart(), DELTA);
        assertEquals(-.092, results.getImagPart(), DELTA);

    }

    @Test
    public void conj() {
        ComplexNumber test = new ComplexNumber(5, 2);
        test.conj();
        assertEquals(-2, test.getImagPart(), DELTA);
    }

    @Test
    public void abs() {
        ComplexNumber test = new ComplexNumber(3, 4);
        double absValue = test.abs();
        assertEquals(5, absValue, DELTA);
    }

    @Test
    public void testToStringPositive() {
        ComplexNumber test = new ComplexNumber(5, 3);
        String testString = test.toString();
        assertEquals("5.0 +3.0i", testString);
    }

    @Test
    public void testToStringNegative(){
        ComplexNumber test = new ComplexNumber(5, -2);
        String testString = test.toString();
        assertEquals("5.0 -2.0i", testString);
    }

    @Test
    public void main() {
    }
}