package Saper;

public class Main {
    public static void main(String[] args) {
        //int[] arr = {1, 2, 5, 0, 111, 10};
        //System.out.println(getMax(arr, 0, 0));
        //stringSravPrint("test", "t1es", 0, 0);
        //System.out.println(stringSrav("test", "test", 0, 0));
        //String n = "123456";
        //System.out.println(swap(n, "", 1));
//        String[] arr = new String[3];
//        arr[0] = "123";
//        arr[1] = "123456";
//        arr[2] = "123456789";
//        System.out.println(find(arr, "123", 0));

//        Integer[] arr = {1, 2, 4, 5};
//        Integer z = 2;
//        System.out.println(findAnyType(arr, z, 0));


    }
    public static int getMax(int[] arr, int index, int max) {
        if (index < arr.length) {
            if (arr[index] > max) {
                max = arr[index];
                index++;
                return getMax(arr, index, max); //  Почему???
            }
            index++;
            return getMax(arr, index, max); //Почему без ретерн не работает?
        }
        return max;
    }
    // Написать рекурсивный метод, сравнивающий две строки на равенство посимвольно
    // (попробовать с возвратом результата и просто с печатью на консоль)

    public static void stringSravPrint(String a, String b, int index, int count) {
        if (a.length() > b.length() || a.length() < b.length()) {
            System.out.println("Строки не равны");
        }
        else if (a.length() > index && a.charAt(index) == b.charAt(index)){
            index++;
            count++;
            stringSravPrint(a,b,index, count);
        }
        else if (a.length() > index && a.charAt(index) != b.charAt(index)){
            System.out.println("Строки не равны");
        }
        else if (count == a.length()) {
            System.out.println("Строки равны");
        }
    }

    public static String stringSrav(String a, String b, int index, int count) {
        if (a.length() > b.length() || a.length() < b.length()) {
            return "Строки не равны";
        }
        else if (a.length() > index && a.charAt(index) == b.charAt(index)){
            index++;
            count++;
            return stringSrav(a,b,index, count);
        }
        else if (a.length() > index && a.charAt(index) != b.charAt(index)){
            return "Строки не равны";
        }
        ///else if (count == a.length()) {
        else{
            return "Строки равны";
        }
        //return null;
    }
    //Дано число n, записанное в типе String. Получите число, записанное теми же цифрами,
    // но в противоположном порядке.
    //При решении этой задачи нельзя использовать циклы, списки, массивы, разрешается только рекурсия.
    //Фунция должна возвращать число в типе String, являющееся результатом работы программы.
    public static String swap (String n, String n1, int count) {
        if (n.length() >= count) {
            n1 += n.charAt(n.length() - count);
            count++;
            return swap(n,n1,count);
        }
        return n1;
    }
//    Написать метод, который будет принимать в качестве параметра массив типа String и сроку
//    , которую метод будет рекурсивно искать в массиве (вы можете добавлять дополнительные параметры методу).
//    Если данная строка есть в массиве, метод должен вернуть true, иначе - false.
//    В методе запрещено использовать циклы.
//Можно сделать задачу более сложным путем: сделайте так,
// чтобы метод мог принимать массив в любом типе данных и искать в этом массиве
// значение также в любом типе данных, а не только в виде строки.

    public static boolean find (String[] arr, String z, int count) {
        if(count >= arr.length){
            return false;
        }

        if (arr[count].equals(z)) {
            return true;
        }
        else{
            count++;
            return find(arr, z, count);
        }


        /*if (arr.length > count && arr[count].equals(z)) {
            return true;
        }
        else if(arr.length > count) {
            count++;
            find(arr, z, count);
        }
        else if (count == arr.length) {
            return false;
        }
        return find(arr,z, count);

         */
    }

    public static boolean findAnyType (Object[] arr, Object z, int count) {
        if (arr.length > count && arr[count].equals(z)) {
            return true;
        }
        else if(arr.length > count) {
            count++;
            findAnyType(arr, z, count);
        }
        else if (count == arr.length) {
            return false;
        }
        return findAnyType(arr,z, count);
    }

}
