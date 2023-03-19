/* Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол
Форматы данных:
фамилия, имя, отчество - строки
дата_рождения - строка формата dd.mm.yyyy
номер_телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.
Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
*/
package lesson3;

import java.io.*;
import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Введите ФИО, дату рождения, номер телефона и пол:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            String[] data = input.split(" ");

            String[] fio = { data[0], data[1], data[2] };
            String date = data[3];
            String phoneNumber = data[4];
            String gender = data[5].toLowerCase();

            // Check to Array Length
            if (data.length < 6) {
                throw new Exception("1");
            } else if (data.length > 6) {
                throw new Exception("2");
            }

            // Check to FIO syntax
            for (String en : fio) {
                if (!en.matches("^[a-zA-Zа-яА-Я]+$")) {
                    throw new Exception("3");
                }
            }
            // Check to Date Length
            if (date.length() != 10) {
                throw new Exception("4");
            }
            // Check to Date Format
            if (date.charAt(2) != '.') {
                if (date.charAt(5) != '.') {
                    throw new Exception("4");
                }
            }
            String[] sd = date.split("\\.");
            for (String i : sd) {
                if (!i.matches("\\d+")) {
                    throw new Exception("4");
                }
            }
            // Check to Phone Number syntax
            for (char ch : date.toCharArray()) {
                if (ch != '.' && !Character.isDigit(ch)) {
                    throw new Exception("5");
                }
            }
            if (phoneNumber.length() != 11) {
                throw new Exception("5");
            }
            if (!phoneNumber.matches("^\\d+$")) {
                throw new Exception("5");
            }
            // Check to Gender syntax
            if (!gender.equals("f") && !gender.equals("m")) {
                throw new Exception("6");
            }

            // Format to Write Data
            String fiostr = String.join(" ", fio);
            String file = "<" + fiostr + "><" + date + "><" + phoneNumber + "><" + gender + ">\n";

            // Write to file
            File outputFile = new File(fio[0] + ".txt");
            FileWriter writer = new FileWriter(outputFile, true);
            writer.write(file);
            writer.close();
        }
        // If it will error with add data to File
        catch (IOException e) {
            System.out.println("Не получилось записать данные в файл");
        }
        // Numbers and Means of errors
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            switch (ex.getMessage()) {
                case "1":
                    System.out.println("Ошибка! Слишком мало данных!");
                    break;
                case "2":
                    System.out.println("Ошибка! Слишком много данных!");
                    break;
                case "3":
                    System.out.println("Ошибка! Неправильный формат ФИО!");
                    break;
                case "4":
                    System.out.println("Ошибка! Неправильный формат даты!");
                    break;
                case "5":
                    System.out.println("Ошибка! Неправильный формат номера телефона!");
                    break;
                case "6":
                    System.out.println("Ошибка! Неправильный формат пола!");
                    break;
            }
        }
    }
}