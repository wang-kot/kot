package cn.znufew.kot.action;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * (业务实现)
 *
 * @author wangzx
 * @date 2017/10/13 15:53.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@WebAppConfiguration
@ContextConfiguration({"classpath:spring/spring-mapper.xml", "classpath:spring/spring-service.xml", "classpath:spring/spring-action.xml"})
//这里可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class StudentActionTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void testRegister() throws Exception {
        mockMvc.perform((post("/student/login.do")
                .param("nickName", "123")
                .param("passw", "wr18r18")
//                .param("sex", "1")
//                .param("emailOrPhone", "13164618850")
        )).andExpect(status().isOk())
                .andDo(print());
    }
}
