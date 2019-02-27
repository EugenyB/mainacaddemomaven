package main;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {

    private final static double EPS = 1e-9;

    public static final double a = -0.5;
    public static final double b = 2.0;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

    }

    public double f(double x) {
        if (x<0.7+EPS) {
            return 1;
        }
        if (x>1.4+EPS) {
            return Math.exp(a*x)*Math.cos(b*x);
        }
        return a*x*x*Math.log(x);
    }

    public int calcSteps(double start, double finish, double step) {
        return (int) Math.round((finish-start)/step+1);
    }

    public double[] fillX(double start, double finish, double step) {
//        double[] x = new double[calcSteps(start,finish,step)];
//        for (int i = 0; i < x.length; i++) {
//            x[i] = start + i*step;
//        }
//        return x;
        var n = calcSteps(start,finish,step);
        return IntStream.range(0, n).mapToDouble(i -> start + i * step).toArray();
    }

    public double[] fillY(double[] x) {
        return DoubleStream.of(x).map(this::f).toArray();
    }

    public int numMin(double[] arr) {
        int nMin = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[nMin]) {
                nMin = i;
            }
        }
        return nMin;
    }

    public int numMax(double[] arr) {
        int nMax = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[nMax]) {
                nMax = i;
            }
        }
        return nMax;
    }

    public double sum(double[] arr) {
        return Arrays.stream(arr).sum();
    }

    public double avg(double[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}
