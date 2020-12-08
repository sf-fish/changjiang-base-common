package com.changjiang.base.common.web;

import com.changjiang.base.common.lib.exception.enumtypes.BusinessResponseEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sfy
 * @description 全局异常测试
 * @date 2020/12/8
 */
@RestController
@RequestMapping(value = "/testException")
public class TestExceptionController {

    @PostMapping(value = "/postMethod")
    public String postMethod(){
        return "success";
    }

    @GetMapping(value = "/getMethod")
    public String getMethod(){

        BusinessResponseEnum.NO_DATA.assertNotNull(
                null, "666666","77777","88888","999999"
                ,"aaaaa","bbbbbb","cccc","dddd","gggggg","kkkkkk","lllllll","oooooo"
        );

        return "success";
    }
}
