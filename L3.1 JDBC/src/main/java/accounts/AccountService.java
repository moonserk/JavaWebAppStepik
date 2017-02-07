package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

/**
 * Created by moonserk on 15.12.16.
 */
public class AccountService {

    private DBService dbService;

    public AccountService(DBService dbService) {
        this.dbService = dbService;
    }

    public void addNewUser(String login, String password) throws DBException {
        dbService.addUser(login, password);
    }

}
