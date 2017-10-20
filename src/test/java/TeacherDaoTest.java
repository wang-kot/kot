package cn.znufew.kot.mapper;

import cn.znufew.kot.entity.Teacher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherDaoTest extends cn.znufew.kot.mapper.BaseTest {

    @Autowired
    private TeacherMapper teacherMapper;

    //    @Test
//    public void testQueryByCondition() throws Exception {
//        String nickName = "111";
//        List<TStudent> students = iStudentDao.selectByCondition(nickName,null);
//        System.out.print(students);
//    }
    private Long teaId;

    @Test
    public void testInsert() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setNickName("王二蛋");
        teacher.setEmail("1@1.com");
        System.out.print(teacherMapper.insert(teacher));
    }
//    @Test
//    public void testDelete() throws Exception {
//        System.out.print("stuId="+stuId);
//        studentBusiness.delete(54l);
//        System.out.print("delete成功");
//    }
}