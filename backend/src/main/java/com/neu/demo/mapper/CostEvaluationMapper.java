package com.neu.demo.mapper;


import com.neu.demo.entity.UFP;
import org.apache.ibatis.annotations.*;

import java.util.List;
import com.neu.demo.entity.GSC;
import com.neu.demo.entity.Project;
import com.neu.demo.entity.S;

@Mapper
public interface CostEvaluationMapper {

    @Select("select ufp from t_project where project_id=#{project_id}")
    int selectUFP(@Param("project_id") String project_id);

    @Select("select * from t_project where project_id=#{project_id}")
    Project selectProject(@Param("project_id") String project_id);

    @Update("update t_project set s=#{s_value} where project_id=#{project_id}")
    int updateSValue(@Param("project_id") String project_id, @Param("s_value") Double s_value);

    @Update("update t_project set step=#{step} where project_id=#{project_id}")
    int updateStep(@Param("project_id") String project_id, @Param("step") Double step);

    @Update("update t_project set dfp=#{dfp_num} where project_id=#{project_id}")
    int updateDFPValue(@Param("project_id") String project_id, @Param("dfp_num") Double dfp_num);

    @Insert("insert into t_s (project_id, type, value) VALUES (#{project_id},  #{type}, #{value}) ")
    void saveCfItem(S cfItem);

    @Delete("delete from t_s WHERE project_id = #{project_id}")
    void deleteCFItemsByProjectId(@Param("project_id") String project_id);

    //
    @Select("select  * from t_ufp where module_id=#{module_id}")
    List<UFP> selectModuleUfp(@Param("module_id") String module_id);

    @Insert("insert into t_ufp values(#{module_id},null,#{type},#{detail})")
    int insertModuleUfp(UFP ufp);

    @Delete("delete from t_ufp where module_id=#{module_id}")
    int deleteModuleUfp(String module_id);

    @Insert("INSERT INTO t_dfp (project_id, type, value) VALUES (#{project_id},  #{type}, #{value}) ")
    void saveGSCItem(GSC diDatum);

    @Delete("DELETE FROM t_dfp WHERE project_id = #{project_id}")
    void deleteGSCItemsByProjectId(@Param("project_id") String project_id);

    @Select("select * from t_dfp where project_id=#{project_id}")
    List<GSC> selectGSCItemsByProjectId(@Param("project_id") String project_id);

    @Select("select * from t_s where project_id=#{project_id}")
    List<S> selectSItemsByProjectId(@Param("project_id") String project_id);

}

