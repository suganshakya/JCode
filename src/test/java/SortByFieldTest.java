import implementation.SortByFieldImpl;
import model.Student;
import org.testng.annotations.Test;
import service.SortByField;

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

        SortByField sortByField = new SortByFieldImpl();
        sortByField.sort(list, "name");
        System.out.println(list);

        sortByField.sort(list, "subject");
        System.out.println(list);

        sortByField.sort(list, "mark");
        System.out.println(list);

        sortByField.sort(list, (a) -> a.getName());
        System.out.println(list);
    }

    @Test
    public void test2(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("Davis", "Math", 35.0));
        list.add(new Student(null, "Science", null));
        list.add(new Student("Aana", "Math", 37.0));
        list.add(new Student("Robin", "English", 65.0));
        list.add(new Student("Sascha", null, 85.0));
        list.add(new Student(null, "Literature", null));

        SortByField sortByField = new SortByFieldImpl();

        sortByField.sort(list, (a) -> a.getName());
        System.out.println(list);

        sortByField.sort(list, (a) -> a.getSubject());
        System.out.println(list);

        sortByField.sort(list, (a) -> a.getMark());
        System.out.println(list);

    }
}
