package stepDefinition;

import io.cucumber.java.en.*;
import utils.DriverManager;
import pages.CalculatorPage;

public class openCalculatorSteps {
    private CalculatorPage calculatorPage; // Variable para la página de la calculadora

    @Given("Abro la calculadora")
    public void abro_la_calculadora()  {
        // Inicializa el driver
        DriverManager.initialize();
        // Crea una instancia de la página de la calculadora
        calculatorPage = new CalculatorPage(DriverManager.getDriver());
    }

    @When("Ingreso un numero")
    public void ingresoUnNumero() {
        // Usa el método de la página para presionar el número 5
        calculatorPage.pressDigit5();
    }
}
