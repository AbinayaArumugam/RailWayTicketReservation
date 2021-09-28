package com.railwayticketbooking;

import java.util.HashMap;
import java.util.Map;

public class BookTicket {

    public static void bookTicket(Passenger passenger,int berthInfo,String allotedBerth){
      passenger.setNumber(berthInfo);
      passenger.setAlloted(allotedBerth);
      Runner.map.put(passenger.getTicketId(),passenger);
      TicketBooker.bookedTicket.add(passenger.getPassengerId());
        System.out.println("--------------Booked Successfully");
    }
    public static void addToRAC(Passenger passenger,int racInfo,String allotedRAC){
        passenger.setNumber(racInfo);
        passenger.setAlloted(allotedRAC);
      Runner.map.put(passenger.getTicketId(),passenger);
        TicketBooker.racList.add(passenger.getPassengerId());
        TicketBooker.racPosition.remove(0);
        TicketBooker.availableRACTicket--;
        System.out.println("--------------added to RAC Successfully");
    }
    public static void addToWaitingList(Passenger passenger,int waitingListInfo,String allotedWaitingList){
        passenger.setNumber(waitingListInfo);
        passenger.setAlloted(allotedWaitingList);
        Runner.map.put(passenger.getTicketId(),passenger);
        TicketBooker.waitingList.add(passenger.getPassengerId());
        TicketBooker.waitingListPosition.remove(0);
        TicketBooker.availableWaitingList--;
        System.out.println("----------------added to Waiting List");
    }
    public static void cancelTicket(int id){
        Passenger passenger=Runner.map.get(id);
        Runner.map.remove(id);
        int positionBooked=passenger.getNumber();
        if(passenger.getAlloted().equals("L")){
            TicketBooker.availableLowerBerth++;
            TicketBooker.lowerBerthPosition.add(positionBooked);
        }
        else if(passenger.getAlloted().equals("M")){
            TicketBooker.availableMiddleBerth++;
            TicketBooker.middleBerthPosition.add(positionBooked);
        }
        else if(passenger.getAlloted().equals("U")){
            TicketBooker.availableUpperBerth++;
            TicketBooker.upperBerthPosition.add(positionBooked);
        }
        if (TicketBooker.racList.size()>0) {
            Passenger passengerFromRAC = Runner.map.get(TicketBooker.racList.poll());
            int positionRAC = passengerFromRAC.getNumber();
           TicketBooker. racPosition.add(positionRAC);
            TicketBooker.racList.remove(passengerFromRAC.getPassengerId());
            TicketBooker.availableRACTicket++;
            if (TicketBooker.waitingList.size() > 0) {
                Passenger passengerFromWaitingList = Runner.map.get(TicketBooker.waitingList.poll());
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

