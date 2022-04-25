package leetcode.栈与队列;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * <p>
 * 注意：
 * <p>
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/implement-stack-using-queues">https://leetcode-cn.com/problems/implement-stack-using-queues</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/22 22:56
 **/
class MyStack {
    Queue<Integer> queue;
    int len;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        len++;
    }

    public int pop() {
        for (int i = 1; i < len; i++) {
            queue.add(queue.remove());
        }
        len--;
        return queue.remove();
    }

    public int top() {
        for (int i = 1; i < len; i++) {
            queue.add(queue.remove());
        }
        int res = queue.remove();
        queue.add(res);
        for (int i = 0; i < len; i++) {
            queue.add(queue.remove());
        }
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}


public class So225用队列实现栈 {
    @Test
    public void test() {
        MyStack obj = new MyStack();
        int x = 1;
        obj.push(x);
        assert obj.top() == 1;
        assert  obj.pop() == 1;
        assert obj.empty();
    }
}
