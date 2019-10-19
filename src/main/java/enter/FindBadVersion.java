package enter;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 *
 */
public class FindBadVersion {

    public int firstBadVersion(int n) {
        return findBad(0, n);
    }

    public int findBad(int first, int last) {
        if (last == first) { return first; }
        int median = (last - first) / 2;
        int check = first + median;

        if (isBadVersion(check)) {
            return findBad(first, check);
        } else  {
            return findBad(check + 1, last);
        }
    }
    boolean isBadVersion(int n) {
        return false;
    }
}
