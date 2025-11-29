# language: es
# autor: Brandon Gonzalez

@DeleteUser
Característica: Eliminar usuario existente
  Como administrador del sistema
  Quiero eliminar un usuario
  Para quitarlo del sistema permanentemente

  Escenario: Eliminar el usuario de prueba
    Dado que busco el usuario para eliminar
    Cuando hago click en el boton de eliminar
    Y confirmo la eliminacion en el modal
    Entonces Buscar el usuario eliminado
    Y el usuario ya no debe existir en el sistema
