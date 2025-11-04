# 🚀 Guía para Ejecutar las Pruebas en IntelliJ IDEA

## 📋 Pre-requisitos

✅ Proyecto abierto en IntelliJ IDEA
✅ ChromeDriver está configurado en: `src/test/resources/driver/chromedriver.exe`
✅ Chrome instalado en tu PC

---

## 🎯 MÉTODO 1: Ejecutar desde IntelliJ (MÁS FÁCIL)

### Para probar VEHÍCULOS:

1. **Navega al archivo runner:**
   ```
   app/src/test/java/runners/views_and_search_vehiculos.java
   ```

2. **Click derecho sobre el nombre de la clase** `views_and_search_vehiculos`

3. **Selecciona:** `Run 'views_and_search_vehiculos'`
   - O presiona: `Ctrl + Shift + F10`

4. **Observa:**
   - Se abrirá Chrome automáticamente
   - Navegará a la aplicación Nexlogix
   - Se autenticará como admin
   - Abrirá Gestión Logística → Vehículos
   - Buscará el vehículo por placa
   - Se quedará 10 segundos para que veas el resultado

---

### Para probar USUARIOS:

1. **Navega al archivo runner:**
   ```
   app/src/test/java/runners/views_and_search_users.java
   ```

2. **Click derecho sobre el nombre de la clase** `views_and_search_users`

3. **Selecciona:** `Run 'views_and_search_users'`
   - O presiona: `Ctrl + Shift + F10`

4. **Observa:**
   - Se abrirá Chrome automáticamente
   - Navegará a la aplicación Nexlogix
   - Se autenticará como admin
   - Abrirá Administración → Usuarios
   - Buscará el usuario por documento/email
   - Se quedará 10 segundos para que veas el resultado

---

## 🎯 MÉTODO 2: Ejecutar desde Terminal de IntelliJ

### Paso 1: Abrir Terminal en IntelliJ
- Click en `View` → `Tool Windows` → `Terminal`
- O presiona: `Alt + F12`

### Paso 2: Ejecutar comandos

**Para VEHÍCULOS:**
```powershell
.\gradlew test --tests views_and_search_vehiculos
```

**Para USUARIOS:**
```powershell
.\gradlew test --tests views_and_search_users
```

**Para ejecutar AMBOS:**
```powershell
.\gradlew test --tests "views_and_search_*"
```

**Para ejecutar TODOS los tests:**
```powershell
.\gradlew test
```

---

## 📊 Ver los Reportes

### Después de ejecutar las pruebas:

1. **Reporte de Cucumber (HTML simple):**
   ```
   app/target/cucumber-reports.html
   ```
   - Click derecho → `Open in Browser`

2. **Reporte de Serenity (MUY DETALLADO):**
   ```
   app/target/site/serenity/index.html
   ```
   - Click derecho → `Open in Browser`
   - Este reporte tiene capturas de pantalla de cada paso!

---

## ⚙️ CONFIGURACIÓN IMPORTANTE

### Si necesitas cambiar el valor de búsqueda de USUARIOS:

1. Abre: `app/src/test/java/stepdefinitions/ViewsAndSearchUsersSteps.java`

2. Línea 37, cambia el valor:
   ```java
   String searchValue = "1234567890"; // ← Cambiar por tu documento o email
   ```

3. Guarda el archivo (Ctrl + S)

### Si necesitas cambiar el valor de búsqueda de VEHÍCULOS:

1. Abre: `app/src/test/java/stepdefinitions/ViewsAndSearchVehiculosSteps.java`

2. Línea 36, el valor viene del feature file. Para cambiarlo:
   - Abre: `app/src/test/resources/features/views_and_search_vehiculos.feature`
   - Busca la línea que dice: `Cuando busca un vehículo específico por su placa "XXX"`
   - Cambia "XXX" por la placa que necesites

---

## 🐛 Solución de Problemas

### Error: "ChromeDriver no encontrado"
✅ **Solución:** Verifica que existe el archivo en:
```
app/src/test/resources/driver/chromedriver.exe
```

### Error: "Chrome no se abre"
✅ **Solución:** 
1. Verifica que Chrome esté instalado
2. Actualiza ChromeDriver si tu versión de Chrome es muy nueva
3. Descarga desde: https://chromedriver.chromium.org/

### Error: "No se encuentra la aplicación"
✅ **Solución:** Verifica las credenciales y URL en:
```
app/src/test/java/stepdefinitions/auth_stepdefinition.java
```

### Error de compilación en IntelliJ
✅ **Solución:**
1. Click derecho en la carpeta raíz → `Reload from Disk`
2. `File` → `Invalidate Caches` → `Invalidate and Restart`
3. En terminal: `.\gradlew clean build`

---

## 🎬 Flujo Completo de Prueba

### OPCIÓN A: Prueba rápida de un solo test
```
1. Abrir runner en IntelliJ
2. Click derecho → Run
3. Ver ejecución en Chrome
4. Ver reporte en target/site/serenity/index.html
```

### OPCIÓN B: Prueba completa desde terminal
```powershell
# Limpiar builds anteriores
.\gradlew clean

# Ejecutar tests
.\gradlew test --tests views_and_search_vehiculos
.\gradlew test --tests views_and_search_users

# Generar reportes de Serenity
.\gradlew aggregate

# Abrir reporte
# Navegar a: app/target/site/serenity/index.html
```

---

## 📝 Notas Importantes

1. **Chrome debe estar visible:** Las pruebas NO son headless, verás el navegador abrirse
2. **Tiempo de espera:** Hay waits de 10 segundos para que puedas ver los resultados
3. **Capturas automáticas:** Serenity toma capturas después de cada paso
4. **No interrumpas:** Deja que el test termine solo, cerrará Chrome automáticamente

---

## ✅ Checklist Antes de Ejecutar

- [ ] IntelliJ tiene el proyecto sincronizado (sin errores de compilación)
- [ ] ChromeDriver existe en `src/test/resources/driver/`
- [ ] Chrome está instalado y actualizado
- [ ] Tienes conexión a internet (para acceder a Nexlogix)
- [ ] Las credenciales de admin son correctas

---

## 🎉 ¡Listo!

Ahora solo tienes que:
1. Abrir el runner que quieras probar
2. Click derecho → Run
3. ¡Ver la magia de la automatización! ✨

¿Algún problema? Revisa la sección de "Solución de Problemas" arriba.
