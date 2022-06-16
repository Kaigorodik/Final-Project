package Doc;

/**
 * Класс Приказ на увольнение - наследник класса Приказы, с атрибутом причина увольнения
 */

public class Order_delete extends Order {

    protected String text_delete;

    //конструктор класса Приказ на увольнение
    public Order_delete(String Name, String Number, String employee, String text_order, String text_delete) {
        super(Name, Number, employee, text_order);
        this.text_delete = text_delete;
        this.Code_Doc = 3;
    }

    @Override //переопределение метода print
    public void print() {

        System.out.println("Код документа: " + this.Code_Doc);
        System.out.println("Cтатус: " + Status);
        System.out.println("Приказ на увольнение: " + Name + " №" + Number);
        if (_Documents.flag_simple == false) { //проверка ключа -simple
            System.out.println("Сотрудник: " + employee);
            System.out.println("Текст: " + text_order);
            System.out.println("Причина увольнения: " + text_delete);
        }


    }
    //метод, возвращающий символьную строку, описывающую объект
    public String toString(){

        String out =    "Код документа: " + this.Code_Doc + "\n" +
                        "Cтатус: " + Status + "\n" +
                        "Приказ на увольнение: " + this.Name + " №" + this.Number + "\n" +
                        "Сотрудник: " + employee + "\n" +
                        "Текст: " +  text_order  + "\n" +
                        "Причина увольнения: " + text_delete + "\n" + "#";;
        return out;

    }

}
