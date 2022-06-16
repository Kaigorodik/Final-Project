package Potoki;

import Doc.AnalysisDoc;
import Doc._Documents;

import java.util.ArrayList;

/**
 * Поток анализа по документам
 * @throws InterruptedException если поток прерван
 */

public class Thread1 implements Runnable{

    private final Wating wating;
    ArrayList<_Documents> list;
    Thread thread = null;

    public Thread1(ArrayList<_Documents> list, Wating wating){
        thread = new Thread(this);
        this.wating = wating;
        this.list = list;
        thread.start();
    }

    @Override
    public void run() {

        try {
            //Thread.sleep(10000);
            while (true) {

                if(wating.getFlag_run_command() == false) break;
                Thread.sleep(500);
            }
            AnalysisDoc.AnalysisDoc(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

