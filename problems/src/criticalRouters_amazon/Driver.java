package criticalRouters_amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import criticalRouters_amazon.CriticalRouters;

public class Driver {
	public static void main(String[] args) {
		//[[0, 1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3, 4]]
		List<List<Integer>> connections = new ArrayList<>();
		connections.add(Arrays.asList(0,1));
		connections.add(Arrays.asList(0,2));
		connections.add(Arrays.asList(1,3));
		connections.add(Arrays.asList(2,3));
		connections.add(Arrays.asList(2,5));
		connections.add(Arrays.asList(5,6));
		connections.add(Arrays.asList(3,4));
		CriticalRouters critical = new CriticalRouters();
		System.out.println(critical.solution(7, 7, connections));
	}
}
