package loadBalancer_amazon;

public class Driver {

	public static void main(String[] args) {
		LoadBalancer load = new LoadBalancer();
		int [] input = {2,3,4,1,2,8,6,1,2,3,4,5,5,5,5,3,6,1,1,1,1,1,1};
		System.out.println("And the output is: "+load.solution(input));

	}

}
