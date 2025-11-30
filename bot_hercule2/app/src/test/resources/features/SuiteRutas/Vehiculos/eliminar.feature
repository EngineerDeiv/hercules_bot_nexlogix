# language: es
# autor: Leidy Fuentes

@DeleteVehicle
Característica: Eliminar vehículo existente
  Como administrador del sistema
  Quiero eliminar un vehículo
  Para quitarlo del sistema permanentemente

  Escenario: Eliminar el vehículo de prueba
    Dado que busco el vehículo para eliminar
      Dado que el administrador ha iniciado sesión y está en el panel principal de Vehículos
    Cuando hago click en el boton de eliminar vehículo
    Y confirmo la eliminacion del vehículo en el modal
      Entonces Buscar la ciudad eliminada
      Y aqui el Vehiculo cudad ya no debe existir en el sistema
      Y si no da click el test debe fallar y no guardar ningun dato en Vehículos
