
int led1 = D5; //Wired LED
int led2 = D7; //In-built Blue LED
int morse_unit = 300; //Timing unit (in ms)

void setup() {
  //Set LED Pin modes as OUTPUTS
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);

}

void loop() {
    dot();
    dash();
    dot();
    dot();
    space(); //L
    
    dot();
    dot();
    space(); //I
    
    dot();
    dash();
    space(); //A
    
    dash();
    dash();
    space(); ///M


    space(); //Long space to finish Morse Word
    space(); 
}

void dash() { //Dash
  digitalWrite(led1, HIGH);
  digitalWrite(led2, HIGH);
  delay(morse_unit * 3);
  digitalWrite(led1, LOW);
  digitalWrite(led2, LOW);
  delay(morse_unit);
}

void dot() { //Dot
  digitalWrite(led1, HIGH);
  digitalWrite(led2, HIGH);
  delay(morse_unit);
  digitalWrite(led1, LOW);
  digitalWrite(led2, LOW);
  delay(morse_unit);
}

void space() { //Space used for after a Letter's combination is complete
    delay(morse_unit * 3);
}