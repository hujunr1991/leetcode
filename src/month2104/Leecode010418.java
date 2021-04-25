package month2104;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 手撕面试题：多个线程交替打印问题
 */
public class Leecode010418 {

    private  int times;

    private int state;

    private Lock lock = new ReentrantLock();

    public Leecode010418 (int times) {
        this.times = times;
    }

    //方法一：lock，但是很低效
    private void printLetter(String name, int targe) {
        for (int i = 0; i < times;) {
            lock.lock();
            if (state %3 == targe) {
                state++;
                i++;
                System.out.println(name);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Leecode010418 leecode010418 = new Leecode010418(100);

        new Thread(() ->{
            leecode010418.printLetter("A", 0);
        }, "A").start();

        new Thread(() ->{
            leecode010418.printLetter("B", 1);
        }, "B").start();

        new Thread(() ->{
            leecode010418.printLetter("C", 2);
        }, "C").start();

    }


}
