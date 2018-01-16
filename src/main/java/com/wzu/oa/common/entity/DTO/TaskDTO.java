package com.wzu.oa.common.entity.DTO;

import com.wzu.oa.common.entity.Application;
import com.wzu.oa.common.entity.User;
import org.activiti.engine.task.Task;

/**
 * @author jack
 * @date 2018-01-03   14:18
 */
public class TaskDTO {

    private Task task;

    private Application application;

    private User user;

    public TaskDTO() {
    }


    public TaskDTO(Task task, Application application, User user) {
        this.task = task;
        this.application = application;
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
