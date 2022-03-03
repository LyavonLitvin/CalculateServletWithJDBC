package by.tms.valuelisthandler;

import java.util.List;

public interface ValueListIterator {
    int getSize();

    Object getCurrentElement();

    List getPreviousElements(int count);

    List getNextElements(int count);

    void resetIndex();

    void setList(List list);
}
