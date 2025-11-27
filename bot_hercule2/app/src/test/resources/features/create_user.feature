# language: es
# autor: Brandon Gonzalez

@CreateUser
Característica: Crear nuevo usuario en Nexlogix
  Como administrador del sistema
  Quiero poder crear nuevos usuarios
  Para dar acceso a nuevas personas al sistema

  Escenario: Crear un usuario exitosamente con datos válidos
    Dado que el administrador ha iniciado sesión y está en el panel principal
    Cuando navega a la sección de creación de usuarios
    Y ingresa los datos del nuevo usuario
      | Nombre             | Email                         | Rol     |
      | Mauricio Canavirez | 89aszgoooooozzzzzzz@gmail.com | Manager |
    Entonces el usuario debe ser creado exitosamente y aparecer en la lista