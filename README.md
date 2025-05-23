# SpringBoot-App-Personnel-GL2

---

## 📦 Fonctionnalités

- Création, consultation, modification et suppression d'employés
- Objets de transfert de données (DTOs) pour des échanges API propres
- Gestion centralisée des exceptions
- Mapping Entity-DTO via des classes Mapper
- Documentation Swagger UI interactive
- Architecture RESTful et évolutive

---

## 📂 Structure du projet

```
src/main/java/com/example/employeecrud
├── controller
│   └── EmployeeController.java
├── dto
│   ├── EmployeeRequest.java
│   ├── EmployeeResponse.java
│   └── ResponseApi.java
├── exception
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
├── mapper
│   └── EmployeeMapper.java
├── model
│   └── Employee.java
├── repository
│   └── EmployeeRepository.java
├── service
│   └── EmployeeService.java
└── config
    └── SwaggerConfig.java
```

---

## 📌 Objets de Transfert de Données (DTOs)

- **EmployeeRequest.java**  
  → Structure des données pour la création ou mise à jour d'un employé.

- **EmployeeResponse.java**  
  → Structure de la réponse renvoyée au client.

- **ResponseAPI.java**  
  → Wrapper générique contenant le statut, message et données associées.

---

## 🔄 Mappers

- **EmployeeMapper.java**  
  → Conversion entre l'entité `Employee` et les DTOs `EmployeeRequest` et `EmployeeResponse` pour une séparation claire entre la base et l'API.

---

## 🚨 Gestion Globale des Erreurs

- **GlobalExceptionHandler.java**  
  → Gestion centralisée des exceptions via `@ControllerAdvice` pour des erreurs uniformes.

- **ResourceNotFoundException.java**  
  → Exception personnalisée levée quand une ressource employé est introuvable.

---

## 📖 Documentation API

**Swagger UI** est activé pour explorer et tester vos endpoints REST.

### Accès Swagger :

```
http://localhost:8080/swagger-ui/index.html
```

**Technologie utilisée :**
- Springdoc OpenAPI 3 (ou springfox selon votre config)

### La Configuration Swagger

```java
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                    .title("API Gestion des Employés - TP4 Applications réparties GL2")
                    .description("Opérations CRUD sur les employés")
                    .version("1.0.0"));
    }
}
```

---

## 📌 Résumé des Endpoints

| Méthode | Endpoint               | Description                    |
|:----------|:------------------------|:--------------------------------|
| `GET`     | `/api/employees`         | Récupérer tous les employés     |
| `GET`     | `/api/employees/{id}`    | Récupérer un employé par ID     |
| `POST`    | `/api/employees`         | Créer un nouvel employé         |
| `PUT`     | `/api/employees/{id}`    | Modifier un employé existant    |
| `DELETE`  | `/api/employees/{id}`    | Supprimer un employé par ID     |

---

## 🚀 Démarrer le Projet

1. Cloner le dépôt

```bash
    //clone avec https
   git clone https://github.com/aymanabid10/SpringBoot-App-Personnel-GL2.git
   ```

2. Lancer :

   ```bash
   ./mvnw spring-boot:run
   ```
   ou lancer la classe `PersonnelApplication.java` avec l'IDE IntelliJ Idea
### 🚨 Remarque :
Assurer que les dependencies sont bien installés via le fichier ``pom.xml``
Aussi peut etre que l'application ne genère pas un build complet, pour résoudre, il suffit de faire un clean et un compile avec ``maven``

```bash
   mvn clean compile
   ```
Puis lancer une autre fois la classe ``PersonnelApplication.java``
3. Accéder à : `http://localhost:8080/swagger-ui/index.html` pour tester les APIs avec Swagger

---

## 📚 Technologies Utilisées

- Java 17+
- Spring Boot 3
- Spring Data JPA
- H2/MySQL
- MapStruct / Mappers
- Swagger / OpenAPI 3
- Lambok
- Maven
