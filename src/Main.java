import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        //        Задача 1

        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer < 0) {
                    return false;
                }
                return true;
            }
        };

        Predicate<Integer> predicate2 = x -> x > 0;

        System.out.println(predicate1.test(200));
        System.out.println(predicate2.test(-50));

//        Задача 2

        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Привет, " + s + "!");
            }
        };

        Consumer<String> consumer2 = s -> System.out.println("Привет, " + s + "!");

        consumer1.accept("Василий");
        consumer2.accept("Иван");

//        Задача 3

        Function<Double, Long> function1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble1) {
                return Math.round(aDouble1);
            }
        };

        Function<Double, Long> function2 = x -> Math.round(x);
//        Double a = 12.4555;
//
//        System.out.println(function1.apply(a));

//        Задача 4

        Supplier<Integer> supplier1 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };
        Supplier<Integer> supplier2 = () -> (int) (Math.random() * 100);
        System.out.println(supplier1.get());
        System.out.println(supplier2.get());


        Function<Integer, Integer> function3 = x -> Math.round(x);
        Function<Integer, Double> function4 = x -> Math.pow(x, 2);

        System.out.println(ternaryOperator(predicate2, function3, function4).apply(-8));

    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }
}
