package pblog.util;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by caonuan on 2017/8/7.
 */
@Controller
@Scope("singleton")
public class PropertiesReader {
    public final String ACTIONPATH = "/information.properties";
    public final String manager_un;
    public final String manager_pw;
    public final String basic_url;
    public final boolean open_aliyun_oss;
    public final String aliyun_oss_path;
    public final String aliyun_image_process;

    PropertiesReader() {
        Properties prop = new Properties();
        InputStream stream =this.getClass().getClassLoader().getResourceAsStream(ACTIONPATH);
        try {
            prop.load(new InputStreamReader(stream,"UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        manager_un = prop.getProperty("username");
        manager_pw = prop.getProperty("password");
        open_aliyun_oss = prop.getProperty("open_aliyun_oss").equals("true") ? true : false;
        aliyun_oss_path = prop.getProperty("aliyun_oss_path");
        aliyun_image_process = prop.getProperty("aliyun_image_process");
        basic_url = prop.getProperty("basic_url");
    }
}
