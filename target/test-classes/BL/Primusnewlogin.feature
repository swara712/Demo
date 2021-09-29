Feature:Login fuctionality for primus bank
Background: Login functionality
Background: User successfully logged 
Given users opens "Chrome" browser and exe "E:\\Automation Support\\chromedriver.exe"
Given user enters url as "http://primusbank.qedgetech.com/"


Scenario Outline: login functionality with valid credentials

When user enters <username> as username
When user enters <password> as password
When user click on login button
Then Check "Welcome to Login" as validation msg for valid credential
Then close browser
Examples:
      |username|password|
      |Admin|Admin|
      |Admin|Admin123|
      |Admin123|Admin|
      |Admin123|Admin123|
      
Scenario Outline: login functionality with invalid credentials
When user enters <username> as username
When user enters <password> as password
When user click on login button
Then Check "Welcome to Login" as validation msg for invalid credential
Then close browser
Examples:
      |username|password|
      |Admin@#|Admin|
       |$#%$$|Admin|
      |AERds|Er456|
       |S$5D|ss*&n|
      
