package by.tms.valuelisthandler;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ValueListHandler implements ValueList {

    public ValueListHandler() {
    }

    protected List list;
    protected ListIterator listIterator;

    @Override
    public int getSize() {
        int size = 0;

        if (list != null)
            size = list.size();
        return size;
    }

    @Override
    public Object getCurrentElement() {
        Object obj = null;
        if (list != null) {
            int currentIndex = listIterator.nextIndex();
            obj = list.get(currentIndex);
        }
        return obj;
    }

    @Override
    public List getPreviousElements(int count) {
        int i = 0;
        Object object = null;
        LinkedList list = new LinkedList();
        if (listIterator != null) {
            while (listIterator.hasPrevious() && (i < count)) {
                object = listIterator.previous();
                list.add(object);
                i++;
            }
        }
        return list;
    }

    @Override
    public List getNextElements(int count) {
        int i = 0;
        Object object = null;
        LinkedList list = new LinkedList();
        if (listIterator != null) {
            while (listIterator.hasNext() && (i < count)) {
                object = listIterator.next();
                list.add(object);
                i++;
            }
        }
        return list;
    }

    @Override
    public void resetIndex() {
if (listIterator != null) {
    listIterator = list.listIterator();
}
    }

    @Override
    public void setList(List list) {
        this.list = list;
        if (list != null)
            listIterator = list.listIterator();
    }

    public Collection getList() {
        return list;
    }
}
