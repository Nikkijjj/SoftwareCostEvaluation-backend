package com.neu.demo.mapper;

import com.neu.demo.entity.Structure;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StructureMapper {

    //获取节点的名称
    @Select("select module_name from t_structure where module_id = #{module_id}")
    String getModuleName(String module_id);

    //获取节点的描述
    @Select("select module_desc from t_structure where module_id = #{module_id}")
    String getModuleDesc(String module_id);

    //更新节点的信息（名称、描述）
    @Update("update t_structure set module_name = #{module_name}, module_desc = #{module_desc} where module_id = #{module_id}")
    int updateModule(@Param("module_id") String module_id, @Param("module_name") String module_name, @Param("module_desc") String module_desc);

    //更新节点未调整功能点信息
    @Update("update t_structure set ufp=#{ufp},ei_num=#{ei_num},eo_num=#{eo_num},eq_num=#{eq_num},ilf_num=#{ilf_num}," +
            "elf_num=#{elf_num},step=#{step} " +
            "where module_id = #{module_id}")
    public int updateUFPInfo(Structure module);

    //添加新节点
    @Insert("insert into t_structure values(#{project_id}, #{module_id}, #{parent_id}, #{module_name}, #{module_desc}, #{ufp}, #{ei_num}, #{eo_num}, #{eq_num}, #{ilf_num}, #{elf_num}, #{step})")
    int insertModule(Structure structure);

    //删除节点
    @Delete("delete from t_structure where module_id = #{module_id}")
    int deleteModule(String module_id);

    //获取所有功能结构
    @Select("select * from t_structure")
    List<Structure> getModules();

    //根据功能模块id获取选中功能模块的信息
    @Select("select * from t_structure where module_id = #{module_id}")
    Structure getModuleById(String module_id);

    //获取同一项目下一个parent下的所有模块
    @Select("select * from t_structure where project_id = #{project_id} and parent_id = #{parent_id}")
    List<Structure> getModuleByProjectIdAndParentId(@Param("project_id") String project_id, @Param("parent_id") String parent_id);

    //获取一个项目下的所有功能模块
    @Select("select * from t_structure where project_id = #{project_id}")
    List<Structure> getModuleByProjectId(String project_id);

    //获取功能模块的ufp
    @Select("select ufp from t_structure where module_id = #{module_id}")
    int getUfp(String module_id);

    //获取功能模块的ei_num
    @Select("select ei_num from t_structure where module_id = #{module_id}")
    int getEiNum(String module_id);

    //获取功能模块的eo_num
    @Select("select eo_num from t_structure where module_id = #{module_id}")
    int getEoNum(String module_id);

    //获取功能模块的eq_num
    @Select("select eq_num from t_structure where module_id = #{module_id}")
    int getEqNum(String module_id);

    //获取功能模块的ilf_num
    @Select("select ilf_num from t_structure where module_id = #{module_id}")
    int getIlfNum(String module_id);

    //获取功能模块的elf_num
    @Select("select elf_num from t_structure where module_id = #{module_id}")
    int getElfNum(String module_id);

    //获取功能模块的step
    @Select("select step from t_structure where module_id = #{module_id}")
    double getStep(String module_id);

}
