# language: es
# autor: Brandon Gonzalez

@UpdateUser
Característica: Editar el usuario que se creo que los anteriores steps
  Como administrador del sistema
  Editar la información de un usuario existente
  Para mantener los datos actualizados y correctos

  Escenario: Editar información de un usuario
    Dado que busco el usuario creado anteriormente y abro la opcion de editar
    Entonces editar toda la informacion del usuario
      | Documento de Identidad | Nombre Completo | Email       | Teléfono       | Dirección       | Rol       | Puesto       | Estado       |
      | {var_documento}        | {var_nombre}    | {var_email} | {var_telefono} | {var_direccion} | {var_rol} | {var_puesto} | {var_estado} |
    Cuando se este llenando el furmlario validar que se de click y se guuarde
    Entonces Buscar el usuario editado
    Y si no da click al editar el test debe fallar y no guardar ningun dato

