package test.examtest;

/**
 * Created by lee on 18/5/7.
 */
public class Main7 {

    //开四个线程求1-100的和.
    public static void main(String[] args){
        //开四个线程进行计算.
        CalculateThread calculateThread[] = new CalculateThread[4];
        CalculateThread tmpThread;
        //分别设置计算范围.
        for(int i=0; i<calculateThread.length; i++){
            tmpThread = new CalculateThread();
            tmpThread.setNumber(i*25+1, i*25+25);
            calculateThread[i] = tmpThread;
        }

        int result = 0;
        boolean isEnd = false;
        while (true){
            for(int i=0; i<calculateThread.length; i++){
                isEnd = isEnd && calculateThread[i].isClose();
            }

            if(isEnd){
                for(int i=0; i<calculateThread.length; i++){
                    result += calculateThread[i].getSum();
                }

                System.out.print("结算结果:" + result);
                break;
            }
        }

    }
}

//子线程计算类
class CalculateThread implements Runnable{

    //计算结果和计算范围
    private int sum = 0;
    private int numberStart = 0;
    private int numberEnd = 0;
    //线程是否计算完毕而结束
    private boolean isClose = false;

    //计算范围内的和
    @Override
    public void run() {
        while(numberStart <= numberEnd){
            sum += numberStart;
            numberStart ++;
        }

        isClose = true;
    }

    //设置计算范围,并直接启动线程
    public void setNumber(int numberStart, int numberEnd){
        this.numberStart = numberStart;
        this.numberEnd = numberEnd;

        new Thread(this).start();
    }

    //得到计算结果和
    public int getSum() {
        return sum;
    }
    //得到线程状态.
    public boolean isClose() {
        return isClose;
    }
}
