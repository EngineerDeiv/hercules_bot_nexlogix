# language: es
# autor: Leidy Fuentes

@UpdateVehicle
Característica: Editar el vehículo que se creo en los anteriores steps
  Como administrador del sistema
  Editar la información de un vehículo existente
  Para mantener los datos actualizados y correctos

  Escenario: Editar información de un vehículo
    Dado que el administrador ha iniciado sesión y está en el panel principal de Vehículos
    Entonces editar toda la informacion del vehículo
      | Placa       | Marca       | Tipo       | Capacidad       | Estado       | Último mantenimiento |
      | {var_placa} | {var_marca} | {var_tipo} | {var_capacidad} | {var_estado} | {var_ultimo_mantenimiento} |
    Cuando se este llenando el formulario del vehículo validar que se de click y se guarde
    Entonces Buscar el vehículo editado
    Y si no da click al editar el test debe fallar y no guardar ningun dato en Vehículos
