package Doc;

/**
 * Класс Приказы - наследник класса Кадровые документы, с атрибутами сотрудник, текст приказа
 * @return employee возвращает ФИО сотрудника
 */
public class Order extends PersonnelDoc {

    protected String employee;
    protected String text_order;


    @Override //переопределение метода print
    public void print() {

        System.out.println("Код документа: " + this.Code_Doc);
        System.out.println("Cтатус: " + Status);
        System.out.println("Приказ: " + Name + " №" + Number);
        if (_Documents.flag_simple == false) { //проверка ключа -simple
            System.out.println("Сотрудник: " + employee);
            System.out.println("Текст: " + text_order);
        }
    }
    //конструктор класса Приказ
    public Order(String Name, String Number, String employee, String text_order) {
        Status = "Создан";
        this.Name = Name;
        this.Number = Number;
        this.employee = employee;
        this.text_order = text_order;
        this.Code_Doc = 2;

    }

    //метод, возвращающий символьную строку, описывающую объект
    public String toString(){

        String out =    "Код документа: " + this.Code_Doc + "\n" +
                        "Cтатус: " + Status + "\n" +
                        "Приказ: " + this.Name + " №" + this.Number + "\n" +
                        "Сотрудник: " + employee + "\n" +
                        "Текст: " +  text_order  + "\n" + "#";
        return out;

    }

    public String getEmployee() {
        return employee;
    }
}
