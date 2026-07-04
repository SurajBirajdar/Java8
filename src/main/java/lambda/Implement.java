package lambda;

import lambda.calculator.Calculator;
import lambda.number.CheckEvenOdd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.function.*;

public class Implement {

    public static void main(String[] args) {
        Shape s1 = () -> System.out.println("It is traingle");
        s1.printName();
        Calculator c = (a,b)-> {
            return a*b;
        };
        System.out.println("Multiplication: " + c.solve(2,3));

        // check even odd
        CheckEvenOdd check = n -> {
            if(n % 2 == 0) {
                return true;
            } else {
                return false;
            }
        };
        System.out.println(check.checkEvenOdd(6));

        // TreeMap with descdending values print
        Comparator<Integer> comp = (a,b)-> b-a;
        TreeMap<Integer,Integer> map = new TreeMap<>(comp);
        map.put(10,11);
        map.put(12,13);
        map.put(14,15);
        System.out.println(map);

        // Arraylist
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.forEach(System.out::println);

        // consumer<T> - takes input, modify, returns no output - method - accept(T t)
        // Predicate<T> - takes input, modify, returns boolean output - method  test(T t)
        // Function<T,R> - takes T input, modify, returns R output - method - apply(T t)
        // Supplier<T> - takes no input , returns T output - method - get()

        // Consumer Learning
        Consumer<Integer> c1 = System.out::println;
        c1.accept(5);

        Consumer<Student> c2 = (n) -> {
            n.setName("Suraj");
            System.out.println(n.name);
        };
        Student s = new Student("Bhai");
        c2.accept(s);

        Predicate<Integer> predicate1 = (n) -> n%2 == 0;
        System.out.println(predicate1.test(6));

        Predicate<Student> predicate2 = (n) -> {
            n.setName("Sura");
            if(n.name.length() % 2 == 0) {
                return true;
            }
            return false;
        };

        System.out.println(predicate2.test(s));

        // Function
        Function<Integer,String> function1 = (n) -> {
            if(n%2 == 0) {
                return "EVEN";
            }
            return "ODD";
        };
        System.out.println(function1.apply(9));

        Function<Student,String> function2 = (n) -> {
            if(n.name.length() % 2 == 0) {
                return "EVEN";
            }
            return "ODD";
        };

        Student s2 = new Student("bhai");
        System.out.println(function2.apply(s2));

        // supplier
        Supplier<Student> supplier = () -> new Student("Dhiraj");
        Student s4 = supplier.get();
        System.out.println(s4.name);

        // BiConsumer
        BiConsumer<Integer,Integer> bicons = (a, b) -> System.out.println(a+b);
        System.out.println("BiConsumer");
        bicons.accept(5,6);

        //BiPredicate
        BiPredicate<Integer,Integer> biPred = (a,b) -> ((a*b) %2 == 0);
        System.out.println("BiPredicate");
        System.out.println(biPred.test(2,3));

        //BiFunction
        System.out.println("BiFunction");
        BiFunction<Integer, Integer, String> biFunction = (a,b)-> {
            if((a*b) % 2 == 0) {
                return "EVEN";
            }
            return "ODD";
        };

        System.out.println(biFunction.apply(2,3));



    }
}
