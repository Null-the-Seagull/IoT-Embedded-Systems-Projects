#include "Adafruit_DHT.h"

// Example code written by ladyada, public domain, adapted by Saiyanide.

#define DHTPIN 2     // The Digital pin sensor is connected to

// Uncomment whatever type you're using!
#define DHTTYPE DHT11		// DHT 11 
//#define DHTTYPE DHT22		// DHT 22 (AM2302)
//#define DHTTYPE DHT21		// DHT 21 (AM2301)

// Connect the 's' pin to whichever DHTPIN is set to
// Connect the '-' pin to the Particle/Arduino/Pi's GROUND
// Connect the '+' pin to the Particle/Arduino/Pi's 3V3

float t;
DHT dht(DHTPIN, DHTTYPE);

void setup() {
	Serial.begin(9600); 
	Serial.println("DHT Temperature sensor is running, readings will begin shortly!");

	dht.begin();
}

void loop() {


  checkTemp(); //Method to read temperature
  
// Check if any reads failed and reattempts if so.
	while (isnan(t)) {
		Serial.println("Failed to read from DHT sensor!");
		
		delay(2000);
		checkTemp();
		
	}

// Output temperature reading to a Particle Serial Monitor
	Serial.print("Temp: "); 
	Serial.print(t);
	Serial.println("*C ");
	
// Send temperature reading to Particle Webhook
	Particle.publish("temp", String(t), PRIVATE);
	
//Milliseconds to wait in-between readings/webhook calls
	delay(30000); 
}

void checkTemp() {
    
// The sensors take roughly 250 milliseconds to read temperature/humidity.
// Sensor readings may also be up to 2 seconds 'old' (its a 
// very slow sensor)

    t = dht.getTempCelcius();
}
