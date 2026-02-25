import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Zodiac {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Tworzenie obiektu Scanner do odczytu danych
        boolean repeat; // Typ danych kontrolujący powtarzanie gry

        do {
            System.out.println("Autor programu: Szymon Zakrzewicz");
            System.out.println("Witaj w grze Zodiak! Podaj swoją datę urodzenia (w formacie RRRR-MM-DD):");

            LocalDate birthDate = null; // Zmienna do przechowywania daty urodzenia
            while (birthDate == null) { // Pętla do sprawdzania poprawności daty
                try {
                    String input = scanner.nextLine(); // Odczyt daty jako ciągu znaków
                    birthDate = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
                } catch (DateTimeParseException e) {
                    System.out.println("Niepoprawny format daty. Spróbuj ponownie:"); // Instrukcja wyskakująca przy błędnym wpisaniu danych
                }
            }

            String zodiacSign = getZodiacSign(birthDate); // Wyznaczanie znaku zodiaku na podstawie daty urodzenia
            System.out.println("Twój znak zodiaku to: " + zodiacSign);

            System.out.println("Wybierz opcję:"); // Wyświetlenie dostępnych opcji
            System.out.println("1. Wylosuj wróżbę");
            System.out.println("2. Otrzymaj imię twojego wróżbity");
            System.out.println("3. Poznaj ciekawostkę o swoim znaku zodiaku");
            int choice = scanner.nextInt(); // Odczyt wybranej opcji
            scanner.nextLine();

            switch (choice) { // Wybór 3 różnych opcji
                case 1 -> {
                    String fortune = getRandomFortune(); // Generowanie losowej wróżby
                    System.out.println("Twoja wróżba: " + fortune);
                }
                case 2 -> {
                    String prophetName = generateProphetName(); // Generowanie losowego imienia wróżbity
                    System.out.println("Imię Twojego wróżbity: " + prophetName);
                }
                case 3 -> {
                    String fact = getZodiacFact(zodiacSign); // Pobranie ciekawostki o znaku zodiaku
                    System.out.println("Ciekawostka: " + fact);
                }
                default -> System.out.println("Niepoprawna opcja."); // Niepoprawny wybór
            }

            System.out.println("Czy chcesz zagrać ponownie? (tak/nie)"); // Pytanie o powtórzenie gry
            String response = scanner.nextLine().trim().toLowerCase(); // Odczyt odpowiedzi użytkownika
            repeat = response.equals("tak"); // Powtarzanie gry, jeśli odpowiedź to "tak"

        } while (repeat); // Powtarzanie gry

        System.out.println("Dziękujemy za grę! Do zobaczenia."); // Pożegnanie użytkownika i koniec gry
        scanner.close(); // Zamknięcie obiektu Scanner
    }

    private static String getZodiacSign(LocalDate birthDate) { // Funkcja do wyznaczania znaku zodiaku
        Month day = birthDate.getMonth(); // Pobranie miesiąca z daty urodzenia
        int date = birthDate.getDayOfMonth(); // Pobranie dnia z daty urodzenia

        // Logika do wyznaczania znaku zodiaku na podstawie dnia i miesiąca
        if ((day == Month.MARCH && date >= 21) || (day == Month.APRIL && date <= 19)) {
            return "Baran";
        } else if ((day == Month.APRIL && date >= 20) || (day == Month.MAY && date <= 20)) {
            return "Byk";
        } else if ((day == Month.MAY && date >= 21) || (day == Month.JUNE && date <= 20)) {
            return "Bliźnięta";
        } else if ((day == Month.JUNE && date >= 21) || (day == Month.JULY && date <= 22)) {
            return "Rak";
        } else if ((day == Month.JULY && date >= 23) || (day == Month.AUGUST && date <= 22)) {
            return "Lew";
        } else if ((day == Month.AUGUST && date >= 23) || (day == Month.SEPTEMBER && date <= 22)) {
            return "Panna";
        } else if ((day == Month.SEPTEMBER && date >= 23) || (day == Month.OCTOBER && date <= 22)) {
            return "Waga";
        } else if ((day == Month.OCTOBER && date >= 23) || (day == Month.NOVEMBER && date <= 21)) {
            return "Skorpion";
        } else if ((day == Month.NOVEMBER && date >= 22) || (day == Month.DECEMBER && date <= 21)) {
            return "Strzelec";
        } else if ((day == Month.DECEMBER && date >= 22) || (day == Month.JANUARY && date <= 19)) {
            return "Koziorożec";
        } else if ((day == Month.JANUARY && date >= 20) || (day == Month.FEBRUARY && date <= 18)) {
            return "Wodnik";
        } else {
            return "Ryby";
        }
    }

    private static String getRandomFortune() { // Funkcja do generowania losowej wróżby
        List<String> fortunes = new ArrayList<>(Arrays.asList( // Lista możliwych wróżb
                "Dziś spotkasz kogoś wyjątkowego.",
                "Twoje marzenia się spełnią w tym roku, a każda trudność stanie się tylko pretekstem do większych sukcesów.",
                "Przed Tobą szczęśliwy dzień.",
                "Czeka Cię miła niespodzianka.",
                "Twoje wysiłki zostaną docenione.",
                "Wiosna przyniesie Ci nowe przyjaźnie, które zmienią Twoje życie na lepsze.",
                "Latem odnajdziesz wewnętrzny spokój, który pozwoli Ci zrealizować najskrytsze pragnienia.",
                "W tym roku miłość zaskoczy Cię w najmniej oczekiwanym momencie, przynosząc radość i stabilizację.",
                "Zdrowie będzie Ci sprzyjało, a każdy dzień przyniesie nowe siły do pokonywania wyzwań.",
                "Twoja kreatywność eksploduje jesienią, prowadząc do odkrycia nowej pasji lub hobby.",
                "Zima przyniesie długo oczekiwane odpowiedzi na nurtujące Cię pytania, otwierając nowe drogi.",
                "Będziesz miał okazję podróżować, a każda podróż odkryje przed Tobą coś niezwykłego.",
                "Finansowo rok będzie dla Ciebie łaskawy, ale kluczem do sukcesu będzie rozwaga i planowanie.",
                "Twoje relacje rodzinne pogłębią się, a wspólne chwile przyniosą wiele radości.",
                "Koniec roku przyniesie Ci awans lub nową, satysfakcjonującą pracę.",
                "Znajdziesz w sobie odwagę, by zrealizować projekt, który od dawna odkładałeś na później.",
                "Twoje zdolności przywódcze zostaną docenione, a Ty staniesz się inspiracją dla innych.",
                "Nauczysz się nowego języka lub umiejętności, co otworzy przed Tobą nowe horyzonty.",
                "Spotkasz kogoś, kto zmieni Twoje spojrzenie na życie w sposób, którego się nie spodziewasz.",
                "Twoje zdrowie psychiczne i fizyczne będą w najlepszej formie, co pozwoli Ci na realizację wielu celów.",
                "Przez cały rok będziesz otoczony pozytywną energią, która przyciągnie do Ciebie wiele dobra.",
                "Twoje dążenie do samodoskonalenia przyniesie spektakularne rezultaty, zaskakując nawet Ciebie.",
                "Osiągniesz równowagę między życiem zawodowym a osobistym, co przyniesie Ci poczucie spełnienia.",
                "Nowy rok zakończy się dla Ciebie wielkim sukcesem, który będzie początkiem kolejnych wspaniałych przygód."
        ));

        Random random = new Random(); // Obiekt Random do losowania
        return fortunes.get(random.nextInt(fortunes.size())); // Zwraca losową wróżbę z listy
    }

    private static String generateProphetName() { // Funkcja do generowania losowego imienia wróżbity
        List<String> names = new ArrayList<>(Arrays.asList( // Lista możliwych imion wróżbitów
                "Szymon","Krystian","Robert","Nostradamus","Wojtek","Urszula"
        ));

        Random random = new Random(); // Obiekt Random do losowania
        return names.get(random.nextInt(names.size())); // Zwraca losowe imię z listy
    }

    private static String getZodiacFact(String zodiacSign) { // Funkcja do pobierania ciekawostki o znaku zodiaku
        Map<String, String> facts = new HashMap<>(); // Mapa przechowująca ciekawostki
        facts.put("Baran", "Barany są znane z impulsywności i energii, często działają szybko, nie zważając na konsekwencje.");
        facts.put("Baran", "Mają naturalne przywódcze zdolności i są skłonne do podejmowania ryzyka.");
        facts.put("Baran", "Ich żywiołem jest ogień, co odzwierciedla ich pasję i dynamizm w działaniu.");
        facts.put("Byk", "Byki są bardzo lojalne i cenią stabilność oraz komfortowe życie.");
        facts.put("Byk", "Są znane ze swojej upartości, ale również z cierpliwości i wytrwałości.");
        facts.put("Byk", "Ziemia jest ich żywiołem, co sprawia, że są praktyczne i mają silne poczucie rzeczywistości.");
        facts.put("Bliźnięta", "Bliźnięta są niezwykle komunikatywne i mają dar przekonywania.");
        facts.put("Bliźnięta", "Są bardzo adaptacyjne, potrafią się szybko dostosować do nowych sytuacji.");
        facts.put("Bliźnięta", "Ich żywiołem jest powietrze, co symbolizuje ich potrzebę intelektualnej stymulacji.");
        facts.put("Rak", "Raki są głęboko emocjonalne i troskliwe, szczególnie wobec rodziny.");
        facts.put("Rak", "Mają tendencję do życia w przeszłości, często są nostalgiczne.");
        facts.put("Rak", "Woda to ich żywioł, co odzwierciedla ich zmienne nastroje i intuicję.");
        facts.put("Lew", "Lwy są pewne siebie i uwielbiają być w centrum uwagi.");
        facts.put("Lew", "Mają wielkie serca, są lojalne i hojne wobec przyjaciół.");
        facts.put("Lew", "Ich żywioł, ogień, sprawia, że są pełne energii i entuzjazmu.");
        facts.put("Panna", "Panny są perfekcjonistkami, zwracają uwagę na szczegóły.");
        facts.put("Panna", "Są bardzo analityczne, co czyni je doskonałymi pracownikami w dziedzinach wymagających precyzji.");
        facts.put("Panna", "Żywioł ziemi daje im praktyczne podejście do życia.");
        facts.put("Waga", "Wagi cenią harmonię i sprawiedliwość, starają się unikać konfliktów.");
        facts.put("Waga", "Są bardzo towarzyskie i mają talent do dyplomacji.");
        facts.put("Waga", "Powietrze jako żywioł oznacza, że szukają równowagi w relacjach interpersonalnych.");
        facts.put("Skorpion", "Skorpiony są intensywne, pełne emocji i pasji, często tajemnicze.");
        facts.put("Skorpion", "Mają zdolność do regeneracji i odradzania się po trudnych sytuacjach.");
        facts.put("Skorpion", "Woda to ich żywioł, co wskazuje na ich głęboką intuicję i emocjonalność.");
        facts.put("Strzelec", "Strzelce są miłośnikami wolności i przygód, uwielbiają podróżować.");
        facts.put("Strzelec", "Są optymistyczne i mają szerokie horyzonty myślowe.");
        facts.put("Strzelec", "Ich żywiołem jest ogień, co podkreśla ich entuzjazm i chęć do odkrywania nowego.");
        facts.put("Koziorożec", "Koziorożce są bardzo ambitne i mają silną wolę do osiągnięcia sukcesu.");
        facts.put("Koziorożec", "Są odpowiedzialne i praktyczne, często stawiają karierę na pierwszym miejscu.");
        facts.put("Koziorożec", "Ziemia jako żywioł sprawia, że są stabilne i realistyczne.");
        facts.put("Wodnik", "Wodniki są innowacyjne i mają niekonwencjonalne podejście do życia.");
        facts.put("Wodnik", "Są humanitarne, często zaangażowane w działalność społeczną.");
        facts.put("Wodnik", "Powietrze to ich żywioł, co symbolizuje ich intelektualną otwartość i oryginalność.");
        facts.put("Ryby", "Ryby są bardzo empatyczne, z łatwością rozumieją uczucia innych.");
        facts.put("Ryby", "Mają bogatą wyobraźnię i skłonność do eskapizmu przez sztukę lub marzenia.");
        facts.put("Ryby", "Woda jest ich żywiołem, co wskazuje na ich wrażliwość i głęboką intuicję.");

        return facts.getOrDefault(zodiacSign, "Brak informacji o tym znaku zodiaku."); // komunikat o braku informacji
    }
}
