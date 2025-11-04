# language: es
# autor: Brandon Gonzalez

@AssignVehiculeDriverForRoutersAndCheck
Característica: Asignación de vehículo con conductor a ruta existente
  Como administrador de rutas
  Quiero asignar un vehículo con conductor ya asociado a una ruta existente
  Para validar que la asignación se haya realizado correctamente

  Escenario: Asignar vehículo con conductor a una ruta existente correctamente
    Dado el usuario es administrador y está autenticado en el sistema
    Dado que se encuentra en el módulo "Gestión Logística"
    Dado que navega hasta la sección "Rutas" mostrando la lista de rutas existentes
    Cuando asigna el vehículo con conductor a la ruta existente
    Entonces la ruta muestra que el vehículo con conductor ha sido asignado correctamente y debe quedar registrada en el sistema