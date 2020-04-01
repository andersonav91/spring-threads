package com.consejosano.status.service;

import com.consejosano.status.component.CustomThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class AsynchronousService {

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private ApplicationContext applicationContext;

    public void executeAsynchronously(int threadtNumber) {
        CustomThread thread = applicationContext.getBean(CustomThread.class, threadtNumber);
        taskExecutor.execute(thread);
    }

}
