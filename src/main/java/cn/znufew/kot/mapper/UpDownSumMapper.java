package cn.znufew.kot.mapper;

import cn.znufew.kot.entity.UpDownSum;
import cn.znufew.kot.entity.UpDownSumExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UpDownSumMapper {
    long countByExample(UpDownSumExample example);

    int deleteByExample(UpDownSumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UpDownSum record);

    int insertSelective(UpDownSum record);

    List<UpDownSum> selectByExample(UpDownSumExample example);

    UpDownSum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UpDownSum record, @Param("example") UpDownSumExample example);

    int updateByExample(@Param("record") UpDownSum record, @Param("example") UpDownSumExample example);

    int updateByPrimaryKeySelective(UpDownSum record);

    int updateByPrimaryKey(UpDownSum record);
}