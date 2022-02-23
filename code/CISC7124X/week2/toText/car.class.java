


import java.util.Scanner;

//definition of the Car class...
class Car
{
    //declare some private variables...
    private double fuel_efficiency, fuel, drive;
    
    //constructor with set the efficiency of the car and initialize other variables to 0...
    public Car(double eff)
    {
        this.fuel_efficiency = efficiency;
        this.fuel = 0.0;
        this.drive = 0.0;
    }
    
    //definition of the drive() function...
    public void drive(double d)
    {
        //update the drive variable...
        this.drive = this.drive + d;
        
        //decrement the fuel as per the formula...
        fuel = fuel - (d / fuel_efficiency);
    }
    
    //definition of addGas()...
    public void addGas(double gas)
    {
        //add the fuel with gas...
        fuel = fuel + gas;
    }
    
    //definition of getGasLevel() function...
    public double getGasLevel()
    {
        //return the fuel...
        return fuel;
    }
    
}