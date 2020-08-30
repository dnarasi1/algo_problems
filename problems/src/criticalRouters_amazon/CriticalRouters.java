package criticalRouters_amazon;

import java.util.*;

public class CriticalRouters {
	List<Integer>[] graph;
	int[] ids;
	int[] lowLink;
	boolean[] visited;
	int id =0;
	int size;
	int edgeNum =0;
	boolean art[];
	List<Integer> output;
	public List<Integer> solution(int n, int numEdges, List<List<Integer>> connections){
		size = n;
		graph = new ArrayList[n];
		art = new boolean[n];
		visited = new boolean[n];
		lowLink = new int[n];
		ids = new int[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i =0; i<connections.size();i++) {
			graph[connections.get(i).get(1)].add(connections.get(i).get(0));
			graph[connections.get(i).get(0)].add(connections.get(i).get(1));
		}
		return findNode();	
	}
	public List<Integer> findNode(){
		output = new ArrayList<Integer>();
		for(int i=0; i<size;i++) {
			edgeNum =0;
			if(!visited[i]) {
				dfs(i, i, -1);
				
				art[i] = (edgeNum>1);
			}
		}
		for(int  b=0; b<art.length;b++) {
			if(art[b]==true) output.add(b);
		}
		return output;
	}
	public void dfs(int root, int at, int parent) {
		if(parent==root) edgeNum++;
		visited[at] = true;
		id = id+1;
		lowLink[at] = id;
		ids[at] = id;
		for(int to: graph[at]) {
			if(to==parent) continue;
			if(!visited[to]) {
				dfs(root, to, at);
				lowLink[at] = Math.min(lowLink[at], lowLink[to]);
				if(ids[at]<=lowLink[to]) {
					
					art[at] = true;
				}
			}
			else lowLink[at] = Math.min(lowLink[at], ids[to]);
		}
	}
	
}
