package criticalConnections_amazon;

import java.util.*;

import criticalConnections_amazon.CriticalConnection;

public class Driver {

	public static void main(String[] args) {
		//[[1, 2], [1, 3], [2, 3], [3, 4], [3, 6], [4, 5], [6, 7], [6, 9], [7, 8], [8, 9]]
		List<List<Integer>> connections = new ArrayList<>();
		connections.add(Arrays.asList(1,2));
		connections.add(Arrays.asList(1,3));
		connections.add(Arrays.asList(2,3));
		connections.add(Arrays.asList(3,4));
		connections.add(Arrays.asList(3,6));
		connections.add(Arrays.asList(4,5));
		connections.add(Arrays.asList(6,7));
		connections.add(Arrays.asList(6,9));
		connections.add(Arrays.asList(7,8));
		connections.add(Arrays.asList(8,9));
		CriticalConnection critical = new CriticalConnection();
		System.out.println(critical.solution(9, connections));
	}

}
