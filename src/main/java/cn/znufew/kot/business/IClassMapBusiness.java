package cn.znufew.kot.business;

import cn.znufew.kot.entity.ClassMap;
import cn.znufew.kot.entity.ClassMapExample;

import java.util.List;

/**
 * (接口定义)
 *
 * @author wangzx
 * @date 2017/10/16 16:44.
 */
public interface IClassMapBusiness extends IBaseBusiness<ClassMap,ClassMapExample> {

    ClassMap getClassMapByCode(String classMapCode);

    ClassMap getSupClassMap(ClassMap subClassMap);

    List<ClassMap> getSubClassMaps(ClassMap supClassMap);

    ClassMap[] getCompleteClassMaps(ClassMap classMap);

    List<ClassMap> getSameLevelClassMap(ClassMap classMap);
}
