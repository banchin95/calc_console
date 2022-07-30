import java.util.Scanner;

class Main {
  static String[] roman = {
    "O",
    "I",
    "II",
    "III",
    "IV",
    "V",
    "VI",
    "VII",
    "VIII",
    "IX",
    "X",
    "XI",
    "XII",
    "XIII",
    "XIV",
    "XV",
    "XVI",
    "XVII",
    "XVIII",
    "XIX",
    "XX",
    "XXI",
    "XXII",
    "XXIII",
    "XXIV",
    "XXV",
    "XXVI",
    "XXVII",
    "XXVIII",
    "XXIX",
    "XXX",
    "XXXI",
    "XXXII",
    "XXXIII",
    "XXXIV",
    "XXXV",
    "XXXVI",
    "XXXVII",
    "XXXVIII",
    "XXXIX",
    "XL",
    "XLI",
    "XLII",
    "XLIII",
    "XLIV",
    "XLV",
    "XLVI",
    "XLVII",
    "XLVIII",
    "XLIX",
    "L",
    "LI",
    "LII",
    "LIII",
    "LIV",
    "LV",
    "LVI",
    "LVII",
    "LVIII",
    "LIX",
    "LX",
    "LXI",
    "LXII",
    "LXIII",
    "LXIV",
    "LXV",
    "LXVI",
    "LXVII",
    "LXVIII",
    "LXIX",
    "LXX",
    "LXXI",
    "LXXII",
    "LXXIII",
    "LXXIV",
    "LXXV",
    "LXXVI",
    "LXXVII",
    "LXXVIII",
    "LXXIX",
    "LXXX",
    "LXXXI",
    "LXXXII",
    "LXXXIII",
    "LXXXIV",
    "LXXXV",
    "LXXXVI",
    "LXXXVII",
    "LXXXVIII",
    "LXXXIX",
    "XC",
    "XCI",
    "XCII",
    "XCIII",
    "XCIV",
    "XCV",
    "XCVI",
    "XCVII",
    "XCVIII",
    "XCIX",
    "C",
  };

  public static String convertNumToRoman(int numArabian) {
    final String s = roman[numArabian];
    return s;
  }

  private static int convertRomanToNum (String rom) {
    if (rom.equals("I")) {
        return 1;
    } else if (rom.equals("II")) {
        return 2;
    } else if (rom.equals("III")) {
        return 3;
    } else if (rom.equals("IV")) {
        return 4;
    } else if (rom.equals("V")) {
        return 5;
    } else if (rom.equals("VI")) {
        return 6;
    } else if (rom.equals("VII")) {
        return 7;
    } else if (rom.equals("VIII")) {
        return 8;
    } else if (rom.equals("IX")) {
        return 9;
    } else if (rom.equals("X")) {
        return 10;
    }
    return -1;
}

  public static void main(String[] args) throws Exception {
    while (true) {
      System.out.println("Введите выражение  2 + 2 или V + V. (от 1 до 10)");
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();

      String[] params = input.split(" ");

      if (params.length < 3) {
        scanner.close();
        throw new Exception(
          "Строка не является математической операцией. Введите корректное число. Например 2 + 2"
        );
      }

      if (params.length > 3) {
        scanner.close();
        throw new Exception(
          "Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, )"
        );
      }

      if (params.length > 3) {
        scanner.close();
        throw new Exception(
          "Используются одновременно разные системы счисления"
        );
      }

      if (
        (convertRomanToNum(params[0]) == -1 && convertRomanToNum(params[2]) != -1) ||
        (convertRomanToNum(params[0]) != -1 && convertRomanToNum(params[2]) == -1)
      ) {
        scanner.close();
        throw new Exception(
          "Используются одновременно разные системы счисления"
        );
      }

      final Boolean isArab = convertRomanToNum(params[0]) != -1;

      if (isArab) {
        params[0] = String.valueOf(convertRomanToNum(params[0]));
        params[2] = String.valueOf(convertRomanToNum(params[2]));
      }

      final String pattern = "^\\d+\\.\\d+";

      if (params[0].matches(pattern) || params[2].matches(pattern)) {
        scanner.close();
        throw new Exception("Введите целые числа");
      }

      int a = Integer.parseInt(params[0]);
      String operator = params[1];
      int b = Integer.parseInt(params[2]);

      if (a < 1 || a > 10 || b < 1 || b > 10) {
        scanner.close();
        throw new Exception("Введите числа от 1 до 10");
      }

      int result = 0;

      switch (operator) {
        case "+":
          result = a + b;
          break;
        case "-":
          result = a - b;
          break;
        case "":
          result = a * b;
          break;
        case "/":
          result = a / b;
          break;
        default:
          break;
      }

      if (isArab) {
        if(result < 0) {
            scanner.close();
            throw new Exception("В римской системе нет отрицательных чисел");
        }

        System.out.printf(
          "Ответ: %s %s %s = %s%n",
          convertNumToRoman(a),
          operator,
          convertNumToRoman(b),
          convertNumToRoman(result)
        );
      } else {
        System.out.printf("Ответ: %d %s %d = %d%n", a, operator, b, result);
      }
    }
  }
}
