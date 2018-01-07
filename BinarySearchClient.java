package JavaLearn;

public class BinarySearchClient {
	public static void main(String[] args){
		String stringToBeSearched = "isha";
		String[] str = {"ankit","bob","claire","david","isha"};
		
		BinarySearch binarysearch = new BinarySearch();
	    int resultIndex1 = binarysearch.binarySearchforString(str,0,str.length-1,stringToBeSearched);
	    System.out.println("the name "+stringToBeSearched+" is at "+resultIndex1+" index of array");	
	}
}

class BinarySearch{
 public int binarySearchforString(String[] str, int l, int r, String s) {
		 if(r>=l) {
			 int mid = l + (r-l)/2;
			System.out.println(mid);
			 if(s.compareToIgnoreCase(str[mid])==0) {
				 return mid;
			 }
			 if (s.compareToIgnoreCase(str[mid])<0) {
				return binarySearchforString(str,l,mid-1,s); //why return?
			 } else {
				 return binarySearchforString(str,mid+1,r,s);
			 }
		 }
		 
		 return -1;
	 }
}