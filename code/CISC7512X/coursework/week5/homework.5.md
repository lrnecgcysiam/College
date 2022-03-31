Chris Samuel
Databases 2

### Using GPS Trackers to detect drivers moving to fast
## Calculate Speed
# Speed = (distance/time) -> x = d/t

CISC 7512X HW# 4: Imagine you have a database table with columns: phoneid, time, gps_latitude, gps_longitude. Assume these records are logged approximately every few seconds for every phone. Your task is to detect speeding: Write a database query (in SQL) to find anyone whose *average* speed is between 90 and 200mph for at least a minute. If can't write SQL query, write detailed procedural speudo code (assume input is coming from a comma delimited text file). Submit code via email, with subject "CISC 7512X HW4".

By using two GPS points (locations) we can calculate the distance covered. WE can use the clock inside the GPS Device (a very accurate clock that synchronizes regularly with the atomic clocks)
aboard the GPS satellites

To measures how long it took the vehicle to travel between those two points. 

GPS satellites send their positions to recievers on the ground every second. For the purpose of this example, we are comparing position difference over a longer period of time.


- 1. convert the difference between 2 latitudinal and 2 longitudinal positions.

- 2. determine the distance between the two timestamps to calculate how long it took
     to get from Point A to Point B.

- 3. Calculate the average speed based on these results. If the distance was three miles
     and the time taken was 2 minutes, then the average speed across that distance would be 90 mph

- 4. We would want to measure the speed from more than just two minutes of three miles. We would also have to rule in the idea that there might be some inconsistencies

- 5. We would not be able to validate the speed of the driver on its own to ensure maximum speed 
    the speed limit of other municipalities


Distance traveled among all drivers must be relative to a phone that is of someone not in a vehicle moving as fast. ( a person sitting on a bench or in a building) Another way to manage  speeds is to 
obtain speed limits from existing speed violations in the area. Ever road would not be able to measure the speed of its drivers the same way but it can be used to measure the speeds of the cars 
in popular traffic areas prone to accidents. 