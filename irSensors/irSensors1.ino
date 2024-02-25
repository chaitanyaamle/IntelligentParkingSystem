#include <ESP8266WiFi.h>
#include <FirebaseArduino.h>

// Set these to run example.
#define FIREBASE_HOST "ipslogin-747e7.firebaseio.com"
#define FIREBASE_AUTH "8nyi9xXqX5Zk5EI7ELqDRpxcXatWRfOze3kH04v0"
#define WIFI_SSID "OnePlus 7T"
#define WIFI_PASSWORD "Swaraj@31"
#define IROBJAVOID_1_PIN_OUT  5
#define IROBJAVOID_2_PIN_OUT  4
#define IROBJAVOID_3_PIN_OUT  0
#define IROBJAVOID_4_PIN_OUT  2
#define IROBJAVOID_5_PIN_OUT  14

void setup() {
  
  Serial.begin(115200);
    // connect to wifi.
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("connecting");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(500);
  }
  Serial.println();
  Serial.print("connected: ");
  Serial.println(WiFi.localIP());

  pinMode(IROBJAVOID_1_PIN_OUT, INPUT);
  pinMode(IROBJAVOID_2_PIN_OUT, INPUT);
  pinMode(IROBJAVOID_3_PIN_OUT, INPUT);
  pinMode(IROBJAVOID_4_PIN_OUT, INPUT);
  pinMode(IROBJAVOID_5_PIN_OUT, INPUT);
  
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
  
}


void loop() {

  // 1st Sensor------------------------------
    int irObjAvoidVar1 = !digitalRead(IROBJAVOID_1_PIN_OUT);
    Serial.print(("1st Sensor: ")); Serial.println(irObjAvoidVar1);
    delay(400);
    Firebase.set("1st Sensor",irObjAvoidVar1);
    //*********************************************************

    //2nd Sensor------------------------------
    int irObjAvoidVar2 = !digitalRead(IROBJAVOID_2_PIN_OUT);
    Serial.print(("2nd Sensor: ")); Serial.println(irObjAvoidVar2);
    delay(400);
    Firebase.set("2nd Sensor",irObjAvoidVar2);
    //************************************************************
    
//    //3rd Sensor-------------------------------
//    int irObjAvoidVar3 = !digitalRead(IROBJAVOID_3_PIN_OUT);
//    Serial.print(("3rd Sensor: ")); Serial.println(irObjAvoidVar3);
//    delay(400);
//    Firebase.set("3rd Sensor",irObjAvoidVar3);
//    //*************************************************************
//    
//    //4th Sensor--------------------------------
//    int irObjAvoidVar4 = !digitalRead(IROBJAVOID_4_PIN_OUT);
//    Serial.print(("4th Sensor: ")); Serial.println(irObjAvoidVar4);
//    delay(400);
//    Firebase.set("4th Sensor",irObjAvoidVar4);
//    //**************************************************************
//
//    //5th Sensor---------------------------------
//    int irObjAvoidVar5 = !digitalRead(IROBJAVOID_5_PIN_OUT);
//    Serial.print(("5th Sensor: ")); Serial.println(irObjAvoidVar5);
//    delay(400);
//    Firebase.set("5th Sensor",irObjAvoidVar5);
//    //**************************************************************
    
   }
