package les5.presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date orderDate, int tableNo, String name);

    void onChangeReservationTable( int reservId, Date newReservationDate , int tableNo, String name);



}