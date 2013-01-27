package com.lancktele.rest.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by IntelliJ IDEA.
 * User: azee
 * Date: 1/27/13

 */
public class LoadParams {
    @Value("#{perf['high.prior.invoke']}")
    public static String HIGH_PRIOR_INVOKE;

    public static int getHighPriorInvoke() {
        return Integer.parseInt(HIGH_PRIOR_INVOKE);
    }

}
