![Logo de AstraFly](src/vista/imagenes)

# ✈️ AstraFly

**Sistema de Reservas de Vuelos** — Aplicación de escritorio para la gestión administrativa de vuelos, reservas y usuarios.

![Version](https://img.shields.io/badge/versi%C3%B3n-1.0.0-blue)
![Java](https://img.shields.io/badge/Java-25-orange)
![MySQL](https://img.shields.io/badge/MySQL-JDBC-4479A1)

---

## 📋 Descripción

AstraFly es una aplicación de escritorio desarrollada en Java para facilitar la gestión administrativa de vuelos y reservas. El sistema permite centralizar y organizar la información, proporcionando herramientas para registrar, consultar, modificar y eliminar datos de manera sencilla y eficiente.

## 🎯 Propósito

Optimizar la administración de vuelos y reservas mediante una interfaz intuitiva que permita al personal autorizado acceder y gestionar la información desde un único sistema.

## 🚀 Funcionalidades

- **Gestión de Vuelos**: registrar, buscar, editar y eliminar vuelos (número, aerolínea, origen, destino, fecha, hora y precio).
- **Gestión de Reservas**: administrar reservas asociadas a usuarios y vuelos, con código de reserva, estado (confirmada/pendiente) y precio pagado.
- **Gestión de Usuarios**: administración de las cuentas del sistema.
- **Autenticación**: sistema de login que restringe el acceso a las funcionalidades principales mediante credenciales.
- **Búsqueda dinámica**: filtros de búsqueda por distintos criterios (número, código, etc.) en cada módulo.

## 🖼️ Capturas de pantalla

| Login | Vuelos |
|---|---|
| Pantalla de inicio de sesión | Administración de vuelos |

| Reservas | Acerca de |
|---|---|
| Administración de reservas | Información del sistema |

## 🏗️ Arquitectura

El proyecto sigue una arquitectura por capas (Modelo - Vista - Controlador):

```
ProyectoFinal-Equipo2/
├── Controladores/          # Lógica de control (Login, Reservas, User, Vuelos)
├── Modelos/                 # Entidades y DAOs (Reservas, User, Vuelo)
├── login/                    # Pantalla y fondo de inicio de sesión
├── vista/                    # Vistas principales (Login, Menu, Acerca de)
│   ├── PanelesAdmin/          # Paneles de administración (Vuelos, Reservas, Usuarios)
│   ├── PanelesAdmin.ventanas/ # Diálogos (Reservas, Usuarios, Vuelo)
│   └── imagenes/              # Recursos gráficos e íconos
├── swing/                     # Componentes UI personalizados (Button, PasswordField, TextField, etc.)
├── raven/                     # Utilidades de UI (bordes, scrollbars)
├── shadow/                    # Renderizado de sombras
├── proyectofinal_equipo2/     # Conexión a base de datos (ConexionDB, script SQL)
└── Main.java                  # Punto de entrada de la aplicación
```

## 🛠️ Tecnologías utilizadas

- **Lenguaje**: Java 25
- **Interfaz gráfica**: Java Swing
- **Base de datos**: MySQL
- **Librerías**:
  - `mysql-connector-j` — conector JDBC para MySQL
  - `flatlaf` / `flatlaf-extras` — Look and Feel moderno
  - `jsvg` — soporte de gráficos SVG
  - `AbsoluteLayout` — manejo de layouts
  - `TimingFramework` — animaciones
  - `common-image` — utilidades de manejo de imágenes

## ⚙️ Requisitos previos

- JDK 25 o superior
- MySQL Server instalado y en ejecución
- IDE compatible con Java (NetBeans, IntelliJ IDEA, VS Code, etc.)

## 📦 Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/edujm25/ProyectoFinal-Equipo2_Programacion1.git
   ```
2. Importa el proyecto en tu IDE de preferencia.
3. Crea la base de datos ejecutando el script `AstroFlyBD.sql` incluido en el proyecto.
4. Configura los datos de conexión en `ConexionDB.java` (host, usuario, contraseña y nombre de la base de datos).
5. Asegúrate de que todas las librerías del directorio `Libraries` estén correctamente referenciadas en el proyecto.
6. Ejecuta la clase `Main.java` para iniciar la aplicación.

## 👥 Autores

- **Edwis Jimenez Mercedes** — [edujm25](https://github.com/edujm25)
- **Shing Roxber Cruz Carbajal** — [Shing999](https://github.com/Shing999)

## 🏫 Institución

Instituto Tecnológico de las Américas (ITLA) · 2026

## 🔗 Repositorio

[https://github.com/edujm25/ProyectoFinal-Equipo2_Programacion1](https://github.com/edujm25/ProyectoFinal-Equipo2_Programacion1)

## 📧 Contacto

- edwisjimenezm25@gmail.com
- shing999c@gmail.com

---

<p align="center">Hecho con ✈️ por el Equipo 2</p>
