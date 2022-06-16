package Doc;

import IOFile.IOFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;


/**
* Класс читает файл посимвольно и передает объекты в список документов по коду
* */

public class ReadDoc {


    public static ArrayList<_Documents> ParsingDoc(String nameFile) throws FileNotFoundException {

        ArrayList<_Documents> ListDoc = new ArrayList<_Documents>();
        IOFile d = new IOFile(nameFile);

        while(true){

            String buff = d.readLine();

            if(buff.startsWith("Код документа: ")){

                String CodeDoc = buff.substring(buff.indexOf(": ") + 2);

                String Name, Number, For, From, Status, employee, text_order, text_delete;
                _Documents documents = null;

                switch (CodeDoc){
                    case "1":

                        buff = d.readLine();
                        Name = buff.substring(buff.indexOf("Письмо: " ) + 8, buff.indexOf("№") - 1);
                        Number = buff.substring(buff.indexOf("№") + 1);

                        buff = d.readLine();
                        For = buff.substring(buff.indexOf("Кому: ") + 6);

                        buff = d.readLine();
                        From = buff.substring(buff.indexOf("От кого: ") + 9);

                        buff = d.readLine();
                        if(!buff.equals("#")) System.out.println("Error");

                        ListDoc.add(new Mail(Name, Number, For, From));
                        break;

                    case "2":

                        buff = d.readLine();
                        Status = buff.substring(buff.indexOf("Статус: ") + 8);

                        buff = d.readLine();
                        Name = buff.substring(buff.indexOf("Приказ: " ) + 8, buff.indexOf("№") - 1);
                        Number = buff.substring(buff.indexOf("№") + 1);

                        buff = d.readLine();
                        employee = buff.substring(buff.indexOf("Сотрудник: ") + 11);

                        buff = d.readLine();
                        text_order = buff.substring(buff.indexOf("Текст: ") + 7);

                        buff = d.readLine();
                        if(!buff.equals("#")) System.out.println("Error");

                        documents = new Order(Name, Number, employee, text_order);

                        if(Status.equals("Исполнен")){
                            PersonnelDoc personnelDoc = (PersonnelDoc) documents;
                            personnelDoc.changeStatusOnly();
                        }

                        ListDoc.add(documents);
                        break;


                    case "3":

                        buff = d.readLine();
                        Status = buff.substring(buff.indexOf("Статус: ") + 8);

                        buff = d.readLine();
                        Name = buff.substring(buff.indexOf("Приказ на увольнение: " ) + 22, buff.indexOf("№") - 1);
                        Number = buff.substring(buff.indexOf("№") + 1);

                        buff = d.readLine();
                        employee = buff.substring(buff.indexOf("Сотрудник: ") + 11);

                        buff = d.readLine();
                        text_order = buff.substring(buff.indexOf("Текст: ") + 7);

                        buff = d.readLine();
                        text_delete = buff.substring(buff.indexOf("Причина увольнения:  ") + 20);

                        buff = d.readLine();
                        if(!buff.equals("#")) System.out.println("Error");

                        documents = new Order_delete(Name, Number, employee, text_order, text_delete);

                        if(Status.equals("Исполнен")){
                            PersonnelDoc personnelDoc = (PersonnelDoc) documents;
                            personnelDoc.changeStatusOnly();
                        }

                        ListDoc.add(documents);

                        break;
                }


            }
            if(d.cheakNextLine() == false) break;

        }
        d.close();
        return ListDoc;

    }


}
