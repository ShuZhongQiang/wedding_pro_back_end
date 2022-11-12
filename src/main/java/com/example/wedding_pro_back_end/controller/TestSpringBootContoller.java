package com.example.wedding_pro_back_end.controller;

import com.example.wedding_pro_back_end.bean.vo.TestVo;
import com.example.wedding_pro_back_end.config.response.ResponseResult;
import com.example.wedding_pro_back_end.mapper.TestMapper;
import com.example.wedding_pro_back_end.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
@Api(value = "测试", tags = "测试")
public class TestSpringBootContoller {

    @Autowired
    private TestService testService;

    @ApiOperation("测试查询用户信息")
    @PostMapping("findList")
    public ResponseResult<List<TestVo>> findList(){
        List<TestVo> testVoList = testService.list();
        return ResponseResult.success(testVoList);
    }

    @ApiOperation("测试添加用户信息")
    @PostMapping("addTestInfo")
    public ResponseResult<Boolean> addInfo(TestVo testVo) {
        Boolean result = testService.save(testVo);
        return ResponseResult.success(result);
    }
}
