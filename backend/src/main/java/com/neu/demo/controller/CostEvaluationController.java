package com.neu.demo.controller;


import com.neu.demo.biz.CostEvaluationBiz;
import com.neu.demo.entity.Project;
import com.neu.demo.mapper.CostEvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CostEvaluationController {

    @Autowired
    private CostEvaluationBiz costEvaluationBiz;

    @Autowired
    private CostEvaluationMapper costEvaluationMapper;

    @RequestMapping("/costEvaluation/ufp")
    @ResponseBody  // 表示返回的是 JSON 响应
    public Map<String, Object> searchUFP(@RequestParam int project_id){
        Map<String, Object> result = new HashMap<>();

        // 调用 biz 层的方法查询 ufp_num
        double ufp_num = costEvaluationBiz.selectUFP(project_id);

        if(ufp_num != 0){
            result.put("isOk",true);
            result.put("msg","查询ufp成功！");
            result.put("ufp_num",ufp_num);
        }else {
            result.put("isOk",false);
            result.put("msg","查询课程失败！");
        }
        return result;
    }


}
