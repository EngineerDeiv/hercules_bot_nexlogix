# language: es
# autor: Brandon Gonzalez

Característica: Autenticación de administrador en Nexlogix
  Como usuario administrador de Nexlogix
  Quiero poder iniciar sesión en el sistema
  Para acceder al panel de administración

  @LoginAuth
  Escenario: Iniciar sesión como administrador usando credenciales correctas
    Dado que el usuario navega a la página web de Nexlogix y se encuentra en la pantalla de inicio de sesión
    Cuando ingrese el usuario "deivgonz777@gmail.com" y la contraseña "Hero77777"
    Entonces el sistema deberá autenticarlo correctamente y mostrar el panel de administración
