package Graph.Level2;

class Parent{
    {
        System.out.println("Parent class init block 1");
    }
    static{
        System.out.println("Parent class static block 1");
    }
    public Parent() {
        System.out.println("Parent constructor called");
    }

    {
        System.out.println("Parent class init block 2");
    }
    static {
        System.out.println("Parent class static block 2");
    }
}

class Child extends Parent{
    {
        System.out.println("Child class init block 1");
    }

    static {
        System.out.println("Child class static block 1");
    }

    public Child() {
        System.out.println("Child constructor called");
    }

    {
        System.out.println("Child class init block 2");
    }

    static {
        System.out.println("Child class static block 2");
    }
}

class InitBlockTest{

    public static void main(String[] args){
        new Child();
    }
}


/*
✔ Instance and Static Initialization Blocks in Java

▪ init block is called instance initializer block which is used to initialize the instance data members.

▪ init block runs each time when object of the class is created.

▪ init and static blocks run in the order they appear in the program.

▪ Compiler copies all the code of instance initializer block into the constructor after first statement super(). So, the code in instance initialization block is executed exactly before the code in constructor.

▪ init block is different from static block which runs at the time of class loading.

▪ The code in static initialization block will be executed at class load time (and yes, that means only once per class load), before any instances of the class are constructed and before any static methods are called.

▪ Static blocks of child class gets executed before init blocks and constructors of parent class.
 */
