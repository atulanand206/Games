package rotateList

type ListNode struct {
	Val  int
	Next *ListNode
}

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil {
		return head
	}
	size := 1
	ptr := head
	for ptr.Next != nil {
		size++
		ptr = ptr.Next
	}
	exit := ptr
	k = k % size
	if k == 0 {
		return head
	}
	exit.Next = head
	last := head
	for i := 1; i < size-k; i++ {
		last = last.Next
	}
	node := last.Next
	last.Next = nil
	return node
}
