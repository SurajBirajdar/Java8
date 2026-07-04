package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(50);
        list.add(7);
        list.add(3);
        list.add(10);

        Stream<Integer> stream = list.stream();
        //System.out.println(stream.count());

        int sum = list.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .sorted((a,b)-> (b-a))
                .map(a -> a *2)
                .reduce(0, (a,b)-> a + b);

        System.out.println(sum);

        List<Integer> integerList = list.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .sorted((a,b)-> (b-a))
                .map(a -> a *2)
                .collect(Collectors.toList());

        System.out.println(integerList);





    }

}
