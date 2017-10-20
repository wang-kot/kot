package cn.znufew.kot.mapper;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * (业务实现)
 *
 * @author wangzx
 * @date 2017/10/11 12:31.
 */

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-mapper.xml", "classpath:spring/spring-service.xml","classpath:spring/spring-action.xml"})
public class BaseTest {

}
