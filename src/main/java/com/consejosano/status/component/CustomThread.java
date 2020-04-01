package com.consejosano.status.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Component
@Scope("prototype")
public class CustomThread implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(CustomThread.class);

    private int threadNumber;

    public CustomThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        Date date = new Date();
        logger.info(date.toString() + " CONCEJOSANO " + this.threadNumber);
    }

}
