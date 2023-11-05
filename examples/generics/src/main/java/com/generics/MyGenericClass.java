package examples.generics.src.main.java.com.generics;

class MyGenericClass<T> {
    // My Generic Class.
    // T parameter is arbitrary but is conventional as it hints "Type"
    // E as in Element, K as en Key, V as in Value are also common.
    T myValue;
    public MyGenericClass(T value){
        this.myValue = value;
        System.out.println(myValue.getClass().getName());
    }
}

