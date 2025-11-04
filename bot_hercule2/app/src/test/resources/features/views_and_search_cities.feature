# language: es
# autor: Brandon Gonzalez

@ViewAndSearchCity
Característica: Ver y buscar ciudades existentes
  Como administrador de rutas
  Quiero poder ver y buscar ciudades existentes
  Para validar que puedo acceder a la información de la ciudad correctamente

  Escenario: Visualizar y buscar una ciudad existente correctamente
    Dado el usuario es administrador y está autenticado en el sistema
    Dado que se encuentra en el módulo "Gestión Logística"
    Dado que navega hasta la sección "Ciudades" mostrando la lista de ciudades existentes
    Cuando busca una ciudad específica por su nombre
    Entonces el sistema muestra los detalles de la ciudad seleccionada correctamente
