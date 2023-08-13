package com.gl.builder;

import java.util.*;

public class SkyscraperConstruction {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the total number of floors in the building");
		int N = scanner.nextInt();

		List<Integer> floorSizes = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			System.out.println("Enter the floor size given on day " + (i + 1));
			int size = scanner.nextInt();
			floorSizes.add(size);
		}

		List<Integer> constructedFloors = new ArrayList<>();
		for (int size : floorSizes) {
			int idx = constructedFloors.size() - 1;
			while (idx >= 0 && constructedFloors.get(idx) < size) {
				System.out.print(constructedFloors.get(idx) + " ");
				constructedFloors.remove(idx);
				idx--;
			}
			constructedFloors.add(size);

			System.out.println("\nThe order of construction is as follows\n");
			for (int i = floorSizes.indexOf(size); i >= 0; i--) {
				System.out.println("Day: " + (i + 1));
				int currentSize = floorSizes.get(i);
				if (constructedFloors.contains(currentSize)) {
					int index = constructedFloors.indexOf(currentSize);
					for (int j = index; j >= 0; j--) {
						System.out.print(constructedFloors.get(j) + " ");
					}
				}
				System.out.println();
			}
		}

		scanner.close();
	}
}
