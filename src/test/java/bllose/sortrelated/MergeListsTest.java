package bllose.sortrelated;

import org.junit.Assert;
import org.junit.Test;
import bllose.sortrelated.MergeLists.ListNode;

public class MergeListsTest {

    @Test
    public void test(){
        ListNode ln_1 = establishListNode(new int[]{1,4,5});
        ListNode ln_2 = establishListNode(new int[]{1,3,4});
        ListNode ln_3 = establishListNode(new int[]{2,6});

        ListNode[] listNodes = new ListNode[]{ln_1, ln_2, ln_3};

        MergeLists ml = new MergeLists();
        ListNode result = ml.mergeKLists(listNodes);
        StringBuffer sb = new StringBuffer();
        while(result != null){
            sb.append(result.value);
            result = result.next;
        }

        Assert.assertEquals("11234456", sb.toString());
    }

    private ListNode establishListNode(int[] args){
        ListNode p = new ListNode();
        ListNode h = p;

        for(int i = 0 ; i < args.length; i ++){
            ListNode curNode = new ListNode(args[i]);
            p.next = curNode;
            p = p.next;
        }

        return h.next;
    }
}
