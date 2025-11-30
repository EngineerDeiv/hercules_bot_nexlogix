# language: es
# autor: Leidy Fuentes

@UpdateCity
Característica: Editar la ciudad que se creo en los anteriores steps
  Como administrador del sistema
  Editar la información de una ciudad existente
  Para mantener los datos actualizados y correctos

  Escenario: Editar información de una ciudad
    Dado que busco la ciudad creada anteriormente y abro la opcion de editar
    Entonces editar toda la informacion de la ciudad
      | Nombre       | Departamento       | Código Postal       | Estado       |
      | {var_nombre} | {var_departamento} | {var_codigo_postal} | {var_estado} |
    Cuando se este llenando el formulario de la ciudad validar que se de click y se guarde
    Entonces Buscar la ciudad editada
    Y si no da click al editar el test debe fallar y no guardar ningun dato