package month2104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sum24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) { //输入n个数，保存起来
            ints[i] = in.nextInt();
        }
        Node[] nodes = new Node[25];
        for (int i = 0; i <= 24; i++) {//申请24个ArrayList
            Node node = new Node();
            node.setList(new ArrayList<String>());
            nodes[i] = node;
        }
        for (int i = 0; i < len; i++) { //从第一个数开始，以此一个个维护
            int num = ints[i];
            for (int j = 24 - num; j > 0; j--) { //从后往前维护，避免重复进入，即将和为j的子集合中，加入和为[j-ints[i]]的个数，并且一个个加的时候，需要去重
                List<String> fromList = nodes[j].getList();
                List<String> toList = nodes[j + num].getList();
                for (String s : fromList) {
                    List<Integer> list = StringToList(s);
                    list.add(num);
                    Collections.sort(list);
                    String string = ListToString(list);
                    if(!toList.contains(string)) {
                        toList.add(string);
                    }
                }
                nodes[j + num].setList(toList);
            }
            List<String> list = nodes[num].getList();
            Integer integer = num;
            list.add(integer.toString()); //此步骤其实需要判断num是否在和为num的子集合中，但是不判断也可以，因为其实判断了后，在进入和为24的集合中的时候，会被过滤掉
            nodes[num].setList(list);
        }
        System.out.println(nodes[24].getList().size());
    }

    private static List<Integer> StringToList(String s) {
        List<Integer> strings = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return strings;
        }
        String[] split = s.split(",");
        for (String str : split) {
            strings.add(new Integer(str));
        }
        return strings;
    }

    private static String ListToString(List<Integer> integers) {
        if (integers.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(integers.get(0));
        for (int i = 1; i < integers.size(); i++) {
            stringBuilder.append(",").append(integers.get(i));
        }
        return stringBuilder.toString();
    }

    static void findNumbers(int[] list, int index, int current, int goal, String result)
    {
        if (list.length < index || current>goal)
            return;
        for (int i = index; i < list.length; i++) {
            if (current + list[i] == goal)   {
                System.out.println(result + " " + String.valueOf(list[i]));
            }
            else if (current + list[i] < goal) {
                findNumbers(list, i + 1, current + list[i], goal, result + " " + String.valueOf(list[i]));
            }
        }
    }

}


class Node {
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
