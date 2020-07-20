package test.lintcode.day6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 18/5/6.
 */
public class MinStack {
    //实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
    //你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。

    //使用List来模拟栈.第一个是存储数字的栈,第二个是存储比当前最小值还小的插入(push)值.
    private List<Integer> numStack;
    private List<Integer> minStack;

    public MinStack() {
        numStack = new ArrayList<Integer>();
        minStack = new ArrayList<Integer>();
    }

    //push时,若最小值栈没有数字,则不经过比较直接压入最小值栈;否则比较push值和当前最小值(最小值栈的最后一个),只有push更小才压入最小值栈.
    public void push(int number) {
        numStack.add(number);
        if(minStack.size() == 0){
            minStack.add(number);
        }else if(minStack.get(minStack.size()-1) >= number){
            minStack.add(number);
        }
    }

    //pop时,只有当前被弹出的值为最小值栈的最后一个元素(即栈顶元素,当前最小值)时,才同步将最小值栈的栈顶元素弹出.
    public int pop() {
        int tmpMin = numStack.remove(numStack.size()-1);
        if(tmpMin == minStack.get(minStack.size()-1)){
            minStack.remove(minStack.size()-1);
        }
        return tmpMin;
    }

    //弹出最小值栈的栈顶元素,即当前最小值.
    public int min() {
        if(numStack.size() == 0){
            return -999;
        }
        return minStack.get(minStack.size()-1);
    }
}
