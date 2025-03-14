# Java 8 Predicate - Problems & Solutions

## **🟢 Easy (Beginner) - Solutions**

### **1️⃣ Check if a number is even**
```java
Predicate<Integer> isEven = num -> num % 2 == 0;
System.out.println(isEven.test(10)); // true
System.out.println(isEven.test(7));  // false
```

### **2️⃣ Check if a string is empty**
```java
Predicate<String> isEmpty = str -> str.isEmpty();
System.out.println(isEmpty.test(""));    // true
System.out.println(isEmpty.test("Java"));// false
```

### **3️⃣ Check if a string starts with "Re"**
```java
Predicate<String> startsWithRe = str -> str.startsWith("Re");
System.out.println(startsWithRe.test("Reactive")); // true
System.out.println(startsWithRe.test("Java")); // false
```

### **4️⃣ Check if a number is positive**
```java
Predicate<Integer> isPositive = num -> num > 0;
System.out.println(isPositive.test(10)); // true
System.out.println(isPositive.test(-5)); // false
```

### **5️⃣ Check if a string has more than 5 characters**
```java
Predicate<String> hasMoreThan5Chars = str -> str.length() > 5;
System.out.println(hasMoreThan5Chars.test("Reactive")); // true
System.out.println(hasMoreThan5Chars.test("Java")); // false
```

### **6️⃣ Remove all negative numbers from a list**
```java
List<Integer> numbers = new ArrayList<>(Arrays.asList(-5, 3, -1, 8, 10));
numbers.removeIf(num -> num < 0);
System.out.println(numbers); // [3, 8, 10]
```

### **7️⃣ Filter out all even numbers using Streams**
```java
List<Integer> evenNumbers = numbers.stream()
                                  .filter(isEven)
                                  .collect(Collectors.toList());
System.out.println(evenNumbers); // [8, 10]
```

### **8️⃣ Check if a number is a multiple of 3**
```java
Predicate<Integer> isMultipleOf3 = num -> num % 3 == 0;
System.out.println(isMultipleOf3.test(9)); // true
System.out.println(isMultipleOf3.test(10)); // false
```

### **9️⃣ Check if a list contains "Reactive"**
```java
Predicate<List<String>> containsReactive = list -> list.contains("Reactive");
System.out.println(containsReactive.test(Arrays.asList("Java", "Reactive", "Spring"))); // true
```

### **🔟 Check if a number is between 10 and 50**
```java
Predicate<Integer> between10And50 = num -> num >= 10 && num <= 50;
System.out.println(between10And50.test(25)); // true
System.out.println(between10And50.test(5)); // false
```

---

## **🟠 Medium (Intermediate) - Solutions**

### **1️⃣ Check if a `Person` is an adult (age > 18)**
```java
class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

Predicate<Person> isAdult = person -> person.age > 18;
System.out.println(isAdult.test(new Person("John", 20))); // true
```

### **2️⃣ Check if a string contains only uppercase letters**
```java
Predicate<String> isUpperCase = str -> str.chars().allMatch(Character::isUpperCase);
System.out.println(isUpperCase.test("JAVA")); // true
```

### **3️⃣ Check if all elements in a list are even**
```java
Predicate<List<Integer>> allEven = list -> list.stream().allMatch(isEven);
System.out.println(allEven.test(Arrays.asList(2, 4, 6, 8))); // true
```

### **4️⃣ Check if a string is a valid email**
```java
Predicate<String> isValidEmail = email -> email.contains("@") && email.contains(".");
System.out.println(isValidEmail.test("test@example.com")); // true
```

### **5️⃣ Filter salaries greater than 50,000**
```java
List<Double> salaries = Arrays.asList(40000.0, 60000.0, 75000.0);
List<Double> highSalaries = salaries.stream()
                                    .filter(salary -> salary > 50000)
                                    .collect(Collectors.toList());
System.out.println(highSalaries); // [60000.0, 75000.0]
```

