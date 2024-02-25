“Intelligent Parking System (IPS)” provides user an easy way of booking the parking slots through
an application. To avoid the problem of traffic conjunction in commercial areas that unnecessarily
consumes time, this application provides the easy reservation system for parking. In this application
the user can view various parking slots and check for the availability of slots.
Whenever a car is parked in a parking slot , that parking slot will be marked red and all the available
parking slots will be green.

Vehicle follows its path to the parking area. The user fixes his slots by showing his confirmation
details to the concerned person at parking area. After communicating, the vehicle will further follow
its path to the allocated parking slot. After successful parking the slot details are updated
simultaneously in the Administrators database and that parking slot will be indicated by red colour.

## PROPOSED SYSTEM:
### 1. Installation and Registration:

- Android application on the user's Android device.
- App icon appears on the device's home screen.
- User performs one-time registration providing details like name, address, gender, and mobile number.
- All registration data securely stored on a server.

### 2. Parking Location Selection:

- Multiple parking locations available for the client.
- Client selects desired parking location through the app.

### 3. Slot Availability Display:

- Parking slots displayed on the client's device.
- Green color indicates an available slot; red indicates a full slot.
- Color coding aids in easy identification of available and occupied spots.

### 4. Parking Confirmation:

- If a required space is available, the client can proceed with parking.

### 5. Efficient Parking Management:

- System effectively handles parking in crowded areas.
- No need for modifications to existing parking infrastructure.

### 6. System Components:

- IR sensors deployed at each parking space.
- ESP8266 NodeMCU facilitates wireless communication.
- Mobile phone serves as the user interface.

### 7. Data Processing and Transmission:

- IR sensors detect parking space availability.
- Data transmitted to ESP8266 NodeMCU.
- NodeMCU forwards data to Firebase for storage.
- Data converted into a graphical interface for user interaction.

### 8. Real-Time Updates:

- Vacant parking spots marked as green on the mobile application.
- Occupied spots marked as red.
- Provides real-time updates to users about parking availability.

![image](https://github.com/chaitanyaamle/IntelligentParkingSystem/assets/30501921/06865f25-6cc0-412b-9a1f-ef9957558d3c)
![image](https://github.com/chaitanyaamle/IntelligentParkingSystem/assets/30501921/5653f0ad-491c-414b-b079-ed57d914c174)

