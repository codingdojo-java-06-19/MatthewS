public class Calculator {
  private Double operandOne = 0.00;
  private Double operandTwo = 0.00;
  private String operation;
  private Double result = 0.00;

  public Calculator() {

  }

  public void setOperandOne(Double getOperandOne) {
    this.operandOne = getOperandOne;
  }

  public void setOperandTwo(Double getOperandTwo) {
    this.operandTwo = getOperandTwo;
  }

  public void setOperation(String getOperator) {
    this.operation = getOperator;
  }

  public void performOperation() {
    if (this.operation == "+") {
      this.result = operandOne + operandTwo;
    } else if (this.operation == "-") {
      this.result = operandOne - operandTwo;
    } else {
      System.out.println("Operand must be either plus or minus");
    }
  }

  public Double getResults() {
    System.out.println(result);
    return result;
  }

}