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
```

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

## **🔴 Hard (Advanced) - Solutions**

_To be added

