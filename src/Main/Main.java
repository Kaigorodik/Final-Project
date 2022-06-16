package Main;

import Doc.*;
import IOFile.IOFile;
import Potoki.Thread1;
import Potoki.Thread2;
import Potoki.Wating;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static Doc.ReadDoc.ParsingDoc;
/**
 * Точка входа в приложение
 * @throws FileNotFoundException если файл не найден
 * @throws NoSuchElementException если нет объектов, пустой файл
 * */
public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<_Documents> list = null; //создаем пустой список

        try{

            list =  ParsingDoc("data.txt"); //парсим файл

        //обработка исключения нет объектов, пустой файл
        }catch (NoSuchElementException e){

            System.out.println("Данные отсутствуют");
            list = new ArrayList<>();

        //обработка исключения файла нет
        }catch (FileNotFoundException e){

            System.out.println("Файл не найден");
            System.out.println("Создан новый");
            File nowDoc = new File("data.txt"); //создаем новый файл
            list = new ArrayList<>();
        }


        Wating wating = new Wating();
        Scanner input = new Scanner(System.in);
        boolean flag_exit = false; //флаг завершение работы приложения

        while (true){

            if(flag_exit) break;

            System.out.println("Введите команду: ");
            String buff = input.nextLine(); //читает до конца строки
            String Name, Number, For, From, Status, employee, text_order, text_delete;
            wating.setState(); //флаг flag_run_command=true
            switch (buff){

                case "Создать письмо":

                    System.out.print("Введите название письма: ");
                    Name = input.nextLine();
                    System.out.print("Введите № письма: ");
                    Number = input.nextLine();;
                    System.out.print("Введите кому письмо: ");
                    For = input.nextLine();
                    System.out.print("Введите от кого письмо: ");
                    From = input.nextLine();

                    list.add(new Mail(Name,Number,For,From)); //добавляем в список

                    break;

                case "Создать приказ на прием":

                    System.out.print("Введите название приказа: ");
                    Name = input.nextLine();
                    System.out.print("Введите № приказа: ");
                    Number = input.nextLine();;
                    System.out.print("Введите ФИО сотрудника: ");
                    employee = input.nextLine();
                    System.out.print("Введите текст приказа: ");
                    text_order = input.nextLine();

                    list.add(new Order(Name,Number,employee,text_order));  //добавляем в список

                    break;

                case "Создать приказ на увольнение":

                    System.out.print("Введите название приказа на увольнение: ");
                    Name = input.nextLine();
                    System.out.print("Введите № приказа на увольнение: ");
                    Number = input.nextLine();;
                    System.out.print("Введите ФИО сотрудника: ");
                    employee = input.nextLine();
                    System.out.print("Введите текст приказа: ");
                    text_order = input.nextLine();
                    System.out.print("Введите причину увольнения: ");
                    text_delete = input.nextLine();

                    list.add(new Order_delete(Name,Number,employee,text_order, text_delete)); //добавляем в список

                    break;

                case "Сохранить данные":
                    IOFile data = new IOFile(null, "data.txt");
                    for(_Documents Doc : list){
                        data.writeLine(Doc.toString());
                    }
                    data.close();
                    break;

                case "Анализ документов":
                    new Thread1(list, wating);
                    //AnalysisDoc.AnalysisDoc(list);
                    break;

                case "Анализ сотрудников":
                    new Thread2(list, wating);
                    //AnalysisEmployee.AnalysisEmployee(list);
                    break;

                case "Вывести все":

                    for(_Documents Doc : list){
                        Doc.print();
                    }
                    break;

                case "Изменить статус приказа на исполнен":
                    System.out.println("Введите номер приказа");
                    buff = input.nextLine();
                    boolean flag_search = false;
                    for(_Documents Doc : list){
                        if(Doc.getNumber().equals(buff)){
                            PersonnelDoc personnelDoc = (PersonnelDoc) Doc;
                            personnelDoc.changeStatus();
                            flag_search = true;
                            break;
                        }
                    }
                    if(flag_search){
                        flag_search = false;
                        break;
                    }else{
                        System.out.println("Приказ с таким номером не найден");
                        break;
                    }

                case "Стоп":

                    System.out.println("До свидания");
                    flag_exit = true;
                    break;


                case "Помощь":

                    System.out.println("Команды:");
                    System.out.println("- Создать письмо");
                    System.out.println("- Создать приказ на прием");
                    System.out.println("- Создать приказ на увольнение");
                    System.out.println("- Сохранить данные");
                    System.out.println("- Анализ документов");
                    System.out.println("- Анализ сотрудников");
                    System.out.println("- Вывести все");
                    System.out.println("- Изменить статус приказа");
                    System.out.println("- Стоп");

                    break;

                default:
                    System.out.println("Команда не распознана");
                    break;


            }

            wating.resetState(); //флаг flag_run_command=true

        }

    }
}
