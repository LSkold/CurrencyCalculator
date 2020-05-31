# CurrencyCalculator
Aplikacja stworzona na rekrutację do Programu Praktyk w Atos Polska.<br>
Autor: Łukasz Skołd

Program został rozszerzony o możliwość zmiany waluty początkowej.

# Uruchomienie programu:
1. W wierszu poleceń otwieramy katalog "src" i wpisujemy nastepujące polecenie:
    >javac lukasz/skold/*.java<br>

2. Uruchamiamy program z tego samego miejsca wpisując polecenie:
    >java lukasz.skold.CurrencyCalculator
# Działanie
W polu z napisem "Enter amount" należy wpisać kwotę, która ma zostać przewalutowana. W miejscu oznaczonym "Your currency" wybieramy z jakiej waluty będziemy konwertować (domyślnie EURO - tak jak miałobyć w zadaniu). W niższym rzędzie wybieramy docelową walutę. Okienko "Output" będzie wyświetlać nam kwotę po przewalutowaniu zaokrągloną do grosza.
# Testy jednostkowe
Klasa testowa znajduje się w katalogu "test" i zawiera trzy testy sprawdzające poprwność działania aplikacji. Wszystkie użyte biblioteki niezawarte w JDK 1.8, znajdują się w katalogu "lib".
