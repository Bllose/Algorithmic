package bllose.leetcode;

public class DiffBST {

    /**
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:38 MB,击败了75.93% 的Java用户
     * @param n
     * @return
     */
    public static int numTrees(int n){
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;

        for(int i = 2; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                if(i-j != j-1){
                    G[i] += G[j - 1] * G[i - j];
                }else{
                    G[i] *= 2;
                    G[i] += G[j - 1] * G[i - j];
                    break;
                }
                if(i- 2*j + 1 == 1) {
                    G[i] *= 2;
                    break;
                }
            }
        }
        return G[n];
    }

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.4 MB,击败了12.99% 的Java用户
     *
     * @param n
     * @return
     */
    public static int numTreesNormal(int n){
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;

        for(int i = 2; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        System.out.println("2 = " + DiffBST.numTrees(2));
        System.out.println("5 = " + DiffBST.numTrees(3));
        System.out.println("14 = " + DiffBST.numTrees(4));
        System.out.println("42 = " + DiffBST.numTrees(5));

        System.out.println("2 = " + DiffBST.numTreesNormal(2));
        System.out.println("5 = " + DiffBST.numTreesNormal(3));
        System.out.println("14 = " + DiffBST.numTreesNormal(4));
        System.out.println("42 = " + DiffBST.numTreesNormal(5));
    }
}
