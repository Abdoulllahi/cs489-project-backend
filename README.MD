# Problem description

Moviemail: Online DVD rental

We need to specify the requirements of a new system called MovieMail that allows customers to order DVD’s online and receive and return DVD’s by regular mail. This way you do not have to go to the physical video rental store.

Customers can order a subscription at MovieMail. The following subscriptions are offered:

|Name subscription |Number of DVD’s you may have at home |Number of DVD’s per month |Price per month |
| :- | :-: | :-: | :-: |
|Platina |4 |6 |$15,00  |
|Gold |3 |5 |$13,00  |
|Silver |2 |4 |$11,00  |
|Bronze |1 |3 |$9,00  |
|Basic |1 |2 |$7,00  |

Customers can subscribe online and pay in two different ways:

1. creditcard
1. bank transfer

If the customers pays with creditcard, the system will use an external system called Epay.com. Epay.com is a system that can be called through webservices and offers the following services:

1. validate creditcards
1. handle the creditcard payment

If Epay.com is not available, then we don’t accept subscriptions that are paid with creditcard.

If the customer wants to pays with a bank transfer, the system will collect the bank information from the customer, and an MovieMail employee will perform the actual bank transfer with the online bank application of their local bank. If the bank transfer succeeded, the employee will record this in the MovieMail system.

After successfully ordering a subscription, the customer will receive the account login information by email.

Customers can have more than 1 subscriptions. Every subscription has its own account with their own username/password combination.

When the customer logs into the system, he/she can place DVD’s on a watchlist. You are allowed to place a maximum of 50 DVD’s on the watchlist. Customers can change the watchlist at any time. The watchlist has a certain order. The higher the order of the DVD on the watchlist, the higher the change that you will receive this DVD. If the customer receives a DVD, he/she can keep this DVD as long as you want at home.

If a customer wants to see a DVD that is not in the catalog of MovieMail, then you can place a request to add this DVD into the DVD catalog.

Every DVD has a unique scan code. If a DVD is send out, or received back, the DVD is scanned so that the system knows exactly where the DVD’s are at the moment. The system prints the return envelopes automatically.

The system can show for every customer which DVD’s he/she has at home, or has returned to MovieMail.

The system offers the following reporting functionality:  

1. The top x ( x is a variable) most popular DVD’s
1. The top x most requested DVD’s  
1. An overview of all subscriptions and how much we earned.
1. The top x least popular DVD’s

At MovieMail we have a CRM system where we store all relevant information from customers. When a customer orders a movie subscription, we want to add the customer information in our CRM system so we can use that information for advertising purposes.

It is not possible to end a subscription before the ending date, and it is also not possible to get money back from your ordered subscription.

Exercises

1. Draw the context diagram of the MovieMail system
2. Draw the ER diagram of the MovieMail system

![alt text](screenshots/UML.jpg)
