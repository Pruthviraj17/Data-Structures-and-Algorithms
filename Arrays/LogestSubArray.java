package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LogestSubArray {
    private static int usingTwoPointers(int[] arr,int n,int k){
        int left=0;
        int right=0;
        int max=0;
        int sum=arr[0];
        
        while(right<n){
            while(left<=right && sum>k){
                sum-=arr[left];
                left++;
            }
            
            if(sum==k){
                max=Math.max(max,right-left+1);
            }
            
            right++;
            if(right<n){
                sum+=arr[right];
            }
        }
        
        return max;
    }

    private static int usingHashingPosNegatives(int[] a,int n,int k){

        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += a[i];

            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            int rem = sum - k;

            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = { -3,-1,1,1,3,4,4};
        int k = 4;
        System.out.println(usingHashingPosNegatives(arr, arr.length, k));
    }
}
