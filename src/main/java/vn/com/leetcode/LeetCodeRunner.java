package vn.com.leetcode;

import vn.com.leetcode.utils.JsonMapper;

import java.util.List;

public final class LeetCodeRunner {

    private static final String RESET  = "\u001B[0m";
    private static final String GREEN  = "\u001B[32m";
    private static final String RED    = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN   = "\u001B[36m";
    private static final String BOLD   = "\u001B[1m";

    private LeetCodeRunner() {}

    public static <I, O> void run(Solution<I, O> solution) {
        List<TestCase<I, O>> cases = solution.testCases();
        String clazz = solution.getClass().getSimpleName();

        System.out.printf("%n%s=== %s ===%s%n", BOLD + CYAN, clazz, RESET);

        int passed = 0;
        for (int i = 0; i < cases.size(); i++) {
            TestCase<I, O> tc = cases.get(i);
            String label = tc.name().isEmpty() ? "Case " + (i + 1) : tc.name();

            long start = System.nanoTime();
            O actual = solution.solve(tc.input());
            long elapsedNs = System.nanoTime() - start;

            boolean ok = solution.assertEquals(tc.expected(), actual);
            if (ok) passed++;

            String status = ok ? GREEN + "PASS" : RED + "FAIL";
            System.out.printf("  [%s%s] %-20s  %s(%s)%s%n",
                    status, RESET,
                    label,
                    YELLOW, formatNs(elapsedNs), RESET);

            if (!ok) {
                System.out.printf("       input:    %s%n", JsonMapper.write(tc.input()));
                System.out.printf("       expected: %s%n", JsonMapper.write(tc.expected()));
                System.out.printf("       actual:   %s%n", JsonMapper.write(actual));
            }
        }

        System.out.printf("  %s%d/%d passed%s%n%n", BOLD, passed, cases.size(), RESET);
    }

    public static <I, O> void benchmark(Solution<I, O> solution, int warmup, int iterations) {
        List<TestCase<I, O>> cases = solution.testCases();
        String clazz = solution.getClass().getSimpleName();

        System.out.printf("%n%s=== BENCHMARK: %s ===%s%n", BOLD + CYAN, clazz, RESET);
        System.out.printf("  warmup=%d  iterations=%d%n%n", warmup, iterations);

        for (int i = 0; i < cases.size(); i++) {
            TestCase<I, O> tc = cases.get(i);
            String label = tc.name().isEmpty() ? "Case " + (i + 1) : tc.name();

            // Warmup — discard results
            for (int w = 0; w < warmup; w++) solution.solve(tc.input());

            long[] times = new long[iterations];
            for (int it = 0; it < iterations; it++) {
                long start = System.nanoTime();
                solution.solve(tc.input());
                times[it] = System.nanoTime() - start;
            }

            Stats stats = computeStats(times);
            System.out.printf("  %-20s  avg=%s  min=%s  max=%s  p99=%s%n",
                    label,
                    formatNs(stats.avg),
                    formatNs(stats.min),
                    formatNs(stats.max),
                    formatNs(stats.p99));
        }
        System.out.println();
    }

    // --- internals ---

    private static String formatNs(long ns) {
        if (ns < 1_000) return ns + "ns";
        if (ns < 1_000_000) return String.format("%.2fµs", ns / 1_000.0);
        if (ns < 1_000_000_000) return String.format("%.2fms", ns / 1_000_000.0);
        return String.format("%.2fs", ns / 1_000_000_000.0);
    }

    private static Stats computeStats(long[] times) {
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE, sum = 0;
        for (long t : times) {
            if (t < min) min = t;
            if (t > max) max = t;
            sum += t;
        }
        long[] sorted = times.clone();
        java.util.Arrays.sort(sorted);
        long p99 = sorted[(int) Math.ceil(sorted.length * 0.99) - 1];
        return new Stats(sum / times.length, min, max, p99);
    }

    private record Stats(long avg, long min, long max, long p99) {}
}
