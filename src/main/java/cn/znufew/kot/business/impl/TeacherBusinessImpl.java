package cn.znufew.kot.business.impl;

import cn.znufew.kot.business.ITeacherBusiness;
import cn.znufew.kot.entity.Teacher;
import cn.znufew.kot.entity.TeacherExample;
import cn.znufew.kot.mapper.TeacherMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (业务实现)
 *
 * @author wangzx
 * @date 2017/10/26 10:59.
 */
@Service
public class TeacherBusinessImpl implements ITeacherBusiness {
    @Autowired
    TeacherMapper teacherMapper;

    public long countByExample(TeacherExample example) {
        return 0;
    }

    public int deleteByExample(TeacherExample example) {
        return 0;
    }

    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(Teacher record) {
        return 0;
    }

    public int insertSelective(Teacher record) {
        return 0;
    }

    public List<Teacher> selectByExample(TeacherExample example) {
        return teacherMapper.selectByExample(example);
    }

    public Teacher selectByPrimaryKey(Long id) {
        return null;
    }

    public int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example) {
        return 0;
    }

    public int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example) {
        return 0;
    }

    public int updateByPrimaryKeySelective(Teacher record) {
        return 0;
    }

    public int updateByPrimaryKey(Teacher record) {
        return 0;
    }
}
