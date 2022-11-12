package com.example.wedding_pro_back_end.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.wedding_pro_back_end.bean.vo.TestVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestMapper extends BaseMapper<TestVo> {
}
