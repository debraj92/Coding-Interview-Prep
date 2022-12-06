package JavaLearn.HackerRank;



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountAnagrams{

    // Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {
        int l = s.length();
        String sub1, sub2;
        int c=0;
          // number of sizes = 1 to l - 1
          for (int i=1; i<=l-1; i++) {
             for (int j=0; j<l-i; j++) {
                sub1 = s.substring(j, j+i);
                for (int k=j+1; k<=l-i; k++) {
                    sub2 = s.substring(k,k+i);
                    if(isAnagram(sub1,sub2)) {
                        c++;
                    }
                }
             }
          }
          return c;

    }

    static boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s1.length(); i++) {
            char ch = s1.charAt(i);
            if(!hm.containsKey(ch)) {
                hm.put(ch,1);
            } else {
                hm.put(ch,hm.get(ch) + 1);
            }
        }

        for(int i=0; i<s2.length(); i++) {
            char ch = s2.charAt(i);
            if(!hm.containsKey(ch)) {
                return false;
            } else {
                int v = hm.get(ch);
                if (v==1) hm.remove(ch);
                else {
                  hm.put(ch,v-1);
                }
            }
        }
        if(hm.size() > 0) {
            return false;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();*/
    	
    System.out.println(sherlockAndAnagrams("ifailuhkqq"));
    }
}
