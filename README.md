# ClockTime

This is my solution to the assignment **ClockTime** of class **software developement 1**, written in Java.

More information can be seen in the comments of the source code.

### Requirements:

This program consists of one class: Class **ClockTime** represents the time on a clock. There are three ways to create a clock time: Either with X hours, 0 minutes, 0 seconds - X hours, X minutes, 0 seconds - or X hours, X minutes, X seconds.

#### Class ClockTime

A day has 86400 seconds and the value range can be negative or any value like 12345678 seconds. But there is a problem, what is a negative time? It can be solved by bringing all unnatural numbers of range < 0 or > 86400 to a value >= 0 and < 86400 by adding another day. 
To "add" another day we normalize the value by doing a modulo operation with % 86400 seconds. 

ClockTime also can add another clock time or another value. Also there is a chance to check if another clock time is same like this clock time.
