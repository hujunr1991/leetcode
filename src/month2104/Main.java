package month2104;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import javax.xml.soap.Node;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();

        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = in.nextInt();
        }
        Nodes[] nodes = new Nodes[25];
        for (int i = 0; i <= 24; i++) {
            Nodes node = new Nodes();
            node.setList(new ArrayList<String>());
            nodes[i] = node;
        }

        for (int i = 0; i <len; i++) {
            int num = ints[i];
            for (int j = 24-num; j >0; j--) {
                List<String> list1 = nodes[j].getList();
                List<String> list = nodes[j + num].getList();
                for (String s : list1) {
                    List<Integer> res = stringToList(s);
                    res.add(num);
                    Collections.sort(list);

                    String str = listToString(res);
                    if (!list.contains(str)) {
                        list.add(str);
                    }
                }

                nodes[j+num].setList(list);

                List<String> list2 = nodes[num].getList();

                list2.add(String.valueOf(num));
                nodes[num].setList(list2);

            }
            System.out.println(nodes[24].getList().size());
        }
    }

    private static String listToString(List<Integer> integers) {
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

    private static List<Integer> stringToList(String s) {
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
}


class Nodes {
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}

