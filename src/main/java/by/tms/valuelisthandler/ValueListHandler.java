//package by.tms.valuelisthandler;
//
//import by.tms.dao.jdbc.InMySQLResultDAO;
//import by.tms.entity.Result;
//
//import java.util.*;
//
//public class ValueListHandler<T> implements ValueListIterator {
//
//
//    private InMySQLResultDAO inMySQLResultDAO;
//    protected List<T> list;
//    protected ListIterator<T> listIterator;
//    private int index;
//
//    public ValueListHandler(InMySQLResultDAO inMySQLResultDAO) {
//        this.inMySQLResultDAO = inMySQLResultDAO;
//        list = inMySQLResultDAO != null & inMySQLResultDAO.findAll() :null;
//
//    }
//
//
//    @Override
//    public int getSize() {
//        int size = 0;
//
//        if (list != null)
//            size = list.size();
//        return size;
//    }
//
//    @Override
//    public Object getCurrentElement() {
//        Object obj = null;
//        if (list != null) {
//            int currentIndex = listIterator.nextIndex();
//            obj = list.get(currentIndex);
//        }
//        return obj;
//    }
//
////    @Override
////    public List getPreviousElements(int count) {
////        int i = 0;
////        List<Result> previousElements = new ArrayList<>();
////        if (listIterator != null && list != null) {
////            while (listIterator.hasPrevious() && (i < count)) {
////                previousElements.add(listIterator.previous());
////                i++;
////            }
////        }
////        return previousElements;
////    }
//
////    @Override
////    public List getNextElements(int count) {
////        int i = 0;
////Object object = null;
////        List<Result> list = new LinkedList();
////        if (listIterator != null) {
////            while (listIterator.hasNext() && (i < count)) {
////                object = ;
////                list.add(listIterator.next());
////                i++;
////            }
////        }
////        return list;
////    }
//
//    @Override
//    public void resetIndex() {
//        if (listIterator != null) {
//            listIterator = list.listIterator();
//        }
//    }
//
//    @Override
//    public void setList(List list) {
//        this.list = list;
//        if (list != null)
//            listIterator = list.listIterator();
//    }
//
//    public Collection getList() {
//        return list;
//    }
//}
