Note: from this point on I will be taking more limited notes as the amount of content in this book is huge.

# Operators

At the lowest level, all data in Java is manipulated using operators.
Most of these operators will be familiar to C and C++ users since Java inherits from C++, but there are some improvements and simplifications.

### Simpler print statements ###

(This section touches on the use of static imports from mindeview so will be skipped)

### Using Java operators ###

An operator takes one or more arguments and produces a new value.
In addition, some operators change the value of an operand; this is known as a *side-effect*.
All operators only work with primitives, with the exception of '=', '==', and '!=', which work with all objects. 
String also supports '+' and '+='.

### Precedence ###

(skip)

### Assignment ###

Assigning a primitive is straightforward as the primitive holds the actual value.
If you say 'a = b' for primitives, the value of 'b' is copied into 'a', and 'a' is unaffected by subsequent changes to 'b'.

However for objects, assignation actually copies the reference to an object.
If you say 'c = d' for objects, 'c' and 'd' will both now be pointing to the same object, and the original object 'd' is cleaned up by the garbage collector.
In this case, changes to 'd' will be reflected in 'c' and vice versa.
This phenomenon is often called *aliasing*.

#### Aliasing during method calls ####

Aliasing will occur when an object is passed into a method.
That is, the object's reference is what is passed in, so any changes made to the object within the method will be reflected in the object itself.

### Mathematical Operators ###

The basic mathematical operators are the following:  
- addition (+)
- subtraction (-)
- division (/)
- multiplication (\*)
- modulus (%)

Java also supports shorthand for combining an operation and an assignemt, e.g. 'x += 4' is the same as 'x = x + 4'

#### Unary minus and plus operators ####

Unary minus inverts the sign on the data, e.g. 'x = -a'.

Unary plus only promotes smaller-type operands to _int_.

### Auto increment and decrement ###

Java supports the shorthand increment and decrement operators, which modify a variable and produce the value of the variable as a result.
There are two versions of each, 'pre-' and 'post-'.

For pre-increment and pre-decrement ('++a' or '--a'), the operation is performed and then the value is produced.

For post-increment and post-decrement ('a++' or 'a--'), the value is produced and then the operation is performend.

These are the only operators that product side effects, other than those involving assignment.

A quote from Bill Joy (one of the Java creators): 'Java = C++--'.
As in, Java is C++ with the unnecessary hard parts removed.

### Relational operators ###

Relational operators generate a boolean result by evaluating the relationship between the values of the operands.


The relational operators are:
- less than (<)
- greater than (>)
- less than or equal to (<=)
- greater than or equal to (>=)
- equivalent (==)
- not equivalent (!=)

Equivalence and nonequivalence work with all primitives, but the others don't work with booleans.

Equivalence and nonequivalence can also be applied to objects, but they will only compare the object references, not the value of the objects.
To compare the actual contents of two objects you must use the '.equals()' method.
However, the default behaviour of '.equals()' is to compare the object references, so for your own classes you will have to *override* this behaviour (discussed later.)

### Logical Operators ###

Logical operators produce a boolean value based on the logical relationship of their arguments.

The logical operators are:
- AND (&&)
- OR (||)
- NOT (!)

These operators can be applied to boolean values only.

#### Short circuiting ####

An expression will only be evaluated until the truth or falsehood of the entire expression can be unambiguously determined.
In a complex expression with multiple logical operators, this means the latter parts may not be evaluated at all.

### Literals ###

A trailing character after a literal value establishes its type.
- 'L' or 'l' means long (lowercase 'l' can be confused for the number 1)
- 'F' or 'f' means float
- 'D' or 'd' means double

Hexadecimal (base 16) is denoted by a leading '0x' or '0X' follwed by 0-9 or a-f (uppercase or lowercase.)

Octal (base 8) is denoted by a leasing zero and digits from 0-7.

If a variable is initialised with a value greater than it can hold the compiler will give an error message.
In the case of char, byte, and short, the compiler will automatically make the value an int and force you to use a *narrowing cast* for the assignment (discussed later.)

#### Exponential notation ####

In Java, 'e' means refers to base 10.
Uppercase 'E' and lowercase 'e' behave the same.
Take care not to confuse this with 'e' in the scientific world which refers to the base of natural logarithms, which is available in Java using 'Math.E'.

float expFloat = 1.39e-43f;  
double expDouble = 47e47d; // 'd' is optional

### Bitwise operators ###

Bitwise operators allow the manipulation of individual bits in an integral primitive data type.

(I won't be taking detailed notes of this as I don't expect it to be useful in modern web dev. May revisit.)

### Shift operators ###

Also manipulate bits.

(again, skipping this section.)

### Ternary _if-else_ operator ###

The *ternary* operator, also known as the *conditional* operator, has three operands in the form:

boolean-exp ? value0 : value1

This is very similar to the ordinary if-else statement, except that it also produces a value.
If 'boolean-exp' evaluates to true, 'value0' is evaluated and its value produced by the operator.
If 'boolean-exp' is false, 'value1' is evaluated and its value produced.


Using the ternary operator produces more concise code, but can often be less readable than a regular if-else, so use it wisely.

### _String_ operator + and += ###

A special usage of the '+' and '+=' operators is that they can be used to concatenate Strings.
There is some intersting behaviour produced when using non-String operands:

int x = 1, y = 2;  
System.out.println("string " + x + y); // string 12
System.out.println("string " + (x + y)); // string 3
System.out.println("" + x); // shorthand for Integer.toString()

In the first println statement, x and y are converted to Strings first and then concatenated.
In the second, the brackets are used to control the order of evaluation of the expression, so the ints are added together before being converted into a String.

### Common pitfalls when using operators ###

The most common pitfalls are things like using '=' instead of '=='.

### Casting operators ###

Java will automatically change one type of data into another when appropriate.
Casting can be used to make this process explicit, or to force it where it wouldn't normally happen.
This is done by putting the desired data type in brackets to the left of a value.
There are two types of casts, *widening* and *narrowing*.

A widening cast is a conversion from a type that holds less data to a type that holds more, e.g. from an int to a long.
This is something Java will do automatically since no data will be lost in the process. e.g:

int i = 200;
long lng = (long) i; // the cast here is not strictly needed as Java will do it automatically, but can help provide clarity

A narrowing cast is the inverse.
In this process, data can be lost since the new data type cannot hold as much information as the previous.
Since this is the case, Java forces you to use a cast, e.g:

long lng = 200;
int i = (int) lng; // cast is required

#### Truncation and rounding ####

When converting from a float or a double to an int for example, Java will simply truncate the digits to the right of the decimal point rather than rounding to the nearest integer, e.g:

float above = 0.7f;
double below = 0.4;
int intAbove = (int) above; // 0
int intBelow = (int) below; // 0

If we do want to round to the nearest integer, we can use 'Math.round()' from java.lang, e.g:


float above = 0.7f;
double below = 0.4;
int intAbove = Math.round(above); // 1
int intBelow = Math.round(below); // 0


#### Promotion ####

If a mathematical or bitwise operation is performed on a primitive data type smaller than an int (char, byte, or short), they will be promoted to an int before performing the operation, and the result will be an int.
To assign back to the smaller type, a cast must be used (potentially losing information.)
Generally, the largest data type in the expression will determine the size of the result.

### Java has no 'sizeOf' ###

(skip)

### A compendium of operators ###

(see book)

Note that is is possible to oveflow a result, e.g. by multiplying two ints that are big enough.
In these cases there will be no warnings from the compiler, and no exceptions at runtime, so take care.

### Summary ###

Operators in Java are very similar to other languages with C-like syntax.

-- End --
