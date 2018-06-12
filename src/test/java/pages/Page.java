package pages;

import ru.yandex.qatools.allure.annotations.Step;

public class Page {

    public int getRandomNumber(int a1, int b1) {
        int a = a1;
        int b = b1;
        int x = a + (int) (Math.random() * ((b - a) + 1));
        return x;
    }

    public boolean equalsIgnoreCase(String str1, String str2) {
       boolean equals =  str1.equalsIgnoreCase(str2);
        return equals;
    }

    @Step("{0}")
    public static void report(String s) {}

}
