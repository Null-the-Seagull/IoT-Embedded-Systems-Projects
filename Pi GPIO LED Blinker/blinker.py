import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BOARD)
GPIO.setup(19, GPIO.OUT) #GPIO Board 19 is literal 'PIN 19' (or 'GPIO10')

# Circuit Setup:
#   GPIO Pin (designated above) to LED's '+' (long) terminal
#   GND Pin to Breadboards '-' line
#       Resistor from Breadboard '-' to LED's '-' (short) terminal

print "LED Blinker now beginning..."
print "Ctrl + C to Interrupt."
time.sleep(1)

try:
    while 1:
        #print "."
        GPIO.output(19, GPIO.HIGH)
        time.sleep(0.25)
        GPIO.output(19, GPIO.LOW)
        time.sleep(0.25)
except KeyboardInterrupt:
    GPIO.cleanup()
    