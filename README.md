# N.O.V.A — Inventory Management Dashboard.

![Java](https://img.shields.io/badge/Java-17+-007396?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15+-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-ES6+-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)

**iTechStore Dashboard** es una aplicación Full-Stack de gestión de inventarios diseñada bajo una **arquitectura desacoplada** y enfocada en la alta mantenibilidad, integridad de datos relacionales y estándares RESTful. Cuenta con una interfaz gráfica moderna, consumo asíncrono mediante `fetch` API y persistencia en base de datos relacional.

---

## UI & Design System.

El diseño fue desarrollado desde cero utilizando clases CSS personalizadas para garantizar la ligereza y rapidez de carga del frontend.

---

## Tech Stack & Arquitectura.

### **Backend (REST API)**
* **Java 17+** & **Spring Boot**
* **Spring Data JPA / Hibernate:** Mapeo objeto-relacional (ORM) y gestión de persistencia.
* **Jakarta Validation:** Validaciones de integridad en los DTOs/Entidades (`@Valid`, `@RequestBody`).
* **CORS Management:** Configuración del puerto servidor a servidor mediante `@CrossOrigin`.

### **Database**
* **PostgreSQL:** Garantiza la integridad referencial (relación Entidad-Relación 1:N entre Categorías y Productos).

### **Frontend**
* **HTML5 Semantic & Modern CSS3 (Grid + Flexbox)**
* **Vanilla JavaScript (ES6+ Async/Await):** Manejo dinámico del DOM y peticiones HTTP asíncronas.

---

## API Endpoints

La API REST del servidor opera sobre la ruta base `/api/products`:

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| **GET** | `/api/products` | Obtiene la lista completa de productos |
| **POST** | `/api/products` | Registra un nuevo producto |
| **PUT** | `/api/products/{id}` | Actualiza los datos de un producto existente |
| **DELETE** | `/api/products/{id}` | Elimina un producto por su ID referencial |
| **GET** | `/api/products/stock/{quantity}` | Filtra productos según el umbral de stock |

---

## Estructura del Proyecto (Arquitectura Desacoplada)

El sistema está preparado para el despliegue independiente del cliente (Frontend) y servidor (Backend):

```text
itechstore/
├── backend/ (Spring Boot + PostgreSQL)
│   ├── src/main/java/com/itechstore/platform/
│   │   ├── controller/      # ProductController.java (REST API Endpoints)
│   │   ├── model/           # Entidades JPA (Product, Category)
│   │   ├── repository/      # Interfaces Spring Data JPA
│   │   └── service/         # Lógica de negocio (ProductService)
│   └── src/main/resources/
│       └── application.properties
│
└── frontend/ (Client Dashboard)
    ├── index.html           # Estructura del dashboard
    ├── Style.css            # Sistema de estilos Dark Mode
    └── app.js               # Lógica de consumo de API (Fetch & DOM)
