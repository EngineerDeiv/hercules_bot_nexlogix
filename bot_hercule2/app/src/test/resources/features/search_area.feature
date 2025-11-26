# language: es
# autor: Brandon Gonzalez

@SearchArea
Característica: Buscar área existente
  Como administrador del sistema
  Quiero buscar áreas específicas por ID
  Para gestionar su información

  Escenario: Buscar área por ID específico
    Dado que el administrador está en la lista de áreas
    Cuando busca el área creada anteriormente
    Entonces el sistema debe mostrar el área creada en los resultados
