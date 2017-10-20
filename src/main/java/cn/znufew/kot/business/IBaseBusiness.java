package cn.znufew.kot.business;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (业务实现)
 *
 * @author wangzx
 * @date 2017/10/12 16:38.
 */
public interface IBaseBusiness<T,TExp>{
    long countByExample(TExp example);

    int deleteByExample(TExp example);

    int deleteByPrimaryKey(Long id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(TExp example);

    T selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") TExp example);

    int updateByExample(@Param("record") T record, @Param("example") TExp example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
