package les5.presenters;

import les5.models.TableService;
import les5.views.BookingView;

import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private Model model;
    private  View view;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        view.registerObserver(this);
    }

    public void updateTablesView(){
        view.showTables(model.loadTables());
    }

    private void updateReservationTableView(int reservationNo){
        view.showReservationTableResult(reservationNo,model.loadTables());
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateReservationTableView(reservationNo);
        }
        catch (Exception e){
            updateReservationTableView(-1);
        }

    }

    @Override
    public void onChangeReservationTable(int reservId, Date newReservationDate, int tableNo, String name) {
        try {
            int reservationNo = model.changeReservationTable(reservId, newReservationDate, tableNo, name) ;
            
            updateReservationTableView(reservationNo);
        }
        catch (Exception e){
            System.out.println(e);
            updateReservationTableView(-1);
        
    }
    }
}