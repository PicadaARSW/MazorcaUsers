# Mazorca Users Microservice - WhereWeApp

Este microservicio es responsable de la gestión de los usuarios dentro de la aplicación **WhereWeApp**. Utiliza Spring Boot y MongoDB para almacenar y gestionar la información de los usuarios de manera eficiente.

---

## 🧩 Tipo de Microservicio

- **Dominio**: Gestión de usuarios
- **Base de datos**: MongoDB
- **Framework**: Spring Boot
- **Arquitectura**: RESTful + DTO + Swagger
- **Transporte**: HTTP REST
- **Otros servicios relacionados**: Microservicio de grupos (`PapaGroups`)

---

## 📦 Endpoints

> Todos los endpoints están bajo el prefijo `/api/v1/users`.

### POST `/`
Crea un nuevo usuario. El cuerpo debe contener:
```json
{
  "userFirstName": "John",
  "userFullName": "John Doe",
  "userEmail": "john.doe@example.com",
  "userTimeZone": "America/New_York"
}
```

### GET `/`
Obtiene todos los usuarios.

### GET `/{id}`
Obtiene los detalles de un usuario específico por ID.

---

## 📄 Modelo de datos (`User`)

```json
{
  "id": "507f1f77bcf86cd799439011",
  "userFirstName": "John",
  "userFullName": "John Doe",
  "userEmail": "john.doe@example.com",
  "userTimeZone": "America/New_York"
}
```

---

## ✅ Cobertura de Pruebas - JaCoCo


### Generar reporte:
```bash
mvn clean verify
```

Reporte HTML generado en:  
`/target/site/jacoco/index.html`

![image](https://github.com/user-attachments/assets/4068058b-3cd0-46fe-b2e8-60eafca9126d)

---

## 📊 Análisis de Calidad - SonarCloud


Incluye:
- Cobertura de JaCoCo
- Reglas de calidad
- Análisis estático (bugs, code smells, duplicación)


![image](https://github.com/user-attachments/assets/abd91f26-0abc-482b-a710-0824d81cdafb)

---

## 📌 Consideraciones

- El servicio gestiona usuarios, permitiendo crear nuevos usuarios, obtener todos los usuarios, y obtener un usuario específico por ID.
- Todos los servicios están documentados con anotaciones de Swagger/OpenAPI.
- El `UserService` se encarga de gestionar las operaciones de creación y recuperación de usuarios en la base de datos MongoDB.

---

## 👨‍💻 Equipo de Desarrollo

- **Team Picada ARSW 2025**
- 📧 picadaarsw2025@outlook.com

---
