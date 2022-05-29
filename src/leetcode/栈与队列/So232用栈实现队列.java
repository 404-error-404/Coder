package leetcode.栈与队列;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * <p>
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/22 22:24
 **/
class MyQueue {
    Stack<Integer> popStack;
    Stack<Integer> pushStack;

    public MyQueue() {
        popStack = new Stack<>();
        pushStack = new Stack<>();
    }

    public void push(int x) {
        while (!popStack.empty()) {
            pushStack.push(popStack.pop());
        }
        pushStack.push(x);
    }

    public int pop() {
        while (!pushStack.empty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }

    public int peek() {
        while (!pushStack.empty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }

    public boolean empty() {
        return popStack.empty() && pushStack.empty();
    }
}

public class So232用栈实现队列 {
    @Test
    public void test(){
        MyQueue obj = new MyQueue();
        obj.push(1);
        assert obj.peek() == 1;
        assert obj.pop() == 1;
        assert obj.empty();
    }
}
