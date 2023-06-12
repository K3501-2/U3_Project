import com.team.hospital.util.OSSUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/12 10:47
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package PACKAGE_NAME
 * @Classname Demo1
 * @Created by Administrator
 * @Description:NULL
 */
public class Demo1 {
    public static void main(String[] args) throws FileNotFoundException {
        //利用oss工具类实现上传
        String path = OSSUtils.upload_File("QQ空间.jpg", new FileInputStream("D:\\QQ空间.jpg"));
        System.out.println("文件位置:" + path);
    }
}
