package com.wfs.automation.selenium.waithelper;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.wfs.automation.selenium.helper.ExecuteCommand;

public class WaitHelper {
	
    public void waitUntillCommandReturnsTrue(ExecuteCommand<Boolean> executeCommand, TimeUnit timeUnit,long retryInterval, long timeOut) throws TimeoutException {

        boolean result = false;

        long startTime = System.currentTimeMillis();
        long maxWaitTime = startTime + TimeUnit.MILLISECONDS.convert(timeOut, timeUnit);

        while (maxWaitTime > System.currentTimeMillis() && !result) {
            result = executeCommand.execute();
            if (!result) {
                try {
                    Thread.sleep(TimeUnit.MILLISECONDS.convert(retryInterval,timeUnit));
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        
        if (!result) {
            throw new TimeoutException();
        }

    }
}
