import java.text.ParseException;
import java.time.Instant;
import java.util.*;
import java.text.SimpleDateFormat;
public class FlightsImpl {
    public static void main(String[] args) throws ParseException{
        Scanner sc = new Scanner(System.in);
        System.out.println("This Application is only for Booking today's flights");
        List<Flights> domesticFlights = new ArrayList<>();
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
        String date=formatter.format(new Date());
        System.out.println(date);

        Flights f1 = new Flights(date, "Hyderabad", "Delhi", 50, 1000,"f1234");
        Flights f2 = new Flights(date, "Goa", "Delhi", 50, 1000,"f1567");
        Flights f3 = new Flights(date, "Chennai", "Delhi", 50, 1000,"f1890");
        Flights f4 = new Flights(date, "Banglore", "Delhi", 50, 1000,"f2134");
        Flights f5 = new Flights(date, "Punjab", "Delhi", 50, 1000,"f2567");
        Flights f6 = new Flights(date, "Dehli", "Hyderabad", 50, 1000,"f2890");
        Flights f7 = new Flights(date, "Delhi", "Goa", 50, 1000,"f3124");
        Flights f8 = new Flights(date, "Delhi", "Chennai", 50, 1000,"f3567");
        Flights f9 = new Flights(date, "Delhi", "Banglore", 50, 1000,"f3890");
        Flights f10 = new Flights(date, "Delhi", "Punjab", 50, 1000,"f4123");
        Flights[] f = new Flights[]{f1, f2, f3, f4, f5, f6, f7, f8, f9, f10};
        for (Flights a : f)
            domesticFlights.add(a);

        List<Flights> internationalFlights = new ArrayList<>();
        Flights i1 = new Flights(date, "Hyderabad", "America", 50, 10000,"f9123");
        Flights i2 = new Flights(date, "Goa", "Switzerland", 50, 7000,"f9145");
        Flights i3 = new Flights(date, "Chennai", "German", 50, 9000,"f9167");
        Flights i4 = new Flights(date, "Banglore", "Norway", 50, 11000,"f9189");
        Flights i5 = new Flights(date, "Punjab", "Japan", 50, 12000,"f9124");
        Flights i6 = new Flights(date, "Delhi", "Africa", 50, 18000,"f9156");
        Flights i7 = new Flights(date, "Delhi", "Pakisthan", 50, 5000,"f9178");
        Flights i8 = new Flights(date, "Delhi", "Ireland", 50, 15000,"f9190");
        Flights i9 = new Flights(date, "Delhi", "Brazil", 50, 10000,"f9139");
        Flights i10 = new Flights(date, "Delhi", "Mexico", 50, 18000,"f9159");
        Flights[] i = new Flights[]{i1, i2, i3, i4, i5, i6, i7, i8, i9, i10};
        for (Flights a : i)
            internationalFlights.add(a);

        System.out.println("Welcome to IndiGo Airways");
        while (true) {
            System.out.println("Select an option to perform appropriate Operation\n1-Booking\n2-Viewing Booked Flight\n3-Cancelling Flight Ticket");
            int k = sc.nextInt();
            Flights bf=new Flights();
            if (k == 1) {
              boolean bool=bf.bookTicket(domesticFlights,internationalFlights);
              if(bool)
                  System.out.println("Ticket is booked Successfully");
              else
                  System.out.println("Sorry,Your Ticket is not booked");
            }
            else if(k==2){
                Ticket t=new Ticket();
                System.out.println("Enter your pnr number");
                String pnrno=sc.next();
                t.viewBookTicket(pnrno);
            }
            else if(k==3){
                Ticket t=new Ticket();
                System.out.println("Enter your pnr number");
                String pnrno=sc.next();
                t.cancelBookedTicket(pnrno);
            }
            else
                System.out.println("INVALID INPUT");
            System.out.println("If you want to exit press'e'\nTo continue press any Alphabet");
            char c=sc.next().charAt(0);
            if(c=='e')
                break;
        }
    }

}
