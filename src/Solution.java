import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
            int testCases = scan.nextInt();
            for(int i = 0; i < testCases; i++){
                long h = scan.nextInt();
                long d = scan.nextInt();
                long w = scan.nextInt();
                //long sum = h * d * 12*w;
                System.out.println(h * d * 12*w);
            }
        }
    }