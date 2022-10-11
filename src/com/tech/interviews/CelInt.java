package com.tech.interviews;

import sun.security.krb5.internal.Ticket;

import java.util.*;

public class CelInt {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        System.out.println(getNodesAtLevel(node , 2));
    }

    private static List<Integer> getNodesAtLevel(TreeNode root , int level) {
        List<Integer> ans = new ArrayList<>();
        Queue<QueueItem> queue = new LinkedList<>();
        QueueItem item = new QueueItem(0 , root);
        queue.add(item);
        while(!queue.isEmpty()) {
            item = queue.poll();
            if(item.level == level) {
                ans.add(item.node.val);
            } else if(item.level < level) {
                if(item.node.left != null) {
                    queue.add(new QueueItem(item.level + 1 , item.node.left));
                }
                if(item.node.right != null) {
                    queue.add(new QueueItem(item.level + 1 , item.node.right));
                }
            }
        }
        return ans;
    }

}

class QueueItem {
    TreeNode node;
    int level;
    QueueItem(int level , TreeNode node) {
        this.node = node;
        this.level = level;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}



abstract class Vehicle {

    abstract String getRegNo();
}

class TwoVehicle extends Vehicle {

    String regNo;
    TwoVehicle(String regNo) {
        this.regNo = regNo;
    }

    @Override
    String getRegNo() {
        return regNo;
    }
}

class Car extends Vehicle {

    @Override
    String getRegNo() {
        return null;
    }
}

class Floor {
    int level;
    String identifier;
}

class Slot {
    Floor floor;
    Vehicle vehicle;
    String slotNo;
    boolean isFree;
}

interface ITicketDispenser {
    String dispenseTicket(VehilceType vehilceType , Vehicle vehicle);
    abstract public VehilceType getVehicleType();
}


class VehicleDispenseFactory {
    Map<VehilceType , ITicketDispenser> ticketDispenserSericeMap = new HashMap<>();

    VehicleDispenseFactory(List<ITicketDispenser> iTicketDispensers) {
        iTicketDispensers.forEach(item -> ticketDispenserSericeMap.put(item.getVehicleType() , item));
    }

    ITicketDispenser getTicketDispenser(VehilceType vehilceType) {
        return ticketDispenserSericeMap.get(vehilceType);
    }

}

abstract class TicketDispenserImpl implements ITicketDispenser {


    abstract public String dispenseTicket(VehilceType vehilceType , Vehicle vehicle);
    abstract public VehilceType getVehicleType();
}

class TwoVehicleTicketDispenser extends TicketDispenserImpl {

    VehicleDataStore vehicleDataStore;

    @Override
    public String dispenseTicket(VehilceType vehilceType , Vehicle vehicle) {
        List<Slot> twoVehicleSlots = vehicleDataStore.twoVehicleSlot;
        Slot freeSlot = null;
        for(Slot slot : twoVehicleSlots) {
            if(slot.isFree) {
                slot.vehicle = vehicle;
                slot.isFree = false;
                freeSlot = slot;
                break;
            }
        }
        if(freeSlot != null) {
            TicketInfo ticketInfo = new TicketInfo();
            ticketInfo.checkInTime = System.currentTimeMillis();
            ticketInfo.vehicle = vehicle;
            ticketInfo.slot = freeSlot;
            String ticketId = TicketCreationUtils.createRandomString(8);
            ticketInfo.ticketId = ticketId;
            TicketDataStore.saveTicket(ticketId , ticketInfo);
            return ticketId;
        }


        throw new NoSlotException("No two vehicle slots available");
    }

    @Override
    public VehilceType getVehicleType() {
        return VehilceType.BIKE;
    }
}


class TicketCreationUtils {
    public static String createRandomString(int len) {
        return null;
    }
}


class NoSlotException extends RuntimeException {

    NoSlotException(String message) {
        super(message);
    }
}

interface IVehicleCheckoutService {

    Double checkout(String ticketId);
}

class VehicleCheckoutServiceImpl implements IVehicleCheckoutService {

    @Override
    public Double checkout(String ticketId) {
        return null;
    }
}

interface IParkingService {
    String dispenseTicket(VehilceType vehilceType);
    Double checkout(String ticketId);
}

class ParkingServiceImpl implements IParkingService {

    VehicleDispenseFactory vehicleDispenseFactory;
    ParkingServiceImpl(VehicleDispenseFactory vehicleDispenseFactory , IVehicleCheckoutService vehicleCheckoutService) {
           this.vehicleDispenseFactory = vehicleDispenseFactory;
    }
    @Override
    public String dispenseTicket(VehilceType vehilceType) {
        return vehicleDispenseFactory.getTicketDispenser(vehilceType).dispenseTicket(vehilceType);
    }

    @Override
    public Double checkout(String ticketId) {
        return null;
    }
}



class VehicleDataStore {
    List<Slot> twoVehicleSlot;
    List<Slot> carSlots;
    List<Slot> truckSlot;
    VehicleDataStore(int twoVehicleSlots , int carSlot , int truckSlots) {
        twoVehicleSlot = new ArrayList<>(twoVehicleSlots);
        carSlots = new ArrayList<>(carSlots);
        truckSlot = new ArrayList<>(truckSlots);
    }



}

class TicketInfo {
    Slot slot;
    Vehicle vehicle;
    Long checkInTime;
    String ticketId;
}


class TicketDataStore {
    static Map<String , TicketInfo> ticketInfoMap = new HashMap<>();

    public static TicketInfo getTicket(String ticket) {
        return ticketInfoMap.get(ticket);
    }

    public static  void saveTicket(String ticketNo , TicketInfo ticketInfo) {
        ticketInfoMap.put(ticketNo , ticketInfo);
    }
}

enum VehilceType {
    BIKE,
    CAR,
    TRUCK;
}

