package NewD;

public class LinkedList {
    Node head;

    // class Node {
    static class Node {
        int data;

        Node next;

        public Node(int data) {
            super();
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node [data=" + data + ", next=" + next + "]";
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedList list = new LinkedList();
        // if inner class is not static
        // LinkedList.Node node = list.new Node(10);
        // list.head = list.new Node(10);
        // LinkedList.Node node2=list.new Node(20);

        // if inner class is static
        list.head = new Node(10);
        System.out.println(list.head);
        Node second = new Node(20);
        Node third = new Node(30);
        list.head.next = second;
        System.out.println(second);
        second.next = third;
        System.out.println(third);
        // traverse
        list.printList();
        // push at first
        list.pushAtFirst(5);// O(1)
        list.printList();
        // push at any position
        list.pushAtGivenNode(second, 40);// O(1)
        list.printList();
        // push at the end
        list.pushAtEnd(50);// O(n)
        list.printList();
        // push at any given position
        list.pushAtGivenPos(2, 100);
        list.printList();
        // delete from beginning
        // list.deleteFromBegining();
        // list.printList();
        // list.deleteFromLast();
        // list.printList();
        // list.deleteFromAnyPosition(2);
        // list.printList();
        // list.reverseLinkedList();
        // list.printList();
        // list.head = list.reverseRecursion(list.head);
        // list.printList();
        list.findMiddleElement();
        list.findMiddle();
    }

    private void findMiddle() {
        // TODO Auto-generated method stub
        int n = 0;// always take from 0
        Node traverse = head;
        while (traverse != null) {
            n++;
            traverse = traverse.next;
        }
        if (head != null) {
            int length = n;
            Node temp = head;
            int middleLength = length / 2;
            while (middleLength != 0) {
                temp = temp.next;
                middleLength--;
            }
            System.out.print("The middle element is [" + temp.data + "]");
            System.out.println();
        }
    }

    private void findMiddleElement() {
        // TODO Auto-generated method stub
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element is:" + slow.data);
    }

    private Node reverseRecursion(Node head) {
        // TODO Auto-generated method stub
        if (head == null || head.next == null) {
            return head;
        }
        Node newhead = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }

    private Node reverseLinkedList() {
        // TODO Auto-generated method stub
        if (head == null) {
            return head;
        }
        Node current = head;
        Node nextNode = null;
        Node prevNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        return prevNode;
    }

    private void deleteFromAnyPosition(int pos) {
        // TODO Auto-generated method stub
        Node start = head;
        Node iterate = head;
        Node prev = null;
        int count = 1;
        int n = 0;
        while (iterate != null) {
            n = n + 1;
            iterate = iterate.next;
        }
        if (pos == 1) {
            head = start.next;
        }
        else if (pos == n) {
            start = head;
            while (((start.next).next) != null) {
                start = start.next;
            }
            start.next = null;
        }
        else {
            start = head;
            while (count < pos) {
                count = count + 1;
                prev = start;
                start = start.next;
            }
            prev.next = start.next;
        }
    }

    private void deleteFromLast() {
        // TODO Auto-generated method stub
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node iterateLast = head;
        Node prevLast = null;
        while (iterateLast.next != null) {
            prevLast = iterateLast;
            iterateLast = iterateLast.next;
        }
        prevLast.next = null;
    }

    private void deleteFromBegining() {
        // TODO Auto-generated method stub
        if (head == null) {
            System.out.println("List is empty");
        }
        head = head.next;
    }

    private void pushAtGivenPos(int pos, int data) {
        // TODO Auto-generated method stub
        Node betweenNode = new Node(data);
        int n = 0;
        Node iterateNode = head;
        if (head == null) {
            System.out.println("List doesnot exist");
        }
        while (iterateNode != null) {
            n = n + 1;
            iterateNode = iterateNode.next;
        }
        if (pos < 1) {
            System.out.println("Position cannot be less than 1");
            return;
        }
        if (pos == 1) {
            betweenNode.next = head;
            head = betweenNode;
        }
        else if (pos == (n + 1)) {
            Node pointHead = head;
            while (pointHead.next != null) {
                pointHead = pointHead.next;
            }
            Node bwtNode = new Node(data);
            bwtNode.next = null;
            pointHead.next = bwtNode;
        }
        else {
            Node prevNode = head;
            int count = 1;
            while (count < pos - 1) {
                prevNode = prevNode.next;
                count++;
            }
            Node current = prevNode.next;
            prevNode.next = betweenNode;
            betweenNode.next = current;
        }
    }

    private void pushAtEnd(int data) {
        // TODO Auto-generated method stub
        Node traverseLast = head;
        Node lastNode = new Node(data);
        lastNode.next = null;
        while (traverseLast.next != null) {
            traverseLast = traverseLast.next;
        }
        traverseLast.next = lastNode;
    }

    private void pushAtGivenNode(Node second, int data) {
        // TODO Auto-generated method stub
        Node betweenNode = new Node(data);
        betweenNode.next = second.next;
        second.next = betweenNode;
    }

    private void pushAtFirst(int data) {
        // TODO Auto-generated method stub
        Node firstNode = new Node(data);
        firstNode.next = head;
        head = firstNode;
    }

    private void printList() {

        Node traverseNode = head;
        while (traverseNode != null) {
            System.out.println("The nodes data are:" + traverseNode.data + " ");
            System.out.println("The nodes next are:" + traverseNode.next + " ");
            traverseNode = traverseNode.next;
        }
    }

}

/*
 *
 * Time Complexity Worst Case Average Case Search O(n) O(n) Insert O(1) O(1)
 * Deletion O(1) O(1)
 *
 */