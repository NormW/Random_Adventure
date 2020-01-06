package leetcode.enter;

import java.util.*;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right,
 * negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
 * If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> survivals = new ArrayList<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                survivals.add(asteroid);
            } else {
                int radius = asteroid * -1;
                boolean doesCollisionEnd = false;
                while (!doesCollisionEnd) {
                    int last = survivals.isEmpty()
                            ? 0
                            : survivals.get(survivals.size() - 1);
                    if (last <= 0) {
                        survivals.add(asteroid);
                        doesCollisionEnd = true;
                    } else if (last <= radius) {
                        survivals.remove(survivals.size()-1);
                        doesCollisionEnd = (last == radius);
                    } else {
                        doesCollisionEnd = true;
                    }
                }
            }
        }
        return survivals.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> positiveAsteroids = new Stack<>();
        List<Integer> survivals = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                positiveAsteroids.push(asteroid);
            } else if (positiveAsteroids.isEmpty()) {
                survivals.add(asteroid);
            } else {
                int radius = asteroid * -1;
                while (!positiveAsteroids.isEmpty() && positiveAsteroids.peek() <= Math.abs(radius)) {
                    int last = positiveAsteroids.pop();
                    radius = (last == radius) ? 0 : radius;
                }
                if (radius != 0 && positiveAsteroids.isEmpty()) {
                    survivals.add(asteroid);
                }
            }
        }
        int[] results = new int[survivals.size() + positiveAsteroids.size()];
        for (int i = 0; i < survivals.size(); i++) {
            results[i] = survivals.get(i);
        }
        for (int j = results.length - 1; j >= survivals.size(); j--) {
            results[j] = positiveAsteroids.pop();
        }
        return results;
    }

    public static void main(String[] args) {
        AsteroidCollision operator = new AsteroidCollision();
        int[] result = operator.asteroidCollision(new int[]{-2, -1, 1, 2});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
