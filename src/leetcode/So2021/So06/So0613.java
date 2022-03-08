package leetcode.So2021.So06;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-bad-version
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/6/13 11:40
 **/
public class So0613 {
    int[] versions;

    So0613(int[] res){
        versions = res;
    }


    /**
     * 构造一个isBadVersion函数方便测试
     * @param n 版本号
     * @return  该版本是否在单元测试中出错
     */
    boolean isBadVersion(int n){
        return versions[n-1] == 0;
    }

    public int firstBadVersion(int n) {
        int min = 1, max = n;
        while (min < max){
            int mid = min + (max - min)/2;
            if(isBadVersion(mid)){
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] res = new int[]{1,1,1,1,1,0,0,0,0};
        System.out.println(
                new So0613(res).firstBadVersion(res.length)
        );
    }
}
