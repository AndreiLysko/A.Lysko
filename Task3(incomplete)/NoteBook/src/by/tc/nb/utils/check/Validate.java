package by.tc.nb.utils.check;

import by.tc.nb.bean.entity.Note;

public class Validate {

    private static final String REG_EXP_NOTE = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d  \\|  (.*)";

    public static boolean content(String content, Note note){

        if(note.getData().contains(content)){
            return true;
        } else {
            return false;
        }
    }

    public static boolean date(String searchDate, Note note) {

        if(note.getCreationDate().contains(searchDate)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean note(String strForCheck) {

        if(strForCheck.matches(REG_EXP_NOTE)) {
            return true;
        } else {
            return false;
        }
    }
}
