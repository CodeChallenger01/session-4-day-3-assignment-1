
package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.language.postfixOps

class PaymentMethodTest extends AnyFlatSpec with Matchers {

  val paymentObject = new PaymentMethod
  private val addPaymentMethod = paymentObject.addAnotherPayment("credit-card") ++ paymentObject.addAnotherPayment("paypal")
  private val addedBankTransferMethod = addPaymentMethod ++ paymentObject.addAnotherPayment("bank-transfer")
  private val listOfPaymentMethods = addPaymentMethod

  "addPaymentMethod" should "add new Payment Method such as credit-card" in {
    val addPaymentMethod = paymentObject.addAnotherPayment("credit-card")
    val cardNumber: Long = 123456
    val cardHolderName: String = "Manish"
    val cvv: Int = 322
    val expiryDate: String = "12/2025"
    val actualOutput = List(CreditCard(cardNumber, cardHolderName, cvv, expiryDate))
    actualOutput shouldBe addPaymentMethod
  }

  "addPaymentMethod" should "add new Payment Method such as pay-pal" in {
    val addPaymentMethod = paymentObject.addAnotherPayment("paypal")
    val userName: String = "Manish Mishra"
    val emailId: String = "manish.mishra@knoldus.com"
    val actualOutput = List(Paypal(userName, emailId))
    actualOutput shouldBe addPaymentMethod
  }

  "addPaymentMethod" should "add new Payment Method such as bank-transfer" in {
    val addPaymentMethod = paymentObject.addAnotherPayment("bank-transfer")
    val accountHolderName: String = "Manish Mishra"
    val accountNumber: Long = 123456789
    val actualOutput = List(BankTransfer(accountHolderName, accountNumber))
    actualOutput shouldBe addPaymentMethod
  }

  "addPaymentMethod" should "not add other payment details instead of paypal, credit-card and bank transfer" in {
    val addPaymentMethod = paymentObject.addAnotherPayment("upi-payment")
    val actualOutput = List()
    actualOutput shouldBe addPaymentMethod
  }

  "listOfPaymentMethod" should "match with list of all payment Methods" in {
    val listOfPayment = paymentObject.listAllPaymentMethods(addPaymentMethod)
    assert(listOfPayment == addPaymentMethod)
  }

  "listOfPaymentMethod" should "not match with list of different payment Methods" in {
    val listOfPayment = paymentObject.listAllPaymentMethods(addPaymentMethod)
    val accountHolderName: String = "Manish Mishra"
    val accountNumber: Long = 123456789
    val actualOutput = List(BankTransfer(accountHolderName, accountNumber))
    assert(listOfPayment != actualOutput)
  }

  "payment By Credit Card" should "match Payment successfully if it match with details" in {
    val processPaymentType: String = "credit-card"
    val result = paymentObject.selectProcessPayment(listOfPaymentMethods, processPaymentType)
    val expectedOutput: String = s"Payment Successfully from Credit Card.\nBalance Left :900.0"
    expectedOutput shouldBe result
  }

  "payment By Pay Pal" should "match Payment successfully if it match with details" in {
    val processPaymentType: String = "paypal"
    val result = paymentObject.selectProcessPayment(listOfPaymentMethods, processPaymentType)
    val expectedOutput: String = s"Payment Successfully from PayPal.\nBalance Left :900.0"
    expectedOutput shouldBe result
  }

  "payment By Bank Transfer" should "match Payment successfully if it match with details" in {
    val processPaymentType: String = "bank-transfer"
    val result = paymentObject.selectProcessPayment(addedBankTransferMethod, processPaymentType)
    val expectedOutput: String = s"Transfer Payment Successfully from Bank.\nBalance Left :900.0"
    expectedOutput shouldBe result
  }

  "payment By Other 3 Method" should "match None Payment Found" in {
    val processPaymentType: String = "upi-payment"
    val result = paymentObject.selectProcessPayment(addedBankTransferMethod, processPaymentType)
    val expectedOutput: String = s"None Payment Found"
    expectedOutput shouldBe result
  }

}
