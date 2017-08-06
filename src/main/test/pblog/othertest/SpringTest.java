package pblog.othertest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by caonuan on 2017/8/7.
 */
@Controller
@Scope("singleton")
public class SpringTest {
    String a="a";

    {
        System.out.println("SpringTest new");
    }

    public String getA() {
        System.out.println("get a");
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

}
