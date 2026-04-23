package vn.com.leetcode;

import java.util.List;

public abstract class Solution<I, O> {

    public abstract O solve(I input);

    public abstract List<TestCase<I, O>> testCases();

    public boolean assertEquals(O expected, O actual) {
        if (expected == null) {
            return actual == null;
        }
        return expected.equals(actual);
    }

    public final void run() {
        LeetCodeRunner.run(this);
    }

    public final void benchmark(int warmup, int iterations) {
        LeetCodeRunner.benchmark(this, warmup, iterations);
    }
}
