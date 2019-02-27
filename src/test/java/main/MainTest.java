package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    final static double EPS = 1e-6; // 0.000001

    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testF1() {
        System.out.println("Testing f(x) x <= 0.7");
        double x = 0.5;
        double expected = 1.0;
        double result = main.f(x);
        assertEquals(expected, result, EPS);
    }

    @Test
    void testF2() {
        System.out.println("Testing f(x) x > 1.4");
        double x = 2.0;
        double expected = -0.240462; // 04996858368907557575135511;
        double result = main.f(x);
        assertEquals(expected, result, EPS);
    }

    @Test
    void testF3() {
        System.out.println("Testing f(x)  0.7 < x <= 1.4");
        double x = 1.2;
        double expected = -0.131272;
        double result = main.f(x);
        assertEquals(expected, result, EPS);
    }

    @Test
    void testCalcSteps() {
        System.out.println("Testing calcSteps(0, 3, 0.004) - 751");
        double start = 0.0;
        double finish = 3.0;
        double step = 0.004;
        int expected = 751;
        int result = main.calcSteps(start, finish, step);
        assertEquals(expected, result);
    }

    @Test
    void testFillX() {
        System.out.println("Testing fillX(0,3,0.004)");
        var start = 0.0;
        var finish = 3.0;
        var step = 0.004;
        double[] x = main.fillX(start, finish, step);
        double[] expected = {0.7, 1.4, 3.0};

        assertEquals(expected[0], x[175], EPS);
        System.out.println(">>>"+x[175]);
        assertEquals(expected[1], x[350], EPS);
        System.out.println(">>>"+x[350]);
        assertEquals(expected[2], x[750], EPS);
        System.out.println(">>>"+x[750]);
        assertEquals(751, x.length);
    }

    @Test
    void testFillY() {
        var start = 0.0;
        var finish = 3.0;
        var step = 0.004;
        double[] x = main.fillX(start, finish, step);
        double[] y = main.fillY(x);
        double[] expected = {1.0, -0.329743, 0.214243};

        assertEquals(expected[0], y[175], EPS);
        assertEquals(expected[1], y[350], EPS);
        assertEquals(expected[2], y[750], EPS);
        assertEquals(751, y.length);

    }

    @Test
    void testNumMin() {
        System.out.println("Testing numMin");
        double[] arr = {1.5, -2.7, 3.0, 4.1, -5.5, 10.0, 9.4};
        int expected = 4;
        int result = main.numMin(arr);
        assertEquals(expected, result);
    }

    @Test
    void testNumMax() {
        System.out.println("Testing numMax");
        double[] arr = {1.5, -2.7, 3.0, 4.1, -5.5, 10.0, 9.4};
        int expected = 5;
        int result = main.numMax(arr);
        assertEquals(expected, result);
    }

    @Test
    void testSum() {
        System.out.println("Testing sum()");
        double[] arr = {1.5, -2.7, 3.0, 4.1, -5.5, 10.0, 9.4};
        double expected = 19.8;
        double result = main.sum(arr);
        assertEquals(expected, result, EPS);
        System.out.println(">>>" + result);
    }

    @Test
    void testAvg() {
        System.out.println("Testing avg()");
        double[] arr = {1.5, -2.7, 3.0, 4.1, -5.5, 10.0, 9.4};
        double expected = 2.828571;
        double result = main.avg(arr);
        assertEquals(expected, result, EPS);
    }
}