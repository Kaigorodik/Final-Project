package Doc;

import java.util.ArrayList;

/**
 * Класс, подсчитывающий количество документов с классификацией по коду документа
 */

public class AnalysisDoc {

    public static void AnalysisDoc(ArrayList<_Documents> list){

        int Mail = 0;
        int Order = 0;
        int Order_delete = 0;

        for(_Documents Doc : list){

            switch (Doc.getCode_Doc()){

                case 1:
                    Mail++;
                    break;
                case 2:
                    Order++;
                    break;
                case 3:
                    Order_delete++;
                    break;

            }

        }

        System.out.println("Анализ документов:");
        System.out.println("Писем: " + Mail);
        System.out.println("Приказов: " + Order);
        System.out.println("Приказов на увольнение: " + Order_delete );

    }

}
