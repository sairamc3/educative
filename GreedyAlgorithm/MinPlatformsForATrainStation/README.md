# Find Min no of Platforms requried for a train station

## Problem Statement

Implement a function that returns the min no of platforms that are required 
for the trains, so that none of them wait.

### Input

The input is two arrays that represent the arraival and departure times of trains that stop.

### Output

The min no of platforms required

### Sample Input

|Arrival Time | Departure Time |
|-------------|----------------|
| 9:00        | 9.10           |
| 9:40        | 12.00          |
| 9:50 | 11:20|
|11:00 | 11:30|
|15:00 | 19:00 | 
|18:00 | 20:00 |

```java
int[] arrival = {900, 940, 950, 1100, 1500, 1800};
int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
```

### Sample output

```java
int minPlatformsRequired = 3;
```
