package com.taurus.newyorktimes.util;

import java.util.ArrayList;
import java.util.List;

public final class ListConverter {

    public interface Converter<U, T> {
        T convert(U item);
    }

    private ListConverter() {
    }

    public static <U, T> List<T> convert(List<U> list, Converter<U, T> converter) {

        final List<T> newList = new ArrayList<>();

        for (U item : list) {
            newList.add(converter.convert(item));
        }

        return newList;

    }
}