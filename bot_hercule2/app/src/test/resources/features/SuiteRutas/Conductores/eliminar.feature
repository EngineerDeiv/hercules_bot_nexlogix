# language: es
# autor: Leidy Fuentes

@DeleteDriver
Característica: Eliminar conductor existente
  Como administrador del sistema
  Quiero eliminar un conductor
  Para quitarlo del sistema permanentemente

  Escenario: Eliminar el conductor de prueba
    Dado que busco el conductor para eliminar
    Cuando hago click en el boton de eliminar conductor
    Y confirmo la eliminacion del conductor en el modal
    Entonces Buscar el conductor eliminado
    Y el conductor ya no debe existir en el sistema
