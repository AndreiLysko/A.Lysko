package com.epam.data;

/**
 * Created by Andrei_Lysko on 9/23/2016.
 */
public class ProgrammerBook extends Book {

    private String language;
    private int level;

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result;
        result = super.hashCode();
        result = prime * result + getLevel();
        result = prime * result + getLanguage().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        ProgrammerBook book = (ProgrammerBook) obj;
        if (!super.equals(obj)) {
            return false;
        } else {
            if (!this.language.equals(book.language)) {
                return false;
            }
            if (!(this.level == book.level)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " Language: " + getLanguage() + " Level: " + String.valueOf(getLevel());
    }
}