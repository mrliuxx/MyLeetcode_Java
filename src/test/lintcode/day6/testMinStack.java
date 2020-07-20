package test.lintcode.day6;

/**
 * Created by lee on 18/5/6.
 */
public class testMinStack {

    public static void main(String[] args){

        MinStack m = new MinStack();
        m.push(2);
        m.push(1);
        m.pop();
        m.push(2);
        m.push(3);
        m.min();
        m.push(1);
        System.out.print(m.min());
    }
}
