package njzhan;

public class No002Add_Two_Sum {
	//
	public static class ListNode {
		  
		  ListNode next;
		  int val;
		  ListNode(int x) { 
			  val = x; 
			  }
		  }
	public static class Solution {
	    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	if(l1 ==null) return l2;
	    	if(l2 ==null) return l1;
	    	//
	    	//进位变量
	    	int AddUp = 0;
	    	//result 返回的初始节点
	    	//pNext是下一个结点
	    	//pNode 结尾结点
	    	ListNode result = null, pNext = null, pNode = null;
	        ListNode p = l1;
	        ListNode q = l2;
	    	while(p!= null && q != null){
	    		//新建一个next节点 计算相关数据
	    		pNext = new ListNode(p.val + q.val + AddUp);
	    		AddUp = pNext.val /10;
	    		pNext.val %=10;
	    		
	    		if(result ==null){
	    			result = pNode = pNext;
	    		}
	    		else{
	    			pNode.next = pNext;
	    			pNode = pNode.next;
	    		}
	    		p = p.next;
	    		q = q.next;	    			    		
	    	}
	    	
	    	
	    	
	    	
	    		//p != null || q != null
	    		if(p == null){
	    			p = q;
	    		}
	    		while(p != null)
	    		{
	    			pNext = new ListNode(p.val + AddUp);
		    		AddUp = pNext.val /10;
		    		pNext.val %=10;
		    		
		    		if(result ==null){
		    			result = pNode = pNext;
		    		}
		    		else{
		    			pNode.next = pNext;
		    			pNode = pNode.next;
		    		}
		    		p = p.next;
	    		}

	    		//AddUp !=0
		    	
	    		if(AddUp != 0)
	    		{
	    			pNext = new ListNode(AddUp);
	    			if(result ==null){
		    			result = pNode = pNext;
		    		}
		    		else{
		    			pNode.next = pNext;
		    			pNode = pNode.next;
		    		}
	    		}
	    	
	    	
	    	return result;
	        
	    }
	}
	
	public static void printListNode(ListNode list){
		while(list !=null){
			System.out.print(list.val + " ");
			list = list.next;
		}
	}
	public static void main(String[] args) {
		ListNode l1, l2, x1, x2;
		l1 = new ListNode(0);
		l2 = new ListNode(0);
		x1 = l1;
		x2 = l2;
		
		int[] a = {5,6,6};
		int[] b = {5,6,6};
		for(int i = 0; i < 2; i ++)
		{
			l1.val = a[i];
			l1.next = new ListNode(0);
			l1 = l1.next;
			
			l2.val = b[i];
			l2.next = new ListNode(0);
			l2 = l2.next;
		}
		l1.val = a[2];
		l2.val = b[2];
		
		printListNode(x1);
		System.out.println();
		printListNode(x2);
		System.out.println();
		
		
		printListNode(Solution.addTwoNumbers(x1, x2));
	}
}
