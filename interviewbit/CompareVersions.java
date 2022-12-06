package JavaLearn.interviewbit;

import java.math.BigInteger;

// https://www.interviewbit.com/problems/compare-version-numbers/

public class CompareVersions {
	public static int compareVersion(String A, String B) {
        String[] arr = A.split("\\.");
        String[] brr = B.split("\\.");
        int i=0;
        while(i<arr.length && i<brr.length) {
            if(new BigInteger(arr[i]).compareTo(new BigInteger(brr[i])) > 0) {
                return 1;
            }
            if(new BigInteger(arr[i]).compareTo( new BigInteger(brr[i])) < 0) {
                return -1;
            }
            i++;
        }
        if(arr.length > brr.length) {
            while(i<arr.length) {
                if(new BigInteger(arr[i]).compareTo(BigInteger.ZERO) > 0) {
                    return 1;
                }
                i++;
            }
        } else if (arr.length < brr.length) {
            while(i<brr.length) {
                if(new BigInteger(brr[i]).compareTo(BigInteger.ZERO) > 0) {
                    return -1;
                }
                i++;
            }
        }
        return 0;
    }
	
	public static void main(String[]args) {
		System.out.println(compareVersion("1.13","1.13.4"));
	}
}
