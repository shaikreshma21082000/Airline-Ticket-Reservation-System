import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.*;

public class Flights {
    String date;
    String origin,destination;
    int no_of_seats=50;
    int fare_charge;
    String flightNo;
    static Flights flight=null;
    Map<Integer,Boolean> map=new HashMap<Integer,Boolean>();
   Flights ()
   {
       for(int i=1;i<=no_of_seats;i++){
           map.put(i,false);}
   }
    public Flights(String date, String origin, String destination, int no_of_seats, int fare_charge ,String flightNo) {
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.no_of_seats = no_of_seats;
        this.fare_charge = fare_charge;
        this.flightNo=flightNo;
        for(int i=1;i<=no_of_seats;i++){
            map.put(i,false);}
        }



    @Override
    public String toString() {
        return "Flights{" +
                "date='" + date + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", no_of_seats=" + no_of_seats +
                ", fare_charge=" + fare_charge +
                ", flightNo='" + flightNo + '\'' +
                '}';
    }

    boolean bookTicket(List<Flights> domesticFlights,List<Flights> internationalFlights)throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
        int no=1;
        System.out.println("Enter option to Book Ticket.\n'1'-Domestic\n'2'-International");
        int choice =sc.nextInt();
        if(choice==1)domesticFlights.forEach(flights -> System.out.println(flights.toString()));
        else if(choice==2)internationalFlights.forEach(flights -> System.out.println(flights.toString()));
        else {System.out.println("INVALID OPTION");return false;}
        System.out.println("\nEnter date on which u like to travel in dd/mm/yyyy format.");
        String date =sc.next();
        System.out.println("Enter the Origin from where you travel\n");
        String origin = sc.next();
        System.out.println("Enter the destination to where you want to travel\n");
        String destination =sc.next();
        if (choice == 1) {
             for(Flights f:domesticFlights)
             {
                 if(f.date.equalsIgnoreCase(date) && f.origin.equalsIgnoreCase(origin) && f.destination.equalsIgnoreCase(destination))
                 {
                     System.out.println("Flight is available\n"+f.toString());
                     flight=f;
                     choice=10;
                     break;}
             }
        }
        else {
            for(Flights f:internationalFlights)
            {

                if(f.date.equalsIgnoreCase(date) && f.origin.equalsIgnoreCase(origin)&&f.destination.equalsIgnoreCase(destination))
                {
                    System.out.println("Flight available\n"+f.toString());
                    flight=f;
                    choice=10;
                    break;}
            }
        }
        if(choice==1 || choice==2) { System.out.println("NO FLIGHTS");return false;}
        System.out.println("Enter the Flight Number\n");
        String flightNo=sc.next();
        System.out.println("Enter the no of tickets");
        int noOfticket=sc.nextInt();

        while(no<=noOfticket){
            System.out.println("No of available seats "+flight.no_of_seats);
            System.out.print("Enter the details of passenger\nName: ");
            String name=sc.next();
            System.out.print("\nAge: ");
            int age=sc.nextInt();
            System.out.print("\nPhone Number: ");
            long phoneNo= sc.nextLong();
            System.out.print("\nCity: ");
            String city= sc.next();
            System.out.print("Enter Seatno\n");
            int seatno=sc.nextInt();

            while(flight.map.get(seatno)){
                System.out.println(seatno+" is already reserved.\nAvailable Seats are:");
                int i=1;
                while(i<=no_of_seats){if(!flight.map.get(i)) System.out.print(i+" ");i++;}
                System.out.println("\nEnter another seat number");
                seatno=sc.nextInt();
            }
            flight.map.replace(seatno,true);
            System.out.println(seatno+" is successfully reserved");
            Passenger p=new Passenger(name,age,phoneNo,city);
            int lowerbound=100,upperbound=999;
            String pnrno="IND"+Integer.toString(new Random().nextInt(upperbound-lowerbound)+lowerbound);
            Ticket t=new Ticket(date,origin,destination,seatno,p,pnrno,flight.fare_charge);
            while(true){
                Boolean value=t.isPnrUnique(pnrno);
                if(value==false)
                    pnrno="IND"+Integer.toString(new Random().nextInt(upperbound-lowerbound)+lowerbound);
                else
                    break;
            }
            Ticket.tickets.put(pnrno,t);
            System.out.println(name+"'s ticket is booked successfully at seat "+seatno+"\n\n PNR NUMBER IS "+pnrno+"\n\n");
            flight.no_of_seats--;
            System.out.println(t.getTicket(pnrno));
            no++;
        }
        return true;
    }

}


