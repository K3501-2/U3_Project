package com.team.hospital.service.impl;

import com.team.hospital.entity.MedicalAdvice;
import com.team.hospital.entity.MedicalAdviceExample;
import com.team.hospital.mapper.MedicalAdviceMapper;
import com.team.hospital.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/19 17:27
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.service.impl
 * @Classname MedicalServiceImpl
 * @Created by Administrator
 * @Description:医嘱业务接口实现
 */
@Service
public class MedicalServiceImpl implements MedicalService {
    @Autowired
    private MedicalAdviceMapper medicalAdviceMapper;

    //
    @Override
    public int addMedical(MedicalAdvice advice) {
        //如果没有医嘱信息，则添加
        //如果有医嘱信息，则修改
        //1.通过挂号单查询医嘱信息----利用selectByExample
        MedicalAdviceExample m = new MedicalAdviceExample();
        MedicalAdviceExample.Criteria criteria = m.createCriteria();
        criteria.andRegistryIdEqualTo(advice.getRegistryId());
        List<MedicalAdvice> list = medicalAdviceMapper.selectByExample(m);
        if (list.size() == 0){
            //添加医嘱
            return medicalAdviceMapper.insertSelective(advice);
        } else {
            //修改医嘱
            return medicalAdviceMapper.updateByPrimaryKeySelective(advice);
        }
    }
}