### **6️⃣ Check if a number is prime**
```java
Predicate<Integer> isPrime = num -> IntStream.rangeClosed(2, (int) Math.sqrt(num))
                                            .allMatch(i -> num % i != 0);
System.out.println(isPrime.test(7)); // true


Here are different ways to implement the prime number check using Java 8+ features:

1. Using noneMatch (Concise and Readable)

import java.util.stream.IntStream;

public class PrimeCheckJava8 {
    public static void main(String[] args) {
        System.out.println("10 is Prime ? ::" + isPrime(10));
        System.out.println("5 is Prime ? ::" + isPrime(5));
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        return IntStream.rangeClosed(2, (int) Math.sqrt(num))
                        .noneMatch(i -> num % i == 0);
    }
}
🔹 Explanation:

rangeClosed(2, √num): Generates numbers from 2 to √num.
noneMatch(i -> num % i == 0): Returns true if no divisor is found, meaning the number is prime.
2. Using allMatch (Alternative)

public static boolean isPrimeUsingAllMatch(int num) {
    if (num < 2) {
        return false;
    }
    return IntStream.rangeClosed(2, (int) Math.sqrt(num))
                    .allMatch(i -> num % i != 0);
}
🔹 Explanation:

Instead of checking for no match, this checks if all numbers are not divisors.
3. Using filter and count (Less Efficient but Descriptive)

public static boolean isPrimeUsingCount(int num) {
    if (num < 2) {
        return false;
    }
    return IntStream.rangeClosed(2, (int) Math.sqrt(num))
                    .filter(i -> num % i == 0)
                    .count() == 0;
}
🔹 Explanation:

Filters numbers that divide num and counts them.
If the count is 0, it's prime.
4. Fully Concise One-Liner (Lambda Expression)

public static boolean isPrimeOneLiner(int num) {
    return num > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(i -> num % i == 0);
}
🔹 Explanation:

Combines everything into a single return statement.
Best Choice?
noneMatch approach is the most readable and efficient for Java 8.
allMatch is an alternative but less intuitive.
count is not recommended for performance reasons.
One-liner is great for brevity.
```
import java.util.Scanner; // Importing Scanner class for user input

public class PrimeNumberCheck { // Class definition
    public static void main(String[] args) { // Main method, entry point of the program
        Scanner scanner = new Scanner(System.in); // Creating Scanner object to take user input
        System.out.print("Enter a number: "); // Prompting user to enter a number
        int number = scanner.nextInt(); // Reading integer input from the user
        scanner.close(); // Closing the scanner to prevent resource leak

        if (isPrime(number)) { // Checking if the entered number is prime
            System.out.println(number + " is a prime number."); // Printing result if number is prime
        } else {
            System.out.println(number + " is not a prime number."); // Printing result if number is not prime
        }
    }

    public static boolean isPrime(int num) { // Method to check if a number is prime
        if (num < 2) { // If number is less than 2, it is not prime
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) { // Loop from 2 to square root of the number
            if (num % i == 0) { // If number is divisible by any i, it's not prime
                return false; // Return false if a divisor is found
            }
        }
        return true; // Return true if no divisors are found, meaning number is prime
    }
}


### **7️⃣ Chain predicates: Check if number is even and > 10**
```java
Predicate<Integer> complexPredicate = isEven.and(num -> num > 10);
System.out.println(complexPredicate.test(12)); // true
```

### **8️⃣ Check if a string contains a vowel**
```java
Predicate<String> containsVowel = str -> str.matches(".*[AEIOUaeiou].*");
System.out.println(containsVowel.test("Hello")); // true
```

### **9️⃣ Filter strings that start and end with a vowel**
```java
List<String> words = Arrays.asList("apple", "banana", "orange", "grape");
List<String> filtered = words.stream()
                             .filter(w -> w.matches("^[AEIOUaeiou].*[AEIOUaeiou]$"))
                             .collect(Collectors.toList());
System.out.println(filtered); // [apple, orange]
```

### **🔟 Check if first number is divisible by second (BiPredicate)**
```java
BiPredicate<Integer, Integer> isDivisible = (a, b) -> a % b == 0;
System.out.println(isDivisible.test(10, 5)); // true
```

---
# Java 8 Predicate - Hard Problems & Solutions

