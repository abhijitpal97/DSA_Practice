package com.example.gspractice;

import java.util.*;

public class OrderTableDisplay {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> ansMap = new TreeMap<>();
        Set<String> itemSet = new TreeSet<>();
        List<List<String>> ans = new ArrayList<>();
        for(List<String> order: orders) {
            Integer tableNo = Integer.parseInt(order.get(1));
            ansMap.putIfAbsent(tableNo, new HashMap<>());
            ansMap.get(tableNo).put(order.get(2), ansMap.get(tableNo).getOrDefault(order.get(2), 0) + 1);
            itemSet.add(order.get(2));
        }
        System.out.println(ansMap);

        for(Integer key: ansMap.keySet()) {
            List<String> row = new ArrayList<>();
            row.add(key.toString());
            for(String item: itemSet)
                row.add(ansMap.get(key).getOrDefault(item, 0).toString());
            ans.add(row);
        }
        System.out.println(ans);

        List<String> items = new ArrayList<>(itemSet);
        items.add(0, "Table");
        ans.add(0, items);

        return ans;
    }
}