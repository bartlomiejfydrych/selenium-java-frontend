# 🚧Repository under construction - do not enter🚧

# 📑Informations about this repository (for recruiters)

## 📄Description

Frontend tests using Cypress and TypeScript.\
There are publicly available websites for learning Frontend test automation and the testerczaki.pl website, which is aimed at practicing actions on websites.

## 🌐 Pages covered with tests

- [Testerczaki](https://dawidkaruga.pl/testerczaki/)

## 🧰Used frameworks and technologies

- Node.js
- Cypress
- TypeScript
- Visual Studio Code (VSC)

## 🎯What I learned and what I practiced

- Further practice of using VSC
- Track and commit GIT changes with VSC
- (TODO) Instalation, configuration and run first example test in Cypress

# 📝Moje notatki (notes for me in PL, you don't have to read this)

## 📚Dokumentacja i przydatne linki

- [Cypress](https://docs.cypress.io/guides/overview/why-cypress)
- [TypeScript](https://www.typescriptlang.org/docs/)
- [To repozytorium (żeby przechodzić tu z IDE)](https://github.com/bartlomiejfydrych/cypress-type-script)
- [Kurs - Codenbox AutomationLab](https://www.youtube.com/playlist?list=PLN9RL2PyZc19eQy4xrIva67SpB8jNqHAo)

## 🔧Konfiguracja

1. Dodajemy plik `.gitignore` z szablonem pod Node.js
2. Instalujemy [Node.js](https://nodejs.org/en/download)
3. Otwieramy terminal w katalogu z projektem
4. Możemy sprawdzić czy mamy prawidłowo zainstalowanego Node'a za pomocą poleceń:\
   `node -v`\
   `npm -v`
5. Wpisujemy i zatwierdzamy polecenie:\
   `npm init -y`\
   Ten `-y` oznacza, że w konsoli odpowiadamy na wszystko domyślnie "yes" podczas tego procesu.\
   Powinniśmy po tym mieć utworzony w katalogu plik `package.json`
6. (Opcjonalne) We wtyczkach VSC możemy wyszukać i zainstalować `Code Runner`\
   Jest to wtyczka mogąca ułatwiać nam uruchamianie kodu w VSC.
7. Instalujemy **Cypress** poleceniem:\
   `npm install cypress`\
   W dokumentacji jest polecenie `npm install cypress --save-dev`\
   Ten dopisek `--save-dev` należy do **npm** i generalnie jest bardziej dla Developerów korzystających z tego narzędzia do testów. Sprawia on, że produkcyjny build nie ma tego instalowane. Npm install to pomija wtedy.
8. Instalujemy **TypeScript** poleceniem:\
   `npm install typescript`
9. Inicjujemy nowy plik `tsconfig.json` poleceniem:\
   `npx tsc --init --types cypress --lib dom,es6`\
   Zapewnia to, że typy z Cypress są dostępne i obsługiwane za pomocą TypeScript. Te typy zależą od **dom** & **es6**, więc przekazujemy je jako opcję `lib` do TypeScript.
10. Otwieramy **TestRunner** poleceniem:\
    `npx cypress open`