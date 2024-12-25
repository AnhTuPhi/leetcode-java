package vn.com.leetcode.problems;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;
import vn.com.leetcode.common.JsonMapper;

/**
 * @author : AnhTuPhi
 * @created : 12/23/2024 - 11:45 PM - Monday
 * @project : leetcode-java
 **/
public abstract class Problem {

    public void execute() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var result = solve();
        stopWatch.stop();
        System.out.println("Time elapsed: " + stopWatch.getTime(TimeUnit.MICROSECONDS) + " microseconds");
        System.out.println(JsonMapper.readTree(result));
    }

    public abstract Object solve();
}
