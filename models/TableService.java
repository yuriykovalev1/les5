package les5.models;

import les5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableService implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    @Override
    public int changeReservationTable(int reservId, Date newReservationDate, int tableNo, String name) {
        for (Table table : tables) {
              for (Reservation reservation : table.getReservations()) {
                if (reservation.getId()==reservId) {
                    table.delReservation(reservation);
                    for (Table newtable : tables) {
                        if (newtable.getNo() == tableNo) {
                            Reservation newreservation = new Reservation(newtable, newReservationDate, name);
                            table.getReservations().add(newreservation);
                            // System.out.println(newreservation.getId());
                             return newreservation.getId();   
                        }   
                    }              
                }
        
            }
        }
      
      
        // for (Table table : tables) {
        //     if (table.getNo() == tableNo) {

        //         Collection<Reservation> reservations = table.getReservations();
        //         for (Reservation reservation : reservations) {
        //             if (reservation.getId()==reservId)
        //             {
        //                 table.delReservation(reservation);
        //                 //reservations.remove(reservation);
        //             }
        //         Reservation newreservation = new Reservation(table, newReservationDate, name);
        //         table.getReservations().add(newreservation);
        //         System.out.println(newreservation.getId());
        //         return newreservation.getId();
        //         }
        //     }
        // }
        throw new RuntimeException("Некорректный номер столика");
    }




}