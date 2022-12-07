package NewD;

public class CircularLinkedList {

    Node tail = null;

    static Node head = null;

    int count;

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

    public void add(int data) {
        // Create new node
        Node newNode = new Node(data);
        // Checks if the list is empty.
        if (head == null) {
            // If list is empty, both head and tail would point to new node.
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else {
            // tail will point to new node.
            tail.next = newNode;
            // New node will become new tail.
            tail = newNode;
            // Since, it is circular linked list tail will point to head.
            tail.next = head;
        }
    }

    private Node reverseLinkedList() {
        // TODO Auto-generated method stub
        if (head == null) {
            return head;
        }
        Node prev = null;
        Node current = head;
        Node next;
        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != (head));

        // adjusting the links so as to make the
        // last node point to the first node
        (head).next = prev;
        head = prev;
        return head;
    }

    // Displays all the nodes in the list
    public void display(Node head) {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
        }
        else {
            System.out.println("Nodes of the circular linked list: ");
            do {
                // Prints each node by incrementing pointer.
                System.out.print(" " + current.data);
                current = current.next;
            } while (current != head);
            System.out.println();
        }
    }

    public void countNodes() {
        Node current = head;
        do {
            // Increment the count variable by 1 for each node
            count++;
            current = current.next;
        } while (current != head);
        System.out.println("Count of nodes present in circular linked list: " + count);
    }

    public static void main(String[] args) {
        // CircularLinkedList csll = new CircularLinkedList();
        // Node first = new Node(10);
        // Node second = new Node(20);
        // Node third = new Node(30);
        // Node fourth = new Node(40);
        // Node fifth = new Node(50);
        //
        // first.next = second;
        // System.out.println(first);
        // second.next = third;
        // System.out.println(second);
        // third.next = fourth;
        // System.out.println(third);
        // fourth.next = fifth;
        // System.out.println(fourth);
        // fifth.next = first;
        // csll.last = fifth;
        // csll.head = first;
        // csll.display();

        CircularLinkedList csll = new CircularLinkedList();
        csll.add(1);
        csll.add(2);
        csll.add(3);
        csll.add(4);
        // csll.add(50);
        // csll.display();
        // Node reverseHead = csll.reverseLinkedList();
        // csll.display(reverseHead);
        csll.countNodes();
        // csll.addBeginning(60);
        // csll.display(head);
        // csll.addLast(70);
        // csll.display(head);
        csll.addMiddle(80);
        csll.display(head);
        // csll.deleteStart();
        // csll.display(head);
        // csll.deleteLast();
        // csll.display(head);
        // csll.deleteMiddle();
        // csll.display(head);
    }

    private void deleteMiddle() {
        // TODO Auto-generated method stub
        Node current = null;

        if (head != null) {
            Node temp = head;
            int countTotal = (count % 2 == 0) ? (count / 2) : ((count + 1) / 2);
            for (int i = 0; i < countTotal; i++) {
                // Current will point to node previous to temp.
                current = temp;
                // Traverse through the list till the middle of the list is
                // reached
                temp = temp.next;
            }
            current.next = temp.next;
            temp = null;
        }
    }

    private void deleteLast() {
        // TODO Auto-generated method stub
        if (head == null) {
            return;
        }
        else {
            // Checks whether contain only one element
            if (head != tail) {
                Node current = head;
                // Loop will iterate till the second last element as
                // current.next is pointing to tail
                while (current.next != tail) {
                    current = current.next;
                }
                // Second last element will be new tail
                tail = current;
                // Tail will point to head as it is a circular linked list
                tail.next = head;
            }
            // If the list contains only one element
            // Then it will remove it and both head and tail will point to null
            else {
                head = tail = null;
            }
        }
    }

    private void deleteStart() {
        // TODO Auto-generated method stub
        if (head == null) {
            return;
        }
        else {

            if (head != tail) {
                head = head.next;
                tail.next = head;
            }

            else {
                head = tail = null;
            }
        }
    }

    private void addMiddle(int data) {
        // TODO Auto-generated method stub
        Node newNode = new Node(data);
        // Checks if the list is empty.
        if (head == null) {
            // If list is empty, both head and tail would point to new node.
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else {
            Node temp, current;
            // Store the mid-point of the list
            int countTotal = (count % 2 == 0) ? (count / 2) : ((count + 1) / 2);
            // temp will point to head
            temp = head;
            current = null;
            for (int i = 0; i < countTotal; i++) {
                // Current will point to node previous to temp.
                current = temp;
                // Traverse through the list till the middle of the list is
                // reached
                temp = temp.next;
            }

            // current will point to new node
            current.next = newNode;
            // new node will point to temp
            newNode.next = temp;
        }
    }

    private void addLast(int data) {
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
    }

    private void addBeginning(int data) {
        // TODO Auto-generated method stub
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        tail.next = head;
    }

}
