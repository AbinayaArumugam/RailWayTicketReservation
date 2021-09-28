package com.railwayticketbooking;

public class CancelTicket {
    public static void cancel(int id){
      
        if(!Runner.map.containsKey(id)){
            System.out.println("Passenger details unknown");
        }
        else {
            BookTicket.cancelTicket(id);
        }
    }
}
