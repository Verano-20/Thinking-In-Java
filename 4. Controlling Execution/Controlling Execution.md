# Controlling Execution

A program must make choices during execution.
In Java, this is done using execution control statements.

### true and false ###

All conditional statements use the truth or falsehood of a conditional statement to control the execution path.
Java does not allow the use of a number as a boolean like in C or C++.

### if-else ###

The 'if-else' statement is the most basic form of program control.
The 'else' statement is optional, so there are two forms of 'if':

if(Boolean-expression)  
&nbsp;&nbsp;statement

or:

if(Boolean-expression)  
&nbsp;&nbsp;statement  
else  
&nbsp;&nbsp;statement

'statement' can be a simple statement followed by a semicolon, or a compound statement enclosed in brackets.

'else if' is often seen in Java programs.
This is not a new keyword, but simply an 'else' followed by a new 'if'.

### Iteration ###

Looping is controlled using *iteration statements* which repeat until a controlling Boolean-expression evaluates to false.
There are three iteration statements used for looping:

**while**, which has the form:

while(Boolean-expression)  
&nbsp;&nbsp;statement

The Boolean-expression is evaluated once at the start of the loop and again before each subsequent iteration.
The loop will continue to iterate until the Boolean-expression evaluates to false.

**do-while**, which has the form:

do  
&nbsp;&nbsp;statement  
while(Boolean-expression)

This behaves the same as a regular while loop, except the statement will always be executed at least once, even if the Boolean-expression evaluates to false initially.
In practice this is less common than a regular while loop.

**for**, which has the form:

for(initialisation; Boolean-expression; step)  
&nbsp;&nbsp;statement

A 'for' loop is the most common form of iteration.
It will perform an initialisation before the first iteration, then conditional testing, and at the end of each iteration some form of stepping.
Any of the expressions 'initialisation', 'Boolean-expression', or 'step' can be empty.
The Boolean-expression is evaluated before each iteration, and when it evaluates to false execution will continue at the line following the for loop.

### The comma operator ###

The *comma operator* (not to be confused with the *comma separator*) has only one use in Java; in the control expression of a for loop.
The 'initialisation' and 'step' parts of the control expression can contain multiple statements separated by commas, which will be executed sequentially, e.g:

for(int i = 1, j = i + 10; i < 5; i++, j = i * 2) {  
&nbsp;&nbsp;System.out.println("i = " + i + " j = " + j);  
}

Note that using the comma operator, multiple variables can be defined in the 'initialisation' part, but they must share the same type.
The ability to define variables in the control expression is limited to the for loop.

### Foreach syntax ###

The *foreach* syntax is a more concise way of writing a for loop, which avoids the need to create an int to iterate through a sequence.
Foreach takes the form:

for(float x : f) {}

where 'f' is an array of floats.
On each iteration of the loop, the next element in 'f' is assigned to 'x'.
Foreach works with any array or method which returns an array, and also any object that is *iterable* (discussed later).
The foreach syntax saves time when writing code, and is far easier to read.

### return ###

There are several keywords in Java which represent *unconditional branching*, including **return**, **break**, **continue** (discussed below).

The *return* keyword specifies the value a method will return (if not void) and causes the current method to exit, returning that value.
If you do not include a return statement in a method which returns void, there is an implicit return at the end of that method, so adding one isn't always necessary.
However, if a method returns anything other than void, every code path must return a value.

### break and continue ###

*break* and *continue* are also used to control the flow of a loop.

*break* quits the loop without executing the rest of the statements in the loop.

*continue* stops the execution of the current iteration, and returns to the start of the loop for the next iteration.

These keywords work the same way in a regular for loop and when using the foreach syntax.

Note that infinite loops can be generated using 'while(true)' or 'for(;;)', which are both treated the same by the compiler.
break and continue can be used to exit an infinite loop.

### The infamous 'goto' ###

*goto* is a keyword found in many programming languages, including the assembly language.
The purpose is to jump to a given place in the code to continue execution.
'goto' is a reserved word in Java, however it is not used in the language.

A similar behaviour can be achieved using the Java concept of *labels*.
Labels are not generic jumps like 'goto', rather they are used as a way of breaking out of iteration statements, tied in with break and continue.
A label is an identifier followed by a colon, e.g:

label1:

The only place a label should be used is right before an iteration statement.
The only reason a label should be put before an iteration statement is if there is going to be a nested iteration or 'switch' (discussed later) inside it.
Normally the 'break' and 'continue' keywords will only interrupt the current loop, but when used in conjunction with a label, they will interrupt the loops up to where the label exists, e.g:

label1:  
outer-iteration {  
&nbsp;&nbsp;inner-iteration {  
&nbsp;&nbsp;&nbsp;&nbsp;//...  
&nbsp;&nbsp;&nbsp;&nbsp;break; // (1)  
&nbsp;&nbsp;&nbsp;&nbsp;//...  
&nbsp;&nbsp;&nbsp;&nbsp;continue // (2)  
&nbsp;&nbsp;&nbsp;&nbsp;//...  
&nbsp;&nbsp;&nbsp;&nbsp;continue label1; // (3)  
&nbsp;&nbsp;&nbsp;&nbsp;//...  
&nbsp;&nbsp;&nbsp;&nbsp;break label1; // (4)  
&nbsp;&nbsp;}  
}

In (1), the 'break' exits the inner-iteration and continues in the outer-iteration.  
In (2), the 'continue' moves to the beginning of the next iteration of the inner-iteration.  
In (3), the 'continue label1' breaks out of both the inner-iteration and the outer-iteration back to 'label1', then continues with the next iteration of the outer-iteration.  
In (4), the 'break label1' breaks out all the way to 'label1', but does not continue either iteration.

In cases where breaking out of a loop will also exit the method, the 'return' keyword can be used instead.

The same rules for labels apply to while loops.

### switch ###

*switch*, also known as a *selection statement*, uses the value of an integral expression to determine the path of code to execute.
The general form is:

switch(integral-selector) {  
&nbsp;&nbsp;case integral-value1: statement; break;  
&nbsp;&nbsp;case integral-value2:  
&nbsp;&nbsp;case integral-value3: statement; break;  
&nbsp;&nbsp;case integral-value4: statement; break;  
&nbsp;&nbsp;// ...  
&nbsp;&nbsp;default: statement;  
}

*integral-selector* is an expression that produces an integral value, which is compared to each *integral-value* case.
If a match is found, the corresponding statement is executed.
If no match is found, the default statement executes.
A statement can be single or contain multiple statements; no brackets are required.
Note that in the above example, 'case integral-value2' and 'case integral-value3' have been 'stacked' to provide multiple matches which execute the same statement.

The 'break' after each statement will cause execution to jump to the end of the switch body.
The 'break' is optional, however if it is not included execution will continue into the statement for the next case until a break is encountered.
The 'default' statement does not include a 'break' as the execution continues where a break would take it anyway, although one can be included if desired for style reasons.

switch statements can also be used with the *enum* feature (discussed in next chapter).

### Summary ###

This chapter concludes the study of fundamental features that appear in most programming languages:
- calculation
- operator precedence
- type casting
- selection and iteration

Further chapters will move closer to the world of object-oriented programming.

-- End --