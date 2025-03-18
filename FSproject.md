# Full-Stack Application Development and Deployment on AWS (Free Tier)

## **Architecture Overview**
The application follows a **microservices architecture** with the following components:
1. **Auth Service** - Handles user authentication (Spring Boot, JWT, MySQL)
2. **Task Service** - Manages tasks (Spring Boot, MySQL)
3. **API Gateway** - Routes API requests (Spring Cloud Gateway)
4. **React Frontend** - UI (React, Redux, Axios)
5. **MySQL Database** - Stores user and task data
6. **Docker & Kubernetes** - Containerization & orchestration
7. **Jenkins & CI/CD** - Automates deployment on AWS

---

## **Step 1: Setup Backend Microservices**

### **1.1: Create `auth-service` (Authentication Service)**
1. **Generate Spring Boot Project** with dependencies:
   - Spring Web
   - Spring Security
   - Spring Data JPA
   - MySQL Driver
   - JWT
2. **Configure `application.properties`**:
   ```properties
   server.port=8081
   spring.datasource.url=jdbc:mysql://localhost:3306/auth_db
   spring.datasource.username=root
   spring.datasource.password=root
   ````
3. **Create `User` Entity**
   ```java
   @Entity
   public class User {
       @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String email;
       private String password;
   }
   ```
4. **Implement JWT Authentication**
5. **Expose API Endpoints** for user registration and login

### **1.2: Create `task-service` (Task Management Service)**
1. **Generate Spring Boot Project** with dependencies:
   - Spring Web
   - Spring Data JPA
   - MySQL Driver
2. **Configure `application.properties`**
3. **Create `Task` Entity**
   ```java
   @Entity
   public class Task {
       @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String title;
       private String description;
   }
   ```
4. **Implement Task API CRUD Operations**

---

## **Step 2: API Gateway Implementation**
1. **Generate Spring Boot Project** with dependencies:
   - Spring Cloud Gateway
   - Eureka Client
2. **Configure API Gateway**
   ```yaml
   spring:
     cloud:
       gateway:
         routes:
           - id: auth-service
             uri: http://localhost:8081
             predicates:
               - Path=/auth/**
           - id: task-service
             uri: http://localhost:8082
             predicates:
               - Path=/tasks/**
   ```
3. **Implement JWT Authorization Filter**
4. **Run API Gateway** on port `8080`

---

## **Step 3: React Frontend Development**
1. **Create React Project**:
   ```bash
   npx create-react-app task-manager
   ```
2. **Install Dependencies**:
   ```bash
   npm install redux react-redux axios react-router-dom jwt-decode
   ```
3. **Setup Redux Store** for authentication
4. **Create Login & Task Components**
5. **Implement API Calls with Axios**
6. **Setup React Router** for navigation

---

## **Step 4: Dockerize Microservices**
1. **Create Dockerfile for `auth-service`**:
   ```dockerfile
   FROM openjdk:17
   COPY target/auth-service.jar app.jar
   ENTRYPOINT ["java", "-jar", "app.jar"]
   ```
2. **Repeat for `task-service` and `api-gateway`**
3. **Build and Run Containers**:
   ```bash
   docker build -t auth-service .
   docker run -p 8081:8081 auth-service
   ```

---

## **Step 5: Deploy with Kubernetes**
1. **Create Kubernetes Deployments for Services**
   ```yaml
   apiVersion: apps/v1
   kind: Deployment
   metadata:
     name: auth-service
   spec:
     replicas: 2
     template:
       spec:
         containers:
         - name: auth-service
           image: auth-service:latest
   ```
2. **Create Kubernetes Services**
3. **Deploy to Minikube or AWS EKS**

---

## **Step 6: Setup CI/CD with Jenkins**
1. **Install Jenkins on AWS EC2**
2. **Configure Jenkins Pipeline**
3. **Automate Build, Test, and Deployment**

---

## **Step 7: Deploy on AWS Free Tier**
1. **Create AWS EC2 & RDS for MySQL**
2. **Deploy Microservices on EC2**
3. **Use AWS EKS for Kubernetes**
4. **Configure AWS Load Balancer**

---

## **Final Outcome**
🎯 **A fully deployed, scalable task management application with microservices architecture running on AWS Free Tier!**

