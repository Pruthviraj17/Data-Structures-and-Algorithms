package Arrays;

public class MaxConsquetive1 {
    private static int bruteForce(int[] nums,int n){
        int max=0;
        int i=0;
        int j=0;

        while(j<n){
            if(nums[j]==0){
                if(max<(j-i)){
                    max=j-i;
                }
                j++;
                i=j;
            }
            else if(nums[j]==1){
                j++;
            }
        }

        if(max<(j-i)){
                    max=j-i;
        }

        return max;
    }  
    public static void main(String[] args) {
        int arr[]={1,0,1,1,1,0,0};
        System.out.println(bruteForce(arr, arr.length));
    }
}
