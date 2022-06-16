package Potoki;


/**
 * Класс отслеживания выполнения команды содержит переменную flag_run_command и методы установить флаг и сбросить флаг
 *  @return flag_run_command возвращает текущее состояние выполнения команды
 */

public class Wating {

    boolean flag_run_command = false;

    public void setState(){
        flag_run_command = true;
    }

    public void resetState(){
        flag_run_command = false;
    }

    public boolean getFlag_run_command(){
        return flag_run_command;
    }
}
