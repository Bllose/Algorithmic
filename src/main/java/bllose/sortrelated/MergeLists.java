package bllose.sortrelated;

public class MergeLists {

    static class ListNode{
        int value;
        ListNode next;
        ListNode(){}
        ListNode(int x){value = x;}
    }

    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length<1){
            return null;
        }

        for(int i = 1 ; i < lists.length; i *= 2){            // 两待合并队列相隔距离
            for(int j = 0; j < (lists.length - 1); j += i*2){ // 循环处理当前合并的俩队列
                lists[j] = mergeList(lists[j], lists[i+j]);
            }
        }

        return lists[0];
    }

    private ListNode mergeList(ListNode list, ListNode listAdd) {
        ListNode p = new ListNode();
        ListNode h = p;
        while(list != null && listAdd != null){
            if(list.value >= listAdd.value){
                p.next = listAdd;
                listAdd = listAdd.next;
            }else{
                p.next = list;
                list = list.next;
            }
            p = p.next;
        }

        if(list == null && listAdd != null){
            p.next = listAdd;
        }else if(list != null && listAdd == null){
            p.next = list;
        }

        return h.next;
    }
}
