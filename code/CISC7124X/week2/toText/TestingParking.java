// TestingParking.java file:


public class TestingParking {

   public static void main(String[] args) {
      
       ParkingMeter p = new ParkingMeter(300, 30);
       System.out.println("Maximum parking time : " + p.maxTime);
       System.out.println("Parking rate(minutes per quarter) : " + p.rate);
       System.out.println("Now remaining time : " + p.time );
       System.out.println("Now inserting 2 quarters : ");
       p.insert(2);
       System.out.println("Now inserting 5 quarters : ");
       p.insert(5);
   }

}