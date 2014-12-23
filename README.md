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

   Streams follow same principle in Java 8. Streams provide elegant evaluation of expressions (mostly lambda expressions). Operations on stream does not affect the collection from which stream was obtained. There are two types of operations carried out on a stream, intermediate and terminal. Intermediate operations are mainly filters, mappers, max, min functions which apply rules on stream and transform from one form to another. Terminal operations are the ones which are used to produce, collect results. Once the result has been collected using terminal operation, you can not reuse stream.
    
   For example consider the following code snippet. We are creating an integer list and creating stream out of it. The operations performed on list are filter, map and collect. 

	List<Integer> greaterThan3 = Arrays.asList(3, 4, 5, 7, 1, 2, 9, 8, 44, 4, 6, 2, 3, 1, 0)
				.stream()
				.filter(num -> num > 3)
				.map(num -> num * 2)
				.collect(Collectors.toList());
		System.out.println(greaterThan3);

* Here, filter accepts a Predicate which in turn returns a boolean value. That means we are checking if an integer is greater than 3 or not. This is a intermediate operation.
* map function converts a value from one form to another. It returns a stream consisting of the results of applying the given function to the elements of this stream. In this case we are multiplying an integer by 2. This is a intermediate operation.
* collect operation Performs a mutable reduction operation on the elements of this stream using a Collector. In above example we are collecting resultant elements in the list. This is a terminal operation.

