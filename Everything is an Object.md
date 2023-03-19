# Everything is an Object

While Java is a hybrid language like C++, in Java the assumption is that you only want to do OOP. Hence, (almost) everything in Java is an object.

### You manipulate objects with references ###

In Java, everything is treated as an object using a single consistent syntax.
An object identifier is actually a reference to that object in memory (similar to a C pointer), but Java abstracts the need for the programmer to worry about different syntax for handling this.
It is possible to have an object reference on its own, with no connected object, e.g:

String s;

's' is just a reference to a String.
However, since 's' is not attached to any object, sending messages to 's' will return an error.
It is thus considered good practice to always initialise an object when it is created, i.e:

String s = "asdf";

This case makes use of a special Java feature which lets Strings be initialised with quoted text.

### You must create all the objects ###

The general syntax for creating a new object is to use the *new* keyword:

String s = new String("asdf");

In this case we are saying "make me a new String", and also providing details on how to make the String by giving an initial value.

### Where storage lives ###

There are 5 different places to store data:
1. **Registers** - The fastest storage as they exist within the processor.
The number of registers is severely limited and you don't have direct access to registers in your Java programs.
2. **The Stack** - Lives in the general RAM area, but has direct processor support via the *stack pointer*. 
The stack pointer is moved up or down to release or create memory, which is an extremely fast process.
Some Java storage exists on the stack such as object references, but its inflexibility means Java objects are not placed on the stack.
3. **The Heap** - The general purpose pool of memory in the RAM area.
All Java objects live here.
The compiler doesn't need to know the lifetime of the storage allocated to the heap which gives it greater flexibility, but it may take more time to allocate and clean up than stack storage.
4. **Constant Storage** - Constant values which are often placed directly in the code for safety.
Some constants such as the *String Pool*, which contains all literal strings and string-valued constant expressions, are put into special static storage automatically.
5. **Non-RAM Storage** - Some data lives completely outside of the program, existing while the program is not running.
One example of this is *Streamed Objects*, which are objects turned into a stream of bytes generally sent to another machine.
The other example is *Persisted Objects*, which are placed onto a disk so they hold their state after the program is terminated.
The key to these types of storage is to convert the objects into something that can exist on the other medium, but can be turned back into regular RAM-based objects when needed.
Java supports *Lightweight Persistence*, and mechanisms inclusing JDBC and Hibernate provie more support for persisting objects in databases.

### Special case: primitive types ###

*Primitive types* in Java represent small, simple variables which will be used often in your Java programs.
Since it is not very efficient to use the *new* keyword to create objects on the heap for these simple types, variables are created which hold the value directly (i.e. not references) and are placed on the stack.
Java's primitive types have constant size, min/max values, and a corresponsing *wrapper* class.
The wrapper classes enable you to create non-primitive objects on the heap to represent the primitive types.

|Primitive Type|Size|Wrapper Type|
|---|---|---|
|boolean|-|Boolean|
|char|16 bits|Character|
|byte|8 bits|Byte|
|short|16 bits|Short|
|int|32 bits|Integer|
|long|64 bits|Long|
|float|32 bits|Float|
|double|64 bits|Double|
|void|-|Void|

All numerical types are signed.

#### High-precision numbers ####

Java supports two classes for high-precision arithmetic:
- **BigInteger** - supports arbitrary-precision integers.
- **BigDecimal** - supports arbitrary-precision fixed-point numbers, e.g. for use in monetary calculations.

These are similar to the above wrapper classes, but don't have primitive analogues.

### Arrays in Java ###

Java arrays benefit from the general focus on safety.
A Java array is guaranteed to be initialised and cannot be accessed outside of its range, preventing common errors seen in C or C++.
An array of objects is really an array of object references, each of which is automatically initialised to *null*.
Arrays of primitives can also be created in Java.

*null* is a special value in Java, which recognises that a reference with a value of null isn't pointing to an object, and trying to use a null reference will cause errors at run time.

### You never need to destroy an object ###

Java handles all of the cleanup of variables automatically.

#### Scoping ####

*Scope* determines the visibility and lifetime of names defined within that scope.
In Java, scope is determined using curly braces {}.
A variable defined within a scope is available only to the end of that scope.
Java does not have the C or C++ concept of 'hiding' a variable in a larger scope, e.g:

{  
&nbsp;&nbsp;int x = 12;  
&nbsp;&nbsp;{  
&nbsp;&nbsp;&nbsp;&nbsp;int x = 34; // Illegal  
&nbsp;&nbsp;}  
}

#### Scope of objects ####

Java objects have different lifetimes to primitives.
An object created using *new* will continue to exist in memory past the end of the scope.
However, the object reference will vanish at the end of the scope.
This means there is no way to access the object after the end of the scope.

So if Java objects continue to exist, what stops them filling up the memory?
Java's *garbage collector* manages this by looking at the objects created with *new* and releasing the memory of those which no longer have a reference.
This means the programmer does not have to think about releaseing memory, and the 'memory leak' problem seen in other languages is eliminated.

### Creating new data types: **class** ###

Everything is an object, but what determines the type of an object?








