package pblog.othertest;

import java.io.Serializable;

/**
 * Created by caonuan on 2017/8/12.
 */
public class TestObject implements Serializable {
    private int id;
    private String name;

    public TestObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id+name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
