# session-4-day-3-assignment-1
This assignment contains  session-4-day-3-assignment-1(Payment)
   
**Step 1:** Open IntelliJ and create a new Project of Name **payment-system**     
**Step 2:** Create **three scala fil**e with same class name in **src/main/scala/com/knoldus**       
        **1. PaymentMethod      
        2. PaymentProcess          
        3. Driver** 
**Step 3:** In PaymentMethod file create a class **PaymentMethod** and declare an empty list of payment methods. Define three method inside that class
        **1. addAnotherPayment :** It take type of **payment method and match with the type** and create that type of payment method with details and                        add it to newList of payment methods.
           **It contains three type:**
              **i. credit-card
              ii. paypal
              iii. bank-transfer**
        **2. listAllPaymentMethods:** This method is used **to view the list of all the payment** available for transaction
        **3. selectProcessPayment:** In this method we **perform the payment process** by matching with type of payment and after that call paymentProcess                  method from PaymentProcess class.     
**Step 4:** In PaymentProcess we declare a **trait of name PaymentProcess** and define a **abstract method of name paymentProcess** with return type String. Inside this scala file we declare three case class for CreditCard, Paypal, BankTransfer with their field.      
**Step 5:** Each **case class extend the trait** and define the body part of** each payment with process** of money deduction by validating data.     
**Step 6:** In Driver class create object of **PaymentMethod and add call method** to add new Payment methods and call each method to **check the functionality etc**.    
**Step 7:** After that add the **scalatest dependencies** in build.sbt file     
**Step 8:** Also add **scalastyle plugin in plugin.sbt** of project folder and sync the project. After that run a command of **terminal to generate** scalastyle-config.xml by **sbt scalastyleGenerateConfig **    
**Step 9:** Create a **Test Class in src/test/scala/com.knoldus**. Inside the test class extend the AnyFlatSpec with Matchers Class and import the scalatest package in that test class.     
**Step 10:** Inside the test class create instance of Class in each **test case with different scenario** and check with assert.     
**Step 11:** In terminal run the **command sbt test** it show the result that test case is passed or fail.
   
   **OUTPUT 
sbt compile & sbt run**
