/*
    Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
    Find all unique quadruplets in the array which gives the sum of target.

    Note:
    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
    The solution set must not contain duplicate quadruplets.
        For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

        A solution set is:
        (-1,  0, 0, 1)
        (-2, -1, 1, 2)
        (-2,  0, 0, 2)
*/

// Use set to avoid duplicates. 
// time: O(n^3); space: O(n^3)
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        if (num==null || num.length<4) return new ArrayList<ArrayList<Integer>>(res);
        Arrays.sort(num);
        for (int i=0; i<num.length; i++){
            int a = num[i];
            for (int j=i+1; j<num.length; j++){
                int b = num[j];
                int p = j+1, q=num.length-1;
                while (p < q){
                    int c = num[p], d=num[q];
                    if (a+b+c+d == target){
                        ArrayList<Integer> r= new ArrayList<Integer>();
                        r.add(a); r.add(b); r.add(c); r.add(d);
                        res.add(r);
                        p++;q--;
                    }else if (a+b+c+d < target) p++;
                    else q--;
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(res);
    }
}

// avoid duplicates without using set
// time: O(n^3); space: O(n^3)
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num==null || num.length<=3)
            return res;
        Arrays.sort(num);
        int N = num.length;
        for (int a=0; a<N; a++){
            if (a>0 && num[a]==num[a-1]) // notice
                continue;
            for (int b=a+1; b<N; b++){
                if (b>(a+1) && num[b]==num[b-1])    // notice
                    continue;
                int c = b+1, d = N-1;
                while (c<d){
                    int sum = num[a] + num[b] + num[c] + num[d];
                    if ( sum == target){
                        ArrayList<Integer> r = new ArrayList<Integer>();
                        r.add(num[a]);
                        r.add(num[b]);
                        r.add(num[c]);
                        r.add(num[d]);
                        res.add(r);
                        while (c<d && num[c+1]==num[c])
                            c++;
                        while (c<d && num[d-1]==num[d])
                            d--;
                        if (c>=d)
                            break;
                        c++;    // don't forget to move to the next element with different value
                        d--;
                    }else if (sum < target){
                        c++;
                    }else{
                        d--;
                    }
                }
            }
        }
        return res;
    }
}