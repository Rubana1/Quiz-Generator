package Services;

import java.util.HashMap;

public class SignupService {
    private static HashMap<String, String> users = new HashMap<>();

    public static boolean createUser(String email, String password) {
        if (users.containsKey(email)) {
            return false; 
        }
        users.put(email, password);
        return true;
    }

    
}
