import com.team.hospital.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/9 12:00
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package PACKAGE_NAME
 * @Classname TestController
 * @Created by Administrator
 * @Description:NULL
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public Result<String []> test(){
        //1.定义数组
        String [] names={"张三","李四","麻子哥"};
        //返回数据
        return new Result<>("200","查询学姓名",names);
    }


}
