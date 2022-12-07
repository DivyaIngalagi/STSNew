package com.example;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment1 {

	public void sortFunc1() {
		
	int arr1[]= {10,34,97,4,72,45};
	
	int arr2[]= {16,79,64,2};
	
	int arr3[]= new int[arr1.length+arr2.length];
	int k=0;
	
	 for(int i=0;i<arr1.length;i++) {
            arr3[k++]=arr1[i];
        }
        for(int i=0;i<arr2.length;i++) {
            arr3[k++]=arr2[i];
        }
        
        System.out.println("Merged array before sorting: ");
        for(int i=0;i<arr3.length;i++) {
        	System.out.print(arr3[i]+" ");
        }
         //Using sort method
        Arrays.sort(arr3);
        
        System.out.println("\n"+"Array after sorting: ");
        for(int i:arr3) {
            System.out.print(i+" ");
        }
        
	}

	
		
	public void sortFunc2() {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of elements of 1st array which you want to store: "); 
		int n=sc.nextInt();
		int[] arr1= new int[n];
		
		System.out.println("Enter the elements of 1st array: ");
	
		for(int i=0;i<n;i++) {
			arr1[i]= sc.nextInt();
		}
		
		System.out.print("Enter the number of elements of 2nd array which you want to store: "); 
		int x=sc.nextInt();
		int[] arr2= new int[x];
		
		System.out.println("Enter the elements of 2nd array: ");
	
		for(int i=0;i<arr2.length;i++) {
			arr2[i]= sc.nextInt();
		}
		
		int arr3[]=new int[arr1.length+arr2.length];
		
		int k=0;
		 for(int i=0;i<arr1.length;i++) {
	            arr3[k++]=arr1[i];
	        }
	        for(int i=0;i<arr2.length;i++) {
	            arr3[k++]=arr2[i];
	        }
	        
	        System.out.println("Merged array before sorting: ");
	        for(int i=0;i<arr3.length;i++) {
	        	System.out.print(arr3[i]+" ");
	        }
	         //Without using sort method
	       
	        for(int i=0;i<arr3.length;i++) {
	        	
	        	for(int j=i+1;j<arr3.length;j++) {
	        		
	        		if(arr3[i]>arr3[j]) {
	        			
	        			int temp=0;
	        			temp=arr3[i];
	        			arr3[i]=arr3[j];
	        			arr3[j]=temp;
	        		}
	        		
	        	}
	            
	        }
	        
	        System.out.println("\n"+"Array after sorting: ");
	        for(int i:arr3) {
	            System.out.print(i+" ");
	        }
	       // sc.close();
		
	}
	        
	        
		
		
		
	

}
