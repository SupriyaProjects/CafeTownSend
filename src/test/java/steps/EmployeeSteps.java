package steps;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.core.annotation.Page;
import pages.EmployeePage;
import java.util.List;


/**
 * Created by Supriya Pawar on 7/05/2017.
 */
public class EmployeeSteps extends FluentCucumberTest{

    public static String getEmployeeName() {
        return employeeName;
    }

    private static String employeeName;

    @Page
    private EmployeePage employeePage;

    @Before
    public void before(Scenario scenario) {
        super.before(scenario);
    }

    @After
    public void after(Scenario scenario) {
        super.after(scenario);
    }

    @When("^the owner enters all the employee details as follows:$")
    public void the_owner_enters_all_the_employee_details_as_follows(DataTable employeeDetails) {
        List<List<String>> data = employeeDetails.raw();
        employeePage.createEmployee(data);
    }

    @Then("^the saved employee \"(.*?)\" should be listed$")
    public void the_saved_employee_details_should_be_listed(String empName) {
        employeePage.verifyEmployeeIsListed(empName);
    }

    @When("^the owner deletes the employee \"(.*?)\"$")
    public void the_owner_deletes_the_employee(String empName) {
        employeeName = empName;
        employeePage.deleteEmployee(employeeName);
    }

    @Then("^the employee record should be deleted$")
    public void the_employee_record_should_be_deleted() {
        employeePage.verifyEmployeeIsDeleted(employeeName);
    }

    @And("^the owner edits the employee details as follows:$")
    public void the_owner_edits_the_employee_details_as_follows(DataTable employeeDetails) {
        List<List<String>> data = employeeDetails.raw();
        employeePage.editEmployee(data);
    }
}