## **🔴 Hard (Advanced) - Solutions**

### **1️⃣ Validate a strong password**
```java
Predicate<String> isStrongPassword = pwd -> 
    pwd.length() >= 8 && 
    pwd.chars().anyMatch(Character::isUpperCase) && 
    pwd.chars().anyMatch(Character::isLowerCase) && 
    pwd.chars().anyMatch(Character::isDigit) &&
    pwd.chars().anyMatch(ch -> "!@#$%^&*()_+".indexOf(ch) >= 0);
System.out.println(isStrongPassword.test("Str0ng@Pwd")); // true
```

### **2️⃣ Check if a number is a Fibonacci number**
```java
Predicate<Integer> isFibonacci = num -> {
    int a = 0, b = 1;
    while (b < num) {
        int temp = b;
        b = a + b;
        a = temp;
    }
    return b == num || num == 0;
};
System.out.println(isFibonacci.test(21)); // true
System.out.println(isFibonacci.test(25)); // false
```

### **3️⃣ Validate a MAC address**
```java
Predicate<String> isValidMAC = mac -> mac.matches("^([0-9A-Fa-f]{2}:){5}[0-9A-Fa-f]{2}$");
System.out.println(isValidMAC.test("00:1A:2B:3C:4D:5E")); // true
```

### **4️⃣ Check if a list contains only unique elements**
```java
Predicate<List<Integer>> hasUniqueElements = list ->
    list.size() == new HashSet<>(list).size();
System.out.println(hasUniqueElements.test(Arrays.asList(1, 2, 3, 4))); // true
System.out.println(hasUniqueElements.test(Arrays.asList(1, 2, 2, 3))); // false
```

### **5️⃣ Validate a hexadecimal color code**
```java
Predicate<String> isValidHexColor = color -> color.matches("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$");
System.out.println(isValidHexColor.test("#FFA07A")); // true
```

## **🔴 5 More Tough Problems**
```java
// Traditional Approach (Loop-based) ArmStrong Number Check **** IMP ****
public class ArmstrongNumber {
    public static void main(String[] args) {
        int num = 9474;
        System.out.println(num + " is Armstrong? " + isArmstrong(num));
    }

    public static boolean isArmstrong(int num) {
        int originalNum = num, sum = 0, digits = 0;

        // Step 1: Count the number of digits
        int temp = num;
        while (temp > 0) {
            temp /= 10;
            digits++;
        }

        // Step 2: Calculate Armstrong sum
        temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }

        return sum == originalNum;
    }
}
```

### **Traditional Approach Explanation**
- **Step 1:** Count the number of digits using a loop.
- **Step 2:** Extract digits, raise them to the power, and sum them.
- **Step 3:** Compare the sum with the original number.
- ✅ **Simple & efficient**, avoids unnecessary conversions.

---

```java
// Java 8 Stream-based Approach
import java.util.stream.IntStream;

public class ArmstrongNumberJava8 {
    public static void main(String[] args) {
        int num = 9474;
        System.out.println(num + " is Armstrong? " + isArmstrong(num));
    }

    public static boolean isArmstrong(int num) {
        int digits = (int) Math.log10(num) + 1; // Efficient digit count
        return num == IntStream.iterate(num, n -> n > 0, n -> n / 10) // Extract digits
                .map(n -> (int) Math.pow(n % 10, digits)) // Power each digit
                .sum(); // Sum and compare
    }
}
```

### **Java 8 Functional Approach Explanation**
- **Step 1:** Calculate digit count efficiently using `Math.log10()`.
- **Step 2:** Extract digits using `IntStream.iterate()`.
- **Step 3:** Raise each digit to the power and sum it.
- ✅ **More concise and readable**.

---

```java
// Java 8 Parallel Stream Approach (Optimized for Large Numbers)
import java.util.stream.IntStream;

public class ArmstrongNumberParallel {
    public static void main(String[] args) {
        int num = 9474;
        System.out.println(num + " is Armstrong? " + isArmstrong(num));
    }

    public static boolean isArmstrong(int num) {
        int digits = (int) Math.log10(num) + 1;
        return num == IntStream.iterate(num, n -> n > 0, n -> n / 10)
                .parallel() // Enable parallel processing
                .map(n -> (int) Math.pow(n % 10, digits))
                .sum();
    }
}
```

