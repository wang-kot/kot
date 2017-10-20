package cn.znufew.kot.business;

import cn.znufew.kot.entity.AreaMap;
import cn.znufew.kot.entity.AreaMapExample;

import java.util.List;

/**
 * (接口定义)
 *
 * @author wangzx
 * @date 2017/10/16 16:25.
 */
public interface IAreaMapBusiness extends IBaseBusiness<AreaMap,AreaMapExample> {

    AreaMap getAreaMapByCode(String areaMapCode);

    AreaMap getSupAreaMap(AreaMap subAreaMap);

    List<AreaMap> getSubAreaMaps(AreaMap subAreaMap);

    AreaMap[] getCompleteAreaMaps(AreaMap areaMap);

    List<AreaMap> getSameLevelAreaMaps(AreaMap areaMap);
}
