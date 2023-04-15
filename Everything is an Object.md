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
This means the programmer does not have to think about releasing memory, and the 'memory leak' problem seen in other languages is eliminated.

### Creating new data types: **class** ###

Everything is an object, but what determines the type of an object?
Java, like many OOP languages, uses the *class* keyword to define a new type of object, e.g:

class TypeName { /* Class body */ }

This introduces a new type 'TypeName' which can be used to create a new object as follows:

TypeName a = new TypeName();

#### Fields and methods ####

Classes can contain two types of elements: *fields* and *methods*.

Fields (aka data members) are objects of any type, or a primitive type.
Object fields must be initialised to connect them to an actual object.
Each object keeps its own storage for its fields.

Members of an object are referred to using dot notation, i.e 'objectReference.member'.
An object may contain a reference to another object which contains data you'd like to access, in which case you would just 'connect the dots', e.g:

myPlane.leftTank.capacity = 100;

####  Default values for primitive members ####

Java assigns default values to primitive values *only* when they are used as a member of a class.
This does not apply to local variables, which are not fields of a class.
It is best practice to initialise the variables to ensure the values are legal for your program.

|Primitive Type|Default|
|---|---|
|boolean|false|
|char|'\u0000' (null)|
|byte|(byte) 0|
|short|(short) 0|
|int|0|
|long|0L|
|float|0.0f|
|double|0.0d|

### Methods, arguments, and return values ###

In Java, the word *method* is generally used in place of the word *function* used in other languages.
This is only a syntactic difference, with methods and functions just meaning 'a way to do something'.
Methods determine the messages an object can receive.

The basic form of a method is as follows:

ReturnType methodName( /* Argument list */ ) {
&nbsp;&nbsp;/* Method body */
}

where:  
- ReturnType describes the value that comes back from the method when it is called.
- The argument list gives the names and types of the information to pass into the method.
- The method name and argument list uniquely identify the method; this is reffered to as the method's *signature*.

Methods can only be created as part of a class, and can only be called for an object.
An exception to this is static methods, which can be called for the class itself, and will be covered later.
If an object is unable to perform a method, attempting to call that method will result in a compile time error.
Methods are called much like fields are, using dot notation, e.g:

objectName.methodName(arg1, arg2, arg3);

The act of calling a method is commonly referred to as 'sending a message to an object'.

#### The argument list ####

Methods take in objects as arguments, so the arguments list must specify the types and names to use for each one.
As with everywhere else in Java, passing objects is actually done under the hood by passing the object references (with the exception of primitive types.)
Passing objects into a method which do not match the expected types will result in a compile time error.

The *return* keyword is used within methods, and does two things.
First, it means 'exit the method'.
Second, the method will produce the value placed right after the return statement.
Any type can be returned from a method, or none at all by using void.
Consider these examples:

boolean flag() { return true; }  
double naturalLogBase() { return 2.718; }  
void nothing() { return; }  
void nothing2() {}

Note that when the return type is void, the return keyword is only used to exit the method.
If the code reaches the end of the method, the return keyword is therefore unnecessary as the method will exit anyway.
If the return type is non-void the compiler will force you to return the appropriate type of value.

### Building a Java program ###

There are several other issues to understand at this stage.

#### Name visibility ####

To avoid the common problem of names clashing when the same name is used in multiple modules, Java takes a fresh approach.
Java libraries should use your internet domain name in reverse, since the domain names are guaranteed to be unique.
For example, if your domain name is mindview.net, a utility library would be named 'net.mindview.utility'.
The dots after the reversed domain name represent subdirectories.

#### Using other components ####

When using a predefined class in your program, the compiler needs to know where to find it.
If the class exists in the same source code file it's being called from, it can just be used.
Java eliminates the 'forward referencing' problem so the class can be used even if it is referenced later in the file.

For classes that exist in some other file, you must use the *import* keyword.
This will tell the compiler to bring in a package (a library of classes) with no ambiguities as to where it may be.
Standard Java libraries don't bother with the long, reversed domain names, so for example:

import java.util.ArrayList;

This will enable us to use the ArrayList class in our file.
If a package contains a number of classes we want to use, we can also use a '\*' to indicate a wildcard import, e.g.

import java.util.*;

This will enable us to use all classes in java.util.

#### The static keyword ####

