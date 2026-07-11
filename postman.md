Below is the complete list of your REST APIs with the **HTTP method**, **URL**, and **sample request body** where applicable.

> **Base URL**
>
> ```text
> http://localhost:8080/api/todos
> ```

---

# 1. Create Todo

### HTTP Method

```text
POST
```

### URL

```text
http://localhost:8080/api/todos
```

### Request Body

```json
{
    "todoName": "Complete Spring Boot Assignment",
    "todoDescription": "Develop REST APIs using Spring Boot and H2 Database",
    "status": "PENDING",
    "priority": "HIGH",
    "type": "WORK",
    "dueDate": "2026-07-15",
    "categoryId": 2
}
```

---

# 2. Get All Todos

### HTTP Method

```text
GET
```

### URL

```text
http://localhost:8080/api/todos
```

---

# 3. Get Todo By ID

### HTTP Method

```text
GET
```

### URL

```text
http://localhost:8080/api/todos/1
```

---

# 4. Update Todo

### HTTP Method

```text
PUT
```

### URL

```text
http://localhost:8080/api/todos/1
```

### Request Body

```json
{
    "todoName": "Complete Spring Boot Project",
    "todoDescription": "Finish CRUD APIs with Validation",
    "status": "COMPLETED",
    "priority": "HIGH",
    "type": "WORK",
    "dueDate": "2026-07-20",
    "categoryId": 2
}
```

---

# 5. Delete Todo

### HTTP Method

```text
DELETE
```

### URL

```text
http://localhost:8080/api/todos/1
```

---

# 6. Get Todos By Status

### HTTP Method

```text
GET
```

### URL

```text
http://localhost:8080/api/todos/status/PENDING
```

or

```text
http://localhost:8080/api/todos/status/COMPLETED
```

---

# 7. Get Todos By Priority

### HTTP Method

```text
GET
```

### URL

```text
http://localhost:8080/api/todos/priority/HIGH
```

Available values

```text
LOW
MEDIUM
HIGH
```

---

# 8. Get Todos By Type

### HTTP Method

```text
GET
```

### URL

```text
http://localhost:8080/api/todos/type/WORK
```

Available values

```text
PERSONAL
WORK
OTHER
```

---

# 9. Get Todos By Category

### HTTP Method

```text
GET
```

### URL

```text
http://localhost:8080/api/todos/category/Office
```

Examples

```text
Home
Office
School
Shopping
Health
```

---

# 10. Get Todos By Due Date Range

### HTTP Method

```text
GET
```

### URL

```text
http://localhost:8080/api/todos/due-date?start=2026-07-01&end=2026-07-31
```

---

# Sample Test Data

| Todo                            | Status    | Priority | Type     | Category |
| ------------------------------- | --------- | -------- | -------- | -------- |
| Complete Spring Boot Assignment | PENDING   | HIGH     | WORK     | Office   |
| Buy Groceries                   | PENDING   | MEDIUM   | PERSONAL | Shopping |
| Morning Workout                 | COMPLETED | HIGH     | PERSONAL | Health   |
| Java Interview Preparation      | PENDING   | HIGH     | WORK     | Office   |
| Read Spring Security            | PENDING   | LOW      | OTHER    | School   |
| Pay Electricity Bill            | COMPLETED | MEDIUM   | PERSONAL | Home     |

---

# Postman Collection Summary

| Method | Endpoint                                      | Body Required |
| ------ | --------------------------------------------- | ------------- |
| POST   | `/api/todos`                                  | ✅ Yes         |
| GET    | `/api/todos`                                  | ❌ No          |
| GET    | `/api/todos/{id}`                             | ❌ No          |
| PUT    | `/api/todos/{id}`                             | ✅ Yes         |
| DELETE | `/api/todos/{id}`                             | ❌ No          |
| GET    | `/api/todos/status/{status}`                  | ❌ No          |
| GET    | `/api/todos/priority/{priority}`              | ❌ No          |
| GET    | `/api/todos/type/{type}`                      | ❌ No          |
| GET    | `/api/todos/category/{category}`              | ❌ No          |
| GET    | `/api/todos/due-date?start={start}&end={end}` | ❌ No          |

### Suggestion

Since you're building this as an interview project, I recommend also creating:

* A **Postman Collection (v2.1 JSON)** with all APIs preconfigured.
* A **Swagger/OpenAPI** configuration so you can test the APIs directly from a browser using `/swagger-ui/index.html`.

These additions make the project look much more polished and are commonly appreciated in interviews.
