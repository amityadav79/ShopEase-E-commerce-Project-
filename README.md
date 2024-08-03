# ShopEase

ShopEase is a full-featured, web-based e-commerce platform built using the Java stack. It provides a robust and scalable solution for managing products, orders, payments, and customer interactions. Whether you are a small business owner or a developer looking to create a sophisticated online store, ShopEase has the tools you need to get started.

## Features

- **User Management**: Secure authentication and role-based access control for Admin and Customer users.
- **Product Management**: Comprehensive CRUD operations for managing product listings, categories, and tags.
- **Order Management**: Efficient order processing, tracking, and management.
- **Payment Integration**: Support for various payment methods and secure transaction handling.
- **Shopping Cart and Wishlist**: Convenient shopping cart functionality for customers.

## Tech Stack

- **Backend**: Java, Hibernate
- **Frontend**: HTML, CSS, JavaScript, Thymeleaf
- **Database**: MySQL
- **Build Tool**: Maven
- **Version Control**: Git

## Getting Started

### Prerequisites

- Java 11 or higher
- MySQL 5.7 or higher
- Maven 3.6 or higher

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/ShopEase.git
    cd ShopEase
    ```

2. Set up the database:
    ```sql
    CREATE DATABASE shopease;
    CREATE USER 'shopeaseuser'@'localhost' IDENTIFIED BY 'password';
    GRANT ALL PRIVILEGES ON shopease.* TO 'shopeaseuser'@'localhost';
    FLUSH PRIVILEGES;
    ```

3. Configure application properties in `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/shopease
    spring.datasource.username=shopeaseuser
    spring.datasource.password=password
    ```

4. Build and run the application:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

5. Access the application at `http://localhost:8080`.

## Usage

- **Admin Portal**: Manage products, orders, and customer inquiries.
- **Customer Portal**: Browse products, place orders, and manage personal account information.

## Contributing

Contributions are welcome! Please read our [Contributing Guidelines](CONTRIBUTING.md) before submitting a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries or support, please contact [amityadav0579@gmail.com](mailto:amityadav0579@gmail.com).
