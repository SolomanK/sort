package data;

public class Tree {
    class Node{
        Object data;
        Node parent;
        Node left;
        Node right;

        public Node() {
            super();
        }

        public Node(Object data) {
            this.data = data;
        }
    }
    Node root;

    private  void put(Object data){
        Node addNode = new Node(data);
        if (root == null){
            root = addNode;
        } else {
            Node parentNode = findParentNode(data);
            if (compare(parentNode.data, data) > 0){
                parentNode.left = addNode;
            } else {
                parentNode.right = addNode;
            }
            addNode.parent = parentNode;
        }
    }

    private void delete(Object data){
        Node byData = findByData(data);
        if (byData == null){
            System.out.println("不存在该数据");
        } else if (root == byData){
            if (root.left == null && root.right == null){
                root = null;
            } else if (root.left == null){
                root = root.right;
            } else if (root.right == null){
                root = root.left;
            } else {
                Node maxNode = findMaxNode(root.left);
                maxNode.right = root.right;
                root.right.parent = maxNode;
                root = root.left;
            }
        } else {
            if (byData.left == null && byData.right == null){
                if (compare(byData.parent.data, data) > 0){
                    byData.parent.left = null;
                } else {
                    byData.parent.right = null;
                }
            } else if (byData.left == null){
                if (compare(byData.parent.data, data) > 0){
                    byData.parent.left = byData.right;
                } else {
                    byData.parent.right = byData.right;
                }
                byData.right.parent = byData.parent;
            } else if (byData.right == null){
                if (compare(byData.parent.data, data) > 0){
                    byData.parent.left = byData.left;
                } else {
                    byData.parent.right = byData.left;
                }
                byData.left.parent = byData.parent;
            } else {
                if (compare(byData.parent.data, data) > 0){
                    byData.parent.left = byData.left;
                } else {
                    byData.parent.right = byData.left;
                }
                byData.left.parent = byData.parent;
                Node maxNode = findMaxNode(byData);
                maxNode.right = byData.right;
                byData.parent = maxNode;
            }
        }
    }

    private Node findByData(Object data){
        Node temp = root;
        while(temp != null){
            if (compare(temp.data, data) == 0){
                return temp;
            }
            if (compare(temp.data, data) > 0){
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }

    private Node findMaxNode(Node node){
        while (node != null){
            node = node.right;
        }
        return node;
    }
    //查找父节点
    private  Node findParentNode(Object data){
        Node temp = root;
        Node prev = null;
        while (temp != null){
            prev = temp;
            if (compare(temp.data, data) > 0){
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return prev;
    }

    private int compare(Object d1, Object d2){
        Comparable c1;
        Comparable c2;
        if (d1 instanceof Comparable && d2 instanceof Comparable){
            c1 = (Comparable) d1;
            c2 = (Comparable) d2;
        } else {
            c1 = d1.toString();
            c2 = d2.toString();
        }
        return c1.compareTo(c2);
    }

    private void print(){
        see(root);
    }
    private void see(Node node){
        if (node == null){
            return;
        }
        see(node.left);
        System.out.println(node.data);
        see(node.right);
    }
}
