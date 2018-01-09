package data;

public class SingleLink {
    class Node{
        Object data;
        Node next;

        public Node(Object data) {
            super();
            this.data = data;
        }
    }
    Node head;
    Node prev;

    private void put(Object data){
        Node addNode = new Node(data);
        if (head == null){
            head = addNode;
        } else {
            Node lastNode = findLastNode();
            lastNode.next = addNode;
        }
    }

    private void delete(Object data){
        Node nodeByData = findNodeByData(data);
        if (nodeByData == null){
            System.out.println("不存在该元素");
        } else if (nodeByData == head){
            if(nodeByData.next == null){
                head = null;
            }else{
                head = head.next;
            }
        } else if (nodeByData.next == null){
            prev.next = null;
        } else {
            prev.next = nodeByData.next;
        }
    }

    private Node findLastNode(){
        Node temp = head;
        while (temp != null){
            temp = temp.next;
        }
        return temp;
    }

    private Node findNodeByData(Object data){
        Node temp = head;
        while (temp != null){
            if (temp.data.hashCode() == data.hashCode() && temp.data.equals(data)){
                return temp;
            }
            prev = temp;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        Node temp = head;
        while (temp.next != null){
            buffer.append(temp.data + ", ");
            temp = temp.next;
        }
        buffer.append(temp.data +"]");
        return buffer.toString();
    }
}
