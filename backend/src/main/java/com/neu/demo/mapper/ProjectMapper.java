package com.neu.demo.mapper;

import com.neu.demo.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProjectMapper {
    //获取全部项目
    @Select("select * from t_project")
    List<Project> getProjects();

    //按照项目id获取项目
    @Select("SELECT * FROM t_project WHERE project_id = #{project_id}")
    Project getProjectById(@Param("project_id") String project_id);

    //按照项目所属公司获取项目
    @Select("SELECT * FROM t_project WHERE company = #{company}")
    List<Project> getProjectsByCompany(@Param("company") String company);

    //更新项目的ufp，ei_num，eo_num，eq_num，ilf_num，elf_num
    @Update("update t_project set ufp = #{ufp}, ei_num = #{ei_num}, eo_num = #{eo_num}, eq_num = #{eq_num}, ilf_num = #{ilf_num}, elf_num = #{elf_num} where project_id = #{project_id}")
    int updateUFP(@Param("project_id") String project_id, @Param("ufp") int ufp, @Param("ei_num") int ei_num, @Param("eo_num") int eo_num, @Param("eq_num") int eq_num, @Param("ilf_num") int ilf_num, @Param("elf_num") int elf_num);

    //更新项目的step和status
    @Update("update t_project set step = #{step},status=#{status} where project_id = #{project_id}")
    int updateStep(@Param("project_id") String project_id, @Param("step") double step,@Param("status") String status);


    //按照项目名称获取项目
    @Select("SELECT * FROM t_project WHERE project_name LIKE CONCAT('%', #{project_name}, '%')")
    List<Project> getProjectByName(String project_name);

    //按照项目状态获取项目
    @Select("SELECT * FROM t_project WHERE status = #{status}")
    List<Project> getProjectByStatus(String status);

    //按照项目截止日期获取项目
    @Select("SELECT * FROM t_project WHERE ddl = #{ddl}")
    List<Project> getProjectByDDL(String ddl);


    //按照条件获取项目
    @Select({
            "<script>",
            "SELECT * FROM t_project",
            "WHERE 1=1",
            "<if test='project_name != null and project_name != \"\"'>",
            "AND project_name LIKE CONCAT('%', #{project_name}, '%')",
            "</if>",
            "<if test='status != null and status != \"\"'>",
            "AND status = #{status}",
            "</if>",
            "<if test='ddl != null and ddl != \"\"'>",
            "AND ddl = #{ddl}",
            "</if>",
            "LIMIT #{offset}, #{pageSize}",
            "</script>"
    })
    List<Project> getProjectByNameStatusDDL(@Param("project_name") String project_name,
                                            @Param("status") String status,
                                            @Param("ddl") String ddl,
                                            @Param("offset") int offset,
                                            @Param("pageSize") int pageSize);

    @Select({
            "<script>",
            "SELECT * FROM t_project",
            "WHERE 1=1",
            "<if test='project_name != null and project_name != \"\"'>",
            "AND project_name LIKE CONCAT('%', #{project_name}, '%')",
            "</if>",
            "<if test='status != null and status != \"\"'>",
            "AND status = #{status}",
            "</if>",
            "<if test='ddl != null and ddl != \"\"'>",
            "AND ddl = #{ddl}",
            "</if>",
            "</script>"})
    List<Project> countProjects(@Param("project_name") String project_name,
                                            @Param("status") String status,
                                            @Param("ddl") String ddl);



}