### **Parallel Stream Approach Explanation**
- **Parallel Processing:** Enables faster computation on large numbers.
- **Useful for handling huge inputs efficiently.**

---

### **Comparison of Approaches**
| Approach            | Efficiency  | Readability | Best Use Case |
|--------------------|------------|------------|--------------|
| **Traditional Loop** | ✅ Fast | ✅ Easy to Understand | Small numbers |
| **Java 8 Streams**  | ✅ Faster | ✅ More concise | Medium-sized numbers |
| **Java 8 Parallel** | ✅✅ Fastest | ✅ Concise | Large numbers |





### **6️⃣ Check if a number is an Armstrong number**
```java
Predicate<Integer> isArmstrong = num -> {
    int sum = 0, temp = num, digits = String.valueOf(num).length();
    while (temp > 0) {
        sum += Math.pow(temp % 10, digits);
        temp /= 10;
    }
    return sum == num;
};
System.out.println(isArmstrong.test(153)); // true
```

### **7️⃣ Validate a complex JSON string format**
```java
Predicate<String> isValidJson = json -> json.trim().matches("\{.*:\{.*:.*}}");
System.out.println(isValidJson.test("{\"data\":{\"key\":\"value\"}}")); // true
```

### **8️⃣ Check if a given year is a leap year**
```java
Predicate<Integer> isLeapYear = year -> (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
System.out.println(isLeapYear.test(2024)); // true
```

### **9️⃣ Validate a binary number**
```java
Predicate<String> isBinary = bin -> bin.matches("[01]+");
System.out.println(isBinary.test("101010")); // true
System.out.println(isBinary.test("123")); // false
```

### **🔟 Check if a string is a palindrome ignoring case**
```java
```Palindrome logic 
   //palindrome check
        String str="madam";
        String rev = new StringBuilder(str).reverse().toString();
        if(rev.equals(str)){
            System.out.println(str + " is a palindrome");
        }else{
            System.out.println(str + "is not a palindrome");
        }
        Predicate<String> isPalindrome=s->IntStream.rangeClosed(0,s.length()/2).allMatch(i->s.charAt(i)==s.charAt(s.length()-1-i));
        System.out.println("madam is palindrome :: "+isPalindrome.test("madam"));

        Predicate<String> isPalindromeCase = s ->
                IntStream.range(0, s.length() / 2)
                        .allMatch(i -> Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(s.length() - 1 - i)));

        System.out.println(isPalindromeCase.test("Madam"));  // true
        System.out.println(isPalindromeCase.test("Hello"));  // false
Predicate<String> isPalindromeIgnoreCase = str -> {
    String lowerStr = str.toLowerCase();
    return IntStream.range(0, lowerStr.length() / 2)
        .allMatch(i -> lowerStr.charAt(i) == lowerStr.charAt(lowerStr.length() - 1 - i));
};
System.out.println(isPalindromeIgnoreCase.test("Madam")); // true
```
```

## **🔴 2 Most Tough Problems**

### **1️⃣1️⃣ Validate a well-formed XML string**
```java
Predicate<String> isValidXML = xml -> xml.matches("<([a-zA-Z]+)>.*</\\1>");
System.out.println(isValidXML.test("<tag>Hello</tag>")); // true
System.out.println(isValidXML.test("<tag>Hello</other>")); // false
```

### **1️⃣2️⃣ Check if a given Sudoku board is valid**
```java
Predicate<int[][]> isValidSudoku = board -> {
    Set<String> seen = new HashSet<>();
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            int num = board[i][j];
            if (num != 0) {
                if (!seen.add(num + " in row " + i) ||
                    !seen.add(num + " in col " + j) ||
                    !seen.add(num + " in box " + (i / 3) + "-" + (j / 3))) {
                    return false;
                }
            }
        }
    }
    return true;
};
System.out.println(isValidSudoku.test(new int[][] {
    {5,3,0,0,7,0,0,0,0},
    {6,0,0,1,9,5,0,0,0},
    {0,9,8,0,0,0,0,6,0},
    {8,0,0,0,6,0,0,0,3},
    {4,0,0,8,0,3,0,0,1},
    {7,0,0,0,2,0,0,0,6},
    {0,6,0,0,0,0,2,8,0},
    {0,0,0,4,1,9,0,0,5},
    {0,0,0,0,8,0,0,7,9}
})); // true
```

