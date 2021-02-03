import java.util.Date;

public class BookReservation {
    Date dayOfBooking;
    ReservationStatus status;

    BookReservation()
    {
         dayOfBooking = new Date();
    }
    BookReservation(Date date)
    {
        dayOfBooking = date;
    }
    int calculateFine()
    {
        int fine = 0;
        Date date = new Date();
        int numberOfDays = date.compareTo(dayOfBooking);
        if(numberOfDays > 15)
            fine = (numberOfDays - 15) * 5;

        return fine;
    }

}
