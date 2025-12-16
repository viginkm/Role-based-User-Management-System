Role-Based User Management System (Spring Boot + Angular)

A full-stack application implementing JWT Authentication, Role-Based Authorization, Admin/User access control, and Angular UI for login, product viewing, and user creation (Admin-only).
This project demonstrates secure backend-frontend integration with modern development practices

📌 Features
Backend (Spring Boot + MongoDB)
•	✔️ JWT Authentication (Login + Token Validation)
•	✔️ Role-Based Authorization using Spring Security
•	✔️ Admin Role:
o	Create new users
o	Access all /users/** endpoints
•	✔️ User Role:
o	Read-only access to product APIs
•	✔️ Global CORS configuration
•	✔️ Password hashing using BCrypt
•	✔️ Structured controller-service-repository architecture
•	✔️ MongoDB database integration


Frontend (Angular + Bootstrap)
•	✔️ Login page with authentication
•	✔️ Token Interceptor to attach JWT to all requests
•	✔️ Route Guards:
o	AuthGuard: Protects private routes
o	RoleGuard: Restricts pages based on user role
•	✔️ Create User page (Admin only)
•	✔️ Auto-redirect if non-admin tries to access Admin routes
•	✔️ Logout from navigation bar
•	✔️ Clean UI (Bootstrap)
