# language: es
# autor: Brandon Gonzalez

@ViewAndSearchDriver
Característica: Ver y buscar conductores existentes
  Como administrador de rutas
  Quiero poder ver y buscar conductores existentes
  Para validar que puedo acceder a la información del conductor correctamente

  Escenario: Visualizar y buscar un conductor existente correctamente
    Dado el usuario es administrador y está autenticado en el sistema
    Dado que se encuentra en el módulo "Gestión Logística"
    Dado que navega hasta la sección "Conductores" mostrando la lista de conductores existentes
    Cuando busca un conductor específico por su nombre, número de identificación o numero de licencia
    Entonces el sistema muestra los detalles del conductor seleccionado correctamente
