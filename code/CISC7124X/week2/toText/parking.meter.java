// ParkingMeter.java file:


public class ParkingMeter {
   int maxTime;
   int rate;
   int time;

   public ParkingMeter(int maxTime, int rate) {
       this.maxTime = maxTime;
       this.rate = rate;
       this.time = maxTime;
   }

   public void insert(int numberOfQuarters) {
       int requiredTime = numberOfQuarters * rate;
       if (time >= requiredTime)
           time -= requiredTime;
       else
           time = 0;
       System.out.println("Remaining parking time : " + time);
   }

}