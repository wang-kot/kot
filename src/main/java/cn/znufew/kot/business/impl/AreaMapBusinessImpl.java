package cn.znufew.kot.business.impl;

import cn.znufew.kot.business.IAreaMapBusiness;
import cn.znufew.kot.entity.AreaMap;
import cn.znufew.kot.entity.AreaMapExample;
import cn.znufew.kot.mapper.AreaMapMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (业务实现)
 *
 * @author wangzx
 * @date 2017/10/16 16:26.
 */
@Service
public class AreaMapBusinessImpl implements IAreaMapBusiness {

    @Autowired
    AreaMapMapper areaMapMapper;

    public long countByExample(AreaMapExample example) {
        return 0;
    }

    public int deleteByExample(AreaMapExample example) {
        return 0;
    }

    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(AreaMap record) {
        return 0;
    }

    public int insertSelective(AreaMap record) {
        return 0;
    }

    public List<AreaMap> selectByExample(AreaMapExample example) {
        return areaMapMapper.selectByExample(example);
    }

    public AreaMap selectByPrimaryKey(Long id) {
        return areaMapMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(@Param("record") AreaMap record, @Param("example") AreaMapExample example) {
        return 0;
    }

    public int updateByExample(@Param("record") AreaMap record, @Param("example") AreaMapExample example) {
        return 0;
    }

    public int updateByPrimaryKeySelective(AreaMap record) {
        return 0;
    }

    public int updateByPrimaryKey(AreaMap record) {
        return 0;
    }

    public AreaMap getAreaMapByCode(String areaMapCode) {
        AreaMapExample areaMapExample = new AreaMapExample();
        AreaMapExample.Criteria criteria = areaMapExample.createCriteria();
        criteria.andCodeEqualTo(areaMapCode);
        return areaMapMapper.selectByExample(areaMapExample).get(0);
    }

    public AreaMap getSupAreaMap(AreaMap subAreaMap) {
        return areaMapMapper.selectByPrimaryKey(subAreaMap.getParentId());
    }

    public List<AreaMap> getSubAreaMaps(AreaMap supAreaMap) {
        AreaMapExample areaMapExample = new AreaMapExample();
        AreaMapExample.Criteria criteria = areaMapExample.createCriteria();
        criteria.andParentIdEqualTo(supAreaMap.getId());
        return areaMapMapper.selectByExample(areaMapExample);
    }

    public AreaMap[] getCompleteAreaMaps(AreaMap areaMap) {
        int i = 0;
        AreaMap[] completeAreaMaps = new AreaMap[5];
        completeAreaMaps[i]=areaMap;
        AreaMap tempAreaMap=areaMap;
        while (tempAreaMap.getParentId()!=0l){
            Long parentId = areaMap.getParentId();
            tempAreaMap = areaMapMapper.selectByPrimaryKey(parentId);
            i++;
            completeAreaMaps[i]=tempAreaMap;
        }
        return completeAreaMaps;
    }

    public List<AreaMap> getSameLevelAreaMaps(AreaMap areaMap) {
        AreaMapExample areaMapExample = new AreaMapExample();
        AreaMapExample.Criteria criteria = areaMapExample.createCriteria();
        criteria.andParentIdEqualTo(areaMap.getParentId());
        return areaMapMapper.selectByExample(areaMapExample);
    }

}
