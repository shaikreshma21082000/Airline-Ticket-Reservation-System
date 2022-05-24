import java.util.*;

public class Ticket {
    String origin,destination;
    String date;
    int seatNo,fare;
    Passenger passenger;
    String pnrno;
    static Map<String,Ticket> tickets=new TreeMap<>();
    public Ticket getTicket(String pnrno){return tickets.get(pnrno); }

    public Ticket() {
    }

    public Ticket(String date, String origin, String destination, int seatNo, Passenger passenger, String pnrno, int fare) {
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.seatNo=seatNo;
        this.passenger=passenger;
        this.pnrno=pnrno;
        this.fare=fare;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "date='" + date + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", seatNo=" + seatNo +
                ", passenger=" + passenger +
                ", pnrno='" + pnrno + '\'' +
                ", fare='" +fare +'\'' +
                '}';
    }

    public Boolean isPnrUnique(String pnrno){
        for(String k:tickets.keySet()){
            if(k.equalsIgnoreCase(pnrno))
                return false;
        }
        return true;
    }

    void viewBookTicket(String pnrno){
        int flag=0;
        for(String k:tickets.keySet()){
            if(k.equalsIgnoreCase(pnrno)){
                flag++;
                System.out.println(tickets.get(k));
                break;
            }
        }
        if(flag==0)
            System.out.println("NO SUCH TICKET IS BOOKED");
    }


    void cancelBookedTicket(String pnrno){
        for(String k:tickets.keySet()){
            if(k.equalsIgnoreCase(pnrno)){
                String pnrNo= pnrno.toUpperCase();
                Ticket tic=tickets.get(pnrNo);
                int seatno=tic.seatNo;
                tickets.remove(pnrno);
                Flights.flight.map.put(seatno,false);
                System.out.println("your Ticket is Successfully Cancelled");
                Flights.flight.no_of_seats++;
                System.out.println("Available no of seats "+Flights.flight.no_of_seats);
                break;
            }
        }

    }

}
