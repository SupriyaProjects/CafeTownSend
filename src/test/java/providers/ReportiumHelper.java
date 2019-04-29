package providers;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ReportiumHelper {

  public static ReportiumClient reportiumClient;

  ReportiumHelper(RemoteWebDriver remoteDriver) {
    PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
        .withProject(new Project("Qantas Booking Engine Supriya ", "1.0"))
        .withJob(new Job("Desktop tests", 45))
        .withContextTags("Regression")
        .withWebDriver(remoteDriver)
        .build();
    reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);
  }

  public static ReportiumClient getReportiumClient() {
    return reportiumClient;
  }

  public static void startTest(String testName, String context) {
    reportiumClient.testStart(testName, new TestContext(context));
  }
}
