
# 📑Spis treści

- [Plik wzorcowy — wrzucenie na repo i wyłączenie śledzenia](#file_example)

---

# 🐱Git — notatki

## Plik wzorcowy — wrzucenie na repo i wyłączenie śledzenia <a name="file_example"></a>

### Wstęp

Czasami potrzebujemy wrzucić do repozytorium jakiś wzór pliku bez konieczności jego aktualizowania ze względu na dane
wrażliwe itp. Przykładem mogą być pliki ze zmiennymi środowiskowymi `.env`.  
Poniżej instrukcja jak takie coś zrobić.

### Kroki

1. Tworzymy przykładowy plik. Jego ogólny wzór bez konkretnych danych.  
   Np. w głównym katalogu z projektem tworzymy katalog `environment`, a w nim plik `.env.example`
2. Deklarujemy w nim zmienne, ale bez konkretnych wartości np.
   ```.env
   # book_store_application
   TQ_BSA_USERNAME=yourUsername
   TQ_BSA_PASSWORD=yourPassword
   ```
3. Pushujemy go na repozytorium.
4. Dopisujemy do `.gitignore` katalog lub/i nazwę oryginalnego pliku  
   Np. `environment/.env`
5. Tworzymy normalny plik `.env`
6. Podajemy w nim prawdziwe dane, których będziemy używać
