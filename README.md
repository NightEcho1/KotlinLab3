# ЛР3. Фрагменты

Мокринский, Малахов, Ершова. Группа МИБ-2512.

## Реализация

Две кнопки открывают `FirstFragment` и `SecondFragment` внутри `FragmentContainerView`. У фрагментов разные цвет и текст. Дополнительная кнопка переключает фрагменты. Установлен `FLAG_SECURE`, фамилии и группа показаны во фрагментах.

## Открытие и сборка

Откройте именно папку `Lab3` через File → Open в Android Studio и дождитесь Gradle Sync. Выберите модуль `app`, эмулятор/устройство с API 26 или новее и нажмите Run.

Стек: Kotlin 2.1.20, Android Gradle Plugin 8.9.2, Gradle Wrapper 8.14, JDK 17, compileSdk/targetSdk 35, minSdk 26. XML-разметка и View Binding. API 26 соответствует Android 8.0; подпись Android 6.0 в методичке ошибочна.

На этом компьютере JDK и SDK настроены. При переносе обновите `sdk.dir` в `local.properties`, `org.gradle.java.home` в `gradle.properties` и Gradle JDK в Android Studio.

```powershell
$env:JAVA_HOME = 'C:\Users\NuaghtyDragon\.jdks\ms-17.0.19'
.\gradlew.bat assembleDebug lintDebug
# Требуется запущенный эмулятор или подключённое устройство:
.\gradlew.bat connectedDebugAndroidTest
```

APK: `app/build/outputs/apk/debug/app-debug.apk`.
Отчёт UI-тестов: `app/build/reports/androidTests/connected/debug/index.html`.

## Проверка перед защитой

1. Нажмите кнопки первого и второго фрагментов.
2. Проверьте кнопку переключения и сохранение выбранного фрагмента при повороте.
3. Проверьте запрет скриншотов на устройстве.

Исходники: `app/src/main/java/ru/mib2512/lab3`; разметки и строки: `app/src/main/res`. Фамилии и группа находятся в `values/strings.xml`. Автоматические сценарии — в `app/src/androidTest`.

Парольная схема учебная и повторяет методичку; SharedPreferences не шифрует пароль.
