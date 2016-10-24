package by.tc.nb.dao;

import by.tc.nb.dao.impl.mysql.MySQLQuestionsDAO;

public class QuestionsDAOFactory {

    private static final QuestionsDAOFactory instance = new QuestionsDAOFactory();
    private QuestionsDAO questionsDAO = new MySQLQuestionsDAO();

    public static QuestionsDAOFactory getInstance() {
        return instance;
    }

    public QuestionsDAO getQuestionsDAO() {
        return questionsDAO;
    }
}
