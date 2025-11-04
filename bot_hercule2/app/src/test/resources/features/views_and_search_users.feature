# language: es
# autor: Brandon Gonzalez

@ViewAndSearchUser
Característica: Ver y buscar usuarios existentes
  Como administrador del sistema
  Quiero poder ver y buscar usuarios existentes
  Para validar que puedo acceder a la información del usuario correctamente

  Escenario: Visualizar y buscar un usuario existente correctamente
    Dado el usuario es administrador y está autenticado en el sistema
    Dado que se encuentra en el módulo "Administración"
    Dado que navega hasta la sección "Usuarios" mostrando la lista de usuarios existentes
    Cuando busca un usuario específico por su ID, email o número de identidad
    Entonces el sistema muestra los detalles del usuario seleccionado correctamente
