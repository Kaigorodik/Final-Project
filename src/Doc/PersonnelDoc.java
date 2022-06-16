package Doc;

/**
 * Класс Кадровые документы - наследник класса Документы, с атрибутом статус и методом, изменяющим его
 */
public abstract class PersonnelDoc extends _Documents{

    protected String Status;

    public void changeStatus(){
        Status = "Исполнен";
        print();

    }

    public void changeStatusOnly(){
        Status = "Исполнен";
    }

}