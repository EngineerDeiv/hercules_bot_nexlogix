# language: es
# autor: Leidy Fuentes

@CreateVehicle
Característica: Crear nuevo vehículo en Nexlogix
  Como administrador del sistema
  Quiero poder crear nuevos vehículos
  Para gestionar la flota de transporte

  Escenario: Crear un vehículo exitosamente con datos válidos
    Dado que el administrador ha iniciado sesión y está en el panel principal de Vehículos
    Cuando navega a la sección de vehículos
    Y ingresa los datos del nuevo vehículo
      | Placa       | Marca       | Tipo       | Capacidad       | Estado       | Último mantenimiento |
      | {var_placa} | {var_marca} | {var_tipo} | {var_capacidad} | {var_estado} | {var_ultimo_mantenimiento} |

    Cuando se este llenando el formulario del vehículo validar que se de click
    Entonces Buscar el vehículo creado
    Y si no da click el test debe fallar y no guardar ningun dato en Vehículos
