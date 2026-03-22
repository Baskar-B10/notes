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
  


