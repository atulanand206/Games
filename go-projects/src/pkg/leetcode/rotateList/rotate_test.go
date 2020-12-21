package rotateList

import (
	"testing"
	"fmt"
	"lib"
)

func TestRotateRight(t *testing.T) {
	last := ListNode{5, nil}
	fth := ListNode{4, &last}
	trd := ListNode{3, &fth}
	snd := ListNode{2, &trd}
	fst := ListNode{1, &snd}

	olast := ListNode{3, nil}
	ofth := ListNode{2, &olast}
	otrd := ListNode{1, &ofth}
	osnd := ListNode{5, &otrd}
	ofst := ListNode{4, &osnd}

	got := rotateRight(&fst, 2)
	lib.AssertEqual(t, getListString(*got), getListString(ofst))
}

func TestRotateRight2(t *testing.T) {
	trd := ListNode{2, nil}
	snd := ListNode{1, &trd}
	fst := ListNode{0, &snd}

	otrd := ListNode{1, nil}
	osnd := ListNode{0, &otrd}
	ofst := ListNode{2, &osnd}

	got := rotateRight(&fst, 4)
	lib.AssertEqual(t, getListString(*got), getListString(ofst))
}

func TestRotateRight3(t *testing.T) {
	snd := ListNode{2, nil}
	fst := ListNode{1, &snd}

	osnd := ListNode{1, nil}
	ofst := ListNode{2, &osnd}

	got := rotateRight(&fst, 1)
	lib.AssertEqual(t, getListString(*got), getListString(ofst))
}

func getListString(node ListNode) string {
	res := ""
	res = res + fmt.Sprint(node.Val) + ","
	for i := 0; i < 10; i++ {
		if node.Next != nil {
			node = *node.Next
		}
		res = res + fmt.Sprint(node.Val) + ","
		if node.Next == nil {
			break
		}
	}
	return res
}
