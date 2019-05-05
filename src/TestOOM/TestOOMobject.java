package TestOOM;

import java.util.ArrayList;
import java.util.List;

/**
 * java堆溢出
 *
 */

public class TestOOMobject {
    static class OOMobject{

    }
    public static void main(String[] args) {
        List<OOMobject> list =  new ArrayList<>();
        while (true){
            list.add(new OOMobject());
        }
    }
}
