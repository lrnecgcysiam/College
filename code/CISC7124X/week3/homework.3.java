// https://www.chegg.com/homework-help/questions-and-answers/consider-following-implementation-singly-linked-lists-list-consists-nodes-node-stores-valu-q29570864?trackid=191d1fbd2cc6&strackid=d4d263564e0b


public ListNode<E> take(ListNode<E> lst,int n){

    int count = 0;
    
    ListNode<E> temp = lst;
    
    while(lst!=null && count < n) {
    
    lst = lst.next;
    
    count++;
    
    }
    
    lst.next = null;
    
    return temp;
    
    }