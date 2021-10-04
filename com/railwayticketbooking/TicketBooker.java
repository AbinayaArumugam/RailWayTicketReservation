package com.railwayticketbooking;

import java.util.*;

public class TicketBooker {
    static int availableLowerBerth = 1;    //21
    static int availableMiddleBerth = 1;//21
    static int availableUpperBerth = 1;//21
    static int availableRACTicket = 1;//9
    static int availableWaitingList = 1;//10
    //static int[] arr= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
    static List<Integer> lowerBerthPosition = new ArrayList<>(Arrays.asList(1, 4, 7 , 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52, 55, 58, 61));
    static List<Integer> middleBerthPosition = new ArrayList<>(Arrays.asList(2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44, 47, 50, 53, 56, 59, 62));
    static List<Integer> upperBerthPosition = new ArrayList<>(Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60, 63));
    static List<Integer> racPosition = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17));
    static List<Integer> waitingListPosition = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    static List<Integer> bookedTicket = new ArrayList<>();
    static Queue<Integer> racList = new LinkedList<>();
    static Queue<Integer> waitingList = new LinkedList<>();

    public static void bookTicket(List<Passenger> list) {
        if (TicketBooker.availableWaitingList == 0) {
            System.out.println("No Ticket Available");
            return;
        }
        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            Passenger pas = list.get(i);
            if ((pas.getBerthPreference().equals("L") && TicketBooker.availableLowerBerth > 0) || (pas.getBerthPreference().equals("M") && TicketBooker.availableMiddleBerth > 0) ||
                    (pas.getBerthPreference().equals("U") && TicketBooker.availableUpperBerth > 0)) {
                System.out.println("Preferred Berth available");
                if (pas.getBerthPreference().equals("L")) {
                    System.out.println("Lower Berth given");
                    BookTicket.bookTicket(pas, (TicketBooker.lowerBerthPosition.get(0)), "L");
                    TicketBooker.lowerBerthPosition.remove(0);
                    TicketBooker.availableLowerBerth--;
                } else if (pas.getBerthPreference().equals("M")) {
                    System.out.println("Middle Berth given");
                    BookTicket.bookTicket(pas, TicketBooker.middleBerthPosition.get(0), "M");
                    TicketBooker.middleBerthPosition.remove(0);
                    TicketBooker.availableMiddleBerth--;
                } else if (pas.getBerthPreference().equals("U")) {
                    System.out.println("Upper Berth given");
                    BookTicket.bookTicket(pas, TicketBooker.upperBerthPosition.get(0), "U");
                    TicketBooker.upperBerthPosition.remove(0);
                    TicketBooker.availableUpperBerth--;
                }
            } else if (TicketBooker.availableLowerBerth > 0) {
                System.out.println("Lower Berth given");
                BookTicket.bookTicket(pas, (TicketBooker.lowerBerthPosition.get(0)), "L");
                TicketBooker.lowerBerthPosition.remove(0);
                TicketBooker.availableLowerBerth--;
            } else if (TicketBooker.availableMiddleBerth > 0) {
                System.out.println("Middle Berth given");
                BookTicket.bookTicket(pas, TicketBooker.middleBerthPosition.get(0), "M");
                TicketBooker.middleBerthPosition.remove(0);
                TicketBooker.availableMiddleBerth--;
            } else if (TicketBooker.availableUpperBerth > 0) {
                System.out.println("Upper Berth given");
                BookTicket.bookTicket(pas, TicketBooker.upperBerthPosition.get(0), "U");
                TicketBooker.upperBerthPosition.remove(0);
                TicketBooker.availableUpperBerth--;
            } else if (TicketBooker.availableRACTicket > 0) {
                System.out.println("RAC Available");
                BookTicket.addToRAC(pas, TicketBooker.racPosition.get(0), "RAC");
            } else if (TicketBooker.availableWaitingList > 0) {
                System.out.println("Added to Waiting List");
                BookTicket.addToWaitingList(pas, TicketBooker.waitingListPosition.get(0), "WL");
            }
        }
    }

    public static void print() {
        System.out.println("Available LowerBerth  " + availableLowerBerth);
        System.out.println("Available MiddleBerth " + availableMiddleBerth);
        System.out.println("Available UpperBerth  " + availableUpperBerth);
        System.out.println("Available RAC         " + availableRACTicket);
        System.out.println("Available Waiting     " + availableWaitingList);
    }


}
