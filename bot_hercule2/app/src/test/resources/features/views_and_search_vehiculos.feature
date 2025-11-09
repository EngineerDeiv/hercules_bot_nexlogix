# language: es
# autor: Brandon Gonzalez

@ViewAndSearchVehicle
Característica: Ver y buscar vehículos existentes
  Como administrador de logística
  Quiero poder ver y buscar vehículos existentes
  Para validar que puedo acceder a la información del vehículo correctamente

  Escenario: Visualizar y buscar varios vehículos por placa correctamente
    Dado el usuario es administrador y está autenticado en el sistema
    Dado que se encuentra en el módulo "Gestión Logística"
  Dado que navega hasta la sección "Vehículos"
    Cuando busca varias placas de vehiculos de la lista
  Entonces el sistema muestra los detalles del vehículo seleccionado correctamente
