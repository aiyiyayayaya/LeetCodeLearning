package onsite.abb;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aiya on 2019/8/29 上午9:50
 */
public class ListIterator implements Iterator<Integer>{
    private Iterator<List<Integer>> list;

    private Iterator<Integer> col;

    public ListIterator(List<List<Integer>> list) {
        this.list = list.iterator();
        col = Collections.emptyIterator();
    }

    @Override
    public boolean hasNext() {
        while (list.hasNext() && (col == null || !col.hasNext()))
            col = list.next().iterator();
        return col != null && col.hasNext();
    }

    @Override
    public Integer next() {
        return col.next();
    }

    @Override
    public void remove() {
        while (col == null && list.hasNext())
            col = list.next().iterator();
        if (col != null)
            col.remove();
    }
}