A *static* field or method is one that is not tied to any particular object instance of a class.
This means that they can be called even if an object of that class does not exist, as opposed to non-static fields and methods which must be called through a created object so they know the particular object they are working with.
While static methods don't need an object instance, they can't directly access non-static fields and methods without referring to a named object.

To make a field or method static you place the keyword before the definition, e.g.

class StaticTest {  
&nbsp;&nbsp;static int i = 27;  
}

In this case, every created instance of the StaticTest class will share the same storage for i.
Static fields can be accessed the same way as non-static fields when there is an object instance, but they can also be referenced directly as follows:

StaticTest.i++;

This will add 1 to the variable, which will be reflected no matter how it is accessed elsewhere since the storage for i is shared.
Using the class name in this way is the preferred method of referring to a static variable.

Static methods are accessed in a similar way, for example:

class Incrementable {  
&nbsp;&nbsp;static void increment() { StaticTest.i++; }  
}

Incrementable.increment();

The static keyword applied to a method does not affect how data is created in the same way it does when applied to a field.
However, it enables a method to be called without creating an object, which is essential in defining the 'main()' entry method for a Java application.

### Your first Java program ###

Here is a complete program.

// HelloDate.java
import java.util.*

public class HelloDate {  
&nbsp;&nbsp;public static void main(String[] args) {  
&nbsp;&nbsp;&nbsp;&nbsp;System.out.println("Hello, it's: ");  
&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(new Date());  
&nbsp;&nbsp;}  
}

The import statements are placed at the beginning of the file to bring in any extra classes this file will need.
The 'java.lang' library is automatically brought in to every Java file so it doesn't need to be imported explicitly.
The 'out' field on 'System' is static so an instance of System doesn't need to be created to use it.
'println' will take whatever is given to it as an arg, print it to the console and end with a new line.
When passing an instance of 'Date', it is automatically converted into a String for display.

The name of the class is the same as the name of the file.
It is a requirement that for a standalone program like this one of the classes in the file must have the same name as the file, and the compiler will complain if this isn't the case.
This class must contain a method 'main()' with the standard signature and return type:

public static void main(String[] args){}

'public' means the method is available to the outside world (will be covered in more detail later.)
The 'String[] args' argument to main holds any arguments passed from the command line.

#### Compiling and running ####

(This section contains info specific to the source code for this book which I won't be using.)

### Comments and embedded documentation ###

There are two types of comment in Java.

The first type starts with a '/\*', continues possibly across multiple lines, and ends with a '\*/'.
It is common practice to start each new line with a \*, for example:

/* This is a comment  
&nbsp;* that continues  
&nbsp;* across lines  
&nbsp;\*/  

This is no different to just saying:

/* This is a comment that  
continues across lines \*/

The second type of comment is a single line comment which starts with '//' and runs to the end of the line, e.g:

// This is a one line comment

#### Comment documentation ####

Maintaining code documentatin has always been a problem, particularly when the code and documentation are kept separately.
Java solves this by keeping the documentation in the same file as the code, and provides a special comment syntax to mark the documentation.
The tool to extract these comments is called *Javadoc*, and is part of the JDK.

#### Syntax ####

Javadoc commands occur within comennts starting with '/\*\*', and ending with '\*/' as usual.
There are two primary ways to use Javadoc; embed HTML or use 'doc tags'.

Comment documentation can be attached to classes, fields, or methods, for example:

/** A class comment \*/  
public class Documentation1 {  
&nbsp;/** A field comment \*/  
&nbsp;public int i;  
&nbsp;/** A method comment \*/  
&nbsp;public void f() {}  
}

Javadoc will only process documentation for public and proteceted members.
It is possible to set a flag to include private members.

The output of Javadoc is an HTML file which has the same standard format as the rest of the Java documentation.

#### Embedded HTML ####

(see book)

#### Some example tags ####

Javadoc supports many different doc tags, all of which are available in the JDK documentation.
Here are a few useful ones:

@param  
Used for method documentation; '@param parameter-name description'.

@return  
Used for method documentation; '@return description'.

@throws  
Used for method documentation; '@throws fully-qualified-class-name description'.

#### Documentation example ####

(see book)

### Coding style ###

Some code style guidelines are available in the *Code Conventions for the Java Programming Language* from Sun, which can now be found on the Oracle website.

### Summary ###

The goal of this chapter is to show enough basic Java to write a simple program.
The next two chapters will introduce basic operators and show how to control the flow of your program.

-- End --
