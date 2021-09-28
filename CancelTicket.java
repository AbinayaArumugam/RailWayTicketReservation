package com.railwayticketbooking;

public class CancelTicket {
    public static void cancel(int id){
        TicketBooker ticketBooker=new TicketBooker();
        if(!BookTicket.passenger.containsKey(id)){
            System.out.println("Passenger details unknown");
        }
        else {
            BookTicket.cancelTicket(id);
        }
    }
}
