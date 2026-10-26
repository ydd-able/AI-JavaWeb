package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */


@Mapper
public interface EmpMapper {


    //------------------------------------------原始分页查询实现------------------------------------------------------//
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    public Long count();
//
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{start},#{pageSize}")
//    public List<Emp> list(Integer start , Integer pageSize);

    // @Select("select e.* ,d.name from emp e left join dept d on e.dept_id = d.id where e.name like concat('%',#{name},'%')and e.gender = #{gender} and e.entry_date between #{begin} and #{end} order by e.entry_date desc")
//    public List<Emp> list(String name, Integer gender,
//                          LocalDate begin, LocalDate end);

    public List<Emp> list(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)"+
            "values(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);


    /**
     * 批量删除员工的基本信息。
     */

    void deleteByIds(List<Integer> ids);


    Emp getById(Integer id);

    void updateById(Emp emp);

    List<Map<String, Object>> countEmpJobData();

}
