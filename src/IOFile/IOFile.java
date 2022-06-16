package IOFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Класс ввода вывода
 * @throws FileNotFoundException если файл не найден
 */

public class IOFile {

    private File fData;
    private Scanner scanner;
    private PrintWriter out;

    public IOFile(String nameInputFile) throws FileNotFoundException {

        fData = new File(nameInputFile);
        if(nameInputFile != null) scanner = new Scanner(fData);
        out = null;

    }
    public IOFile(String nameInputFile, String nameOutputFile) throws FileNotFoundException {

        if(nameInputFile != null){
            fData = new File(nameInputFile);
            scanner = new Scanner(fData);
        }

        if(nameOutputFile != null) out = new PrintWriter(nameOutputFile);

    }
    //метод для чтения содержимого файла
    public String readLine(){

        String buff = scanner.nextLine();
        return buff;

    }

    //метод для записи в файл
    public void writeLine(String str) throws FileNotFoundException {

        out.println(str);

    }

    //закрываем nameInputFile переданный в scanner
    public void close(){
        if(scanner != null) scanner.close();
        if(out != null) out.close();
    }

    public boolean cheakNextLine(){
        return scanner.hasNext();
    }


}
