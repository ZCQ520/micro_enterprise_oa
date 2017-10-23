package com.wzu.oa.controller.impl;

import com.wzu.oa.controller.UserController;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jack
 * @date 2017/10/23   18:49
 */
@RestController
public class UserControllerImpl implements UserController {

    public String hello() {
        return "hello";
    }
}
