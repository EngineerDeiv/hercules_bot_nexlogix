# language: es
# autor: Leidy Fuentes

@UpdateVehicle
Característica: Editar el vehículo que se creo en los anteriores steps
  Como administrador del sistema
  Editar la información de un vehículo existente
  Para mantener los datos actualizados y correctos

  Escenario: Editar información de un vehículo
    Dado que busco el vehículo creado anteriormente y abro la opcion de editar
    Entonces editar toda la informacion del vehículo
      | Placa       | Marca       | Modelo       | Tipo       | Estado       |
      | {var_placa} | {var_marca} | {var_modelo} | {var_tipo} | {var_estado} |
    Cuando se este llenando el formulario del vehículo validar que se de click y se guarde
    Entonces Buscar el vehículo editado
    Y si no da click al editar el test debe fallar y no guardar ningun dato