## **🔥 1 Toughest Problem**

### **1️⃣3️⃣ Check if a given text follows a complex grammar rule**
```java
Predicate<String> followsGrammar = text -> text.matches("[A-Z][a-z]*(,\s[A-Z][a-z]*)*");
System.out.println(followsGrammar.test("John, Alice, Bob")); // true
System.out.println(followsGrammar.test("john, Alice, Bob")); // false
```

These are the hardest Predicate-based challenges, covering various levels of difficulty for mastering Java 8 functional programming. 🚀

Next -- palindrome check .....then complete java8 , one by one THEN COLLECTIONS CODING , CONCURRENCY AND MULTI THREADING CODING THEN REACTIVE PROGRAMMING , KAFKA , RABBIT MQ BASIC CODING .THEN THEORY 


T --> all types R --> String.valueOf, IntStream , iterate , rangeclosed, parallel , map, flat map , filter, map , reduce , allmatch, noneMatch , findAny ,
----------# Java 8 Consumer - Deep Dive

## **🔹 Concepts & Syntax**

The `Consumer<T>` functional interface in Java 8 is used when an operation needs to be performed on an object of type `T` without returning a result.

### **1️⃣ Definition**
```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```

### **2️⃣ Key Features**
- Represents an operation that accepts a single input argument and returns no result.
- Used mainly in lambda expressions and method references.
- Can be chained using `andThen()` to perform multiple operations in sequence.

### **3️⃣ Basic Usage**
```java
Consumer<String> printConsumer = s -> System.out.println("Hello, " + s);
printConsumer.accept("Java 8"); // Output: Hello, Java 8
```

---

## **🟢 Easy (Beginner) - Problems & Solutions**

### **1️⃣ Print each item in a list**
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(name -> System.out.println(name));
```

### **2️⃣ Convert a string to uppercase and print**
```java
Consumer<String> toUpperCase = s -> System.out.println(s.toUpperCase());
toUpperCase.accept("hello"); // Output: HELLO
```

### **3️⃣ Print the square of a number**
```java
Consumer<Integer> squareConsumer = num -> System.out.println(num * num);
squareConsumer.accept(4); // Output: 16
```

...

---

## **🟠 Medium (Intermediate) - Problems & Solutions**

### **1️⃣ Modify and print each item in a list**
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(name -> System.out.println("Hello, " + name));
```

### **2️⃣ Chain two Consumers using `andThen()`**
```java
Consumer<String> c1 = s -> System.out.print(s.toUpperCase() + " ");
Consumer<String> c2 = s -> System.out.println(s.length());
c1.andThen(c2).accept("Hello"); // Output: HELLO 5
```

...

---

## **🔴 Hard (Advanced) - Problems & Solutions**

### **1️⃣ Process a list of Employee objects**
```java
class Employee {
    String name;
    double salary;
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
List<Employee> employees = Arrays.asList(
    new Employee("John", 50000),
    new Employee("Jane", 60000)
);
Consumer<Employee> giveBonus = emp -> emp.salary += 5000;
employees.forEach(giveBonus.andThen(emp -> System.out.println(emp.name + " -> " + emp.salary)));
```

...

---

## **📌 FAQ (Frequently Asked Questions)**

### **1️⃣ How does `Consumer<T>` differ from `Function<T, R>`?**
- `Consumer<T>` **performs an operation** but does not return a value.
- `Function<T, R>` **transforms input** and returns a value.

### **2️⃣ Can `Consumer<T>` be used with method references?**
Yes! Example:
```java
Consumer<String> printer = System.out::println;
printer.accept("Java 8 Rocks!");
```

...

---

## **🌍 Real-World Examples (Practical Usage)**

