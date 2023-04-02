/**

Класс, описывающий запись о студенте.
Содержит поля, методы чтения/записи из потока, сравнения и копирования объектов.
*/
public class StudentRecord implements Serializable, Comparable<StudentRecord>, Cloneable {
private String firstName;
private String lastName;
private String faculty;
private int birthYear;
private int enrollmentYear;
private String id;
/**
Конструктор класса без параметров.
*/
public StudentRecord() {}
/**
Конструктор класса с параметрами.
@param firstName имя студента
@param lastName фамилия студента
@param faculty факультет студента
@param birthYear год рождения студента
@param enrollmentYear год поступления студента
@param id номер студенческого билета
*/
public StudentRecord(String firstName, String lastName, String faculty, int birthYear, int enrollmentYear, String id) {
this.firstName = firstName;
this.lastName = lastName;
this.faculty = faculty;
this.birthYear = birthYear;
this.enrollmentYear = enrollmentYear;
this.id = id;
}
/**
Конструктор класса с параметром другого объекта данного класса.
@param other другой объект класса StudentRecord
*/
public StudentRecord(StudentRecord other) {
this.firstName = other.firstName;
this.lastName = other.lastName;
this.faculty = other.faculty;
this.birthYear = other.birthYear;
this.enrollmentYear = other.enrollmentYear;
this.id = other.id;
}


/**
Метод клонирования объекта.
@return новый объект типа StudentRecord, который является копией текущего объекта
*/
public StudentRecord clone() {
return new StudentRecord(this);
}
 * Класс, представляющий студенческую запись.
 */
public class StudentRecord {
    
    /**
     * Читает данные студенческой записи из потока ввода.
     * @param in поток ввода, из которого считываются данные.
     * @throws IOException если произошла ошибка ввода/вывода.
     */
    public void readFromStream(DataInputStream in) throws IOException {
        // считываем данные из потока ввода
        this.firstName = in.readUTF();
        this.lastName = in.readUTF();
        this.faculty = in.readUTF();
        this.birthYear = in.readInt();
        this.enrollmentYear = in.readInt();
        this.id = in.readUTF();
    }

    /**
     * Записывает данные студенческой записи в поток вывода.
     * @param out поток вывода, в который записываются данные.
     * @throws IOException если произошла ошибка ввода/вывода.
     */
    public void writeToStream(DataOutputStream out) throws IOException {
        // записываем данные в поток вывода
        out.writeUTF(this.firstName);
        out.writeUTF(this.lastName);
        out.writeUTF(this.faculty);
        out.writeInt(this.birthYear);
        out.writeInt(this.enrollmentYear);
        out.writeUTF(this.id);
    }

    /**
     * Возвращает строковое представление студенческой записи.
     * @return строковое представление студенческой записи.
     */
    public String toString() {
        // возвращаем строковое представление студенческой записи
        return this.firstName + " " + this.lastName + ", " + this.faculty + ", " + this.birthYear + ", " + this.enrollmentYear + ", " + this.id;
    }

    /**
     * Точка входа в программу.
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {
        try {
            // открываем файл с данными студенческих записей
            FileInputStream fileIn = new FileInputStream("studentRecords.txt");
            DataInputStream dataIn = new DataInputStream(fileIn);

            // создаем список для хранения студенческих записей
            ArrayList<StudentRecord> studentRecords = new ArrayList<StudentRecord>();

            // считываем данные студенческих записей из файла и добавляем их в список
            for (int i = 0; i < 50; i++) {
                StudentRecord record = new StudentRecord();
                record.readFromStream(dataIn);
                studentRecords.add(record);
            }

            // закрываем потоки ввода/вывода
            dataIn.close();
            fileIn.close();

            // выводим на экран данные студенческих записей
            for (StudentRecord record : studentRecords) {
                System.out.println(record.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
