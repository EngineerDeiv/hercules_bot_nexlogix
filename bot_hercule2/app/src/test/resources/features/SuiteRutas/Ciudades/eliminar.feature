# language: es
# autor: Leidy Fuentes

@DeleteCity
Característica: Eliminar ciudad existente
  Como administrador del sistema
  Quiero eliminar una ciudad
  Para quitarla del sistema permanentemente

  Escenario: Eliminar la ciudad de prueba
    Dado que busco la ciudad para eliminar
    Cuando hago click en el boton de eliminar ciudad
    Y confirmo la eliminacion de la ciudad en el modal
    Entonces Buscar la ciudad eliminada
    Y la ciudad ya no debe existir en el sistema
