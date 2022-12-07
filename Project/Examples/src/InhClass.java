class Parent {
    void show() {
        System.out.println("Parent's show()");
    }
}

// Inherited class
class Child extends Parent {
    // This method overrides show() of Parent
    @Override
    void show() {
        System.out.println("Child's show()");
    }

    void show1() {
        System.out.println("Child's show1()");
    }
}

class Child1 extends Parent {
    // This method overrides show() of Parent
    @Override
    void show() {
        System.out.println("Child's show()");
    }

    void show1() {
        System.out.println("Child's show1()");
    }
}

public class InhClass {
    public static void main(String[] args) {
        // If a Parent type reference refers
        // to a Parent object, then Parent's
        // show is called
        Parent obj1 = new Parent();
        obj1.show();
        Parent obj2 = new Child();
        // obj2.show1();

        // If a Parent type reference refers
        // to a Child object Child's show()
        // is called. This is called RUN TIME
        // POLYMORPHISM.
        Parent obj3 = new Child();
        obj3.show();
        Child obj4 = (Child) obj3;
        obj4.show();
        obj4.show1();
    }
}
