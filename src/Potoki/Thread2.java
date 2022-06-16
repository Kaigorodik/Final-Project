package Potoki;

import Doc.AnalysisEmployee;
import Doc._Documents;


import java.util.ArrayList;

/**
 * Поток анализа по сотрудникам
 *  @throws InterruptedException если поток прерван
 */
public class Thread2 implements Runnable{
    ArrayList<_Documents> list;
    Thread thread = null;
    Wating wating;

    public Thread2(ArrayList<_Documents> list, Wating wating){
        thread = new Thread(this);
        this.wating = wating;
        this.list = list;
        thread.start();
    }

    @Override
    public void run() {

        try {
           Thread.sleep(5000);

            while (true){
                if(wating.getFlag_run_command() == false) break;
                Thread.sleep(500);
            }
            AnalysisEmployee.AnalysisEmployee(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
