package by.tms.valuelisthandler;

import java.util.List;

public interface ValueList {
    public int getSize();
    public Object getCurrentElement();
    public List getPreviousElements(int count);
    public List getNextElements(int count);
    public void resetIndex();
    public void setList(List list);
}
