jdk - java development toolkit - constist of jre and developer toolkits
jre - java runtime environment - consits of JVM and core libraries 
jvm - java virtual machine - runs java bytecode , handles memory mangement , Garbage collectors and execution of code

Memory management:
Heap - stores object . heap memory shared across each thread. Managed by garbage collector
stack - stores method calls, local varaible. each thread have its own stack
method area - stores classes metadata , static varaibles and method name.
PC register - stores current execution

Garbage collection:
prevents memory leak 
automactially removes unused objects

Class loader- loads .class files in JVM
Bootstrap ( libraries in Java.lang) -> Extension (lib in extension path) ->Application  (java classes)

main method:
public - access from all places
static - no object needed
void - no return object
string [] args- command line arguments

Access modifier:
private (within class only)
default (within package)
protected (within package and subclasses outside package)
public (everywhere)

volatile - can be chanaged asynchronosly 
transient - can be deteached in pesistant stage.
sealed - can't extend the classes 

data types:
primitive - values not objects. stored in stack (local varaibles) int , long 
Non primitive - stores reference of actual object. stored in heap and reference stores in stack. array , string 

Varaible types:
local - created inside method
instance - created inside the class. can't be shared accross instances. every objects have its own copy
static - belonsg to class not to instances. mostly used to share across the objects. here we can change the value in one instance can reflect in other instance object.
  used in utilies/constants class .
Access static varaibles:
  ClassA.varaiable - correct way 
  class a = new class () ; a.variable - not recommened
  
Loops:
for , while, do while for each 

statement /condition:
if, else if, else , if else

class :blue print 
object : real object . instance of class
Object initilization: using new keyword, constructor  and methods (setter)

Anonymous Object: object without reference varaible. Required only when object needed once eg: new Class().method();

methods:
Based on return type : void / not
Static method : static keyword . belongs to class. can't access instance varaible directly. requires object to access instance varaiable ( class a = new class , a.varaiable) 
instance method: required objects. can access both static and instance varaiable 
abstract method : no body required

Static:
field - can shared accross all objects, mainly used for constant and utility class
method - can access static fields only . used in utility class
class - only inner class can be static 
constructor - not exist 
static block - loads data 

  order of execution -> static block , main , constructor and then other methods

final - cant change the value 
static final - mostly used in constant class

Static block vs instance block - static executes once  class loads , isntance for evertime when object created
  example : new demo () , new demo() - calls twices
  class Demo {
    static {
        System.out.println("Static");
    }
    {
        System.out.println("Instance");
    }

    Demo() {
        System.out.println("Constructor");
    }
    public static void main(String[] args) {
        new Demo();
        new Demo();
    }
}
static block execute once for both 
instance block executes first before constructor for both.

static method 
1. cant be overide because it belongs to class and execute at compile time . override happens in runtime.
  example: 
  class Parent {
    static void show() {
        System.out.println("Parent");
    }
}
class Child extends Parent {
    static void show() {
        System.out.println("Child");
    }
}
public class Main {
    public static void main(String[] args) {
        Parent p = new Child();
        p.show();
    }
}
  parent p = new child (); 
  p.show () -> parent method executes if both parent and child have static show method
  p.show () -> child method executes if parent method is override in child class (same method name , access type, return type) extends and @override keywords used.
2. "this" can't be used in static method . this is for current object , static do not need object
    class Test {
    int x = 10;
    static void show() {
        // System.out.println(this.x); ❌ ERROR
    }
}
3. main method is static since it can be called without creating object
4. static cant access non static variable  directly. static is class level , non-static is object level.
  class Test {
    int x = 10;
    static void show() {
        // System.out.println(x); ❌ ERROR
    }
}
Test t = new Test();
System.out.println(t.x);


Varargs : list of argument , In JDK 4 and 5 we  need to chnage other method since method parameter change so we come with varags

OOPS Concepts:
Encapsulation: class have varaiables and method binding as a capsule. dsta protected using private.
Inheritance : one class accquires behaviour of other . parent and child
            multiple inheritance not possible in class possible only in interface 
Polymorphism : many forms . method override (runtime) and overload (compile time)
Abstraction : hiding. shows only essential hide the implementation logic. done by interface and abstract class.

Abstract - 
    have both abstract and concrete methods
    can have instance varaiables
    constructor exist
    single inheritance (extends)
    methods have any access specfier
Interface - 
    only abstract methods
    can have only static final varaiables
    no constructor
    multiple inheritance (implements)
    default and static methods (java 8)
  
✅ Use Abstract Class when:
You need common code (methods with body)
Classes are closely related
Need constructors or state (variables)
✅ Use Interface when:
You need multiple inheritance
You want to define contract
No shared state needed  

Multiple Inheritance:  class inherits more than one parent class
Why Multiple Inheritance is NOT Supported in Classes? -   diamond problem 

  class A {
    void show() {}
}
class B {
    void show() {}
}
// ❌ Not allowed
class C extends A, B { }

Why Multiple Inheritance Works with Interfaces?
  interface A {
    void show();
}
interface B {
    void show();
}
class C implements A, B {
    public void show() {
        System.out.println("Resolved");
    }
}

extends -> class to class  &  Interface to Interface
implements -> class to Interface 

✅Multiple allowed in interface - interface C extends A, B {}
✅Class can implement multiple interfaces - class D implements A, B {}
❌Class cannot extend multiple classes -class D extends A, B {} // ❌ ERROR

Diamond problem in Java 8 Default methods:
  interface A {
    default void show() {
        System.out.println("A");
    }
}
interface B {
    default void show() {
        System.out.println("B");
    }
}
class C implements A, B {
    // ❌ ERROR: conflict
}
To resolve :
  1. class must override the methods 
    class C implements A, B {
    @Override
    public void show() {
        System.out.println("Resolved");
    }
}
2. Call Specific Interface Method
   A.super.show(); // call A version
   B.super.show(); // call B version

Conflict Resolution Rules:
1. Class wins over Interface
  class A {
    void show() {
        System.out.println("Class A");
    }
}
interface B {
    default void show() {
        System.out.println("Interface B");
    }
}
class C extends A implements B { } - > Class A
2. Most specific interface wins
  interface A {
    default void show() {}
}
interface B extends A {
    default void show() {}
}
class C implements B {} -> B is more specific → used
3. Must override if conflict
