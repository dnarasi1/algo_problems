package loadBalancer_amazon;

public class LoadBalancer {
	public boolean solution(int[] input) {
		
		int[] check = new int[input.length];
		check[0] = input[0];
		for(int i=1;i<input.length;i++) {
			check[i] = check[i-1]+input[i];
		}
		int left = 1;
		int right = input.length-2;
		int leftSum;
		int rightSum;
		int middleSum;
		while(left<right) {
			leftSum = check[left] - input[left];
			rightSum = check[check.length-1] - check[right];
			middleSum = check[right] - check[left]-input[right];
			System.out.println(leftSum+" "+middleSum+" "+rightSum);
			if(leftSum==middleSum && middleSum==rightSum) {
				return true;
			}
			else if(leftSum>rightSum){
				right--;
				continue;
			}
			else if(leftSum<rightSum) {
				left++;
				continue;
			}
			else {
				right--;
				left++;
			}
		}
		return false;
	} 
}
