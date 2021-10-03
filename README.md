# ss-utopia-card

### Deprecation notice
- Card microservice will no longer be used.
- Account microservice will now handle all card functions.

#### Cards microservice
- Backend microservice that handles credit & debit cards.
- Routes are secured with JWT authorization & HTTPS.
- Routes are accessed through Spring cloud gateway & Eureka server.

#### REST controller methods:	
- Create a new card type
- Get all card types
- Apply for a card

#### Types of cards:
- Credit
- Debit
