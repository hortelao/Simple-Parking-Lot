package com.andrehortelao;
import java.util.*;

public class ParkingLot {
    private String parkingLotId;
    private List<List<Slot>> slots;

    public ParkingLot(String parkingLotId, int nfloors, int noOfSlotsPerFlr) {
        this.parkingLotId = parkingLotId;
        this.slots = new ArrayList<>();
        for(int i=0; i < nfloors; i++){
            slots.add(new ArrayList<>());
            List<Slot> floorSlots = slots.get(i);
            floorSlots.add(new Slot("truck"));
            floorSlots.add(new Slot("bike"));
            floorSlots. add(new Slot("bike"));

            for(int j=3;j<noOfSlotsPerFlr;j++){
                slots.get(i).add(new Slot("car"));
            }
        }
    }

    public String parkVehicle(String type, String regNo, String color) {
        Vehicle vehicle = new Vehicle(type, regNo, color);

        for(int i=0; i<slots.size();i++){
            for(int j=0;j<slots.get(i).size(); j++){
                Slot slot = slots.get(i).get(j);
                if(slot.getType() == type && slot.getVehicle() == null) {
                    slot.setVehicle(vehicle);
                    slot.setTicketId(generateTicketId(i + 1, j + 1));
                    return slot.getTicketId();
                }
            }
        }
        System.out.println("NO slot available for given type");
        return null;
    }

    private String generateTicketId(int flr, int slno){
        return parkingLotId + "_" + flr + "_" + slno;
    }

    public void unPark(String ticketId) {
        String[] extract = ticketId.split("_");
        int flr_idx=Integer.parseInt(extract[1])-1;
        int slot_idx=Integer.parseInt(extract[2])-1;
        for(int i=0; i<slots.size();i++){
            for(int j=0;j<slots.get(i).size(); j++){
                if(i==flr_idx && j==slot_idx) {
                    Slot slot = slots.get(i).get(j);
                    slot.setVehicle(null);
                    slot.setTicketId(null);
                    System.out.println("Unparked vehicle");
                }
            }
        }
    }

    public int getNoOfOpenSlots(String type) {
            int count=0;
            for(List<Slot> floor: slots){
                for(Slot slot: floor){
                    if(slot.getVehicle() == null && slot.getType().equals(type)) count++;
                }
            }
        System.out.println("No of Open Slots: " + count);
            return count;

    }

    public void displayOpenSlots(String type) {
        for(int i=0;i<slots.size();i++){
            for(int j=0;j<slots.get(i).size();j++){
                Slot slot=slots.get(i).get(j);
                if(slot.getVehicle() == null && slot.getType().equals(type))
                    System.out.println("Floor " + (i+1) + " slot " + (j+1));
            }
        }
    }

    public void displayOccupiedSlots(String type) {
        for(int i=0;i<slots.size();i++){
            for(int j=0;j<slots.get(i).size();j++){
                Slot slot=slots.get(i).get(j);
                if(slot.getVehicle() != null && slot.getType().equals(type))
                    System.out.println("Floor " + (i+1) + " slot " + (j+1));
            }
        }
    }
}
