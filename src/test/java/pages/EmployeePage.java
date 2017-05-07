package pages;


import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import providers.PageUtils;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withText;
/**
 * Created by Supriya Pawar on 7/05/2017.
 */
public class EmployeePage extends PageUtils{

    @FindBy(css = "#bAdd")
    private FluentWebElement createEmployeeButton;
    @FindBy(xpath = "//input[@type='text']")
    private FluentWebElement firstname;
    @FindBy(xpath = "(//input[@type='text'])[2]")
    private FluentWebElement lastname;
    @FindBy(xpath = "(//input[@type='text'])[3]")
    private FluentWebElement startdate;
    @FindBy(css = "input[type=\"email\"]")
    private FluentWebElement email;
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private FluentWebElement addButton;
    @FindBy(css = "div[id=\"employee-list-container\"]>ul")
    private FluentWebElement employeeListContainer;
    @FindBy(css = "div[id=\"employee-list-container\"]>ul>li")
    private FluentWebElement employeeList;
    @FindBy(css = "#bDelete")
    private FluentWebElement deleteEmployeeButton;

    @Override
    public void isAt() {
        assertThat(window().title()).contains("CafeTownsend-AngularJS-Rails");
    }

    private void clickOnCreateEmployeeButton(){
        waitForElementVisible(createEmployeeButton);
        createEmployeeButton.click();
    }

    public void createEmployee(List<List<String>> emp) {
        clickOnCreateEmployeeButton();
        waitForElementVisible(firstname);
        firstname.fill().with(emp.get(1).get(0));
        lastname.fill().with(emp.get(1).get(1));
        startdate.fill().with(emp.get(1).get(2));
        email.fill().with(emp.get(1).get(3));
        addButton.click();
    }

    public void verifyEmployeeIsListed(String employeeName) {
        waitForElementVisible(employeeList);
        employeeListContainer.$("li", withText().contains(employeeName)).scrollIntoView();
    }

    public void deleteEmployee(String employeeName) {
        employeeListContainer.$("li", withText().contains(employeeName)).scrollIntoView();
        employeeListContainer.$("li", withText(employeeName)).click();
        deleteEmployeeButton.click();
        alert().accept();
    }

    public void verifyEmployeeIsDeleted(String employeeName) {
        String empListContainer = "div[id=\"employee-list-container\"]>ul";
        waitForElementWithTextNoVisible(employeeName, empListContainer);
        assertThat(employeeListContainer.$("li", withText().notContains(employeeName)));
    }
}
