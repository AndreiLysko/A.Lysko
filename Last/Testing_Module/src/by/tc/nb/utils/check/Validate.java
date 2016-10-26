package by.tc.nb.utils.check;

public class Validate {

    private static final String REG_EXP_INTEGER = "\\d+";

    public static boolean integer(String checkStr){

        if(checkStr.matches(REG_EXP_INTEGER)){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean question(int subjectID, String searchString) {

        if (searchString == null || searchString.equals("") || subjectID < 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean loginParameters(String username, String password){
        if(username == null || username.equals("") || password == null || password.equals("")) {
            return false;
        }
        else{
            return true;
        }
    }

}
