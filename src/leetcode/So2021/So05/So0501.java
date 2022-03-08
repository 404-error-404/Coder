package leetcode.So2021.So05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/employee-importance/
 * @author 小乐乐
 * @date 2021/5/1 23:15
 **/
public class So0501 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee: employees){
            map.put(employee.id, employee);
        }
        Stack<Employee> stack = new Stack<>();
        stack.add(map.get(id));
        int sum = 0;
        Employee employee;
        while (!stack.empty()){
            employee = stack.pop();
            sum += employee.importance;
            for(int i: employee.subordinates){
                stack.push(map.get(i));
            }
        }
        return sum;
    }
}
