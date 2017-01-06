package service;

import java.util.List;
import java.util.function.Function;

/**
 * Created by sugan on 1/6/17.
 */
public interface SortByField {
     <T>  void sort(List<T> list, final String sortField);
     <T,R> void sort(List<T> list, Function<T, R> getter);
}
