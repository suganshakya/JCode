import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sugan on 1/6/17.
 */
public class SortByFieldTest {

    @Test
    public void test1(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("Davis", "Math", 35.0));
        list.add(new Student(null, "Science", null));
        list.add(new Student("Aana", "Math", 37.0));
        list.add(new Student(null, "English", 85.0));
        list.add(new Student("Sascha", null, 85.0));
        list.add(new Student("Robert", "Literature", null));

        SortByField.sort(list, "name");
        System.out.println(list);

        SortByField.sort(list, "subject");
        System.out.println(list);

        SortByField.sort(list, "mark");
        System.out.println(list);
    }
}
