# language: es
# autor: Brandon Gonzalez

@UpdateUser
Característica: Editar usuario existente
  Como administrador del sistema
  Quiero editar la información de un usuario
  Para mantener los datos actualizados

  Escenario: Editar información de un usuario
    Dado que el administrador ha buscado al usuario "xxxx"
    Cuando selecciona la opción de editar usuario
    Y actualiza la información del usuario
    Entonces los datos del usuario "xxxx" deben quedar actualizados en el sistema