# Design ATM

## Flow
When we go to ATM we have to first insert our ATM card, after that we enter pin and then there are multiple options available to choose from for the cash withdrawal, 
I choose the mode and the amount to withdraw, after that machine validate that amount give me cash if there is enough and update my bank account.

## Objects Required
- ATM  
- ATM State  
	- Idle State  
	- Card Inserted State  
	- VerifiedPin State  
		- Fetch bank details
    - update bank balance
	- MenuState  
- Cash Withdraw Handler  
- verifyBalance -> verifyCash -> Withdraw Cash -> Update Account  
- ATM Handler  
- User  
- Card  
- Bank account  
- External Bank Interface  

![image](https://github.com/user-attachments/assets/1e87c67d-755b-489d-af46-ba895d993b6c)
