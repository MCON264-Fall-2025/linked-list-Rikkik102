package linkedlist;

import org.apache.commons.lang3.NotImplementedException;
import support.CycleInfo;
import support.LLNode;

public class LinkedListCycleAnalyzer<T> {


    public static <T> CycleInfo detectCycleInfo(LLNode<T> head){
       int index = 0;
       LLNode<T> pointer1 = head;
       LLNode<T> pointer2 = head;
       pointer1 = pointer1.getLink();
        if (pointer1 == null) {
            return new CycleInfo(-1, 0);
        }
       while (!(pointer1.equals(pointer2))) {
           LLNode<T> jump = pointer2.getLink();
           pointer2= jump.getLink();
           if (pointer1.equals(pointer2)) {
               break;
           }
           pointer1 = pointer1.getLink();
           if (pointer1 == null) {
               return new CycleInfo(-1, 0);
           }
           index++;
       }
       if (pointer1.equals(head)) {
           index = 0;
       }
        int cycleLength = 1;
            pointer1 = pointer1.getLink();
            while (!(pointer1.equals(pointer2))) {
                pointer1 = pointer1.getLink();
                cycleLength++;
            }
        return new CycleInfo(index, cycleLength);
    }
}
