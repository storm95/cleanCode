package com.ankit.tekion.interview1;

//There is a row of barcodes in a warehouse.
//        where ith barcode is arr[i].
//
//        Rearrange the barcodes so that no 2 adjacent barcodes are equal.
//        arr[] = [1,1,1,2,2,2]
//
//        output[] = [1,2,1,2,1,2]

/*
1 -> 1
2 -> 1
3 >  1
4 >  1

[ 1, 2, 3, 4]
p1 = 5
p2 = 6
 */


import java.util.*;

public class Client {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(3);

        List<Integer> ans = rearrange(arr);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    private static List<Integer> rearrange(List<Integer> arr) {
        int p1 = 0;
        int p2 = 1;
        List<Integer> rearrangedArr = new ArrayList<>(Collections.nCopies(arr.size(), 0));

        Map<Integer, Integer> countArr = new HashMap<>();
        for (int i=0;i<rearrangedArr.size();++i) {
//            Integer cnt = 0;
//            if(countArr.containsValue(arr.get(i))) {
//                cnt = countArr.get(arr.get(i));
//            }
            countArr.put(arr.get(i), countArr.getOrDefault(arr.get(i), 0)+1);
        }

        List<Barcode> barcodes = new ArrayList<Barcode>();
        for (Map.Entry<Integer,Integer> entry : countArr.entrySet()) {
            barcodes.add(new Barcode(entry.getKey(), entry.getValue()));
        }

        barcodes.sort(
                (Barcode a, Barcode b) -> (b.value - a.value) //have to check the order
        );

        for(int i=0;i<barcodes.size();++i) {
            Integer id = barcodes.get(i).id;
            Integer value = barcodes.get(i).value;
            int ptr = Math.min(p1, p2);
            for(int j=0;j<value;++j) {
                rearrangedArr.set(ptr, id);
                ptr = ptr +2;
            }

            if(p1<=p2)
                p1 = ptr;
            else
                p2 = ptr;
        }

        return rearrangedArr;
    }
}
