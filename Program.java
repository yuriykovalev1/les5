package les5;

import les5.models.TableService;
import les5.presenters.BookingPresenter;
import les5.presenters.Model;
import les5.views.BookingView;

import java.util.Date;

public class Program {

 
    public static void main(String[] args) {
        Model model = new TableService();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateTablesView();
        view.reservationTable(new Date(), 2, "Станислав");

        view.changeReservationTable(1001, new Date(), 4, "Станислав");
        System.out.println("---------------------------");
        view.reservationTable(new Date(), 3, "Александр");

    }

}