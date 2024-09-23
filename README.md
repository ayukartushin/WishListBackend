<pre>wishlist-app-backend/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── wishlistapp/
│   │   │               ├── WishlistAppApplication.java  # Основной класс запуска приложения
│   │   │               ├── config/                       # Конфигурации Spring и других библиотек
│   │   │               │   ├── SwaggerConfig.java
│   │   │               │   ├── SecurityConfig.java (если потребуется)
│   │   │               ├── controller/                   # REST контроллеры
│   │   │               │   ├── UserController.java
│   │   │               │   ├── WishlistController.java
│   │   │               │   └── WishlistItemController.java
│   │   │               ├── dto/                           # Data Transfer Objects
│   │   │               │   ├── UserDTO.java
│   │   │               │   ├── WishlistDTO.java
│   │   │               │   └── WishlistItemDTO.java
│   │   │               ├── entity/                        # Сущности базы данных
│   │   │               │   ├── User.java
│   │   │               │   ├── Wishlist.java
│   │   │               │   └── WishlistItem.java
│   │   │               ├── repository/                    # Репозитории для доступа к данным
│   │   │               │   ├── UserRepository.java
│   │   │               │   ├── WishlistRepository.java
│   │   │               │   └── WishlistItemRepository.java
│   │   │               ├── service/                       # Сервисы с бизнес-логикой
│   │   │               │   ├── UserService.java
│   │   │               │   ├── WishlistService.java
│   │   │               │   └── WishlistItemService.java
│   │   │               ├── exception/                     # Обработка исключений
│   │   │               │   ├── GlobalExceptionHandler.java
│   │   │               │   └── CustomException.java
│   │   │               ├── util/                          # Утилиты и вспомогательные классы
│   │   │               │   ├── JwtUtil.java
│   │   │               │   └── PasswordUtil.java
│   │   ├── resources/
│   │   │   ├── application.properties                    # Конфигурации приложения
│   │   │   ├── application-local.properties              # Конфигурация для локальной среды
│   │   │   ├── application-dev.properties                # Конфигурация для среды разработки
│   │   │   ├── application-prod.properties               # Конфигурация для продакшена
│   │   │   ├── static/                                 # Статические файлы (если необходимы)
│   │   │   └── templates/                              # Шаблоны (если необходимы)
│   │   │   └── log4j2.xml                              # Конфигурация Log4j2
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── wishlistapp/
│       │               ├── controller/                   # Тесты контроллеров
│       │               │   ├── UserControllerTest.java
│       │               │   ├── WishlistControllerTest.java
│       │               │   └── WishlistItemControllerTest.java
│       │               ├── service/                       # Тесты сервисов
│       │               │   ├── UserServiceTest.java
│       │               │   ├── WishlistServiceTest.java
│       │               │   └── WishlistItemServiceTest.java
│       │               └── repository/                    # Тесты репозиториев
│       │                   ├── UserRepositoryTest.java
│       │                   ├── WishlistRepositoryTest.java
│       │                   └── WishlistItemRepositoryTest.java
│       └── resources/
│           └── application-test.properties               # Конфигурации для тестов
│
├── .gitignore
├── pom.xml                                              # Файл конфигурации Maven
└── README.md</pre>