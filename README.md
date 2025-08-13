# MapMyTour

MapMyTour is a simple **Spring Boot REST API** for managing tour packages.  
It allows users to create, view, and retrieve tours by ID, with built-in validation and error handling.

---

## 🚀 Features

- **Create Tour Package**  
- **List All Tour Packages**  
- **Get Tour Package by ID**  
- **Validation** for required fields  
- **Global Exception Handling** for clean error responses  

---

## 🛠️ Tech Stack

- **Java 17** (or compatible)
- **Spring Boot** (REST API, JPA, Validation)
- **PostgreSQL** (Database)
- **Lombok** (Boilerplate reduction)
- **Maven** (Dependency management)

---

## 📂 Project Structure

```
src/main/java/com/api/mapmytour
│── MapMyTourApplication.java         # Main Spring Boot application
│
├── Controller
│   └── TourController.java           # REST endpoints
│
├── Dto
│   ├── TourRequest.java               # DTO for incoming requests
│   └── TourResponse.java              # DTO for outgoing responses
│
├── Entity
│   └── Tour.java                      # JPA entity for Tour
│
├── Repository
│   └── TourRepo.java                  # Spring Data JPA repository
│
├── ServiceLayer
│   └── TourService.java               # Business logic layer
│
├── common
│   └── GlobalExceptionHandler.java    # Handles validation & runtime errors
│
└── Exception
    └── TourNotFoundException.java     # Custom exception
```

---

## ⚙️ Installation & Setup

### 1️⃣ Clone the repository
```bash
git clone https://github.com/photon05/MapMyTour.git
cd MapMyTour
```

### 2️⃣ Configure PostgreSQL
Create a PostgreSQL database:
```sql
CREATE DATABASE mapmytour;
```

Update **`src/main/resources/application.properties`**:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mapmytour
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### 3️⃣ Build & Run
```bash
mvn clean install
mvn spring-boot:run
```

---

## 📌 API Endpoints

### 1️⃣ Create a Tour Package
**POST** `/api/tours`
```json
{
  "image": "https://images.unsplash.com/photo-1598275277521-1885382d523a",
  "discountInPercentage": "17%",
  "title": "Himalayan Trek Adventure",
  "description": "14-day trek through the Himalayas",
  "duration": "14Days/13Nights",
  "actualPrice": "$1200",
  "discountedPrice": "$1000"
}
```

**Response:**
```json
{
  "id": 1,
  "title": "Himalayan Trek Adventure",
  "duration": "14Days/13Nights",
  "discountedPrice": "$1000"
}
```

---

### 2️⃣ Get All Tours
**GET** `/api/tours`

---

### 3️⃣ Get Tour by ID
**GET** `/api/tours/{id}`

---

## 🛡️ Validation & Error Handling

- **Validation** ensures all required fields are provided.
- If a tour is not found, a `TourNotFoundException` is thrown and handled by the `GlobalExceptionHandler`.

---

## 📜 License

This project is licensed under the MIT License.  
Feel free to use and modify it for your needs.

---
