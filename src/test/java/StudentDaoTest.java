package cn.znufew.kot.mapper;

import cn.znufew.kot.action.StudentAction;
import cn.znufew.kot.business.impl.StudentBusinessImpl;
import cn.znufew.kot.entity.Student;
import cn.znufew.kot.entity.StudentExample;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentDaoTest extends cn.znufew.kot.mapper.BaseTest {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentBusinessImpl studentBusinessImpl;
    @Autowired
    private StudentAction studentAction;

//    @Test
//    public void testQueryByCondition() throws Exception {
//        String nickName = "111";
//        List<TStudent> students = iStudentDao.selectByCondition(nickName,null);
//        System.out.print(students);
//    }
    private Long stuId;

    @Test
    public void testInsert() throws Exception {
        Student student = new Student();
//        student.setEmail("");
        student.setPhone(13164618850l);
        student.setNickName("123");
        student.setPassw("123123");
        System.out.print("为毛没有输出");
        System.out.print(studentBusinessImpl.insert(student));
        System.out.print(student.getId());
    }

    @Test
    public void testSelectByExample() throws Exception{
        String nickName = "123";
        String passw = "wr18r18";
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andNickNameEqualTo(nickName);
        criteria.andPasswEqualTo(passw);
        List<Student> studentList= studentMapper.selectByExample(studentExample);
        for(Student student:studentList){
            System.out.print(student.getNickName());
        }
    }
//    @Test
//    public void testDelete() throws Exception {
//        System.out.print("stuId="+stuId);
//        studentBusiness.delete(54l);
//        System.out.print("delete成功");
//    }
}