package com.neu.demo.mapper;


import com.neu.demo.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CostEvaluationMapper {


    @Select("select ufp_num from t_project where project_id=#{project_id}")
    double selectUFP(@Param("project_id") int project_id);

}
