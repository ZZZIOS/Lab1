package ru.spbstu.telematics.java;
public class App{
	public static void main(String[] args){
		int vars = 2, eqs = 2;
		double[][] arr = {{1,2,3},{1,2,4}};
		SystemOfEquations sys = new SystemOfEquations(vars, eqs, arr);
		sys.gauss();
		for(int i = 0; i < eqs; i++) {
			for(int j = 0; j < vars + 1; j++)
				System.out.print(arr[i][j] + " ");
		}
	}
}

