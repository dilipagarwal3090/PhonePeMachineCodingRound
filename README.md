# PhonePeMachineCodingRound

Mandatory Implementations

addProvider(Provider provider)
This function is to create and store the provider.
It can only be created if it passes all necessary validations.

getProvider(String providerId)
To get the provider details for the given providerId.

updateState(String providerId, boolean active)
To update the state of the provider to active/inactive

updateProvider(Provider provider)
To update the details of an existing provider.

processRequest(Request)
To process the incoming request



Your system should be able to take different type of communication requests: Email request, Sms request, Soundbox request
Each request will take different inputs as per the requirement for that request type.
Email requests need to have a sender, receiver, subject and message as mandatory fields.
While a sms request may require a mobile number and the message as mandatory fields.
Your system will be integrating with external providers and call their API in order to be able to send out the required communication.
your system needs to onboard different type of providers.
A provider can support multiple channels (SMS, Email, Soundbox) and you can have multiple providers for a single channel.
There should be an authentication mechanism present when making calls to the provider (either in the headers or in the request, we should pass the required username and password)
Each provider will provide a separate API endpoint for each channel (SMS/Email) to send the request to.
Each provider can have multiple accounts, with each account handling a single or multiple channel requests. Account segregation is done in order to be able to handle some critical communications in a better way (like OTP comms)
On receiving a request, you need to randomly choose one of the eligible active providers for processing the request.

addProvider(Provider provider)
It can only be created if it passes all necessary validations. Basics validatins should be there before function is to create and store the provider. 

getProvider(String providerId)
To get the provider details for the given providerId.

updateState(String providerId, boolean active)
To update the state of the provider to active/inactive

updateProvider(Provider provider)
To update the details of an existing provider.

processRequest(Request)
To process the incoming request

Use sepearte Account to handle separate EMAIL TYPE like CRTICAL, NORMAL, WITHIN Minute and SEPARATE Communication chanel like EMAIL SMS. Each provider can have multiple accounts, with each account handling a single or multiple channel requests. 
Create Sepearte EMAIL type and handle that if email; request if of particualr type use particular type of provider 
Create Sepearte SMS type like critical and handle that if sms request is of particualr type use particular type of provider 
Implement it using the strategy, Factory and builder pattern
Create separate class for enum and each component, use proper SOLID principles
There should be atleast 30 and maximum 40 files you create 
Create Separate Main class to test out the code
Write proper implementation as you are senior senior SDE in big MNC and you understand software enginerring very well
implementation of each component should be present and code should be working 
USE proper interfaces and SOLID principles 
