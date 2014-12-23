cricinfo
========

An application to demonstrate use of java 8 features. Cricket player records have been used to mock real time data.

Streams in Java 8
========
The best example using which you could understand Java Streams is pipeline pattern in UNIX commands.

For example: 
If you want to list out all the processes.\, use following command.

    ps -el
    
Now you want to see how many processes of Clementine application are running currently.

    ps -el | grep clementine
    
What exactly the | (pipe) operator does? Pipes as the name suggests is a sort of hollow tube (a pipe) where you can put data into one end and get it out of the other end. That means output of command ```ps -el``` is passed on to pipe which in turn is used to perform grep operation.

Streams follow same principle in Java 8.
