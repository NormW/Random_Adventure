package fun;

public class LoopWithoutRecursion {

    static class loop {
        loop() {
            System.out.println("This is fun");
            new loop();
        }
    }

    public static void main(String[] args){
        new loop();
    }
}
