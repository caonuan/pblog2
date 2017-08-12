package pblog.othertest;

import javassist.bytecode.ByteArray;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * Created by caonuan on 2017/8/12.
 */
public class InputStreamTest {

    public static void main(String[] args) throws IOException {
        TestObject to = new TestObject(1,"caonuan");
        FileOutputStream fos = new FileOutputStream("/Users/caonuan/Documents/test");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(to);
        oos.close();

    }

    @Test
    public void read_object() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("/Users/caonuan/Documents/test");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TestObject stu3 = (TestObject) ois.readObject();
        System.out.println(stu3);
        TestObject stu4 = (TestObject) ois.readObject();
        System.out.println(stu3);
    }

    @Test
    public void test_file_input_stream(){
        File file = new File("/Users/caonuan/Documents/test.txt");
        try {
            FileInputStream fi = new FileInputStream(file);
            byte[] b=new byte[10];
            int read=0;
            while (read!=-1){
                read=fi.read();
                System.out.print((char)read+"\t");
            }
            //fi.read(b,1,4);

            //System.out.println(Arrays.toString(b));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
