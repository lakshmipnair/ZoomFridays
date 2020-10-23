package com.apartmentlist.al.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZoomService
{
    public static List<List<String>> getZoomGroups(List<String> employees) {
        if(employees.isEmpty())
            throw new RuntimeException("Sorry we perform grouping with zero employees.");
        else if(employees.size() < 3)
            throw new RuntimeException("Sorry we need atleast 3 employees to form a group.");

        Collections.shuffle(employees);
        List<List<String>> lunchGroup = new ArrayList<>();

        int size = employees.size();
        int firstIndex = 0;
        int secondIndex = 0;

        while(size >= 3) {
            List<String> group = new ArrayList<>(employees.subList(firstIndex, firstIndex + 3));
            lunchGroup.add(group);

            size = size-3;
            firstIndex = firstIndex+3;
        }

        if(size == 2) {
            lunchGroup.get(secondIndex).addAll(employees.subList(firstIndex, firstIndex + 1));
            firstIndex = firstIndex + 2;
            secondIndex = secondIndex + 2;
        }

        if(size == 1) {
            lunchGroup.get(secondIndex).add(employees.get(firstIndex));
        }

        return lunchGroup;
    }

}
