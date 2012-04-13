Avalara Get Tax Demo
====================

INTRODUCTION
  This simple application calculates taxes from zuora using information retrieved from a Zuora.       

HOW TO DEMO:
  In order to run this test, you need to setup the following environment variable:
  	* avalaraAccount - The avalara account
    * avalaraLicense - The avalara license
    * zuoraUsername - the Zuora login username
    * zuoraPassword - the Zuora login password
	
  * If running from AvalaraFunctionalTestDriver, you just need to run  method. 
  * If running from a Mule Container:  
    	 Example http://localhost:9090/avalara-demo-get-tax, with which parameters:
         - invoiceNumber
        
  	
HOW IT WORKS:
  1. Retrieves an Invoice record from Zuora given its Id. Answers the record as payload, and sets the following invocation headers:
      * accountId
      * createDate
      * dueDate
  2. Retrieves a collection of InvoiceItems from Zuora given it's invoice id.
     Expects the variable:invoiceId to be set
     Answers the collection of items.
  3. Gets taxes from Avalara for the given collection of zuora InvoiceItems payload. 
     It expects the following headers to be set:
      * sKU
      * quantity
      * unitPrice
      * chargeDescription