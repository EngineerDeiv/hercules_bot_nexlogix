# language: es
# autor: Leidy Fuentes

@UpdateDriver
Característica: Editar el conductor que se creo en los anteriores steps
  Como administrador del sistema
  Editar la información de un conductor existente
  Para mantener los datos actualizados y correctos

  Escenario: Editar información de un conductor
    Dado que busco el conductor creado anteriormente y abro la opcion de editar
    Entonces editar toda la informacion del conductor
      | Nombre       | Apellido       | Cédula          | Teléfono       | Licencia       | Estado       |
      | {var_nombre} | {var_apellido} | {var_cedula}    | {var_telefono} | {var_licencia} | {var_estado} |
    Cuando se este llenando el formulario del conductor validar que se de click y se guarde
    Entonces Buscar el conductor editado
    Y si no da click al editar el test debe fallar y no guardar ningun dato
