
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def returnVal(self, carry: int, val: int) -> int:
        if val>=10:
            val = val + carry - 10
            carry = 1
        else:
            carry = 0
        return carry, val

    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0
        track = []
        # First Node
        val = l1.val + l2.val + carry
        carry, val = self.returnVal(carry, val)
        
        l3 = ListNode(val, None)
        head = l3
        while l1.next!=None or l2.next!= None or carry!= 0:
            if l1.next != None:
                l1 = l1.next
            else:
                l1.val = 0
            if l2.next!=None:
                l2 = l2.next
            else:
                l2.val = 0
            val = l1.val + l2.val + carry
            carry = 0
            carry, val = self.returnVal(carry, val)
            l3.next = ListNode(val, None)
            l3 = l3.next
            
        return head


