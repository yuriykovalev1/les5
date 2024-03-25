package les5.views;

import les5.models.Reservation;
import les5.models.Table;
import les5.presenters.View;
import les5.presenters.ViewObserver;
import les5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {


    private Collection<ViewObserver> observers;

    public void showTables(Collection<Table> tables){
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    @Override
    public void registerObserver(ViewObserver observer) {
        if (observers == null)
            observers = new ArrayList<>();
        observers.add(observer);
    }

    @Override
    public void showReservationTableResult(int reservationNo, Collection<Table> tables) {
        if (reservationNo > 0){
            System.out.printf("Столик успешно забронирован. Номер брони: #%d\n", reservationNo);
        }
        else {
            System.out.println("Произошла ошибка при попытке забронировать столик.\nПовторите операцию позже.");
        }


        for (Table table : tables) {
              for (Reservation reservation : table.getReservations()) {
                System.out.println(reservation);
            }
        }

    }


    public void reservationTable(Date orderDate, int tableNo, String name){
        if (observers != null)
        {
            for (ViewObserver observer : observers){
                observer.onReservationTable(orderDate, tableNo, name);
            }
        }
    }

    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        if (observers != null)
        {
            for (ViewObserver observer : observers){
                observer.onChangeReservationTable( oldReservation, reservationDate , tableNo, name);

             
            }
        }
    

    }

}