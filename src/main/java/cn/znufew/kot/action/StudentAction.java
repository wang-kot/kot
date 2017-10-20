package cn.znufew.kot.action;

import cn.znufew.kot.business.IStudentBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * (业务实现)
 *
 * @author wangzx
 * @date 2017/10/11 12:33.
 */
@Controller
public class StudentAction {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    IStudentBusiness iStudentBusiness;



    @RequestMapping(value = "/student/condition", method = RequestMethod.GET)
    public ModelAndView selectByCondition(String test) {
        System.out.print(test);
        ModelAndView mv = new ModelAndView();
        mv.addObject("test", test);
        mv.setViewName("student");
        return mv;
    }

    @RequestMapping("/student/detail.do")
    public Object selectByStudentId(Long studentId) {
        return iStudentBusiness.selectByPrimaryKey(studentId);
    }

}
