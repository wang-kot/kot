package cn.znufew.kot.action;

import cn.znufew.kot.business.IClassMapBusiness;
import cn.znufew.kot.business.ITeacherBusiness;
import cn.znufew.kot.entity.ClassMap;
import cn.znufew.kot.entity.Teacher;
import cn.znufew.kot.entity.TeacherExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * (业务实现)
 *
 * @author wangzx
 * @date 2017/10/11 17:40.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherAction {
    @Autowired
    IClassMapBusiness iClassMapBusiness;

    @Autowired
    ITeacherBusiness iTeacherBusiness;

    @RequestMapping("/searchTeacherByCondition.do")
    @ResponseBody
    private List<Teacher> searchTeacherByCondition(String teacherName, String school, String xueyuan, String zhuanye){
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        if(!zhuanye.equals("kong")){
            String zhuanyeCode = iClassMapBusiness.selectByPrimaryKey(Long.parseLong(zhuanye)).getCode();
            criteria.andClassCodeEqualTo(zhuanyeCode);
        }else if(!xueyuan.equals("kong")){
            ClassMap supClassMap = new ClassMap();
            supClassMap.setId(Long.parseLong(xueyuan));
            List<ClassMap> subClassMaps = iClassMapBusiness.getSubClassMaps(supClassMap);
            List<String> subClassMapsCode = new ArrayList<String>();
            for (ClassMap classMap : subClassMaps) {
                subClassMapsCode.add(classMap.getCode());
            }
            criteria.andClassCodeIn(subClassMapsCode);
        }else if(!school.equals("kong")){
            ClassMap schoolClassMap = new ClassMap();
            schoolClassMap.setId(Long.parseLong(school));
            List<ClassMap> xueyuanClassMaps = iClassMapBusiness.getSubClassMaps(schoolClassMap);
            List<String> allClassMapsCode = new ArrayList<String>();
            for(ClassMap xueyuanClassMap : xueyuanClassMaps){
                List<ClassMap> zhuanyeClassMaps = iClassMapBusiness.getSubClassMaps(xueyuanClassMap);
                for(ClassMap zhuanyeClassMap : zhuanyeClassMaps ){
                    allClassMapsCode.add(zhuanyeClassMap.getCode());
                }
            }
            criteria.andClassCodeIn(allClassMapsCode);
        }
        if(!teacherName.equals("")){
            criteria.andNickNameLike(teacherName);
        }
        List<Teacher> teachers = iTeacherBusiness.selectByExample(teacherExample);
        return teachers;
    }
}
