package com.railwayticketbooking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    static Map<Integer,Passenger> map=new HashMap<>();
    static  int ticketId=0;
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        while (true){
        System.out.println("1.Book Ticket");
        System.out.println("2.Cancel Ticket");
        System.out.println("3.Print booked Tickets");
        System.out.println("4.Print Available Tickets ");
        System.out.println("5.Exit");
        System.out.println("Enter your choice");
        int choice= in.nextInt();
        switch (choice) {
            case 1:
                ticketId+=1;
                System.out.println("Enter the number of ticket you want to Book");
                int tickets = in.nextInt();
                for (int i = 0; i < tickets; i++) {
                    System.out.println("Enter your Name");
                    in.nextLine();
                    String name = in.nextLine();
                    System.out.println("Enter Age");
                    int age = in.nextInt();
                    System.out.println("Enter Gender");
                    String gender = in.next();
                    System.out.println("Enter Berth Preference");
                    String berthPreference = in.next();
                    Passenger passenger = new Passenger();
                    passenger.setTicketId(ticketId);
                    passenger.setPassengerId();
                    passenger.setName(name);
                    passenger.setAge(age);
                    passenger.setGender(gender);
                    passenger.setBerthPreference(berthPreference);
                    passenger.setNumber(-1);
                    passenger.setAlloted("");
                    TicketBooker.bookTicket(passenger);
                }
                break;
            case 2:
                System.out.println("Enter the Passenger ID to cancel");
                int id = in.nextInt();
                CancelTicket.cancel(id);
                break;
            case 3:
                if (map.size() == 0) {
                    System.out.println("No Details of Passenger");
                    return;
                }
                System.out.println(map.size());
                for (Passenger passenger : map.values()) {
                    System.out.println("Ticket ID "+passenger.getTicketId());
                    System.out.println("PASSENGER ID " + passenger.getPassengerId() );
                    System.out.println(" Name " + passenger.getName() );
                    System.out.println(" Age " + passenger.getAge() );
                    System.out.println(" Status " + passenger.getNumber() + passenger.getAlloted());
                    System.out.println("--------------------------");
                }
                break;
            case 4:
                TicketBooker ticketBooker = new TicketBooker();
                ticketBooker.print();
                break;
            case 5:
                return;
        }
        }
    }
}
