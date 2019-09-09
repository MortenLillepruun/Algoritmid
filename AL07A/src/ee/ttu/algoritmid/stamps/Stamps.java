package ee.ttu.algoritmid.stamps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stamps {
    public static List<Integer> findStamps(int value, List<Integer> stampOptions) {

        if (stampOptions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (value == 0) {
            return Collections.emptyList();
        }
        int[] M = new int[value + 1];
        int[] V = new int[value + 1];

        Collections.sort(stampOptions);
        for (int i = 1; i <= value; i++) {

            M[i] = Integer.MAX_VALUE;

            for (int j = stampOptions.size() - 1; j >= 0; j--) {
                int stamp = stampOptions.get(j);

                if (i >= stamp && (M[i] > M[i - stamp])) {
                    if (stampOptions.contains(1)) {
                        if (stamp % 10 == 0) {

                        } else {
                            M[i] = M[i - stamp] + 1;
                            V[i] = stamp;
                        }
                    } else {
                        M[i] = M[i - stamp] + 1;
                        V[i] = stamp;
                    }
                }
            }
        }

        int n = value;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (n > 0) {
            result.add(V[n]);
            n -= V[n];
        }
        return result;
    }
}
