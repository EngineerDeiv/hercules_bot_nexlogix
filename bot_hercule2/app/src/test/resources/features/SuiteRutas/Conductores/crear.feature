# language: es
# autor: Leidy Fuentes

@CreateDriver
Característica: Crear nuevo conductor en Nexlogix
  Como administrador del sistema
  Quiero poder crear nuevos conductores
  Para gestionar el personal de transporte

  Escenario: Crear un conductor exitosamente con datos válidos
    Dado que el administrador ha iniciado sesión y está en el panel principal
    Cuando navega a la sección de conductores
    Y ingresa los datos del nuevo conductor
      | Nombre       | Apellido       | Cédula          | Teléfono       | Licencia       |
      | {var_nombre} | {var_apellido} | {var_cedula}    | {var_telefono} | {var_licencia} |

    Cuando se este llenando el formulario del conductor validar que se de click
    Entonces Buscar el conductor creado
    Y si no da click el test debe fallar y no guardar ningun dato
