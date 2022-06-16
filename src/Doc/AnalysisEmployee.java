package Doc;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Статистика по актуальному списку сотрудников
 */

public class AnalysisEmployee {

    public static void AnalysisEmployee(ArrayList<_Documents> list){

        HashSet<String> set = new HashSet<>(); //уникальный список элементов

        for(_Documents documents : list){

            if(documents.getCode_Doc() == 2){ //добавляет сотрудников в список по коду документа 2
                Order buff = (Order) documents;
                set.add(buff.getEmployee());
            }
            if(documents.getCode_Doc() == 3){
                Order buff = (Order) documents;
                set.remove(buff.getEmployee()); //удаляет сотрудников из списка по коду документа 3
            }

        }

        System.out.println("Актуальный список сотрудников:");

        for (String str : set){

            System.out.println("- " + str);

        }

    }
}
