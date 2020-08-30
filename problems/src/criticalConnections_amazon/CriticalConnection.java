package criticalConnections_amazon;

import java.util.*;

public class CriticalConnection {
	List<Integer>[] graph;
	int[] ids;
	int[] lowLink;	
	boolean[] visited;
	int size;
	int id =0;
	public List<List<Integer>> solution(int n, List<List<Integer>> connections){
		graph = new ArrayList[n];
		ids = new int[n];
		lowLink = new int[n];
		visited = new boolean[n];
		size = n;
		for(int i =0; i<n;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i =0; i<connections.size();i++) {
			System.out.println(connections.get(i));
			graph[connections.get(i).get(0)-1].add(connections.get(i).get(1)-1);
			graph[connections.get(i).get(1)-1].add(connections.get(i).get(0)-1);
		}
		
		return findBridges();
		
	}
	public List<List<Integer>> findBridges() {
		List<List<Integer>> bridges = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			if(!visited[i]) {
				dfs(i,-1,bridges);
			}
		}
		return bridges;
	}
	public void dfs(int at, int parent, List<List<Integer>> bridges) {
		visited[at] = true;
		id = id+1;
		lowLink[at] = id;
		ids[at] = id;
		
		for(int to: graph[at]) {
			if(to==parent) {
				continue;
			}
			if(!visited[to]) {
				dfs(to, at, bridges);
				lowLink[at] = Math.min(lowLink[at], lowLink[to]);
				if(ids[at]<lowLink[to]) {
					bridges.add(Arrays.asList(at+1, to+1));
				}
			}
			else {
				lowLink[at] = Math.min(lowLink[at], ids[to]);
			}
		}
	}
}
