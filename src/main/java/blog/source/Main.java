package blog.source;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
       new Main().sol();
    }

    public void sol(){
        Object[] objs = new Object[]{1, "asd", "ap"};

        add(objs);

        for(Object obj : objs){
            System.out.println(obj);
        }
    }

    public Object[] add(Object[] arr) {
        arr[1] = "aaa";

        return arr;
    }
}