### **1️⃣ Logging messages in an application**
```java
Consumer<String> logger = message -> System.out.println("LOG: " + message);
logger.accept("Application started");
```

### **2️⃣ Sending email notifications**
```java
Consumer<String> emailNotifier = email -> System.out.println("Sending email to: " + email);
emailNotifier.accept("user@example.com");
```

...

---

This document provides a complete deep dive into `Consumer<T>` in Java 8 with examples, problems, solutions, FAQs, and real-world use cases. 🚀

# Java 8 Supplier - Deep Dive

## **🔹 Concepts & Syntax**

The `Supplier<T>` functional interface in Java 8 represents a supplier of results. It takes **no input** and returns **a result** of type `T`.

### **1️⃣ Definition**
```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```

### **2️⃣ Key Features**
- Represents a function that produces a result **without accepting any arguments**.
- Commonly used for **lazy evaluation**, **caching**, **object creation**, and **random value generation**.
- Can be used in **method references** for deferred execution.

### **3️⃣ Basic Usage**
```java
Supplier<String> supplier = () -> "Hello, Supplier!";
System.out.println(supplier.get()); // Output: Hello, Supplier!
```

---

## **🟢 Easy (Beginner) - Problems & Solutions**

### **1️⃣ Generate a random number**
```java
Supplier<Double> randomSupplier = () -> Math.random();
System.out.println(randomSupplier.get());
```

### **2️⃣ Supply a default message**
```java
Supplier<String> messageSupplier = () -> "Default Message";
System.out.println(messageSupplier.get()); // Output: Default Message
```

### **3️⃣ Get current system time**
```java
Supplier<Long> timeSupplier = () -> System.currentTimeMillis();
System.out.println(timeSupplier.get());
```

...

---

## **🟠 Medium (Intermediate) - Problems & Solutions**

### **1️⃣ Supply a list of names**
```java
Supplier<List<String>> nameSupplier = () -> Arrays.asList("Alice", "Bob", "Charlie");
System.out.println(nameSupplier.get());
```

### **2️⃣ Provide a unique ID generator**
```java
Supplier<UUID> uuidSupplier = UUID::randomUUID;
System.out.println(uuidSupplier.get());
```

...

---

## **🔴 Hard (Advanced) - Problems & Solutions**

### **1️⃣ Implement a cached supplier (Lazy Initialization)**
```java
class CachedSupplier<T> {
    private final Supplier<T> supplier;
    private T value;
    private boolean isCached = false;
    
    CachedSupplier(Supplier<T> supplier) {
        this.supplier = supplier;
    }
    
    public T get() {
        if (!isCached) {
            value = supplier.get();
            isCached = true;
        }
        return value;
    }
}

Supplier<String> expensiveSupplier = () -> "Expensive Computation Result";
CachedSupplier<String> cached = new CachedSupplier<>(expensiveSupplier);
System.out.println(cached.get()); // Computed once, cached result
System.out.println(cached.get()); // Returns cached value
```

...

---

## **📌 Real-World Use Cases**

### **1️⃣ Lazy Loading Configuration Values**
```java
Supplier<String> configValue = () -> loadFromDatabase();
```

### **2️⃣ Retry Mechanism for API Calls**
```java
Supplier<Response> apiCall = () -> fetchFromApi();
```

...

---

This document provides a complete deep dive into `Supplier<T>` in Java 8 with examples, problems, solutions, FAQs, and real-world use cases. 🚀

# Java 8 Function<T, R> - Complete Guide

## **🔹 Concepts & Syntax (Deep Dive)**

The `Function<T, R>` functional interface in Java 8 represents a function that **accepts one argument of type `T` and produces a result of type `R`**.

### **1️⃣ Definition**
```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```

### **2️⃣ Key Features**
- Used for **data transformation, mapping, and computations**.
- Can be **chained using `andThen()` and `compose()`**.
- Works seamlessly with **Stream API for processing collections**.

### **3️⃣ Basic Usage**
```java
Function<Integer, String> intToString = num -> "Number: " + num;
System.out.println(intToString.apply(5)); // Output: Number: 5
```

---

