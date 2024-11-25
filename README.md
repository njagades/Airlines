package coreJavaLearning;

import java.util.Arrays;

public class ArraysLearning {
public static void main(String[] args) {
/*We can call arrays as an container, 
 * we will store the multiple value with Similar data types.
 * we can declare the arrays into two ways
 * we can access the element with help of index value.
 * 
*/

//Single dimensional arrays
int a[]= new int[5];
//Or we can declare arrays like literal
int b[]= {1,2,3,4,5};
a[0]=1;
a[1]=2;
a[2]=3;
a[3]=4;
a[4]=5;
//a[5]=6;
System.out.println(Arrays.toString(a));
System.out.println("==================================================================");
//multi dimensional arrays
int c[][]= new int[2][2];
c[0][0]=3;
c[0][1]=2;
c[1][0]=1;
c[1][1]=4;

for(int i=0; i<2;i++) {
	for(int j=0;j<2;j++) {
		System.out.print(c[i][j]+" ");
	}
	System.out.println();
}
System.out.println("==================================================================");

//Find out the min number from matrix
int min=c[0][0];
for(int k=0; k<2; k++) {
	for(int l=0; l<2;l++) {
		if(c[k][l]<min) {
			min=c[k][l];
					}
	}
	System.out.println(min);
}
System.out.println("==================================================================");
//or
//int d[][]= {{1,2,3},{4,5,6}};
//System.out.println(d[0][1]);



}
}
