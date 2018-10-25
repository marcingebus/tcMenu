/*
    The code in this file uses open source libraries provided by thecoderscorner

    DO NOT EDIT THIS FILE, IT WILL BE GENERATED EVERY TIME YOU USE THE UI DESIGNER
    INSTEAD EITHER PUT CODE IN YOUR SKETCH OR CREATE ANOTHER SOURCE FILE.

    All the variables you may need access to are marked extern in this file for easy
    use elsewhere.
 */

#include <tcMenu.h>
replacedInclude

// Global variable declarations
global vars
// Global Menu Item declarations
const PROGMEM AnalogMenuInfo minfoTest = { "test", 2, 4, 100, callback1, 0, 1, "dB" };
AnalogMenuItem menuTest(&minfoTest, 0, NULL);
const PROGMEM SubMenuInfo minfoSub = { "sub", 100, 0xffff, 0, NO_CALLBACK };
BackMenuItem menuBackSub(&menuTest, (const AnyMenuInfo*)&minfoSub);
SubMenuItem menuSub(&minfoSub, &menuBackSub, NULL);
const PROGMEM AnalogMenuInfo minfoTest = { "test", 1, 2, 100, NO_CALLBACK, 0, 1, "dB" };
AnalogMenuItem menuTest(&minfoTest, 0, &menuSub);
const char enumStrExtra_0[] PROGMEM = "test";
const char* const enumStrExtra[] PROGMEM  = { enumStrExtra_0 };
const PROGMEM EnumMenuInfo minfoExtra = { "Extra", 20, 4, 0, NO_CALLBACK, enumStrExtra };
EnumMenuItem menuExtra(&minfoExtra, 0, &menuTest);

// Set up code
void setupMenu() {
setup code}
