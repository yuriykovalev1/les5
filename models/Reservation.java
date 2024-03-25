package les5.models;

import java.util.Date;

public class Reservation {

    private static int counter = 1000;
    private int id;

    private Table table;

    private Date date;

    private String name;

    public Reservation(Table table, Date date, String name) {
        id = ++counter;
        this.table = table;
        this.date = date;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Table getTable() {
        return table;
    }

@Override
public String toString() {
    
    return String.format("Столик %d Имя %s", table.getNo(),name);
}

}