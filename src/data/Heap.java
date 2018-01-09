package data;

public class Heap {
    Object[] datas;
    int index;

    public Heap(int size) {
        super();
        datas = new Object[size];
    }
    //添加元素
    private void push(Object data){
        if (index == datas.length){
            new RuntimeException("栈已满");
        } else {
            datas[index++] = data;
        }
    }
    //弹出元素
    private Object popup(){
        if (index == 0){
            System.out.println("已空！！");
            return null;
        } else {
            return datas[--index];
        }
    }
}
