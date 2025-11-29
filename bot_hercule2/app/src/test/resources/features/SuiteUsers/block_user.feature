# language: es
# autor: Brandon Gonzalez

@BlockUser
Característica: Bloquear usuario existente
  Como administrador del sistema
  Quiero bloquear un usuario
  Para restringir su acceso al sistema

  Escenario: Cambiar estado de usuario a bloqueado
    Dado que busco el usuario editado anteriormente y abro la opcion de editar
    Cuando cambio el estado a "BLOQUEADO"
    Entonces Buscar el usuario bloqueado
    Y el usuario debe aparecer como bloqueado en la lista
