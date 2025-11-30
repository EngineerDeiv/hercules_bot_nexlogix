# language: es
# autor: Leidy Fuentes

@DeleteVehicle
Característica: Eliminar vehículo existente
  Como administrador del sistema
  Quiero eliminar un vehículo
  Para quitarlo del sistema permanentemente

  Escenario: Eliminar el vehículo de prueba
    Dado que busco el vehículo para eliminar
    Cuando hago click en el boton de eliminar vehículo
    Y confirmo la eliminacion del vehículo en el modal
    Entonces Buscar el vehículo eliminado
    Y el vehículo ya no debe existir en el sistema
