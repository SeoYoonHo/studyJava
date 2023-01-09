package Backjoon.WinterSchool.HashTree.BOJ19584;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<Integer> pointList = new ArrayList<>();
            int N = sc.nextInt();
            int M = sc.nextInt();

            for (int i = 0; i < N; i++) {
                sc.next();
                int y = sc.nextInt();
                pointList.add(y);
            }

            List<Street> streetList = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                int p1 = sc.nextInt();
                int p2 = sc.nextInt();
                int amount = sc.nextInt();

                Street temp = new Street();
                int temp1 = pointList.get(p1 - 1);
                int temp2 = pointList.get(p2 - 1);
                temp.pointList.add(Math.min(temp1, temp2));
                temp.pointList.add(Math.max(temp1, temp2));
                temp.amountList.add(amount);

                streetList.add(temp);
            }

            System.out.println(streetList);
            streetList = streetList.stream()
                                   .sorted(Comparator.comparing(o -> o.pointList.get(0)))
                                   .collect(Collectors.toList());
            System.out.println(streetList);

            sumStreet(streetList.get(0), streetList.get(1));
            System.out.println(streetList);
        }
    }

    public static void sumStreet(Street street1, Street street2) {
        for (int i = 0; i < street1.pointList.size(); i++) {
            int tempLast = street2.pointList.get(street2.pointList.size() - 1);
            street2.pointList.remove(street2.pointList.size() - 1);

            if (street2.pointList.get(0) < street1.pointList.get(i)) {
                street2.pointList.add(street1.pointList.get(i));
            }

            street2.pointList.add(tempLast);
        }
    }

    static class Street {
        List<Integer> pointList = new ArrayList<>();
        List<Integer> amountList = new ArrayList<>();

        @Override
        public String toString() {
            return "Street{" +
                    "pointList=" + pointList +
                    ", amountList=" + amountList +
                    '}';
        }
    }
}
