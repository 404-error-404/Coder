package leetcode.So05;

import java.util.Arrays;

/**
 * @author 张佳乐
 * @date 2021/5/8 10:21
 **/
public class So0508 {
    /**
     * @param jobs  表示工作量的数组
     * @param k     工人数
     * @return 最长的工作时间
     */
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int len = jobs.length;
        // 二分查找符合要求的上下限
        int l = jobs[len-1];
        int r = Arrays.stream(jobs).sum();
        while (l < r){
            int mid = (l + r) / 2;
            if(check(jobs, k, mid)){
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 检查最长工作时间为limit时能否完成任务
     * @param jobs  任务时长
     * @param k     工人数
     * @param limit 最长工作时间
     * @return 能否完成任务
     */
    boolean check(int[] jobs, int k, int limit){
        int[] workloads = new int[k];
        return backtrack(jobs, workloads, 0, limit);
    }

    /**
     * 回溯法尝试分配工作
     * @param jobs      任务数组
     * @param workloads 工人们的工作量
     * @param i         当前分配的工作下标
     * @param limit     最大任务时长
     * @return 能否在limit限制下完成任务
     */
    boolean backtrack(int[] jobs, int[] workloads, int i, int limit){
        if(i >= jobs.length){
            return true;
        }
        int cur = jobs[i];
        // 使用回溯法尝试分配当前工作给工人
        for(int j = 0; j < workloads.length; j++){
            if(workloads[j] + cur <= limit){
                workloads[j] += cur;
                if(backtrack(jobs, workloads, i+1, limit)){
                    return true;
                }
                workloads[j] -= cur;
            }
            // 如果当前工人未被分配工作，那么下一个工人也必然未被分配工作
            // 或者当前工作恰能使该工人的工作量达到上限
            // 这两种情况下都无需尝试继续分配工作
            if(workloads[j] == 0 || workloads[j] + cur == limit){
                break;
            }
        }
        return false;
    }

    /**
     * 错误的解决方法，从高到底依次分配
     * 失败测试用例：{5,5,4,4,4}, 2
     * @param jobs 表示工作量的数组
     * @param k 工人数
     * @return 最长的工作时间
     */
    public int wrongMinimumTimeRequired(int[] jobs, int k) {
        // 对数组排序，然后从高到低分配，每次将任务分配给当前任务量最少的那个
        int[] time = new int[k];
        Arrays.sort(jobs);
        for(int i = jobs.length-1; i >= 0; i--){
            time[findMinElement(time)] += jobs[i];
        }
        int max = time[0];
        for (int t: time){
            max = Math.max(max, t);
        }
        return max;
    }

    /**
     * 找到数组中最小的元素下标
     * @param arr 指定数组
     * @return 最小元素的下标
     */
    int findMinElement(int[] arr){
        int min = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[min]){
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] jobs = new int[]{5,5,4,4,4};
        int k = 2;
        System.out.println(new So0508().wrongMinimumTimeRequired(jobs, k));
        System.out.println(new So0508().minimumTimeRequired(jobs, k));
    }
}