
package com.knoldus

/* This is trait of PaymentProcess */
trait PaymentProcess {
  /* It is abstract method that used in other Payment Method Classes */
  def paymentProcess(amount: Double, total: Double): String
}

/* It is case class of CreditCard and it extending the Payment Process trait */
case class CreditCard(cardNumber: Long, cardHolderName: String, cvv: Int, expiryDate: String) extends PaymentProcess {

  /* This method is used to process the payment by credit card */
  override def paymentProcess(amountToDeduct: Double, totalAmount: Double): String = {
    if (cardHolderName == "Manish" && cvv == 322 && expiryDate == "12/2025") {
      val balance = totalAmount - amountToDeduct
      s"Payment Successfully from Credit Card.\nBalance Left :$balance"
    }
    else {
      "Payment Failed Wrong Details"
    }
  }
}

/* It is case class of Paypal and it extending the Payment Process trait*/
case class Paypal(userName: String, email: String) extends PaymentProcess {

  /* This method is used to process the payment by Pay Pal */
  override def paymentProcess(amountToDeduct: Double, totalAmount: Double): String = {
    if (userName == "Manish Mishra" && email == "manish.mishra@knoldus.com") {
      val balance = totalAmount - amountToDeduct
      s"Payment Successfully from PayPal.\nBalance Left :$balance"
    }
    else {
      "Not match with Input"
    }
  }
}

/* It is case class of BankTransfer and it extending the Payment Process trait*/
case class BankTransfer(accountHolderName: String, accountNumber: Long) extends PaymentProcess {

  /* This method is used to process the payment by Bank Transfer */
  override def paymentProcess(amountToDeduct: Double, totalAmount: Double): String = {
    if (accountHolderName == "Manish Mishra" && accountNumber == 123456789) {
      val balance = totalAmount - amountToDeduct
      s"Transfer Payment Successfully from Bank.\nBalance Left :$balance"
    }
    else {
      "Not match with Input"
    }
  }
}