## **🟢 Easy (Beginner) - Problems & Solutions**

### **1️⃣ Convert integer to string**
```java
Function<Integer, String> toString = num -> "Number: " + num;
System.out.println(toString.apply(10)); // Output: Number: 10
```

### **2️⃣ Find string length**
```java
Function<String, Integer> lengthFinder = str -> str.length();
System.out.println(lengthFinder.apply("Java")); // Output: 4
```

### **3️⃣ Convert string to uppercase**
```java
Function<String, String> toUpperCase = str -> str.toUpperCase();
System.out.println(toUpperCase.apply("java")); // Output: JAVA
```

### **4️⃣ Multiply a number by 2**
```java
Function<Integer, Integer> multiplyByTwo = num -> num * 2;
System.out.println(multiplyByTwo.apply(6)); // Output: 12
```

### **5️⃣ Check if a string is empty**
```java
Function<String, Boolean> isEmpty = str -> str.isEmpty();
System.out.println(isEmpty.apply("")); // Output: true
```

### **6️⃣ Extract first character of a string**
```java
Function<String, Character> firstChar = str -> str.charAt(0);
System.out.println(firstChar.apply("Java")); // Output: J
```

### **7️⃣ Get square of a number**
```java
Function<Integer, Integer> square = num -> num * num;
System.out.println(square.apply(5)); // Output: 25
```

### **8️⃣ Append " Functional Programming" to a string**
```java
Function<String, String> appendText = str -> str + " Functional Programming";
System.out.println(appendText.apply("Java")); // Output: Java Functional Programming
```

### **9️⃣ Convert Celsius to Fahrenheit**
```java
Function<Double, Double> celsiusToFahrenheit = c -> (c * 9/5) + 32;
System.out.println(celsiusToFahrenheit.apply(0.0)); // Output: 32.0
```

### **🔟 Get last character of a string**
```java
Function<String, Character> lastChar = str -> str.charAt(str.length() - 1);
System.out.println(lastChar.apply("Java")); // Output: a
```

---

## **🟠 Medium (Intermediate) - Problems & Solutions**

### **1️⃣ Reverse a string**
```java
Function<String, String> reverse = str -> new StringBuilder(str).reverse().toString();
System.out.println(reverse.apply("Java")); // Output: avaJ
```

### **2️⃣ Remove vowels from a string**
```java
Function<String, String> removeVowels = str -> str.replaceAll("[AEIOUaeiou]", "");
System.out.println(removeVowels.apply("Functional")); // Output: Fnctnl
```

### **3️⃣ Convert list of integers to their squares**
```java
Function<List<Integer>, List<Integer>> squareList = list -> 
    list.stream().map(n -> n * n).collect(Collectors.toList());
System.out.println(squareList.apply(Arrays.asList(1, 2, 3, 4))); // Output: [1, 4, 9, 16]
```

...

---

## **🔴 Hard (Advanced) - Problems & Solutions**

### **1️⃣ Find the most frequent character in a string**
```java
Function<String, Character> mostFrequentChar = str -> 
    str.chars()
       .mapToObj(c -> (char) c)
       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
       .entrySet()
       .stream()
       .max(Map.Entry.comparingByValue())
       .get()
       .getKey();
System.out.println(mostFrequentChar.apply("javajava")); // Output: j (or a depending on input)
```

...

---

## **🔥 Very Hard, Tougher, and Toughest Challenges**

### **1️⃣ Most Toughest: Custom Function Pipeline**
```java
Function<String, String> pipeline = str -> str.trim().toUpperCase().replace(" ", "_");
System.out.println(pipeline.apply("  Java 8 Functional  "));
```

...

---

This document provides a complete deep dive into `Function<T, R>` with examples, problems, solutions, FAQs, and real-world use cases. 🚀

# Java 8 Functional Interfaces - Advanced Guide

## Overview
Java 8 introduced several powerful functional interfaces in `java.util.function` package. This guide covers:
- **BiFunction<T, U, R>**
- **UnaryOperator<T> & BinaryOperator<T>**
- **BiPredicate<T, U>**
- **BiConsumer<T, U>**
- **BiSupplier<T, U>**
- **Other Key Functional Interfaces**

