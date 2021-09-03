package quizzes.quiz2;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(2);
        list.add(3);

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += (int)list.get(i);
        }

    }
}
