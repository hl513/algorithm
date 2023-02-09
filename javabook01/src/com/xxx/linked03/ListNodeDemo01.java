package com.xxx.linked03;

/**
 * @author HeP
 * @date 2023/2/7 10:42
 */
@SuppressWarnings("all")
public class ListNodeDemo01 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        // 添加节点
        for (int i = 0; i < 10; i++) {
            insertInLinkedList(head, new ListNode(i), i + 1);
        }
        printList(head);
        System.out.println();
        System.out.println("-------------------");
        // 删除指定节点
        deleteNodeFromLinkedList(head, 6);
        printList(head);
        System.out.println();
        System.out.println("-------------------");
        // 删除整个链表
//        deleteLinkedList(head);
        System.out.println(listLength(head));
        System.out.println("-------------------");

        // 如果插入的时候超出范围 会给出相应的提示
        insertInLinkedList(head, new ListNode(15), 10);
        printList(head);
        System.out.println();
        System.out.println("-------------------");

        // 寻找链表中倒数第n个节点
        ListNode listNode = NthNodeFromEnd(head, 8);
        System.out.println(listNode.getData());

        // 寻找中间节点
        ListNode middle = findMiddle(head);
        System.out.println(middle.getData());

        // 单向链表的逆向输出
        ListNode node = reverseList(head);
        printList(node);

        System.out.println();
        System.out.println("-------------------");
        // 从表尾开始输出元素
        printFromEnd(head);

        System.out.println();
        // 检查链表的长度是奇数还是偶数
        int i = isLinkedListLength(head);
        System.out.println(i);

        // 如何逐对逆置链表
        ListNode recursive = ReversePairRecursive(head);
        System.out.println();
        printList(recursive);

        ListNode iterative = ReversePairIterative(head);
        System.out.println();
        printList(iterative);

        // 约瑟夫环
