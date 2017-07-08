package me.songt.artsharing.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 2017/7/5.
 * Integer Splitter Utility
 */
public class IntegerSpliter
{
    public static List<Integer> StrListToIntList(String input) throws NumberFormatException
    {
        String[] strings = input.split("\\|");
        List<Integer> integerList = new ArrayList<>(strings.length);
        for (String string : strings)
        {
            integerList.add(Integer.parseInt(string));
        }
        return integerList;
    }

    public static String IntArrayToStr(List<Integer> integers)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < integers.size(); i++)
        {
            stringBuilder.append(integers.get(i));
            if (i != integers.size() - 1)
            {
                stringBuilder.append('|');
            }
        }
        return stringBuilder.toString();
    }
}
