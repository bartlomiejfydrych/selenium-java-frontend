# 🐱Git — notatki

## 📑Spis

- [Plik wzorcowy — wrzucenie na repo i wyłączenie śledzenia](#file_example)

---

## Plik wzorcowy — wrzucenie na repo i wyłączenie śledzenia <a name="file_example"></a>

### Wstęp

Czasami potrzebujemy wrzucić do repozytorium jakiś wzór pliku bez konieczności jego aktualizowania ze względu na dane
wrażliwe itp. Przykładem mogą być pliki ze zmiennymi środowiskowymi `.env`.  
Poniżej instrukcja jak takie coś zrobić.

### Kroki

1. Tworzymy plik. Jego ogólny wzór bez konkretnych danych.
2. Pushujemy go na repozytorium.
3. Dopisujemy go do `.gitignore`  
   To pomoże zapobiec potencjalnym konfliktom lub śledzeniu pliku przez innych użytkowników.  
   **Uwaga:** Jeśli dodasz plik do .gitignore, inne osoby, które sklonują repozytorium, nie będą go śledzić automatycznie,
   ale ponieważ plik został już dodany wcześniej, jego kopia pozostanie w repozytorium.

### Dodatkowe

**Zaprzestanie śledzenia zmian w pliku**

1. Otwieramy konsolę/terminal.
2. Wpisz następujące polecenie, aby przestać śledzić zmiany w pliku:  
   `git update-index --assume-unchanged <ścieżka/do/pliku>`  
   Zamieniając `<ścieżka/do/pliku>` na rzeczywistą ścieżkę pliku, np. `src/config-template.json`.  
   To polecenie sprawi, że Git przestanie śledzić zmiany w pliku lokalnie, co oznacza, że nie będą one uwzględniane
   przy kolejnych commitach. Jednak plik nadal pozostaje w repozytorium i jego oryginalna wersja będzie dostępna na
   GitHubie.

**Dodatkowa uwaga**

Aby cofnąć `--assume-unchanged` i znów śledzić plik, otwórz konsolę/terminal i użyj:  
`git update-index --no-assume-unchanged <ścieżka/do/pliku>`