Each section includes concepts, syntax, hands-on problems with solutions, and real-world examples.

---

## 1️⃣ BiFunction<T, U, R>
### **Concepts & Syntax**
- `BiFunction<T, U, R>` takes two arguments of types `T` and `U` and returns a result of type `R`.
- Useful when transforming two inputs into a single output.

```java
import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(5, 10)); // Output: 15
    }
}
```

### **Real-World Example**: Convert two lists into a Map
```java
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {
        List<String> keys = Arrays.asList("A", "B", "C");
        List<Integer> values = Arrays.asList(1, 2, 3);

        BiFunction<List<String>, List<Integer>, Map<String, Integer>> createMap = (k, v) -> {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < k.size(); i++) {
                map.put(k.get(i), v.get(i));
            }
            return map;
        };

        Map<String, Integer> result = createMap.apply(keys, values);
        System.out.println(result); // Output: {A=1, B=2, C=3}
    }
}
```

---

## 2️⃣ UnaryOperator<T> & BinaryOperator<T>
### **Concepts & Syntax**
- `UnaryOperator<T>` extends `Function<T, T>`, where input and output types are the same.
- `BinaryOperator<T>` extends `BiFunction<T, T, T>`, where both inputs and output are the same type.

```java
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;

public class OperatorExample {
    public static void main(String[] args) {
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(4)); // Output: 16

        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println(multiply.apply(3, 5)); // Output: 15
    }
}
```

### **Real-World Example**: Processing a List with UnaryOperator
```java
import java.util.*;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("john", "jane", "doe"));
        names.replaceAll(String::toUpperCase);
        System.out.println(names); // Output: [JOHN, JANE, DOE]
    }
}
```

---

## 3️⃣ BiPredicate<T, U>
### **Concepts & Syntax**
- `BiPredicate<T, U>` takes two arguments and returns a boolean.
- Used for testing conditions.

```java
import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
        BiPredicate<String, Integer> isLongEnough = (str, len) -> str.length() >= len;
        System.out.println(isLongEnough.test("Hello", 5)); // Output: true
    }
}
```

---

## 4️⃣ BiConsumer<T, U>
### **Concepts & Syntax**
- `BiConsumer<T, U>` takes two arguments and returns no result.
- Used when you want to perform an action without returning a value.

```java
import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String, Integer> printInfo = (name, age) -> System.out.println(name + " is " + age + " years old");
        printInfo.accept("Alice", 30);
    }
}
```

---

## 5️⃣ BiSupplier<T, U>
### **Concepts & Syntax**
- Java does not provide a predefined `BiSupplier<T, U>`, but it can be implemented manually using `Supplier<T>` returning a `Pair<T, U>`.

```java
import java.util.function.Supplier;

class Pair<T, U> {
    T first;
    U second;
    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

public class BiSupplierExample {
    public static void main(String[] args) {
        Supplier<Pair<String, Integer>> userSupplier = () -> new Pair<>("Alice", 25);
        System.out.println(userSupplier.get()); // Output: (Alice, 25)
    }
}
```

---

## 6️⃣ Other Key Functional Interfaces
| Interface          | Parameters  | Return Type | Example Use Case |
|--------------------|-------------|-------------|------------------|
| `Predicate<T>`    | 1           | boolean     | Filter data |
| `Function<T, R>`  | 1           | 1           | Transform data |
| `Consumer<T>`     | 1           | void        | Print values |
| `Supplier<T>`     | 0           | 1           | Generate random values |
| `BiFunction<T,U,R>` | 2         | 1           | Combine inputs |
| `BiPredicate<T,U>` | 2         | boolean     | Validate inputs |
| `BiConsumer<T,U>`  | 2         | void        | Logging |

---

## Conclusion
This guide covered various predefined functional interfaces in Java 8 with concepts, hands-on coding problems, and real-world use cases. Mastering these interfaces is essential for writing clean, functional, and expressive Java code.

🚀 **What’s Next?**
Would you like a deep dive into **Streams API** or **Reactive Programming with Project Reactor**?


