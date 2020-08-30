package minCostToRepair_amazon;

public class Driver {

	public static void main(String[] args) {
		int n = 6;
        int[][] edges = {{1, 4}, {2, 3}, {4, 5}};
        int[][] edgesToRepair = {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};
        MinCost cost = new MinCost();
        System.out.println("Output: "+cost.solution(n, edges, edgesToRepair));
        

	}

}
