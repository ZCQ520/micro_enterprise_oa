package com.wzu.oa.common.entity.DTO;

import com.wzu.oa.common.entity.Application;
import com.wzu.oa.common.entity.User;

/**
 * @author jack
 * @date 2018-01-16   14:07
 */
public class ApplicationDTO {
    private Application application;

    private User user;

    public ApplicationDTO() {
    }

    public ApplicationDTO(Application application, User user) {
        this.application = application;
        this.user = user;
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
