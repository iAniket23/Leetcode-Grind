'''
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
'''

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


