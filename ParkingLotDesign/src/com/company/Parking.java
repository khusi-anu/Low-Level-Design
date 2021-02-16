package com.company;


import java.util.ArrayList;
import java.util.HashMap;

class ParkingSpot {
    Integer number;
    ArrayList<Vehicle> vehicles;
    VehicleType type;
    static int capacity = 1000;

    boolean isSpotAvailable(){
        return vehicles.size() < capacity;
    }
    void addVehicle(Vehicle v)
    {
        if(isSpotAvailable())
            vehicles.add(v);
    }
    Integer giveSpotNumber(VehicleType type)
    {
        if(isSpotAvailable())
            return vehicles.size()+1;
        return -1;
    }
}
class ParkingFloor {

    int floor_no;
    ArrayList<ParkingAttendant> attendant;
    HashMap<VehicleType, ArrayList<ParkingSpot>> spots;

    ParkingFloor(){
        attendant = new ArrayList<>();
        spots = new HashMap<>();
    }
    ParkingSpot getParkingSpot(VehicleType type)
    {
        ArrayList<ParkingSpot> spot = spots.get(type);
        ParkingSpot sp = null;

        for(int i = 0; i < spot.size(); i++)
        {
            if(spot.get(i).type == type)
                sp = spot.get(i);
        }
        return sp;
    }

}
public class Parking {

    ArrayList<Admin> admins;
    String name;
    String id;
    ArrayList<ParkingFloor> floors;

    Parking(){
        floors = new ArrayList<>();
    }
    void addVehicle(Vehicle vehicle, ParkingFloor floor)
    {
        floor.spots.forEach(spot -> {
            if(spot[vehicle.type])
                spot.vehicles.add(vehicle);
        });
    }
}
