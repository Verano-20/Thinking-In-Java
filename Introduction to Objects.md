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
A request is made to lt by connecting the name of the object and the reqest with a dot.
That's pretty much it.




