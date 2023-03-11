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

We may find ourselves having defined a class for one purpose, and needing a similar class with slightly different characteristics and behaviour for another.
Rather than writing a whole new class, we can take advantage of *inheritance*, to effectively clone the original class and make additions and modifications to the clone.
If the original class ('base', 'super', 'parent') is changed, the clone class ('derived', 'inherited', 'sub', 'child') also reflects these changes.
A base type contains all of the characteristics and behaviours that are shared among its derived types, representing the core concepts of some objects.
The derived types express different ways this core can be realised.
A common example is the 'shape' base class. This may have characteristics like 'size', 'colour', 'position', and behaviours like 'move', 'erase'.
Specific shapes can be derived from this, like 'triangle', 'square', etc. Each derived type may have additional characteristics and behaviours, like calculating the area.
The type heirarchy produced embodies these similarities and differences.

When inheriting from an existing type, a new type is created.
This new type contains all the members of the existing type (private members being hidden and inaccessible), and duplicates the interface of the base class.
Since the type of a class is defined by its interface, *the derived class is the same type as the base class*.
Consider the previous shape example; a circle *is a shape*.
If a class is simply inherited, the method implementations base class will be applied in the derived class.
This means the derived class has exactly the same type and behaviour as the base class.
A simple way to change this is to add new methods to the derived class which aren't present in the base class.
While this is often the perfect solution, you should check for the possibility that these new methods may also be needed in the base class.
The second way to differentiate the derived class is to *override* a method on the base class.
This is done by creating a new definition for the given method in the derived class.

In Java the keyword for inheritance is *extends*.
As we have seen, the implication that this means adding new methods to the interface is not always necessarily true, as we may only override existing methods.

### Is-a vs is-like-a relationships ###

The *substitution principle* is one way of treating inheritance.
If a derived class overrides only methods present in the base class, both classes have exactly the same interface.
This means an object of the derived class can be directly sustituted for an object of the base class; known as *pure substitution*.
Some say this is the ideal way to treat inheritance, and this relationship between derived and base classes is known as an 'is-a' relationship.

In other cases a derived type will have its interface extended with new methods.
While this new type can still be substituted for the base type, the substitution isn't perfect because the new methods are not accessible from the base type.
This means that whatever was built to use the base type won't be able to handle these new methods, and the new functionality in the derived type will be unused.
These cases can be referred to as having 'is-like-a' relationships between the base and derived classes.

### Interchangeable objects with polymorphism ###

It is often the case that we need to treat an object as its base type rather than its specific type.
This enables us to write code that is valid for all types derived from the base type.
Code targeting the base type is unaffected by the addition of new types, which greatly improves design and reduces maintenance.

Since the generic implementation of a method in the base type may differ from the implementations in its derived types, the compiler cannot know at compile time exactly which piece of code will be executed.
A non-OOP compiler will use *early binding* to generate a call to a specific function name, which the runtime system resolves to the absolute address of the code to be executed.
This is not possible in OOP, so an alternative concept *late binding* is used instead.
The compiler does ensure the method exists and the types are valid, but the code being called isn't known until run time.
This process is covered in more detail in the *Polymorphism* chapter.
In Java, dynamic binding (late binding) is the default behaviour and extra keywords are not needed to get polymorphism.

Using the previous Shape example, we could write the following:

void drawShape(Shape shape) {  
  shape.draw();  
}

Circle circle = new Circle();  
Triangle triangle = new Triangle();  

drawShape(circle);  
drawShape(triangle);  

In this example, the 'drawShape()' method is expecting a Shape, but since a Circle or a Triangle *is a shape*, 'drawShape()' can treat it as one.
This process of treating a derived type as its base type is known as *upcasting*.

### The singly rooted heirarchy ###

In Java, all classes ultimately inherit from the base class 'Object'.
While other languages like C++ don't have this concept built in, the extra flexibility provided in those cases often comes with significant overhead.
For pure OOP in Java, the singly rooted heirarchy has far more benefits that drawbacks.
All objects share certain basic functionality, they can all be easily created on the heap, and argument passing is greatly simplified.
It becomes much easier to implement a *garbage collector*, one of the fundamental advantages of Java over C++.
There can never be an object whose type can't be determined, which is especially important in system-level operations like exception handling.

### Containers ###

When solving a particular problem, it is generally not known exactly how many objects will be needed or how long they will last.
This means we can't know how to store those objects, or how much space to create until run time.
The solution to this is to use a *container* object, which holds references to other objects.
This container can expand when necessary and will take care of the details of storing the objects it holds.
Java comes with generic containers for many needs, including Lists, Maps, Sets, Queues, Trees, Stacks, etc.
Different types of containers provide different interfaces and behaviours which are more suited to some problems than others.
Some containers may have the same interface but different implementations which are more efficient in some cases, e.g. LinkedList and ArrayList.

### Parameterized types (generics) ###

Before Java SE5, containers held the universal Object type.
When adding specific object references to these containers they would be upcast to the Object type, losing their specific character.
So when fetching the reference back from the container, an Object reference would be returned.
To get back the original type, we can use *downcasting*, the inverse to upcasting.
However, remembering exactly what types are stored in a container so that the programmer can properly downcast and avoid exceptions trying to downcast to the wrong type is time consuming.
The solution to this is to use a *parameterized type*; a class which the compiler can customize to work with particular types.
For example, we can create a parameterized container which only accepts and fetches Shape types, as follows:

ArrayList\<Shape> shapes = new ArrayList\<Shape>();

Parameterized types are known as *generics* in Java, and have an impact on much of the code in this book.

### Object creation & lifetime ###

