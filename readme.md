# 🔗 URL Shortener

A simple and efficient URL Shortener web application that converts long URLs into short, manageable links. Built using Spring Boot and MySQL, this project demonstrates backend development, REST API design, and database integration.

---

## 🚀 Features

* Convert long URLs into short URLs
* Redirect short URLs to original URLs
* Generate unique short codes using Base62 encoding
* Store and retrieve URLs from database
* REST API-based architecture
* Simple and user-friendly interface

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot (Java)
* **Database:** MySQL
* **Frontend:** HTML, CSS, JavaScript
* **Tools:** IntelliJ IDEA, Postman

---

## ⚙️ How It Works

1. User submits a long URL
2. Server generates a unique short code (Base62)
3. URL and short code are stored in the database
4. When user accesses the short URL:

    * Server fetches original URL
    * Redirects user to the original link

---

## 📡 API Endpoints

### 1. Shorten URL

```
POST /shorten
```

**Request Body:**

```
http://example.com/very-long-url
```

**Response:**

```
http://localhost:8080/{shortCode}
```

---

### 2. Redirect to Original URL

```
GET /{shortCode}
```

* Redirects to the original URL

---

## 💻 How to Run the Project

1. Clone the repository:

```
git clone https://github.com/manjumedhasree/url-shortener.git
```

2. Open in IntelliJ IDEA

3. Configure MySQL:

* Create a database (e.g., `url_shortener`)
* Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/url_shortener
spring.datasource.username=your_username
spring.datasource.password=your_password
```

4. Run the Spring Boot application

5. Open browser:

```
http://localhost:8080
```

---

## 📁 Project Structure

```
src/
 ├── controller/
 ├── service/
 ├── repository/
 ├── entity/
 └── UrlShortenerApplication.java
```

---

## 📌 Future Improvements

* Add user authentication
* Track number of clicks
* Expiry time for URLs
* Custom short URLs
* UI improvements

---

## 🙌 Acknowledgement

This project is built as part of learning backend development and system design concepts.

---

## 📧 Contact

For any queries or suggestions, feel free to reach out.

---

⭐ If you like this project, consider giving it a star!
