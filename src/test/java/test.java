import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @description: TODO
 * @date : 2018/4/17
 */
public class test {

    public static void main(String[] args) {

    }
//
//    @Test
//    public Integer testString() {
//
//        return 1;
//
//    }

    @Test
    public void add() {
        Set<Integer> array = new LinkedHashSet<>();
        System.out.println(array.add(1));
        System.out.println(array.add(1));
    }

}
