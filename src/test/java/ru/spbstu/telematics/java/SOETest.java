package ru.spbstu.telematics.java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;

public class SOETest extends TestCase {
    public SOETest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        return new TestSuite(SOETest.class);
    }

    private void checkCorrect(double[][] arr, int varsCounter, int equationsCounter, double[][] result)
    {
        SystemOfEquations sys = new SystemOfEquations(varsCounter, equationsCounter, arr);
        double[][] testResult = sys.gauss();
        for(int i = 0; i < equationsCounter; i++)
        	for(int j = 0; j < varsCounter + 1; j++)
        		Assert.assertEquals(testResult[i][j], result[i][j]);
    }
    
    public void testSOE1()
    {
        double[][] arr = {{1, -4, -2, -3}, {3, 1, 1, 5}, {3, -5, -6, -9}};
        double[][] result = {{1, 0, 0, 1},{0, 1, 0, 0},{0, 0, 1, 2}};
        checkCorrect(arr, 3, 3, result);
    }


    public void testSOE2()
    {
        double[][] arr = {{2, 1, 3, -2, 1, 2}, {1, -1, 1, -1, 1, 3}, {3, 2, -1, 1, 4, 4}, {4, -1, 4, -4, -5, 9}};
        double[][] result = {{1, 0, 0, 0, 2, 2},{0, 1, 0, 0, -3, -1},{0, 0, 1, 0, 8, -1}, {0, 0, 0, 1, 12, -1}};
        checkCorrect(arr,  5, 4, result);
    }

    public void testSOE3()
    {
        double[][] arr = {{2, 1, 3, -2, 1,  2}, {1, 0.5, 1, -1, 1, 3}, {3, 2, -1, 1, 4, 4}, {4, -1 ,4, -4, -5, 9}};
        double[][] result = {{1, 0, 0, 0, -0.625, 1.125},{0, 1, 0, 0, 3,  1},{0, 0, 1, 0, -1,  -4}, {0, 0, 0, 1, -1.125, -5.375}};
        checkCorrect(arr, 5, 4, result);
    }

    public void testSOE4()
    {
        double[][] arr = {{1, 2}, {3, 4}};
        double[][] result = {{1, 2},{0, -2}};
        checkCorrect(arr, 1, 2, result);
    }

    public void testSOE5()
    {
        double[][] arr = {{1,2,3},{1,2,4}};
        double[][] result = {{1,2,3},{0,0,1}};
        checkCorrect(arr, 2, 2, result);
    }
    
    public void testSOE6()
    {
        double[][] arr = {{2,-1,-1, 4},{3,4,-2,11},{3,-2,4,11}};
        double[][] result = {{1,0,0,3},{0,1,0,1},{0,0,1,1}};
        checkCorrect(arr, 3, 3, result);
    }
    
    public void testSOE7()
    {
        double[][] arr = {{0,1,-3,4,-5},{1,0,-2,3,-4},{3,2,0,-5,12},{4,3,-5,0,5}};
        double[][] result = {{1,0,0,0,1},{0,1,0,0,2},{0,0,1,0,1},{0,0,0,1,-1}};
        checkCorrect(arr, 4, 4, result);
    }
}





