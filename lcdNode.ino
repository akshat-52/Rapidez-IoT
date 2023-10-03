#include <LiquidCrystal.h> 
int Contrast=90;
 LiquidCrystal lcd(12, 11, 5, 4, 3, 2);  

 void setup()
 {
    analogWrite(6,Contrast);
     lcd.begin(16, 2);
     Serial.begin(115200);
  while (!Serial) {
  ; // wait for serial port to connect. Needed for native USB port only
  }
  } 
     void loop()
 { 
      if (Serial.available()) {
        String printData = Serial.readString();   
        lcd.clear();
        lcd.print(printData);
    }
 }
