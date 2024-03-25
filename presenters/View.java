package les5.presenters;

import les5.models.Table;

import java.util.Collection;

public interface View {

    void showTables(Collection<Table> tables);

    void registerObserver(ViewObserver observer);

    void showReservationTableResult(int reservationNo, Collection<Table> tables);
    

}
