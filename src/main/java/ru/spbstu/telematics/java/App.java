package ru.spbstu.telematics.java;
public class App{
	public static void main(String[] args){
		double[][] arr = {{1,2,3},{1,2,4}};
		SystemOfEquations sys = new SystemOfEquations(2, 2, arr);
		sys.gauss();
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println("fdas");
		}
	}
}

