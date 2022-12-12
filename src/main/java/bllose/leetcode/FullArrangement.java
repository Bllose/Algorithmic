package bllose.leetcode;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FullArrangement {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String[] origin = in.nextLine().split(" ");
		boolean[] recorder = new boolean[origin.length];
		String[] cur = new String[origin.length];
		List<String[]> ans = new ArrayList<>();
		
		dfs(origin, 0, cur, recorder, ans);
		
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for ( String[] an : ans ) {
			sb.append("[");
			for ( int i = 0 ; i < an.length; i ++) {
				sb.append(an[i]).append(",");
			}
			sb.replace(sb.length() - 1, sb.length(), "],");
		}
		sb.replace(sb.length() - 1, sb.length(), "]");
		System.out.println(sb);
	}
	
	private static void dfs(String[] origin, int depth, String[] cur, boolean[] recorder, List<String[]> ans) {
		if(depth == origin.length) {
			String[] theAns = new String[origin.length];
			System.arraycopy(cur, 0, theAns, 0, origin.length);
			ans.add(theAns);
			return;
		}
		
		for( int i = 0 ; i < origin.length; i ++) {
			if(!recorder[i]) {
				cur[depth] = origin[i];
				recorder[i] = true;
				dfs(origin, depth + 1, cur, recorder, ans);
				recorder[i] = false;
			}
		}
	}
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] recorder = new boolean[nums.length];
        Integer[] cur = new Integer[nums.length];
        List<List<Integer>> ans = new ArrayList<>();

        dfs(nums, 0, cur, recorder, ans);

        return ans;
    }

    private void dfs(int[] origin, int depth, Integer[] cur, boolean[] recorder, List<List<Integer>> ans) {
        if(depth == origin.length) {
            List<Integer> theAns = new ArrayList<>(Arrays.asList(cur));
            ans.add(theAns);
            return;
        }

        for( int i = 0 ; i < origin.length; i ++) {
            if(!recorder[i]) {
                cur[depth] = origin[i];
                recorder[i] = true;
                dfs(origin, depth + 1, cur, recorder, ans);
                recorder[i] = false;
            }
        }
    }
  }
