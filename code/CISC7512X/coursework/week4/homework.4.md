### CISC 7512X HOMEWORK #5


In the not so distant future flying car are commonplace everyone on the
the planet has one. Yes there is ~ 10 Billion flying cars all over the globe. Each one logs its coordinate every 10 milliseconds, even when parked. 

Assume x,y,z coordinates, with z being altitude, and x, y some cartesian
equivalent of GPS. To avoid accidents, regulars states that no car be next to any other  by more than 10 feet while in the air.

(Z > 0) for longer than 1 second.

Cars can go really fast ~ 500 mph.


Task
Write an algorithm/ implementation psuedocode to find all violators. Assume
input is a HUGE file


[Sample Table]
|   VIN    | Timestamp | x | y | z | timestamp (next) |
|:--------:|:--------: |:-:|:-:|:-:|:----------------:| 
| abc..123 |  1 sec    | 1 | 2 | 3 |  1647548447272   |
| bga..823 |  2 sec    | 10| 20| 30|  1647548439258   |
| ufl..093 |  3 sec    | 20| 30| 40|  1647548449804   |
| das..745 |  4 sec    | 30| 40| 50|  1647548451248   |
| agg..122 |  5 sec    | 40| 50| 60|  1647548452784   |
| owr..122 |  6 sec    | 50| 60| 70|  1647548453903   |

Guesstimate how will the system work    
            how much data will have to be crunch
            how much processing power would be required

### Implementation

Creating a framework for managing traffic on the ground is very challenging.
Especially when the vehicles are each being independently driven by someone
else. Traffic requires suitable information about services and logistics available on the road. 

### Air Traffic Control

> In order to control one must first know. 
> - Mordenkainen, friend of Elminster Aumar

Before technology such as databases and IoT we would all be driving onthe road 
with the use of traffic lights and road signs. Each driver would have to trust
every other driver on the road around them is following the signs as close as possible. When the light is red the everyone in front of the light would have to
slow down to a final halt. When the light is green everyone in front of the light may accelerate and proceed down the road. 

In the air we depend on the air traffic controller to manage many of the variables and relay them to the pilots and airplane instruments so the plane
can relay such messages to the other aircrafts in the area. 
So we can say that the traffic signs ang lights are in the air as well and are
dynamic.

### Increasing the amount of traffic in the air.

Each flying car will have to be equipped with sensors to evaluate their surroundings and emergency features like instant breaking and perhaps features to protect people on the ground below. The real-time traffic data will have to 
also be available to the users on the ground as well. This data can be relayed to the users in the form of a text or officials in the area of the amount of traffic hovering above them.

Vehicles also will be flagged for violating these rules and will be grounded after reaching a proper threshold.

Algorithm 

- 1. Initialize() Vehicle for transport
- 2. Vehicle will get TrafficFeed()
- 3. Vehicle will be cleared for take off after TrafficFeed()
- 4. Vehicle will be given a view of surrounding cars
- 5. Vehicle will getCurrentSpeed() and getCurrentSpeedLimit()
- 6. All Vehicles will invoke dispatchVehicleInfo() to network.
- 7. A global effect upon each car will check if cars in the air are too close
- 8. Cars will be given warnings that there is a car getting close to them withn 10 feet.


### Processing power estimate

[A person on average consumes 5.68 GB of data a hour](https://www.whistleout.com/Internet/Guides/Internet-usage-guide)

If cars are driving 24 hours a day each vehicle would have at least this
(5.8GB*day)*(~10 billion)
the processing power will have to be above a threshold so all vehicles
can reach the standard.

This would be very challenging do to the different standards of computation for each individual across the globe.