package Tables;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import pages.MainFormPage;
import pages.TablePage;

public class TablesClass extends TestBase {

    @Test
    public void workOnTables() {

        new MainFormPage(driver).goToTablePage();
        new TablePage(driver).printPeaksInSwitzerlandHigherThan4000();
    }
}