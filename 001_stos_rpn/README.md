# Zadanie Stos i RPN

## Zadanie 1: Stos

### Green

Zaimplementuj klasę `Stack` implementującą ideę stosów napisów z następującymi metodami publicznymi:

- `push` wkłada jeden element na stos
- `pop` zdejmuje jeden element ze stosu i oddaje wartość tego elementu; co się ma dziać gdy, `pop` próbuje
  zdjąc element z pustego stosu?
- `peek` podobnie jak `pop` oddaje wartość elementu na szczycie stosu ale go nie zdejmuje;
  podobny problem z pustym stosem co w przypadku `pop`.
  Podstawową strukturą danych w implementacji stosu powinna być tablica. Stos nie powinien posiadać ograniczeń rozmiaru.

### Red

Przygotuj testy jednostkowe dla klasy `Stack`.

## Zadanie 2: RPN

### Green

Zaimplementuj klasę wyliczającą wyrażenia arytmetyczne zapisane w [Odwrotnej Notacji Polskiej](https://pl.wikipedia.org/wiki/Odwrotna_notacja_polska).
Założenia:

- wyrażenia są ciągami znaków
- program umożliwia wyliczanie wyrażeń złożonych z liczb całkowitych i operacji binarnych takich jak `+`, `-` czy `*`.
- do implementacji wykorzystaj klasę `Stack` z Zadania 1.

### Red

Przygotuj testy jednostkowe dla implementacji RPN.

---

## UWAGA:

Staj się zastosować zasady [SOLID](https://www.samouczekprogramisty.pl/solid-czyli-dobre-praktyki-w-programowaniu-obiektowym/)
i [Clean Code](https://cleancoders.com/episode/clean-code-episode-1).
