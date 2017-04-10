import implementation.SortByFieldImpl;
import model.Student;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.SortByField;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by sugan on 1/6/17.
 */
public class SortByFieldTest {

    @Test
    public void test1(){
        List<Student> list = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.set(2015, 02, 10);
        list.add(new Student("Davis", "Math", 35.0, cal));
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2016, 02, 10);
        list.add(new Student(null, "Science", null, cal2));
        Calendar cal3 = Calendar.getInstance();
        cal3.set(2015, 03, 17);
        list.add(new Student("Aana", "Math", 37.0,cal3));
        Calendar cal4 = Calendar.getInstance();
        cal4.set(2014, 07, 22);
        list.add(new Student(null, "English", 85.0, cal4));
        Calendar cal5 = Calendar.getInstance();
        cal5.set(2016, 05, 12);
        list.add(new Student("Sascha", null, 85.0, cal5));
        Calendar cal6 = Calendar.getInstance();
        cal6.set(2014, 02, 15);
        list.add(new Student("Robert", "Literature", null, cal6));

        SortByField sortByField = new SortByFieldImpl();
        sortByField.sort(list, "name");
        Assert.assertEquals(list.get(0).getName(), "Aana");
        Assert.assertNull(list.get(list.size() -1).getName());

        sortByField.sort(list, "subject");
        Assert.assertEquals(list.get(0).getSubject(), "English");
        Assert.assertEquals(list.get(list.size() -1).getName() ,"Sascha");  // student with no subject

        sortByField.sort(list, "mark");
        Assert.assertEquals(list.get(0).getMark(), 85.0);
        Assert.assertEquals(list.get(2).getMark(), 37.0);

        sortByField.sort(list, "enrollDate");
        Assert.assertEquals(list.get(0).getEnrollDate(), cal5);
        Assert.assertEquals(list.get(list.size() -1).getEnrollDate(), cal6);

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
        Assert.assertEquals(list.get(0).getName(), "Aana");
        Assert.assertNull(list.get(list.size() -1).getName());

        sortByField.sort(list, (a) -> a.getSubject());
        Assert.assertEquals(list.get(0).getSubject(), "English");
        Assert.assertEquals(list.get(list.size() -1).getName() ,"Sascha");  // student with no subject

        sortByField.sort(list, (a) -> a.getMark());
        Assert.assertEquals(list.get(0).getMark(), 85.0);
        Assert.assertEquals(list.get(2).getMark(), 37.0);


    }
}
