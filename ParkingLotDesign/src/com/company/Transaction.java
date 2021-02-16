package com.company;


import java.util.Date;

class Ticket {
        Integer id;
        Vehicle v;
        ParkingSpot p;
        ParkingFloor floor;
        Date date;

        Ticket(Vehicle vehicle)
        {
                v = vehicle;
                id = (int) Math.random();
                date = new Date();
        }
        Ticket generateTicket(Vehicle vehicle) {
              Ticket ticket = new Ticket(vehicle);
              return ticket;
        }
}

public class Transaction {
}
