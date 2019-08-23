package sandbox;

import java.util.Optional;

public class SandBox {

    public static void main(String[] args) {

        Optional<String> gender = Optional.of("MALE");
        System.out.println(gender.filter(s -> s.equalsIgnoreCase("MALE")));
        System.out.println(gender.filter(s -> s.equalsIgnoreCase("male")));
        System.out.println(gender.filter(s -> s.equals("male")));

        gender.ifPresent(g -> System.out.println("In gender Option, value available." + g));
    }
}
