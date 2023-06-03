package udemyDSA.greedyAlgorithms;

import java.util.*;

class knapSack {
    static void knapSacks(ArrayList<fractionalKnapSack> items, int capacity) {
        Comparator<fractionalKnapSack> comparator = new Comparator<fractionalKnapSack>() {
            @Override
            public int compare(fractionalKnapSack o1, fractionalKnapSack o2) {
                if (o2.getRatio() > o1.getRatio())
                    return 1;
                else
                    return -1;
            }
        };

        Collections.sort(items, comparator);
        int usedCapacity = 0;
        double totalValue = 0;

        for (fractionalKnapSack item : items) {
            if (usedCapacity + item.getWeight() <= capacity) {
                usedCapacity += item.getWeight();
                System.out.println("Taken : " + item);
                totalValue += item.getValue();
            } else {
                int usedWeight = capacity - usedCapacity;
                double value = item.getRatio() * usedWeight;
                System.out.println(
                        "Taken : item index = " + item.getIndex() + ", obtained value = " + value + ",used weight ="
                                + usedWeight + ", ratio = " + item.getRatio());
                usedCapacity += usedWeight;
                totalValue += value;
            }
            if (usedCapacity == capacity) {
                break;
            }

            System.out.println("Total value obtained " + totalValue);
        }
    }
}
