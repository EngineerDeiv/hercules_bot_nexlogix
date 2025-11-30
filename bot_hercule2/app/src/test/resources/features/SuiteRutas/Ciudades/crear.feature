# language: es
# autor: Leidy Fuentes

@CreateCity
Característica: Crear nueva ciudad en Nexlogix
  Como administrador del sistema
  Quiero poder crear nuevas ciudades
  Para gestionar las rutas de transporte

  Escenario: Crear una ciudad exitosamente con datos válidos
    Dado que el administrador ha iniciado sesión y está en el panel principal
    Cuando navega a la sección de ciudades
    Y ingresa los datos de la nueva ciudad
      | Nombre       | Departamento       | Código Postal       |
      | {var_nombre} | {var_departamento} | {var_codigo_postal} |

    Cuando se este llenando el formulario de la ciudad validar que se de click
    Entonces Buscar la ciudad creada
    Y si no da click el test debe fallar y no guardar ningun dato
