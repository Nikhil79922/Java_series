
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;

public class CollectionsFramework {

    public static void main(String[] args) {
        Collection<Integer> c = new HashSet<>();
        c.add(10);
        c.add(20);
        c.add(100);
        c.add(30);
        c.add(3);
        c.add(40);
        c.add(50);
        c.add(60);

        // System.out.println(c.get(200));
        // Iterable interface -- Iterator
        Iterator<Integer> it = c.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Integer[] nums = c.toArray(new Integer[0]);
        System.out.println(c);

        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(100);
        arr.add(30);
        arr.add(40);
        arr.add(5);
        arr.add(60);
        arr.sort((a, b) -> a.compareTo(b));
        arr.sort((a, b) -> b - a);
        //Or
        Sorts s = new Sorts();
        arr.sort(s);

        System.out.println(arr);

        ListIterator<Integer> listIt = arr.listIterator(4);
        // while (listIt.hasPrevious()) {
        //     System.out.println(listIt.previous());
        // }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);

        for (Map.Entry<Integer, Integer> entries : map.entrySet()) {
            System.out.println(entries.getKey() + "  ::-> " + entries.getValue());
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1); // thow eception if insertion fails
        queue.offer(4); // not exception , safer

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.pop();
        stack.peek();

    }
}

class Sorts implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }

}
