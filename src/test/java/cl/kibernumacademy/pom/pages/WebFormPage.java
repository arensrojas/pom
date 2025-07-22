package cl.kibernumacademy.pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class WebFormPage {
  private WebDriver driver;
  // Localizador para el campo de texto usando selector
  // id=my-text-id
  private By textInput = By.id("my-text-id");
  // Localizador para el menu desplegable
  // name=my-select
  private By selectMenu = By.name("my-select");
  // Localizador para checkbox
  // id=my-check-1
  private By checkBox = By.id("my-check-1");
  // Localizador para el botón de radio
  // id=my-radio-2
  private By radioButton = By.id("my-radio-2");
  // Localizador para el campo de fecha
  // name=my-date
  private By dateInput = By.name("my-date");
  // Localizador para el campo de contraseña
  // name=my-password
  private By passwordInput = By.name("my-password");
  // Localizador para el botón de envío del formulario
  // type=submit
  private By submitButton = By.cssSelector("button[type='submit']");
  // Localizador para el mensaje de éxito
  // id="message"
  private By successMessage = By.id("message");

  /*Constructor: recibe el webdriver para interactuar con la página */
  public WebFormPage(WebDriver driver) {
    this.driver = driver;
  }

  public void setTextInput(String text) {
    driver.findElement(textInput).clear();
    driver.findElement(textInput).sendKeys(text);
  }

  public String getTextInput() {
    return driver.findElement(textInput).getAttribute("value");
  }

  public void selectOption(String value) {
    new Select(driver.findElement(selectMenu)).selectByVisibleText(value);
  }

  public String getSelectedOption() {
    return new Select(driver.findElement(selectMenu)).getFirstSelectedOption().getText();
  }

  // Marca el checkbox si no está marcado

  public void checkCheckBox() {
    WebElement checkBoxElement = driver.findElement(checkBox);
    if (!checkBoxElement.isSelected()) {
      checkBoxElement.click();
    }
  }

  // Verifica si el checkbox está marcado
  public boolean isCheckBoxChecked() {
    return driver.findElement(checkBox).isSelected();
  }

  // Selecciona el radio button si no está seleccionado
  public void selectRadioButton() {
    WebElement radioButtonElement = driver.findElement(radioButton);
    // if (!radioButtonElement.isSelected()) radioButtonElement.click();
    if (!radioButtonElement.isSelected()) {
      radioButtonElement.click();
    } 
  }
  // Verifica si el radio button está seleccionado
  public boolean isRadioButtonSelected() {
    return driver.findElement(radioButton).isSelected();
  }

  /* Escribe una fecha en el campo correspondiente
   - Utiliza clear para borrar el valor previo
   - Utiliza sendKeys para escribir la fecha
  */
  public void setDateInput(String date) {
    WebElement dateElement = driver.findElement(dateInput); // Localiza el campo de fecha
    dateElement.clear(); // Limpia el campo de fecha antes de escribir
    dateElement.sendKeys(date); // Escribe la fecha en el campo
  }

  /*
   * Obtiene la fecha ingresada en el campo de fecha
  */
  public String getDateInput() {
    return driver.findElement(dateInput).getAttribute("value"); // Devuelve el valor del campo de fecha
  }

  // Escribe una contraseña en el campo correspondiente
  public void setPasswordInput(String password) {
    WebElement passwordElement = driver.findElement(passwordInput); // Localiza el campo de contraseña
    passwordElement.clear(); // Limpia el campo de contraseña antes de escribir
    passwordElement.sendKeys(password); // Escribe la contraseña en el campo
  }

  // Obtiene la contraseña ingresada en el campo de contraseña
  public String getPasswordInput() {
    return driver.findElement(passwordInput).getAttribute("value"); // Devuelve el valor del campo de contraseña
  }

  // Hace clic en el botón de envío del formulario
  public void clickSubmitButton() {
    driver.findElement(submitButton).click(); // Localiza y hace clic en el botón de envío  
  }

  // Obtiene el mensaje de éxito después de enviar el formulario
  public String getSuccessMessage() {
    return driver.findElement(successMessage).getText(); // Devuelve el texto del mensaje de éxito
  }


}
