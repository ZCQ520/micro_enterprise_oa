package com.wzu.oa.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jack
 * @date 2017/10/23   18:49
 */
@Api(value = "userOper", tags = {"用户管理"}, description = "UserController", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(name = "操作员管理控制器", value = "/api/v1/admin")
public interface UserController {

    @ApiOperation(value = "[doc]hello", tags = {"hello"}, notes = "hello")
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success", response = ApiResponse.class)})
    public String hello();
}
