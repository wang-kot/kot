package cn.znufew.kot.mapper;

import cn.znufew.kot.entity.UpDown;
import cn.znufew.kot.entity.UpDownExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UpDownMapper {
    long countByExample(UpDownExample example);

    int deleteByExample(UpDownExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UpDown record);

    int insertSelective(UpDown record);

    List<UpDown> selectByExample(UpDownExample example);

    UpDown selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UpDown record, @Param("example") UpDownExample example);

    int updateByExample(@Param("record") UpDown record, @Param("example") UpDownExample example);

    int updateByPrimaryKeySelective(UpDown record);

    int updateByPrimaryKey(UpDown record);
}