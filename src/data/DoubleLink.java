package data;

public class DoubleLink {
    class Node{
        Object data;
        Node next;
        Node prev;

        public Node(Object data) {
            super();
            this.data = data;
        }
    }
    Node head;

    private void put(Object data){
        Node addNode = new Node(data);
        if (head == null){
            head = addNode;
        } else {
            Node lastNode = findLastNode();
            lastNode.next = addNode;
            addNode.prev = lastNode;
        }
    }

    private void delete(Object data){
        Node byData = findByData(data);
        if (byData == null){
            System.out.println("不存在该数据");
        } else {
            if (head == byData){
                head = head.next;
                head.prev = null;
            } else if (byData.next == null){
                byData.prev.next = null;
            } else {
                byData.next.prev = byData.prev;
                byData.prev.next = byData.next;
            }
        }
    }

    private Node findLastNode(){
        Node temp = head;
        while (temp != null){
            temp = temp.next;
        }
        return temp;
    }

    private Node findByData(Object data){
        Node temp = head;
        while(temp != null){
            if (temp.data.hashCode() == data.hashCode() && temp.data.equals(data)){
                return temp;
            }
        }
        return null;
    }
}
