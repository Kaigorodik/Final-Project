package Doc;

/**
 * Класс Письма - наследник класса Документы, с атрибутами кому, от кого
 */
public class Mail extends _Documents {

    protected String For;
    protected String From;

    //static private int numDoc = 0;

    @Override //переопределение метода print
    public void print() {

        System.out.println("Код документа: " + this.Code_Doc);
        System.out.println("Письмо: " + Name + " №" + Number);
        if (_Documents.flag_simple == false) { //проверка ключа -simple
            System.out.println("Кому: " + this.For);
            System.out.println("От кого: " + this.From);
        }

    }
    //конструктор класса Письмо
    public Mail(String Name, String Number, String For, String From) {
        this.Name = Name;
        this.Number = Number;
        this.For = For;
        this.From = From;
        this.Code_Doc = 1;
    }
    //метод, возвращающий символьную строку, описывающую объект
    public String toString(){

        String out =    "Код документа: " + this.Code_Doc + "\n" +
                        "Письмо: " + this.Name + " №" + this.Number + "\n" +
                        "Кому: " + this.For + "\n" +
                        "От кого: " + this.From + "\n" + "#";
        return out;

    }
}
