package com.neu.demo.mapper;

import com.neu.demo.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
