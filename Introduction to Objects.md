# Introduction to Objects

Object Oriented Programming (OOP) is part of a movement towards using the computer as an expressive medium.

### The progress of abstraction ###

All programming languages provide varying levels of abstractions, e.g. Machine -> Assembly -> C.
Languages like C still require thinking in terms of the machine, since they are relatively low level, rather than in terms of the problem you are trying to solve.
The requires the programmer to map between the 'solution space' (machine) and the 'problem space' (real world).
Alternatively, we could save effort by directly mapping the problem we are trying to solve.
OOP enables the programmer to prepresent elements of the real world 'problem space' directly in the 'solution space', which are known as 'Objects'.
This is a hugely versatile and powerful approach which can be applied to all kinds of problem spaces.

There are 5 basic characteristics of pure object-oriented programming:
1. Everything is an object.
2. A program is a bunch of objects telling each other what to do by sending messages.
3. Each object has its own memory made up of other objects.
4. Every object has a type.
5. All objects of a particular type can receive the same messages.

*'An object has state, behaviour, and identity.'*

### An object has an interface ###

In the real world all objects, while unique, also belong to a class of objects that have common characteristics and behaviours (e.g. fish, birds.)
This is where we get the fundamental keyword 'class', which introduces a new type into a program.
Classes are abstract data types which work like built-in types.
Objects that are identical except for their state during execution share a common class, and are also known as 'instances' of that class.
In OOP, 'characteristics' refers to data elements, while 'behaviours' refers to functionality.
Classes enable programmers to create data types which fit the problem, rather than use existing data types which were designed to represent units of storage in a machine, e.g. floating point number.
Once a class is established, many objects of that class can be created and manipulated as if they actually are the elements in the problem space.
One of the challenges of OOP is the create a one-to-one mapping between the elements in the problem space, and the objects in the solution space.
To get an object to do useful work it needs an *interface*, which defines what requests can be made of it.
A given object can only satisfy certain requests, determined by that object's type, e.g. complete transaction, print to screen.

Consider a simple example, a representation of a light bulb:
The type name may be 'Light', while the interface may define 'on()' and 'off()' as requests it will accept.
There must also be code somewhere to satisfy these requests, which along with the hidden data, comprises the *implementation*.
A type has a method associated with every request, and when that request is made, the method is called.
In the case of Light, we can write the following:

Light lt = new Light();  
lt.on();

A Light object is created by defining a reference 'lt' and calling 'new' to request a new object of that type.
A request is made to lt by connecting the name of the object and the request with a dot.
That's pretty much it.

### An object provides services ###

One of the best ways to think about objects is as 'Service Providers'.
Your goal when designing a program is to produce a set of objects which provides the ideal services to solve the problem, and use these to provide the required services to the user.
Locating objects in existing code libraries which do what you need is preferable to writing new ones.

*High cohesion* is a fundamental quality of software design. It means the various aspects of a software component fit together well.
Thinking of an object as a service provider can help improve its cohesiveness, by avoiding cramming too much functionality into a single object.
By splitting one complex object into several simpler objects, each will provide a more cohesive set of services.
'Each object does one thing well, but doesn't try to do too much.'
Splitting objects in this way brings several benefits; it becomes more likely that an object you need already exists, the objects you write in turn may be more likely to be reused, and it can improve the readability of your code when someone else is trying to understand it.

### The hidden implementation ###

It can be helpful to think in terms of two programming roles: 'class creators' who create new data types, and 'client programmers' who consume the data types in their applications.
The class creator builds classes which expose only what's necessary to the client programmer.
In turn, the client programmers collect a 'toolbox' of classes which can be used for rapid application development.

By exposing only what is necessary, the class creator can change the hidden portion of a class at any time without worrying about the impact on the client programmer.
The hidden portion tends to represent the delicate internal workings of an object which could easily be corrupted or misused by a client programmer, so hiding the implementation can reduce bugs.
This is also of benefit to the client programmer, as the exposed interface lets them see what the important parts of the class are.

Java uses three keywords to set the boundaries in a class:
- 'private' elements can only be accessed inside the class (acting like a brick wall between the class creator and client programmer.)
- 'protected' elements can be accesed inside the class or any inheriting classes.
- 'public' elements can be accessed anywhere.

Java also has 'default' access, which applies if one of the explicit specifiers above is not used. This is usually called 'package access' as these elements can be accessed by other classes in the same *package*, but appear as private to classes outside of the package.

### Reusing the implementation ###

A class, once created and tested, should represent a useful unit of code.
Designing reusable classes is not easy to achieve, but code reuse is one of the greatest advantages of OOP.
The simplest way to reuse a class is to just directly create a new object of that class.
It is also possible to place an object of that class inside a new class, which is known as 'creating a member object'.
A class can be made up of any number and type of other objects to achieve the functionality required.
This concept is called *composition*. (If the composition happens dynamically, it is usually called *aggregation*.)
Composition can be reffered to as a 'has a' relationship, e.g. a car has an engine.
One of the benefits of composition is that the member objects can be changed at run time, dynamically changing the behaviour of the program.

In contrast, *inheritance* (next section) has compile time restriction enforced by the compiler.
While inheritance is very important in OOP and often highly emphasised, it can be overused by new programmers.
You should first look to composition when creating new classes, as a simpler and more flexible approach.
Once you've gained some experience, it will be reasonably obvious when you need inheritance.

### Inheritance ###










