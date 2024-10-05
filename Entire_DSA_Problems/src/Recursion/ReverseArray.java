package Recursion;

import java.util.Arrays;

public class ReverseArray {
    static void revArray(int[] arr,int s,int e){
        if( s>e || s==e){
            return;
        }
        swap(arr,s,e);
        revArray(arr,s+1,e-1);
    }

    static void swap(int[] arr,int s,int e){
        int temp=arr[s];
        arr[s]=arr[e];
        arr[e]=temp;
    }

    public static void main(String[] args) {
        int[] arr={10,20,30,40};
        System.out.println(Arrays.toString(arr));
        revArray(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
