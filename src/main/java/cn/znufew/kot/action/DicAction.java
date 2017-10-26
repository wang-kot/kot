package cn.znufew.kot.action;

import cn.znufew.kot.business.IAreaMapBusiness;
import cn.znufew.kot.business.IClassMapBusiness;
import cn.znufew.kot.entity.ClassMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * (业务实现)
 *
 * @author wangzx
 * @date 2017/10/12 10:48.
 */
@Controller
@RequestMapping("/dic")
public class DicAction {
    @Autowired
    IAreaMapBusiness iAreaMapBusiness;
    @Autowired
    IClassMapBusiness iClassMapBusiness;

    @RequestMapping("/classMap/getSubClassMap.do")
    @ResponseBody
    public List<ClassMap> getSubClass(Long supId, HttpServletResponse response){
        ClassMap supClassMap = new ClassMap();
        supClassMap.setId(supId);
        List<ClassMap> subClassMaps = iClassMapBusiness.getSubClassMaps(supClassMap);
        return subClassMaps;
    }
}
