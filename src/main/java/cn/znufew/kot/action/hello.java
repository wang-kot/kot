package cn.znufew.kot.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * (业务实现)
 *
 * @author wangzx
 * @date 2017/10/10 14:10.
 */
@Controller
public class hello {
    @RequestMapping("/hello.do")
    @ResponseBody
    public String sayHello(){
        return "this is hello page";
    }
}
