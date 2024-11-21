package com.neu.demo.biz;


import com.neu.demo.mapper.CostEvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostEvaluationBiz {
    @Autowired
    private CostEvaluationMapper costEvaluationMapper;

    public double selectUFP(int project_id) {
        double ufp_num = costEvaluationMapper.selectUFP(project_id);
        return ufp_num;
    }

}
