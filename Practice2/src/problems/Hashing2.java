package problems;

import java.util.*;

import java.io.*;

public class Hashing2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String array[] = br.readLine().split(" ");
		int[] noArray = new int[N];
		for (int i = 0; i < N; i++) {
			noArray[i] = -1;
		}
		for (int i = 0; i < array.length - 1; i++) {
			int number = Integer.parseInt(array[i]);
			int j = number % N;
			System.out.print(j + " ");
			if (noArray[j] == -1) {
				noArray[j] = number;
			} else {
				int currentLocation = j;
				int tempNumber = number;
				while (true) {
					boolean isPostive = tempNumber % 2 == 0;
					tempNumber = tempNumber / 10;
					if (tempNumber != 0) {
						j = tempNumber % N;
						if (!isPostive) {
							currentLocation = currentLocation + j;
							if (currentLocation >= N) {
								currentLocation -= N;
							}
						} else {
							currentLocation = currentLocation - j;
							if (currentLocation < 0) {
								currentLocation += N;
							}
						}
						System.out.print(currentLocation + " ");
						if (noArray[currentLocation] == -1) {
							noArray[currentLocation] = number;
							break;
						}
					} else {
						currentLocation = j;
						System.out.print(currentLocation + " ");
						if (noArray[currentLocation] == -1) {
							noArray[currentLocation] = number;
							break;
						} else {
							currentLocation--;
							j = currentLocation;
							if (currentLocation < 0) {
								currentLocation += N;
							}
						}

					}
				}
			}
			System.out.println();
		}
	}

}
