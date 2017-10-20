package cn.znufew.kot.action;

import cn.znufew.kot.business.IStudentBusiness;
import cn.znufew.kot.entity.Student;
import cn.znufew.kot.entity.StudentExample;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (业务实现)
 *
 * @author wangzx
 * @date 2017/10/11 17:39.
 */
@Controller
public class LogAction {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IStudentBusiness iStudentBusiness;

    @RequestMapping("/log")
    public String toLog(){
        return "login";
    }

    /**
     * @Author: 王兆勋
     * @Description: 学生注册处理
     * @Date: 2017/10/13 17:40
     */
    @RequestMapping(value = "/log/student/register.do", method = RequestMethod.POST)
    @ResponseBody
    public Object studentRegister(String nickName, String emailOrPhone, String passw, boolean sex) {
        Map result = new HashedMap();
        Student student = new Student();
        student.setNickName(nickName);
        student.setPassw(passw);
        student.setSex(sex);
        String regExp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(emailOrPhone);
        if (m.find()) {
            student.setPhone(Long.parseLong(emailOrPhone));
        } else {
            student.setEmail(emailOrPhone);
        }
        try {
            iStudentBusiness.insertSelective(student);
            result.put("studentId", student.getId());
            result.put("studentNName", student.getNickName());
            result.put("result", "success");
        } catch (Exception e) {
            logger.info(e.toString());
            result.put("result", "failed");
        }
        return result;
        //TODO 字段验证
    }

    /**
     * @Author: 王兆勋
     * @Description: 学生登陆处理
     * @Date: 2017/10/16 12:40
     */
    @RequestMapping(value = "/log/student/login.do", method = RequestMethod.POST)
    @ResponseBody
    public Object studentLogin(String emailOrPhone, String passw) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        String regExp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(emailOrPhone);
        if (m.find()) {
            criteria.andPhoneEqualTo(Long.parseLong(emailOrPhone));
        } else {
            criteria.andEmailEqualTo(emailOrPhone);
        }
        criteria.andPasswEqualTo(passw);
        List<Student> studentList = iStudentBusiness.selectByExample(studentExample);
        Map result = new HashedMap();
        if (studentList.size() > 0) {
            Long studentId = studentList.get(0).getId();
            String studentName = studentList.get(0).getNickName();
            result.put("studentId", studentId);
            result.put("studentName", studentName);
            result.put("result", "success");
        } else {
            result.put("result", "failed");
        }
        return result;
    }
}
