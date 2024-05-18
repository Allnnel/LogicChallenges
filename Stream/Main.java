package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
        public static void main(String[] args) {
            int[] arguments = new int[]{3,2,5,1,4,7,9,4,1,5};
            List<Users> newList = List.of(
                    new Users(3,"test1"),
                    new Users(1,"test2"),
                    new Users(4,"test3"),
                    new Users(2,"test4"),
                    new Users(6,"test5"),
                    new Users(5,"test6")
            );

            newList.stream().sorted(Comparator.comparing((Users u) -> u.name).reversed()).collect(Collectors.toList());

            System.out.println(newList.stream()
                    .sorted(Comparator.comparing((Users e )->e.id).reversed())
                    .collect(Collectors.toList()));

            Integer ac = 0;
            System.out.println(newList.stream()
                    .sorted(Comparator.comparing((Users e)->e.name).reversed())
                    .reduce(ac, (acc, e) -> acc + e.id, Integer::sum));
            System.out.println(ac);
        }
}
