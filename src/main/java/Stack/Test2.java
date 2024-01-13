package Stack;

public class Test2 {

    public static void main(String[] args) {
        Student s = new Student();
    }

}

class Student extends Person {

    public Student() {
        super("Student1");
        this.setName("student");
    }
}

class Person {

    private String name;

    public Person( String n ) {
        super();
        this.name = n;
    }

    public void setName(String name) {
        this.name = name;
    }
}
