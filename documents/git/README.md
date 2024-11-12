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
   Np. w głównym katalogu z projektem tworzymy katalog `environment`, a w nim plik `.env`
2. Pushujemy go na repozytorium.
3. Dopisujemy go do `.gitignore`  
   Np. `environment/.env`  
   To pomoże zapobiec potencjalnym konfliktom lub śledzeniu pliku przez innych użytkowników.  
   **Uwaga:** Jeśli dodasz plik do .gitignore, inne osoby, które sklonują repozytorium, nie będą go śledzić automatycznie,
   ale ponieważ plik został już dodany wcześniej, jego kopia pozostanie w repozytorium.
4. Usuwamy plik z kontroli wersji:  
   Jeśli plik `.env` był już śledzony i pushnięty na GitHub, samo dodanie do `.gitignore` nie wystarczy – trzeba go
   usunąć z kontroli wersji.  
   Wykonaj następujące polecenie:  
   `git rm --cached environment/.env`  
   To polecenie usunie plik `.env` z kontroli wersji, ale pozostawi go na dysku lokalnym.
5. IDE będzie nam ciągle pokazywało, że w tym pliku są zmiany. Jeśli to pushniemy to zniknie on z GitHub.  
   Trzeba dać prawym -> Rollback

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