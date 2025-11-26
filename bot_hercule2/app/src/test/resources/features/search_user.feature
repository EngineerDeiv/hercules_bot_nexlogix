# language: es
# autor: Brandon Gonzalez

@SearchUser
Característica: Buscar usuario existente
  Como administrador del sistema
  Quiero buscar usuarios específicos
  Para gestionar su información

  Escenario: Buscar usuario por criterio específico
    Dado que el administrador está en la lista de usuarios
    Cuando busca el usuario creado anteriormente
    Entonces el sistema debe mostrar al usuario creado en los resultados