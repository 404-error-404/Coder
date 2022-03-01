package bytedance;

import java.util.*;

/**
 * 通过70%测试用例
 * @author 小乐乐
 * @date 2021/6/13 19:19
 **/
public class So061302 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 总人数
        int m = scanner.nextInt();
        // 感染人数
        int n = scanner.nextInt();
        int[][] nums = new int[m][m];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < m; j++){
                nums[i][j] = scanner.nextInt();
            }
        }
        List<Integer> people = new ArrayList<>();
        for (int i = 0; i < n; i++){
            people.add(scanner.nextInt());
        }
        Collections.sort(people);
        Stack<Integer> stack = new Stack<>();
        // 从第一个人开始广度优先搜索
        stack.add(people.get(0));
        // 剩余感染人计数
        int count = 1;
        // 剩余感染人数
        int l = n-1;
        while (l > 0 && !stack.isEmpty()){
            boolean if_silk = false;
            int p = stack.pop();
            count++;
            for(int i = p+1; i < m; i++){
                // 如果有接触
                if(nums[p][i] == 1){
                    stack.add(i);
                    // 如果i是感染者
                    if(people.contains(i)){
                        l--;
                        if (!if_silk){
                            if_silk = true;
                        }
                        else {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
