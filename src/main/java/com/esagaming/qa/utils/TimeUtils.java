package com.esagaming.qa.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class TimeUtils {

    public static final Logger log = LogManager.getLogger(TimeUtils.class);

    public static void forceWait(int waitTimeInSeconds) {
        try {
            Thread.sleep(waitTimeInSeconds * 1000);
            log.debug("Waited " + waitTimeInSeconds + " seconds.");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
