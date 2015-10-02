public class Addon{
   
   public ListNode Add(ListNode l1, ListNode l2){
      return AddHelper(l1,l2,0);
      
   }
   
	public ListNode AddHelper(ListNode l1, ListNode l2, int addon){
      int val = addon;
      if(l1 == null && l2 == null){
      	// deal with situation such as last digits are 8, 9 
         if(val > 0){
            return new ListNode(val);
         }else{
         	return null;
         }
      }
      // add the val
      if(l1 != null){
      	val += l1.val;
      }
      if(l2 != null){
      	val += l2.val;
      }
      if(val > 10){
      	val = val - 10;
      	addon = 1;
      }else{
      	addon = 0;
      }
      ListNode temp = new ListNode(val);
      temp.next = AddHelper(l1 == null ? null:l1.next, l2 == null ? null: l2.next, addon);
      return temp;
   }
   
   public static void main(String[] args){
      ListNode t1 = new ListNode(2);
      t1.next = new ListNode(5);
      t1.next.next = new ListNode(4);
      ListNode t2 = new ListNode(5);
      t2.next = new ListNode(8);
      Addon s = new Addon();
      ListNode r = s.Add(t1,t2);
   }
}