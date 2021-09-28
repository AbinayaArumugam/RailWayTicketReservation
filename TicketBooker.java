package com.railwayticketbooking;

import java.util.*;

public class TicketBooker {
    static int availableLowerBerth=1;
    static int availableMiddleBerth=1;
    static int availableUpperBerth=1;
    static int availableRACTicket=1;
    static int availableWaitingList=1;
    //static int[] arr= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
    static List<Integer> lowerBerthPosition=new ArrayList<>(Arrays.asList(1));
    static List<Integer> middleBerthPosition=new ArrayList<>(Arrays.asList(1));
    static List<Integer> upperBerthPosition=new ArrayList<>(Arrays.asList(1));
    static List<Integer> racPosition=new ArrayList<>(Arrays.asList(1));
    static List<Integer> waitingListPosition=new ArrayList<>(Arrays.asList(1));

    static List<Integer> bookedTicket=new ArrayList<>();
    static Queue<Integer> racList=new LinkedList<>();
    static Queue<Integer> waitingList=new LinkedList<>();

    public static void bookTicket(Passenger p){
        TicketBooker ticketBooker=new TicketBooker();
        if(TicketBooker.availableWaitingList==0){
            System.out.println("No Ticket Available");
            return;
        }
        if((p.getBerthPreference().equals("L")&&TicketBooker.availableLowerBerth>0)||(p.getBerthPreference().equals("M")&&TicketBooker.availableMiddleBerth>0)||
                (p.getBerthPreference().equals("U")&&TicketBooker.availableUpperBerth>0)){
            System.out.println("Preferred Berth available");
            if(p.getBerthPreference().equals("L")){
                System.out.println("Lower Berth given");
                BookTicket.bookTicket(p,(TicketBooker.lowerBerthPosition.get(0)),"L");
                TicketBooker.lowerBerthPosition.remove(0);
                TicketBooker.availableLowerBerth--;
            }
           else if(p.getBerthPreference().equals("M")){
                System.out.println("Middle Berth given");
                BookTicket.bookTicket(p,TicketBooker.middleBerthPosition.get(0),"M");
                TicketBooker.middleBerthPosition.remove(0);
                TicketBooker.availableMiddleBerth--;
            }
            else if(p.getBerthPreference().equals("U")){
                System.out.println("Upper Berth given");
                BookTicket.bookTicket(p,TicketBooker.upperBerthPosition.get(0),"U");
                TicketBooker.upperBerthPosition.remove(0);
                TicketBooker.availableUpperBerth--;
            }
            else if(TicketBooker.availableLowerBerth>0){
                System.out.println("Lower Berth given");
                BookTicket.bookTicket(p,(TicketBooker.lowerBerthPosition.get(0)),"L");
                TicketBooker.lowerBerthPosition.remove(0);
                TicketBooker.availableLowerBerth--;
            }
            else if (TicketBooker.availableMiddleBerth>0){
                System.out.println("Middle Berth given");
                BookTicket.bookTicket(p,TicketBooker.middleBerthPosition.get(0),"M");
                TicketBooker.middleBerthPosition.remove(0);
                TicketBooker.availableMiddleBerth--;
            }
            else if (TicketBooker.availableUpperBerth>0){
                System.out.println("Upper Berth given");
                BookTicket.bookTicket(p,TicketBooker.upperBerthPosition.get(0),"U");
                TicketBooker.upperBerthPosition.remove(0);
                TicketBooker.availableUpperBerth--;
            }
            else if (TicketBooker.availableRACTicket>0){
                System.out.println("RAC Available");
                BookTicket.addToRAC(p,TicketBooker.racPosition.get(0),"RAC");
            }
            else if (TicketBooker.availableWaitingList>0){
                System.out.println("Added to Waiting List");
                BookTicket.addToWaitingList(p,TicketBooker.waitingListPosition.get(0),"WL");
            }
        }
    }
    public static void print(){
        System.out.println("Available LowerBerth  "+availableLowerBerth);
        System.out.println("Available MiddleBerth "+availableMiddleBerth);
        System.out.println("Available UpperBerth  "+availableUpperBerth);
        System.out.println("Available RAC         "+availableRACTicket);
        System.out.println("Available Waiting     "+availableWaitingList);
    }



}
