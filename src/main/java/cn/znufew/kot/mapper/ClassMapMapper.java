package cn.znufew.kot.mapper;

import cn.znufew.kot.entity.ClassMap;
import cn.znufew.kot.entity.ClassMapExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClassMapMapper {
    long countByExample(ClassMapExample example);

    int deleteByExample(ClassMapExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClassMap record);

    int insertSelective(ClassMap record);

    List<ClassMap> selectByExample(ClassMapExample example);

    ClassMap selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClassMap record, @Param("example") ClassMapExample example);

    int updateByExample(@Param("record") ClassMap record, @Param("example") ClassMapExample example);

    int updateByPrimaryKeySelective(ClassMap record);

    int updateByPrimaryKey(ClassMap record);
}