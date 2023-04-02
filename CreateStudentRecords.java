/**

Класс CreateStudentRecords используется для создания 50 записей студентов и записи их в файл.
*/
public class CreateStudentRecords {
/**
Метод main используется для создания 50 записей студентов с помощью объектов класса StudentRecord и записи их в файл studentRecords.txt.
@param args Массив строковых аргументов, передаваемых при запуске программы.
*/
public static void main(String[] args) {
try {
FileOutputStream fileOut = new FileOutputStream("studentRecords.txt");
DataOutputStream dataOut = new DataOutputStream(fileOut);
 for (int i = 0; i < 50; i++) {
     String firstName = "First" + i;
     String lastName = "Last" + i;
     String faculty = "Faculty" + i % 5;
     int birthYear = 1990 + i % 10;
     int enrollmentYear = 2010 + i % 5;
     String id = "ID" + i;

     StudentRecord record = new StudentRecord(firstName, lastName, faculty, birthYear, enrollmentYear, id);
     record.writeToStream(dataOut);
 }

 dataOut.close();
 fileOut.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}
