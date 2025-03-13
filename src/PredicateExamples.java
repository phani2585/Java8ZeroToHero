import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PredicateExamples {
    public static void main(String[] args) {

        MyFunctionalInterface addition=(x,y)->x+y;
        MyFunctionalInterface subtraction=(x,y)->x-y;

        int result = addition.calculate(2, 3);
        System.out.println(result);

        System.out.println(subtraction.calculate(10,2));

        // Predicate , Function , Consumer , Supplier <-- pre-defined functional Interfaces in Java8
        Predicate<Integer> isGreaterThan5 =x->x>5;
        System.out.println(isGreaterThan5.test(10));
        System.out.println(isGreaterThan5.test(3));

        Predicate<Integer> isEven =x ->x%2==0;
        System.out.println(isEven.test(10));
        System.out.println(isEven.test(3));

        Predicate<String> isEmpty =x->x.isEmpty();
        System.out.println(isEmpty.test("java"));
        System.out.println(isEmpty.test(""));

        Predicate<String> isStartsWithRe=x->x.startsWith("Re");
        System.out.println(isStartsWithRe.test("Reactive"));
        System.out.println(isStartsWithRe.test("Java"));

        Predicate<Integer> isPositive=x->x>0;
        System.out.println(isPositive.test(10));
        System.out.println(isPositive.test(-1));

        Predicate<String> hasMoreThan5Chars =x->x.length()>5;
        System.out.println(hasMoreThan5Chars.test("Java"));
        System.out.println(hasMoreThan5Chars.test("Selenium"));
// Be- aware of UnsupportedOperationException while creating List
        List<Integer> nums= new ArrayList<>(Arrays.asList(10,20,30,-10,-20,-30));
        nums.removeIf(num->num<0);
        System.out.println(nums);

        List<Integer> nos=Arrays.asList(10,30,21,45,24);
        List<Integer> evenNums = nos.stream().filter(x -> x % 2 == 0).toList();
        System.out.println(evenNums);
        List<Integer> ans = nos.stream().filter(x -> x % 3 == 0).collect(Collectors.toList());
        System.out.println(ans);

        Predicate<List<String>> containsReactive=x->x.contains("Reactive");
        List<String> myList=Arrays.asList("Reactive", "non-Reactive","java");
        boolean result1 = containsReactive.test(myList);
        System.out.println(result1);
        Predicate<Integer> between10And50=x->x>=10 && x<=50;
        System.out.println("33 , between 10 and 50 ::"+between10And50.test(33));
        System.out.println("51 , between 10 and 50 ::"+between10And50.test(51));
        System.out.println("9 , between 10 and 50 ::"+between10And50.test(9));
        System.out.println("10 , between 10 and 50 ::"+between10And50.test(10));
        System.out.println("50 , between 10 and 50 ::"+between10And50.test(50));
        // is person major., age >18
        Predicate<Person> isMajor =x->x.getAge()>18;
        Person p1=new Person("Mohan", 22);
        Person p2=new Person("Komal", 15);
        System.out.println("Mohan : Major ? ::"+isMajor.test(p1));
        System.out.println("komal : Major ? :: "+isMajor.test(p2));

        // String has all upper case? //IMP **
        Predicate<String> hasAllUpper=x->x.chars().allMatch(Character::isUpperCase);
        System.out.println(hasAllUpper.test("JAVA"));
        System.out.println(hasAllUpper.test("Java"));

        Predicate<List<Integer>> hasAllEven=x->x.stream().allMatch(y->y%2==0);
        List<Integer> testNums=Arrays.asList(2,4,6,8);
        List<Integer> testNums2=Arrays.asList(3,5,2,6);
        List<Integer> testNums3=Arrays.asList(3,5,7,9);
        System.out.println(hasAllEven.test(testNums2));
        System.out.println(hasAllEven.test(testNums));
        System.out.println(hasAllEven.test(testNums3));
        // valid email
        Predicate<String> isValidEmail=x->x.contains("@") && x.contains(".");
        System.out.println("phani@gmail.com is a valid email :: "+isValidEmail.test("phani@gmail.com"));
        System.out.println("abc@gmail is a valid email :: "+isValidEmail.test("abc@gmail"));

        List<Double> sals=Arrays.asList(60000.0,30000.0,50000.0);
        List<Double> highSals = sals.stream().filter(y -> y >= 50000.0).collect(Collectors.toList());
        System.out.println(highSals);
// without Java8 , traditional way
        System.out.println("10 is Prime ? ::"+isPrime(10));
        System.out.println("5 is Prime ? ::"+isPrime(5));
        //isNum prime ..** IMP ** 1 and itself should be factors , check for factors
/*for(int i=2;i<=Math.sqrt(num); i++){
         if(num%i==0){
             // found a factor => num is not prime , already 1 is a factor of all numbers and every number is a factor of itself , we found one additional factor
             return false;
         }
     }*/
        //convert this to Java8 syntax--high level
       /* num-> {
            return IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(i -> num % i == 0);
        };*/
        Predicate<Integer> isPrimeNumber =num-> IntStream.rangeClosed(2,(int)Math.sqrt(num)).noneMatch(i->num%i==0);
        System.out.println("10 is Prime ? ::"+isPrimeNumber.test(10));
        System.out.println("5 is Prime ? ::"+isPrimeNumber.test(5));
    }
    public static boolean isPrime(int num){
     if(num <2){
         return false; // 0 and 1 are not prime
     }
     for(int i=2;i<=Math.sqrt(num); i++){
         if(num%i==0){
             // found a factor => num is not prime , already 1 is a factor of all numbers and every number is a factor of itself , we found one additional factor
             return false;
         }
     }
     return true; // no factors or divisors found , only 1 and itself are factors of the number , we are checking if it is a prime number
    }
}

@FunctionalInterface
interface MyFunctionalInterface{
    int calculate(int a, int b);
}



class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}