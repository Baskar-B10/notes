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
static block execute once for both 
instance block executes first before constructor for both.

static method 
1. cant be overide because it belongs to class and execute at compile time . override happens in runtime.
  example: 
  parent p = new child (); 
  p.show () -> parent method executes if both parent and child have static show method
  p.show () -> child method executes if parent method is override in child class (same method name , access type, return type) extends and @override keywords used.
2. "this" can't be used in static method . this is for current object , static do not need object
3. main method is static since it can be called without creating object
4. static cant access non static variable  directly. static is class level , non-static is object level.


Varargs : list of argument , In JDK 4 and 5 we  need to chnage other method since method parameter change so we come with varags





