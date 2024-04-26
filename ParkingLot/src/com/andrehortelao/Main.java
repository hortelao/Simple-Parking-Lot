package com.andrehortelao;

public class Main {
    public static void main(String[] args) {
        int nFloors = 4;
        int nSlotsPerFloor = 6;

        ParkingLot parkingLot = new ParkingLot("PR123", nFloors, nSlotsPerFloor);

        parkingLot.getNoOfOpenSlots("car");

        String ticket1 = parkingLot.parkVehicle("car", "MH-03", "red");
        String ticket2 = parkingLot.parkVehicle("car", "MH-04", "purple");

        parkingLot.displayOccupiedSlots("car");

        parkingLot.unPark(ticket2);
        parkingLot.displayOccupiedSlots("car");

        parkingLot.displayOpenSlots("truck");
        parkingLot.parkVehicle("truck", "MH-01", "black");
        parkingLot.displayOccupiedSlots("truck");
    }
}
