package com.company;

abstract class Account {

    String name;
    String id;
    AccountStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}

class Admin extends Account{

    void addparkingfloors(Parking parking, ParkingFloor floor){

        parking.floors.add(floor);
    }
    void removeparkignFloors(Parking parking, ParkingFloor floor)
    {
        parking.floors.remove(floor);
    }

    void addparkingspots(Parking parking, ParkingFloor floor, ParkingSpot spot)
    {
        parking.floors.forEach(floor1 -> {
            if(floor == floor1){
                floor1.spots.add(spot);
            }
        });
    }
    void removeparkingSpots(Parking parking, ParkingFloor floor, ParkingSpot spot) {
        parking.floors.forEach(floor1 -> {
            if (floor == floor1) {
                floor1.spots.remove(spot);
            }
        });
    }

    void addparkingAttendant(Parking parking, ParkingFloor floor, ParkingAttendant attendant)
    {
        parking.floors.forEach(floor1 -> {
            if(floor == floor1){
                floor1.attendant.add(attendant);
            }
        });
    }
    void removeparkingAttendant(Parking parking, ParkingFloor floor, ParkingAttendant attendant)
    {
        parking.floors.forEach(floor1 -> {
            if(floor == floor1){
                floor1.attendant.remove(attendant);
            }
        });
    }
}

class ParkingAttendant extends Account{


    Ticket assignTicket(Vehicle v){
        return new Ticket(v);
    }
    TicketStatus scanTicket(Ticket ticket)
    {
        return TicketStatus.PAID;

    }
    TransactionStatus doTransaction(Ticket ticket){
        return TransactionStatus.COMPLETED;
    }

}
