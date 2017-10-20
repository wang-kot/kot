package cn.znufew.kot.business.impl;

import cn.znufew.kot.business.IClassMapBusiness;
import cn.znufew.kot.entity.ClassMap;
import cn.znufew.kot.entity.ClassMapExample;
import cn.znufew.kot.mapper.ClassMapMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (业务实现)
 *
 * @author wangzx
 * @date 2017/10/16 16:45.
 */
@Service
public class ClassMapBusinessImpl implements IClassMapBusiness {

    @Autowired
    ClassMapMapper classMapMapper;
    public long countByExample(ClassMapExample example) {
        return 0;
    }

    public int deleteByExample(ClassMapExample example) {
        return 0;
    }

    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(ClassMap record) {
        return 0;
    }

    public int insertSelective(ClassMap record) {
        return 0;
    }

    public List<ClassMap> selectByExample(ClassMapExample example) {
        return classMapMapper.selectByExample(example);
    }

    public ClassMap selectByPrimaryKey(Long id) {
        return classMapMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(@Param("record") ClassMap record, @Param("example") ClassMapExample example) {
        return 0;
    }

    public int updateByExample(@Param("record") ClassMap record, @Param("example") ClassMapExample example) {
        return 0;
    }

    public int updateByPrimaryKeySelective(ClassMap record) {
        return 0;
    }

    public int updateByPrimaryKey(ClassMap record) {
        return 0;
    }

    public ClassMap getClassMapByCode(String classMapCode) {
        ClassMapExample classMapExample = new ClassMapExample();
        ClassMapExample.Criteria criteria = classMapExample.createCriteria();
        criteria.andCodeEqualTo(classMapCode);
        return classMapMapper.selectByExample(classMapExample).get(0);
    }

    public ClassMap getSupClassMap(ClassMap subClassMap) {
        return classMapMapper.selectByPrimaryKey(subClassMap.getParentId());
    }

    public List<ClassMap> getSubClassMaps(ClassMap supClassMap) {
        ClassMapExample classMapExample = new ClassMapExample();
        ClassMapExample.Criteria criteria = classMapExample.createCriteria();
        criteria.andParentIdEqualTo(supClassMap.getId());
        return classMapMapper.selectByExample(classMapExample);
    }

    public ClassMap[] getCompleteClassMaps(ClassMap classMap) {
        int i = 0;
        ClassMap[] completeClassMaps = new ClassMap[5];
        completeClassMaps[i]=classMap;
        ClassMap tempClassMap=classMap;
        while (tempClassMap.getParentId()!=0l){
            Long parentId = classMap.getParentId();
            tempClassMap = classMapMapper.selectByPrimaryKey(parentId);
            i++;
            completeClassMaps[i]=tempClassMap;
        }
        return completeClassMaps;
    }

    public List<ClassMap> getSameLevelClassMap(ClassMap classMap) {
        ClassMapExample classMapExample = new ClassMapExample();
        ClassMapExample.Criteria criteria = classMapExample.createCriteria();
        criteria.andParentIdEqualTo(classMap.getParentId());
        return classMapMapper.selectByExample(classMapExample);
    }
}
