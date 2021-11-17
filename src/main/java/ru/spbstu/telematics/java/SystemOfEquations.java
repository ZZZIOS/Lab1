package ru.spbstu.telematics.java;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class SystemOfEquations {
    int equationsCounter;
    int varsCounter;
    double[][] arr;

    public SystemOfEquations(int vars, int equations, double[][] arr){
        varsCounter = vars;
        equationsCounter = equations;
        this.arr = arr;
    }

    double[][] gauss() {
        double divider;
        double factor;
        int o = 0;
        for (int i = 0; i < min(varsCounter, equationsCounter); i++) {
            sort();
            divider = arr[i][i + o];
            if (divider == 0) {
                if(i != varsCounter - 1)
                    i--;
                o++;
                continue;
            }
//            else {
//                o = 0;
//            }
            for (int j = 0; j < varsCounter + 1; j++) {
                arr[i][j] /= divider;
            }

            for (int k = 0; k < equationsCounter; k++) {
                if (k != i) {
                    double sign = arr[k][i];
                    factor = abs(arr[k][i]);
                    for (int h = 0; h < varsCounter + 1; h++) {
                        if (sign < 0)
                            arr[k][h] += factor * arr[i][h];
                        else
                            arr[k][h] -= factor * arr[i][h];
                    }
                }
            }
            
          /*  /////////////////
            
            
		for(int f = 0; f < equationsCounter; f++) {
			for(int j = 0; j < varsCounter + 1; j++)
				System.out.print(arr[f][j] + " ");
			System.out.println();
		}
		
		System.out.println();
		System.out.println();*/
	    /////////////////////////////////////////////
		
            o = 0;
        }
        
         for (int j = 0; j < equationsCounter; j++) {
           for (int i = 0; i < varsCounter + 1; i++) {
                if (arr[j][i] == -0.0)
                    arr[j][i] = 0.0;
                arr[j][i] = Math.round(arr[j][i] * 1000000) / 1000000.0;
            }
        }
        return this.arr;
    }

    void sort() {
        for (int j = 0; j < varsCounter; j++) {
            for (int i = j; i < equationsCounter; i++) {
                for (int k = i; k < equationsCounter - i - 1; k++) {
                    if (this.arr[k][j] == 0 && arr[k + 1][j] != 0)
                        changeEqus(k, k + 1);
                }
            }
        }
    }

    void changeEqus(int h, int l) {
        for (int i = 0; i < varsCounter + 1; i++) {
            double t = arr[h][i];
            arr[h][i] = arr[l][i];
            arr[l][i] = t;
        }
    }
}
