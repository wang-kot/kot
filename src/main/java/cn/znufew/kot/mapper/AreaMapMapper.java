package cn.znufew.kot.mapper;

import cn.znufew.kot.entity.AreaMap;
import cn.znufew.kot.entity.AreaMapExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AreaMapMapper {
    long countByExample(AreaMapExample example);

    int deleteByExample(AreaMapExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AreaMap record);

    int insertSelective(AreaMap record);

    List<AreaMap> selectByExample(AreaMapExample example);

    AreaMap selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AreaMap record, @Param("example") AreaMapExample example);

    int updateByExample(@Param("record") AreaMap record, @Param("example") AreaMapExample example);

    int updateByPrimaryKeySelective(AreaMap record);

    int updateByPrimaryKey(AreaMap record);
}