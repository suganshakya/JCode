import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sugan on 1/6/17.
 */
public class SortByField {
    public SortByField() {
    }

    public static <T> void sort(List<T> list, final String sortField){
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                Method method;
                try {
                    String getter = "get" + sortField.substring(0, 1).toUpperCase() + sortField.substring(1);
                    method =  o1.getClass().getMethod(getter);

                    Object result1 = method.invoke(o1);
                    Object result2 = method.invoke(o2);
                    if(result1 == null){
                        return result2 == null? 0: 1;
                    }
                    if(result2 == null){
                        return -1;
                    }
                    // descending order for number
                    if(result1 instanceof Integer){
                        return ((Integer) result2).compareTo((Integer) result1);
                    }
                    if(result1 instanceof Long){
                        return ((Long) result2).compareTo((Long) result1);
                    }
                    if(result1 instanceof Float){
                        return ((Float) result2).compareTo((Float) result1);
                    }
                    if(result1 instanceof Double){
                        return ((Double) result2).compareTo((Double) result1);
                    }
                    // alphabetic order for string
                    if (result1 instanceof String){
                        return ((String) result1).compareTo((String) result2);
                    }
                    throw new RuntimeException("Unsupported Data Type.");
                } catch (IllegalAccessException | InvocationTargetException |
                        NoSuchMethodException e) {
                    throw new RuntimeException("Unsupported Sort Type.");
                }
            }
        });
    }
}
