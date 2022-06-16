package Doc;

/**
 * Абстрактный класс с общими атрибутами (имя, номер, код) для всех типов документов
 * @return Code_Doc возвращает код документа
 * @return Number возвращает номер документа
 * @return Name возвращает имя документа
 */
public abstract class _Documents implements Documentable {

    static boolean flag_simple = false;//проверяет передан ли параметр -simple в качестве ключа
    protected String Name; //имя документа
    protected String Number; //номер документа
    protected int Code_Doc; //код документа

    public int getCode_Doc() {return Code_Doc;}

    public String getNumber() {
        return Number;
    }

    public String getName() {
        return Name;
    }
}