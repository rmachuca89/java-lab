package generics;

import java.math.BigDecimal;
import java.util.Date;

public final class GenericsExampleMain {
    public static void main(String[] args) {

        MyGenericClass<String> myString = new MyGenericClass<>("String Generic");
        MyGenericClass<Integer> myInt = new MyGenericClass<>(123);
        MyGenericClass<Double> myDouble = new MyGenericClass<>(123.123);
        MyGenericClass<Date> myDate = new MyGenericClass<>(new Date());
        MyGenericClass<BigDecimal> myBigDecimal = new MyGenericClass<>(new BigDecimal(777));
        MyGenericClass<Foo> myFoo = new MyGenericClass<>(new Foo());
    }

    private GenericsExampleMain(){}
}
