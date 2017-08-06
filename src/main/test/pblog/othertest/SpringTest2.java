package pblog.othertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by caonuan on 2017/8/7.
 */
@Component
public class SpringTest2 {
    @Autowired
    private SpringTest springTest;

    public void test(){
        System.out.println(1);
        System.out.println(springTest.getA());
    }

    public SpringTest getSpringTest() {
        return springTest;
    }

    public void setSpringTest(SpringTest springTest) {
        System.out.println("springTest set");
        this.springTest = springTest;
    }
}
