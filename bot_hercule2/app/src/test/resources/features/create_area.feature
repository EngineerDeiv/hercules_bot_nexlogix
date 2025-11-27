# language: es
# autor: Brandon Gonzalez

@CreateArea
Característica: Crear nueva área en Nexlogix
  Como administrador del sistema
  Quiero poder crear nuevas áreas
  Para organizar mejor la estructura de la empresa

  Escenario: Crear un área exitosamente con datos válidos
    Dado que el administrador ha iniciado sesión y está en el panel principal
    Cuando navega a la sección de creación de áreas
    Y ingresa los datos de la nueva área
      | NombreArea              | DescripcionArea           |
      | Redes e Infraestructura | Área creada para pruebass |
    Entonces el área debe ser creada exitosamente y aparecer en la lista
