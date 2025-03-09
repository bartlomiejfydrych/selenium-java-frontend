# 📒Pozostałe notatki

# 📑Spis treści

- [🗃Repozytorium z kursu](#repository_from_the_course)
- [👨‍💻IDE](#ide)
  - [Zapełnione miejsce na dysku systemowym (C:) przez katalog AppData](#ide_appdata_disk_space)
  - [Skróty klawiszowe](#ide_keyboard_shortcuts)
    - [Formatowanie kodu](#keyboard_shortcuts_code_formatting)
    - [Optymalizacja importów](#keyboard_shortcuts_import_optimization)
    - [Komentarz liniowy kodu](#keyboard_shortcuts_code_linear_comment)
    - [Komentarz blokowy kodu](#keyboard_shortcuts_code_block_comment)
    - [Zaznaczanie kilku linii](#keyboard_shortcuts_selecting_multiple_lines)
    - [Duplikacja linii](#keyboard_shortcuts_line_duplication)
- [⬇Markdown](#markdown)
  - [Dokumentacja](#markdown_documentation)
  - [TAB/Tabulator – znak](#markdown_tab)
- [📓Pozostałe](#other)
  - [Przełożenie struktury projektu na tekst w konsoli](#other_project_structure_to_text_in_console)

---

# 🗃Repozytorium z kursu <a name="repository_from_the_course"></a>

**Link:**  
https://github.com/simplelogic2023szkolenie

---

# 👨‍💻IDE <a name="ide"></a>

## 📄Zapełnione miejsce na dysku systemowym (C:) przez katalog AppData <a name="ide_appdata_disk_space"></a>

**Link:**  
https://intellij-support.jetbrains.com/hc/en-us/community/posts/360010670000-Is-it-safe-to-delete-C-Users-user-AppData-Local-JetBrains-IdeaIC2020-3-folder

Po każdej aktualizacji IDE do nowej wersji jest tworzony nowy katalog na jej dane.  
Poprzednie katalogi zostają i jak się ich nazbiera, to zajmują sporo GB.

IDE ma wbudowaną funkcję, żeby poradzić sobie z tym problemem:

1. Klikamy "hamburger menu"
2. Klikamy `Help`
3. Klikamy `Delete Leftover IDE Directories...`
4. W prawym dolnym rogu klikamy to co powiadomienie sugeruje
5. Następnie zostanie wyświetlona lista z katalogami możliwymi do usunięcia
6. Zatwierdzamy

## 📄Skróty klawiszowe <a name="ide_keyboard_shortcuts"></a>

### ⌨Formatowanie kodu <a name="keyboard_shortcuts_code_formatting"></a>

`Ctrl + Alt + L`

### ⌨Optymalizacja importów <a name="keyboard_shortcuts_import_optimization"></a>

`Ctrl + Alt + O`

### ⌨Komentarz liniowy kodu <a name="keyboard_shortcuts_code_linear_comment"></a>

`Ctrl + / (slash)`

### ⌨Komentarz blokowy kodu <a name="keyboard_shortcuts_code_block_comment"></a>

`Ctrl + Shift + / (slash)`

### ⌨Zaznaczanie kilku linii <a name="keyboard_shortcuts_selecting_multiple_lines"></a>

Żeby edytować kilka linii naraz, zaznaczamy je kombinacją klawiszy:  
`Alt + Shift + Klikanie lewym przyciskiem myszy`

### ⌨Duplikacja linii <a name="keyboard_shortcuts_line_duplication"></a>

`Ctrl + D`

---

# ⬇Markdown <a name="markdown"></a>

## 📄Dokumentacja <a name="markdown_documentation"></a>

**Dokumentacja:**  
https://www.markdownguide.org/basic-syntax/

## 📄TAB/Tabulator – znak <a name="markdown_tab"></a>

Żeby w dokumencie wstawić tabulację(wcięcie) należy w jej miejscu umieścić poniższą kombinację znaków:  
`&emsp;`

---

# 📓Pozostałe <a name="other"></a>

## 📄Przełożenie struktury projektu na tekst w konsoli <a name="other_project_structure_to_text_in_console"></a>

**Link:**  
https://your-codes.vercel.app/how-to-easily-create-folder-structure-in-readme-with-two-simple-steps

**Potrzeba:**  
Chciałem łatwo przełożyć strukturę projektu na tekst, zamiast przepisywać ją ręcznie w notatniku.  
Dlaczego?  
Pod koniec pisania projektu chciałem zapytać czat GPT czy da się jeszcze lepiej zorganizować cały projekt tj.
porozdzielać pliki na odpowiednie pod-katalogi itp.

**Opis:**
1. Otwieramy konsolę/terminal w naszym katalogu z projektem
    - Obojętne czy to PowerShell czy CMD, czy jeszcze inne konsole
    - Gdy otwieramy projekt w eksploratorze Windows to:
        - Wciskamy w pustym obszarze kombinację `Lewy Shift + Prawy przycisk myszy`
        - "Otwórz tutaj okno programu PowerShell"
    - Gdy mamy otwarte IDE od JetBrains to:
        - W lewym dolnym rogu, na bocznym pasku powinna być trzecia od dołu ikonka z terminalem
        - Otworzy nam ona w IDE konsolę PowerShell
2. Wpisujemy i zatwierdzamy polecenie: `tree`
3. Możemy zaznaczyć i skopiować nasze drzewo ze strukturą projektu
