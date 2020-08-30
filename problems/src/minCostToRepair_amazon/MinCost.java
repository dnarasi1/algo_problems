package minCostToRepair_amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MinCost {
	public int solution(int n, int[][] edges, int[][] edgesToRepair){
		int output =0;
		HashSet<String>set = new HashSet<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
		for(int i = 0;i<edgesToRepair.length;i++) {
			int[] temp = new int[2];
			if(edgesToRepair[i][0]>edgesToRepair[i][1]) {
				temp[0] = edgesToRepair[i][1];
				temp[1] = edgesToRepair[i][0];
			}
			else {
				temp[0] = edgesToRepair[i][0];
				temp[1] = edgesToRepair[i][1];
			}
			set.add(Arrays.toString(temp));
			pq.add(edgesToRepair[i]);
		}
		for(int i = 0;i<edges.length;i++) {
			if(set.contains(Arrays.toString(edges[i]))) {
				continue;
			}
			int[] temp = new int[3];
			temp[0] = edges[i][0];
			temp[1] = edges[i][1];
			temp[2] = 0;
			pq.add(temp);
		}
		int[] parent = new int[n+1];
		for(int i =0;i<parent.length;i++) {
			parent[i]=i;
		}
		while(!pq.isEmpty()) {
			int[] smallest = pq.poll();
			System.out.println(smallest[0]+" "+smallest[1]+" "+smallest[2]);
			int x = find(parent, smallest[0]);
			
			int y = find(parent, smallest[1]);
			//System.out.println(x+" "+y);
			if(x!=y) {
				union(x,y,parent);
				output = output+=smallest[2];
			}
		}
		return output;
	}
	public int find(int[] parent, int i) {
		if(parent[i]!=i) {
			parent[i] = find(parent, parent[i]);
		}
		return parent[i];
	}
	public void union(int x, int y, int[] parent) {
		int xRoot = find(parent, x);
		int yRoot = find(parent, y);
		parent[yRoot] = xRoot;
	}
	
}
