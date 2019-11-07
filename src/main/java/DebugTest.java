import java.util.HashMap;

public class DebugTest {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name","tom");
        map.put("age","12");
        map.put("school","tsinghua");
        map.put("major","computer");
        String age = map.get("age");
        System.out.printf("age");

        map.remove("major");
        System.out.println(map);
    }
}
