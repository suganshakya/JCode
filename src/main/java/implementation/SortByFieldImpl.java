package implementation;

import service.SortByField;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;

/**
 * Created by sugan on 1/6/17.
 */
public class SortByFieldImpl implements SortByField {
    public <T> void sort(List<T> list, final String sortField){
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                Method method;
                try {
                    String getter = "get" + sortField.substring(0, 1).toUpperCase() + sortField.substring(1);
                    method =  o1.getClass().getMethod(getter);

                    Object result1 = method.invoke(o1);
                    Object result2 = method.invoke(o2);
                    return compareItem(result1, result2);
                } catch (IllegalAccessException | InvocationTargetException |
                        NoSuchMethodException e) {
                    throw new RuntimeException("Unsupported Sort Type.");
                }
            }
        });
    }

    public <T,R> void sort(List<T> list, Function<T, R> getter){
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                R result1 = getter.apply(o1);
                R result2 = getter.apply(o2);
                return compareItem(result1, result2);
            }
        });
    }

    private int compareItem(Object obj1, Object obj2){
        if(obj1 == null){
            return obj2 == null? 0: 1;
        }
        if(obj2 == null){
            return -1;
        }
        // descending order for number
        if(obj1 instanceof Integer){
            return ((Integer) obj2).compareTo((Integer) obj1);
        }
        if(obj1 instanceof Long){
            return ((Long) obj2).compareTo((Long) obj1);
        }
        if(obj1 instanceof Float){
            return ((Float) obj2).compareTo((Float) obj1);
        }
        if(obj1 instanceof Double){
            return ((Double) obj2).compareTo((Double) obj1);
        }
        // alphabetic order for string
        if (obj1 instanceof String){
            return ((String) obj1).compareTo((String) obj2);
        }

        if(obj1 instanceof Calendar){
            Long l1 = ((Calendar) obj1).getTime().getTime();
            Long l2 = ((Calendar) obj2).getTime().getTime();
            return l2.compareTo(l1);
        }
        throw new RuntimeException("Unsupported Data Type.");
    }

}
