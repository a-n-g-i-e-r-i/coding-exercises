package com.angieri.w001;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

The given file, merge-sort-integer-array.txt
*/

public class MergeSort {

    private Long count;

    public MergeSort(Long var1) {
        this.count = var1;
    }

    public static void main(String[] var0) throws FileNotFoundException {
        MergeSort var1 = new MergeSort(Long.valueOf(0L));
        var1.run();
    }

    public void run() throws FileNotFoundException {
        List var1 = this.rowsToArrayList();
        ArrayList var2 = new ArrayList();
        var2.add(Integer.valueOf(2));
        var2.add(Integer.valueOf(4));
        var2.add(Integer.valueOf(1));
        var2.add(Integer.valueOf(3));
        var2.add(Integer.valueOf(5));
        this.count = Long.valueOf(0L);
        this.print(this.mergeAndSort(var1));
    }

    public List mergeAndSort(List<Integer> var1) {
        if(var1.size() < 2) {
            return var1;
        } else {
            Integer var4 = Integer.valueOf((var1.size() - var1.size() % 2) / 2);
            List var2 = var1.subList(0, var4.intValue());
            List var3 = var1.subList(var4.intValue(), var1.size());
            var2 = this.mergeAndSort(var2);
            var3 = this.mergeAndSort(var3);
            return this.merge(var2, var3);
        }
    }

    public List merge(List<Integer> var1, List<Integer> var2) {
        ArrayList var3 = new ArrayList();
        Long var4 = Long.valueOf(0L);
        Long var5 = Long.valueOf(0L);
        Integer var6 = Integer.valueOf(var2.size());
        Integer var7 = Integer.valueOf(var1.size());

        while(var5.longValue() < (long)var6.intValue() && var4.longValue() < (long)var7.intValue()) {
            if(((Integer)var1.get(Math.toIntExact(var4.longValue()))).intValue() < ((Integer)var2.get(Math.toIntExact(var5.longValue()))).intValue()) {
                var3.add(var1.get(Math.toIntExact(var4.longValue())));
                var4 = Long.valueOf(var4.longValue() + 1L);
            } else {
                var3.add(var2.get(Math.toIntExact(var5.longValue())));
                var5 = Long.valueOf(var5.longValue() + 1L);
                System.out.println(this.count);
                this.count = Long.valueOf(this.count.longValue() + ((long)var7.intValue() - var4.longValue()));
            }
        }

        List var8 = var1.subList(Math.toIntExact(var4.longValue()), var7.intValue());
        List var9 = var2.subList(Math.toIntExact(var5.longValue()), var6.intValue());
        var3.addAll(var8);
        var3.addAll(var9);
        return var3;
    }

    public void print(List var1) {
        System.out.printf("The number of inversions are equal to : %d", new Object[]{this.count});
    }

    List<Integer> rowsToArrayList() throws FileNotFoundException {
        Scanner var1 = new Scanner(new File("merge-sort-integer-array.txt"));
        ArrayList var2 = new ArrayList();

        while(var1.hasNextInt()) {
            var2.add(Integer.valueOf(var1.nextInt()));
        }

        return var2;
    }
}
