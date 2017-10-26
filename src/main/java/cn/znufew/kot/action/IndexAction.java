package cn.znufew.kot.action;

import cn.znufew.kot.business.IAreaMapBusiness;
import cn.znufew.kot.business.IClassMapBusiness;
import cn.znufew.kot.business.IStudentBusiness;
import cn.znufew.kot.entity.AreaMap;
import cn.znufew.kot.entity.ClassMap;
import cn.znufew.kot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (业务实现)
 *
 * @author wangzx
 * @date 2017/10/11 17:38.
 */
@Controller
public class IndexAction {

    @Autowired
    IStudentBusiness iStudentBusiness;
    @Autowired
    IAreaMapBusiness iAreaMapBusiness;
    @Autowired
    IClassMapBusiness iClassMapBusiness;


    @RequestMapping("/index")
    public ModelAndView toIndex(HttpServletRequest request){
        Cookie cookie[] = request.getCookies();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        if(cookie!=null){
            for (Cookie cookie1:cookie){
                mv.addObject(cookie1.getName(),cookie1.getValue());
        }
        }else {
            mv.addObject("studentId","0");
            mv.addObject("studentName","guest");
        }
        return mv;
    }

    @RequestMapping("/index/{indexPageName}")
    public ModelAndView toIndexPage(@PathVariable String indexPageName,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName(indexPageName);
        Cookie cookies[] = request.getCookies();
        //me页面
        if(indexPageName.equals("me")){
            for (Cookie cookie1 : cookies) {
                if (cookie1.getName().equals("studentId")) {
                    Long studentId = Long.parseLong(cookie1.getValue());
                    Student student = iStudentBusiness.selectByPrimaryKey(studentId);
                    mv.addObject("studentDetail",student);
                    String homeCode = student.getHomeCode();
                    String classCode = student.getClassCode();
                    if(homeCode!=null){
                        AreaMap areaMap = iAreaMapBusiness.getAreaMapByCode(homeCode);
                        AreaMap[] areaMaps = iAreaMapBusiness.getCompleteAreaMaps(areaMap);
                        mv.addObject("shi",areaMaps[0].getName());
                        mv.addObject("sheng",areaMaps[1].getName());
                    }
                    if(classCode!=null){
                        ClassMap classMap = iClassMapBusiness.getClassMapByCode(classCode);
                        ClassMap[] classMaps = iClassMapBusiness.getCompleteClassMaps(classMap);
                        mv.addObject("zhuanye",classMaps[0].getName());
                        mv.addObject("xueyuan",classMaps[1].getName());
                        mv.addObject("school",classMaps[2].getName());
                    }
                }
            }
        }else if(indexPageName.equals("search")){
            ClassMap rootClassMap = iClassMapBusiness.getRootClassMap();
            List<ClassMap> subClassMaps = iClassMapBusiness.getSubClassMaps(rootClassMap);
            mv.addObject("schools",subClassMaps);
        }

        return mv;
    }

    @RequestMapping("/index/me/studentEdit")
    public ModelAndView toStudentEdit(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("studentEdit");
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("studentId")){
                Long studentId = Long.parseLong(cookie.getValue());
                Student student = iStudentBusiness.selectByPrimaryKey(studentId);
                mv.addObject("studentDetail",student);
                String homeCode = student.getHomeCode();
                String classCode = student.getClassCode();
                if(homeCode!=null){
                    AreaMap areaMap = iAreaMapBusiness.getAreaMapByCode(homeCode);
                    AreaMap[] areaMaps = iAreaMapBusiness.getCompleteAreaMaps(areaMap);
                    mv.addObject("shi",areaMaps[0].getName());
                    mv.addObject("sheng",areaMaps[1].getName());
                    List<AreaMap> shis = iAreaMapBusiness.getSameLevelAreaMaps(areaMaps[0]);
                    List<AreaMap> shengs = iAreaMapBusiness.getSameLevelAreaMaps(areaMaps[1]);
                    mv.addObject("shis",shis);
                    mv.addObject("shengs",shengs);
                }else{
                    AreaMap currentAreaMap = iAreaMapBusiness.selectByPrimaryKey(2l);
                    List<AreaMap> shengs = iAreaMapBusiness.getSubAreaMaps(currentAreaMap);
                    mv.addObject("shengs",shengs);
                }
                if(classCode!=null){
                    ClassMap classMap = iClassMapBusiness.getClassMapByCode(classCode);
                    ClassMap[] classMaps = iClassMapBusiness.getCompleteClassMaps(classMap);
                    mv.addObject("zhuanye",classMaps[0].getName());
                    mv.addObject("xueyuan",classMaps[1].getName());
                    mv.addObject("school",classMaps[2].getName());
                    mv.addObject("zhuanyes",iClassMapBusiness.getSameLevelClassMap(classMaps[0]));
                    mv.addObject("xueyuans",iClassMapBusiness.getSameLevelClassMap(classMaps[1]));
                    mv.addObject("schools",iClassMapBusiness.getSameLevelClassMap(classMaps[2]));
                }else{
                    ClassMap currentClassMap = iClassMapBusiness.selectByPrimaryKey(2l);
                    List<ClassMap> schools = iClassMapBusiness.getSubClassMaps(currentClassMap);
                    mv.addObject("schools",schools);
                }
            }
        }
        return mv;
    }
}
