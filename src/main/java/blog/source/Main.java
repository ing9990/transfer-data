package blog.source;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main {

    static Map<String, String> staticSsMap = Map.of("first", "value1");
    static Map<String, Person> staticSpMzap = new HashMap<>();


    public static void main(String[] args) {
        Map<String, String> localSsMap = Map.of("first", "value1");
        Map<String, Person> localSpMap = Map.of("first", new Person("taewoo"));

        long pid = ProcessHandle.current().pid();
        System.out.println("PID: " + pid);
        new Main().task1().run();

    }

    public Thread task1() {
        System.out.println("Static Map에 동적으로 생성된 객체를 넣는 상황.");
        return new Thread(() -> {
            while (true) {
                String userId = UUID.randomUUID().toString();

                staticSpMzap.put(UUID.randomUUID().toString(), new Person(userId));
                System.out.println("Init person from " + userId);
            }
        });
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


