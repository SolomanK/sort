package data;

public class Queue {
    Object[] datas;
    int get;
    int put;
    int num; //队列的元素个数

    public Queue(int size) {
        super();
        datas = new Object[size];
    }

    private void put(Object data){
        if (num == datas.length){
            System.out.println("had full");
        } else {
            datas[put % datas.length] = data;
            put++;
            num++;
        }
    }
    private Object get(){
        if (num == 0){
            System.out.println("has none");
            return null;

        } else {
            Object o = datas[get % datas.length];
            get++;
            num--;
            return o;
        }
    }
}
