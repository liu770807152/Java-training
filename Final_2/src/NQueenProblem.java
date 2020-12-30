import java.util.ArrayList;
import java.util.HashSet;

public class NQueenProblem {
    /**
     * 回溯法求解
     * @param k 当前处理第几行
     * @param n N皇后问题的N
     * @param queen 存储皇后的位置
     * @param attack 标记皇后的攻击区域的二维数组
     * @param solutions 存储所有解法
     */
    private static void backTrack(int k, int n, ArrayList<String> queen, ArrayList<ArrayList<Integer>> attack, HashSet<ArrayList<String>> solutions) {
        // 找到一个解，记录解的深拷贝！
        if (k == n) {
            ArrayList<String> temp = new ArrayList<>();
            temp.addAll(queen);
            solutions.add(temp);
            return;
        }
        // 遍历0至n-1列，在循环中回溯试探皇后的位置
        for (int i=0; i<n; i++) {
            // 判断第k行第i列是否可以放置皇后
            if (attack.get(k).get(i) == 0) {
                // 备份attack, 注意一定要深拷贝
                ArrayList temp = new ArrayList<>();
                for (ArrayList cur : attack) {
                    temp.add(cur.clone());
                }
                // 放置皇后并记录
                StringBuilder cur = new StringBuilder(queen.get(k));
                cur.replace(i, i+1, "Q");
                queen.set(k, cur.toString());
                putQueen(k, i, attack);
                // 递归放置下一个皇后
                backTrack(k+1, n, queen, attack, solutions);
                // 恢复原状态
                attack = temp;
                cur = new StringBuilder(queen.get(k));
                cur.replace(i, i+1, ".");
                queen.set(k, cur.toString());
            }
        }
    }

    /**
     * 放置皇后
     * @param x 表行数
     * @param y 表列数
     * @param attack 标记皇后的攻击区域的二维数组
     */
    private static void putQueen(int x, int y, ArrayList<ArrayList<Integer>> attack) {
        // 记录8个方向的坐标变化
        final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        attack.get(x).set(y, 1);

        // 依据n循环访问所有变化后的坐标
        for (int i=1; i<attack.size(); i++) { // 从皇后位置开始向1到n-1个距离延申
            for (int j=0; j<8; j++) { // 遍历8个方向
                int newX = x + i * dx[j];
                int newY = y + i * dy[j];
                // 不可以越界
                if (newX >= 0 && newX < attack.size() && newY >= 0 && newY < attack.size()) {
                    attack.get(newX).set(newY, 1);
                }
            }
        }
    }

    /**
     * 入口方法
     * @param n N皇后问题的N
     * @return 所有解
     */
    private static HashSet<ArrayList<String>> solve(int n) {
        HashSet<ArrayList<String>> solutions = new HashSet<>();
        ArrayList<ArrayList<Integer>> attack = new ArrayList<>();
        ArrayList<String> queen = new ArrayList<>();
        // 初始化
        for (int i=0; i<n; i++) {
            ArrayList<Integer> temp = new ArrayList<>() {{
                for (int j=0; j<n; j++) {
                    add(0);
                }
            }};
            attack.add(temp);

            StringBuilder tempStr = new StringBuilder();
            tempStr.append(".".repeat(n));
            queen.add(tempStr.toString());
        }
        // 解题
        backTrack(0, n, queen, attack, solutions);
        return solutions;
    }

    public static void main(String[] args) {
        int n = 10;
        HashSet<ArrayList<String>> results = solve(n);
        System.out.println(n+"皇后问题共有"+results.size()+"种解法");
        int i = 0;
        for(ArrayList cur : results) {
            System.out.println("解法"+(++i));
            for (Object o : cur) {
                System.out.println(o);
            }
            System.out.println();
        }
    }
}
