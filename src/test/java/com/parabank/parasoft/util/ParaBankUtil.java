package com.parabank.parasoft.util;

public class ParaBankUtil {
    public static final int WAIT_TIME = 30;
    public static final String ERROR = "Please enter a username and password.";

    public static void waitForDomStable(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
