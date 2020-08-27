Singleton Class
++++++++++++++++++++++++++++++++++++++++++++++++

A class with a single instance in a JVM.

Mandatory Properties :

Private Constructor.
Private & Static & Final Instance (Once Initialized never changed).
Static Public Method to get singleton instance. (Factory Method).
Thread Safe if the application is multi threaded.
If Multi Threaded, If its eager initializesd its fine and if lazy initialized, do the double lock initialization.

To stop Cloning, implement clone method and throw exception saying boss, not allowed.

While DeSerialization, instead of readObject method use readResolve method and return the same singleton object. (Also we need to implement readResolve Method)

Also Enum is Singleton by Default.

Interesting Facts ::
Some Classes and methods which look like Singleton but they are not.
Calendar.getInstance() looks like Singleton but its not. Its factory. Returns new object everytime.

Runtime.getRuntime() is Singleton.
Spring Beans default Singleton.
Logger is Singleton


Avoid OverUsage
Confused with factory Pattern


Some classes are not Singleton but looks like they are.

Calendar.getInstance() as it returns new instance everytime. Its factory pattern.


Exercise : Create a calculator service which implements two methods to do basic airthmatic operations.