
package com.knoldus

class PaymentMethod {
  private val listOfMethod = List.empty

  /* This method is used to add new payment method like credit-card, paypal and bank transfer */
  def addAnotherPayment(paymentType: String): List[PaymentProcess] = {
    paymentType match {
      /* This case is used to create credit-card */
      case "credit-card" => {
        val cardNumber: Long = 123456
        val cardHolderName: String = "Manish"
        val cvv: Int = 322
        val expiryDate: String = "12/2025"
        val creditCard: PaymentProcess = CreditCard(cardNumber, cardHolderName, cvv, expiryDate)
        val newList = listOfMethod.appended(creditCard)
        newList
      }
      /* This case is used to create paypal */
      case "paypal" => {
        val userName: String = "Manish Mishra"
        val emailId: String = "manish.mishra@knoldus.com"
        val paypalMethod: PaymentProcess = Paypal(userName, emailId)
        val newList = listOfMethod.appended(paypalMethod)
        newList
      }
      /* This case is used to create bank-transfer */
      case "bank-transfer" => {
        val accountHolderName: String = "Manish Mishra"
        val accountNumber: Long = 123456789
        val bankPaymentMethod: PaymentProcess = BankTransfer(accountHolderName, accountNumber)
        val newList = listOfMethod.appended(bankPaymentMethod)
        newList
      }
      /* If none of the method match then it result the empty list */
      case _ => listOfMethod
    }
  }

  /* This method is used to view all the payment methods available to the user */
  def listAllPaymentMethods(list: List[PaymentProcess]): List[PaymentProcess] = {
    list
  }

  /* This method is used to select the payment to process as per pattern match */
  def selectProcessPayment(addPaymentMethod: List[PaymentProcess], processPaymentType: String): String = {
    val amountToDeduct = 100
    val totalBalance = 1000
    val afterProcess = processPaymentType match {
      case "credit-card" => addPaymentMethod.head.paymentProcess(amountToDeduct, totalBalance)
      case "paypal" => addPaymentMethod(1).paymentProcess(amountToDeduct, totalBalance)
      case "bank-transfer" => addPaymentMethod(2).paymentProcess(amountToDeduct, totalBalance)
      case _ => s"None Payment Found"
    }
    afterProcess
  }
}


