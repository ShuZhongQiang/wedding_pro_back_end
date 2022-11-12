package com.example.wedding_pro_back_end.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wedding_pro_back_end.bean.vo.TestVo;
import com.example.wedding_pro_back_end.mapper.TestMapper;
import com.example.wedding_pro_back_end.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestVo> implements TestService {
}
