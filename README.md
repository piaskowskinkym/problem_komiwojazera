# Aplikacja Komiwojarzer
 Aplikacja implementuje rozwiązanie problemu Komiwojażera w celu wypisania najkrótszej trasy pomiedzy 
 podanymi przez użytkownika lub wygenerowanymi losowo miastami.
 
# Problem Komiwojarzera
(ang. travelling salesman problem, TSP)– zagadnienie optymalizacyjne, polegające na znalezieniu minimalnego cyklu Hamiltona w pełnym grafie ważonym.
Nazwa pochodzi od typowej ilustracji problemu, przedstawiającej go z punktu widzenia wędrownego sprzedawcy (komiwojażera): dane jest n miast, które komiwojażer ma odwiedzić, oraz odległość / cena podróży / czas podróży pomiędzy każdą parą miast. Celem jest znalezienie najkrótszej / najtańszej / najszybszej drogi łączącej wszystkie miasta, zaczynającej się i kończącej się w określonym punkcie.     
https://pl.wikipedia.org/wiki/Problem_komiwojażera

# Główne założenia projektu
* **Program napisany w środwisku Android Studio przy użyciu języka programowania Kotlin**
* **Skrypt obsługuje problem na 8 miastach**
* **Odległości pomiędzy miastami przetrzymywane są w tablicy dwu wymiarowej**
* **Miasto nie może mieć wobec siebie własnej odległości**
* **Odległość pomiędzy dwoma miastami jest w dwie strony taka sama**
* **Użytkownik ma możliwość wprowadzenia swoich odległości lub wygenerowania losowych**
* **Pod koniec działania skryptu Użytkownik dostaje możliwość wykonania zrzutu ekranu w celu zapisania wyniku** 

# Wygląd Ui
Pierszy panel zawiera 3 przyciski następująco
* **Wprowadź własne odległości i miasta któy po wciśnięciu przenosi użytkownika na panel UserActivity**
* **Użyj losowo wygenerowanych odległości który po wciśnięciu przenosi użytkownika na panel RandomActivity**
* **Zamknij Aplikację któy zamyka aplikację**

Po przejściu na panel UserActivity użytkownik ma następujące opcje
* **Dwa spinnery z rozwijaną listą które pozwalają na wybranie dwóch miast pomiędzy którymi ma zostać utworzone połączenie**
* **Pole tekstowe do wprowadzenia odległości**
* **Button Dodaj dystans który po wciśnięciu dodaje odległość do tablicy odległości**
* **Button Oblicz najkrótszą trasę który zaczyna skrypt**
* **TextView w którym wyświetla obliczoną trasę**
* **Button do robienia zrzutu ekranu który aktywuje się po zakończeniu skryptu**
* **Button powrotu do menu który po kliknięciu wraca na ekran tytułowy aplikacji**

Po przejściu na panel Random użytkownik ma następujące opcje
* **Dwa spinnery z rozwijaną listą które pozwalają na wybranie dwóch miast pomiędzy którymi ma zostać utworzone połączenie**
* **Button Wygeneruj losowy dystans który generuje losową odległość pomiędzy wybranymi ze spinnerów miast**
* **Button Oblicz najkrótszą trasę który zaczyna skrypt**
* **TextView w którym wyświetla obliczoną trasę**
* **Button do robienia zrzutu ekranu który aktywuje się po zakończeniu skryptu**
* **Button powrotu do menu który po kliknięciu wraca na ekran tytułowy aplikacji**

# Instrukcja obsługi
* **Wybierz i naciśnij button odpowiadający dwóm opcjom wprowadzania danych**
* **Po przejściu do aktywności z list rozwijanych wybierz miasta pomiędzy którymi chcesz ustawić połączenia**
* **Wprowadź w polu tekstowym poniżej odległość poczym naciśnij button dodaj odległość**
* **W przypadku losowania odległości wciśnij button "Wygeneruj losową odległość"**
* **Gdy wprowadzisz odległości wciśnij button "Oblicz najkrótszą trasę" po czym poczekaj chwilę na działanie skryptu**
* **Po dostaniu wyniku możesz zapisać go w formie zrzutu ekranu wciskając button "Wykonaj zrzut ekranu"**
