# 🌈 LesVivienda - Backend

## 💜 Descripción del Proyecto
Este backend soporta la web LesVivienda, una plataforma social y autogestionada para facilitar el acceso justo y seguro a la vivienda a mujeres lesbianas y bisexuales en un modelo de co-habitatge.  

Su función principal es gestionar la autenticación, el almacenamiento de datos, encuestas, perfiles de usuarias y mensajes del formulario de contacto, protegiendo la información con buenas prácticas de seguridad.

---

## 🛠 Tecnologías Utilizadas

- Node.js  
- Express.js  
- PostgreSQL como base de datos relacional 🐘  
- Sequelize ORM para manejar la base de datos  
- JWT para autenticación y manejo de sesiones 🔐  
- bcrypt para el hash de contraseñas 🔒  
- Validación de datos con librerías como Joi o express-validator ✔️  
- ReCAPTCHA en endpoints para evitar spam  
- CORS configurado para conexión segura con el frontend  

---

## 🚀 Cómo Ejecutar el Proyecto

1. Clona este repositorio:
   ```bash
   git clone https://github.com/GuadalupeSchajris/lesvivienda-backend.git
Instala las dependencias:

bash
Copiar
Editar
npm install
Configura las variables de entorno (crea un archivo .env con las siguientes variables):

ini
Copiar
Editar
PORT=4000
DATABASE_URL=postgres://usuario:password@localhost:5432/lesvivienda
JWT_SECRET=tu_secreto_jwt
RECAPTCHA_SECRET=tu_clave_recaptcha
Asegúrate de tener PostgreSQL instalado y en funcionamiento, y crea la base de datos lesvivienda.
Puedes crearla con el comando:

bash
Copiar
Editar
createdb lesvivienda
Ejecuta las migraciones y seeders (si aplican) para preparar la base de datos.

Levanta el servidor en modo desarrollo:

bash
Copiar
Editar
npm run dev
El backend correrá por defecto en http://localhost:4000.

🔗 Conexión con el Frontend
El frontend (React) está configurado para hacer peticiones a este backend en http://localhost:4000.

Asegúrate que el backend permita CORS para el dominio donde corre el frontend (localhost:5173 en desarrollo).

El frontend consume los endpoints para:

Autenticación (login, registro, logout)

Gestión de perfiles de usuarias

Envío y recepción de datos de encuestas (Propuestas y Demandas)

Formulario de contacto con validación y protección ReCAPTCHA

El token JWT generado en el backend es almacenado en el frontend para proteger rutas privadas (como Perfil).

🔐 Seguridad y Buenas Prácticas
Hash de contraseñas con bcrypt para máxima seguridad.

Autenticación mediante JWT para proteger rutas sensibles.

Validación estricta de datos recibidos para evitar inyecciones o datos erróneos.

Protección contra spam y bots con ReCAPTCHA en formularios.

Uso de HTTPS (configurable en producción) para mantener la comunicación segura.

👩‍💻 Sobre la Autora
Guadalupe Hani Schajris
Product Owner & Fullstack Developer

GitHub: https://github.com/GuadalupeSchajris

LinkedIn: https://www.linkedin.com/in/guadalupe-hani/

¡Gracias por apoyar LesVivienda! 💖
Este backend es la columna vertebral que permite un acceso seguro y solidario a la vivienda para mujeres lesbianas y bisexuales.
