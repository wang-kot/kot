package cn.znufew.kot.business.impl;

import cn.znufew.kot.business.IStudentBusiness;
import cn.znufew.kot.entity.Student;
import cn.znufew.kot.entity.StudentExample;
import cn.znufew.kot.mapper.StudentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (业务实现)
 *
 * @author wangzx
 * @date 2017/9/8 17:13.
 */
@Service
public class StudentBusinessImpl implements IStudentBusiness {
    @Autowired
    StudentMapper studentMapper;

    public long countByExample(StudentExample example) {
        return studentMapper.countByExample(example);
    }

    public int deleteByExample(StudentExample example) {
        return studentMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    public List<Student> selectByExample(StudentExample example) {
        return studentMapper.selectByExample(example);
    }

    public Student selectByPrimaryKey(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example) {
        return 0;
    }

    public int updateByExample(@Param("record") Student record, @Param("example") StudentExample example) {
        return 0;
    }

    public int updateByPrimaryKeySelective(Student record) {
        return 0;
    }

    public int updateByPrimaryKey(Student record) {
        return 0;
    }
}
