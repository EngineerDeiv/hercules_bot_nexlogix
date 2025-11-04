# language: es
# autor: Brandon Gonzalez

@ViewAndSearchRoute
Característica: Ver y buscar una ruta existente
  Como administrador de rutas
  Quiero poder ver y buscar rutas existentes
  Para validar que puedo acceder a la información de la ruta correctamente

  Escenario: Visualizar y buscar una ruta existente correctamente
    Dado el usuario es administrador y está autenticado en el sistema
    Dado que se encuentra en el módulo "Gestión Logística"
    Dado que navega hasta la sección "Rutas" mostrando la lista de rutas existentes
    Cuando busca una ruta específica por su nombre o ID
    Entonces el sistema muestra los detalles de la ruta seleccionada correctamente
