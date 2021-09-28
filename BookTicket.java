package com.railwayticketbooking;

import java.util.HashMap;
import java.util.Map;

public class BookTicket {
    static Map<Integer,Passenger> passenger=new HashMap<>();
    public static void bookTicket(Passenger p,int berthInfo,String allotedBerth){
      p.setNumber(berthInfo);
      p.setAlloted(allotedBerth);
      passenger.put(p.getPassengerId(),p);
      TicketBooker.bookedTicket.add(p.getPassengerId());
        System.out.println("--------------Booked Successfully");
    }
    public static void addToRAC(Passenger p,int racInfo,String allotedRAC){
        p.setNumber(racInfo);
        p.setAlloted(allotedRAC);
        passenger.put(p.getPassengerId(),p);
        TicketBooker.racList.add(p.getPassengerId());
        TicketBooker.racPosition.remove(0);
        TicketBooker.availableRACTicket--;
        System.out.println("--------------added to RAC Successfully");
    }
    public static void addToWaitingList(Passenger p,int waitingListInfo,String allotedWaitingList){
        p.setNumber(waitingListInfo);
        p.setAlloted(allotedWaitingList);
        passenger.put(p.getPassengerId(),p);
        TicketBooker.waitingList.add(p.getPassengerId());
        TicketBooker.waitingListPosition.remove(0);
        TicketBooker.availableWaitingList--;
        System.out.println("----------------added to Waiting List");
    }
    public static void cancelTicket(int id){
        Passenger p=passenger.get(id);
        passenger.remove(id);
        int positionBooked=p.getNumber();
        if(p.getAlloted().equals("L")){
            TicketBooker.availableLowerBerth++;
            TicketBooker.lowerBerthPosition.add(positionBooked);
        }
        else if(p.getAlloted().equals("M")){
            TicketBooker.availableMiddleBerth++;
            TicketBooker.middleBerthPosition.add(positionBooked);
        }
        else if(p.getAlloted().equals("U")){
            TicketBooker.availableUpperBerth++;
            TicketBooker.upperBerthPosition.add(positionBooked);
        }
        if (TicketBooker.racList.size()>0) {
            Passenger passengerFromRAC = BookTicket.passenger.get(TicketBooker.racList.poll());
            int positionRAC = passengerFromRAC.getNumber();
           TicketBooker. racPosition.add(positionRAC);
            TicketBooker.racList.remove(passengerFromRAC.getPassengerId());
            TicketBooker.availableRACTicket++;
            if (TicketBooker.waitingList.size() > 0) {
                Passenger passengerFromWaitingList = BookTicket.passenger.get(TicketBooker.waitingList.poll());
                int positionWL = passengerFromWaitingList.getNumber();
               TicketBooker. waitingListPosition.add(positionWL);
                TicketBooker.waitingList.remove(passengerFromWaitingList.getPassengerId());
                passengerFromWaitingList.setNumber(TicketBooker.racPosition.get(0));
                passengerFromWaitingList.setAlloted("RAC");
                TicketBooker.racPosition.remove(0);
                TicketBooker.racList.add(passengerFromWaitingList.getPassengerId());
                TicketBooker.availableWaitingList++;
               TicketBooker. availableRACTicket--;
            }
            TicketBooker.bookTicket(passengerFromRAC);
        }
    }
}