//       GetJosephusPosition(10, 5);


    }

    // 统计链表中节点的个数
    public static int listLength(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.getNext();
        }
        return len;
    }

    /**
     * 插入节点
     *
     * @param head     头节点
     * @param node     要插入的节点
     * @param position 插入位置
     * @return
     */
    public static ListNode insertInLinkedList(ListNode head, ListNode node, int position) {
        if (head == null) return node;  // 若链表为空，插入
        int size = listLength(head);
        // 判断插入位置的合法性
        if (position > size + 1 || position < 1) {
            System.out.println("Position of node to insert is isvalid.The valid inputs are 1 to " + (size + 1));
            return head;
        }
        if (position == 1) {
            // 在链表开头插入
            // 1、更新新节点next指针，使其指向当前的表头节点
            // 2、更新表头指针的值，使其指向新节点  (新节点的下一个节点为原来的头节点即可)
            node.setNext(head);
            return node;
        } else {
            // 在链表中间或末尾插入
            ListNode prev = head; // 用于遍历的前几个节点的而存在的
            int count = 1;
            while (count < position - 1) {
                prev = prev.getNext();
                count++;
            }
            // 找到插入的位置之后，直接将要插入的节点设置为下一个节点
            ListNode cur = prev.getNext();
            node.setNext(cur);
            prev.setNext(node);
        }
        return head;
    }

    /**
     * 删除节点
     *
     * @param head     头节点
     * @param position 删除的位置
     * @return
     */
    public static ListNode deleteNodeFromLinkedList(ListNode head, int position) {
        int size = listLength(head);
        // 判断删除的位置是否合法
        if (position > size || size < 1) {
            System.out.println("Position of node to delete is isvalid.The valid inputs are 1 to " + size);
            return head;
        }
        // 删除头节点
        if (position == 1) {
            // 删除单向链表的表头节点  获取头节点的下一个节点，然后将头节点置为空，再将新的头节点返回
            ListNode cur = head.getNext();
            head = null;
            return cur;
        } else {
            // 删除中间或表尾节点
            ListNode prev = head;
            int count = 1;
            // 找到中间要删除节点
            while (count < position) {
                prev = prev.getNext();
                count++;
            }
            // 获取该节点的下一个节点
            ListNode cur = prev.getNext();
            // 当前节点的下下个节点。直接忽略中间
            prev.setNext(cur.getNext());
            cur = null;
        }
        return head;
    }

    /**
     * 删除单向链表
     *
     * @param head
     */
    public static void deleteLinkedList(ListNode head) {
        ListNode aux, iter = head;
        while (iter != null) {
            aux = iter.getNext();
            iter = null;
            iter = aux;
        }
    }

    /**
     * 遍历链表的所有元素
     *
     * @param head
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }

    /**
     * 寻找链表中倒数第n个节点
     * 使用两个指针 NthNode,tmp.首先，两个指针都指向链表的头节点。仅当tmp进行了n次移动后，NthNode才开始移动。
     * 然后两个指针同时移动，直到tmp到达表尾。这是NthNode指针所指的节点就是所求的节点，也就是链表的倒数第n个节点
     *
     * @param head
     * @param position
     * @return
     */
    public static ListNode NthNodeFromEnd(ListNode head, int position) {
        ListNode tmp = head, NthNode = null;
        // 先让 tmp指针移动 position个节点
        for (int i = 1; i < position; i++) {
            if (tmp != null) tmp = tmp.getNext();
        }
        while (tmp != null) {
            if (NthNode == null) NthNode = head;  // 这里也可以赋值为头节点
                // 移动NthNode 直到最后该节点就是所求节点
            else NthNode = NthNode.getNext();
            tmp = tmp.getNext();
        }
        // 如果不为空，直接返回
        if (NthNode != null) return NthNode;
        return null;
    }

    /**
     * 判定给定的链表是以null结尾，还是形成一个环
     * 快慢指针
     *
     * @param head
     * @return
     */
    public static boolean DoesLinkedListContainsLoop(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * 判断给定的链表是否以 null结束
     * 如果链表存在环，找到环起始位置
     * 思路：首先找到链表的环，然后初始化slow为头结点，
     * 然后使slow和fast每次移动一个位置，直到它们
     * 在次相遇，相遇的点即为环的开始处
     *
     * @param head
     * @return
     */
    public static ListNode FindBeginOfLoop(ListNode head) {
        ListNode slow = head, fast = head;
        boolean loopExists = false;
        if (head == null) return null;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                loopExists = true;
                break;
            }
        }
        // 环存在
        if (loopExists) {
            slow = head;
            // 再次相遇
            while (slow != fast) {
                fast = fast.getNext();
                slow = slow.getNext();
            }
            return slow; // 返回环的开始节点
        }
        return null; // 环不存在
    }

    /**
     * 判断给定的链表是否以null结束。如果链表中存在环，返回环的长度
     *
     * @param head
     * @return
     */
    public static int FindLoopLength(ListNode head) {
        ListNode slow = head, fast = head;
        boolean loopExists = false;
        // 计数器
        int counter = 0;
        if (head == null) return 0;
        // 先判断是否是一个环
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                loopExists = true;
                break;
            }
        }
        // 求环的长度 如果快慢指针再次相遇的话，就表示环的长度
        if (loopExists) {
            fast = fast.getNext();
            while (slow != fast) {
                fast = fast.getNext();
                counter++;
            }
            return counter;
        }
        return 0;
    }

    /**
     * 在有序链表中插入一个节点
     * 遍历链表，找到存放元素的正确位置后，插入节点
     *
     * @param head
     * @param newNode
     * @return
     */
    public static ListNode insertInSortedList(ListNode head, ListNode newNode) {
        ListNode cur = head;
        ListNode tmp = null;
        if (head == null) return newNode;
        // 遍历节点，直到找到比新节点中数据指更大的节点
        while (cur != null && cur.getData() < newNode.getData()) {
            tmp = cur;
            cur = cur.getNext();
        }
        // 在该节点前插入新节点
        newNode.setNext(cur);
        tmp.setNext(newNode);
        return head;
    }

    /**
     * 逆置单向链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode tmp = null, newNode = null;
        while (head != null) {
            // 获取头节点的下一个节点
            newNode = head.getNext();
            // 设置头节点的下一个节点为空
            head.setNext(tmp);
            // 接着将头节点赋值给临时
            tmp = head;
            // 再次更新头节点为 头节点的下一个节点
            head = newNode;
        }
        return tmp;
    }

    /**
     * 如何找到链表的中间节点
     * 使用两个指针。让第一个指针的移动速度是另一个的两倍。当第一个指针到达表尾时，另一个指针则指针中间节点。
     *
     * @param head
     * @return
     */
    public static ListNode findMiddle(ListNode head) {
        ListNode ptr1, ptr2;
        ptr1 = ptr2 = head;
        int i = 0;
        // 不断循环，直至到表尾
        while (ptr1.getNext() != null) {
            if (i == 0) {
                ptr1 = ptr1.getNext();  // 只后移第一个指针
                i = 1;
            } else if (i == 1) {
                // 两个指针都后移
                ptr1 = ptr1.getNext();
                ptr2 = ptr2.getNext();
                i = 0;
            }
        }
        return ptr2;  // 返回ptr2的值，即为中间节点
    }

    /**
     * 从表尾开始输出链表(只会输出一个元素，不能输出所有)
     * 递归遍历至表尾。当返回时，输出元素
     *
     * @param head
     */
    public static void printFromEnd(ListNode head) {
        if (head == null) return;
        printFromEnd(head.getNext());
        System.out.print(head.getData() + " ");
    }

    /**
     * 检查链表的长度是奇数还是偶数
     * 使用一个在链表中每次向后移动两个节点的指针。最后，如果指针值为null，那么链表长度为偶数，
     * 否则指针指向表尾节点，链表长度为奇数
     *
     * @param head
     * @return
     */
    public static int isLinkedListLength(ListNode head) {
        // 每次移动两个节点，如果刚好到结尾，则是偶数
        while (head != null && head.getNext() != null) head = head.getNext().getNext();
        if (head == null) return 0;
        return 1;
    }

    /**
     * 如何把两个有序链表合并成一个新的有序链表
     *
     * @param a
     * @param b
     * @return
     */
    public static ListNode mergeList(ListNode a, ListNode b) {
        ListNode result = null;
        if (a == null) return b;
        if (b == null) return a;
        if (a.getData() <= b.getData()) {
            result = a;
            // 递归调用，更新一下a 链表的下一个节点即可
            result.setNext(mergeList(a.getNext(), b));
        } else {
            result = b;
            // 将a链表的位置的设置为b链表的下一个节点
            result.setNext(mergeList(b.getNext(), a));
        }
        return result;
    }

    /**
     * 如何逐对逆置链表
     * 递归版本
     *
     * @param head
     * @return
     */
    public static ListNode ReversePairRecursive(ListNode head) {
        ListNode tmp;
        // 递归的基本情形为 当前链表为空或只有一个元素
        if (head == null || head.getNext() == null) return head;
        else {
            // 逆置第一对
            tmp = head.getNext();
            head.setNext(tmp.getNext());
            tmp.setNext(head);
            head = tmp;
            head.getNext().setNext(ReversePairRecursive(head.getNext().getNext()));
            return head;
        }
    }

    /**
     * 迭代版本
     *
     * @param head
     * @return
     */
    public static ListNode ReversePairIterative(ListNode head) {
        ListNode tmp1 = null;
        ListNode tmp2 = null;
        while (head != null && head.getNext() != null) {
            if (tmp1 != null) tmp1.getNext().setNext(head.getNext());
            tmp1 = head.getNext();
            head.setNext(head.getNext().getNext());
            tmp1.setNext(head);
            if (tmp2 == null) tmp2 = tmp1;
            head = head.getNext();
        }
        return tmp2;
    }

    /**
     * 交换链表中的相邻节点
     *
     * @param head
     */
    public static void exchangeAdjacentNodes(ListNode head) {
        ListNode cur, tmp, next;
        cur = head;
        if (cur == null || cur.getNext() == null) return;
        head = cur.getNext();
        while (cur != null && cur.getNext() != null) {
            next = cur.getNext();
            cur.setNext(next.getNext());
            tmp = cur.getNext();
            next.setNext(cur);
            if (tmp != null && tmp.getNext() != null) cur.setNext(cur.getNext().getNext());
            cur = tmp;
        }
    }


    /**
     * 对于给定的k，逆置链表中包含k个节点的块
     * 输入 1 2 3 4 5 6 7 8 9 10
     * 对于不同的k 输出2: 2 1 4 3 6 5 8 7 10 9
     */
    public static ListNode ReverseBlockOfK_nodeInLinkedList(ListNode head, int k) {
        ListNode tmp, next, cur = head, newHead;
        if (k == 0 || k == 1) return head;
        if (HasKnodes(cur, k - 1)) newHead = GetKPlusOneThNode(k - 1, cur);
        else newHead = head;
        while (cur != null && HasKnodes(cur, k)) {
            tmp = GetKPlusOneThNode(k, cur);
            int i = 0;
            while (i < k) {
                next = cur.getNext();
                cur.setNext(tmp);
                tmp = cur;
                cur = next;
                i++;
            }
        }
        return newHead;
    }

    private static ListNode GetKPlusOneThNode(int k, ListNode head) {
        ListNode Kth;
        int i;
        if (head == null) return head;
        for (i = 0, Kth = head; Kth != null && (i < k); i++, Kth = Kth.getNext()) ;
        if (i == k && Kth != null) return Kth;
        return head.getNext();
    }

    private static boolean HasKnodes(ListNode head, int k) {
        int i;
        for (i = 0; head != null && (i < k); i++, head = head.getNext()) ;
        if (i == k) return true;
        return false;
    }

    /**
     * 约瑟夫环：N个人想选出一个领头人，他们拍成一个环，沿着环每数到第M个人九从环中排除该人，并从下一个人开始重新数。
     * 请找出最后留在环中的人
     */
    public static void GetJosephusPosition(int N, int M) {
        ListNode p=null, q;
        // 建立包含所有人的循环链表
        p.setData(1);
        q = p;
        for (int i = 2; i <= N; i++) {
            p = p.getNext();
            p.setData(i);
        }
        p.setNext(q);  // 设置表尾节点的后继指向第一个节点，构建出循环链表
        for (int count = N; count > 1; count--) {
            // 如果链表中选手数 大于1 ，淘汰第M个选手
            for (int i = 0; i < M - 1; i++) p = p.getNext();
            p.setNext(p.getNext().getNext());  // 从链表中删除被淘汰选手的节点
        }
        System.out.println("Last player left standing is " + p.getData());
    }

}


