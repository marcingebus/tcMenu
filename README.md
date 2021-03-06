# tcMenu beta - An embedded menu system for Arduino

TcMenu is a full feature menu system for Arduino, that is modular enough to support different input types and displays;
it is currently under development so be careful before using in full production.

TcMenu is more than just an Arduino menu library, think of it as a framework for building IoT applications that provides
many useful abstractions and remote control capabilities, including the ability to render menus locally onto a display.

## Installation

There are pre-built packages for Windows and MacOS that include the Generator UI and the UI can copy over the libraries automatically. However, the embedded libraries are in the embedded directory in the above repository, and can be copied directly into the Arduino/libraries folder.

[Get a copy of the project from the releases page](https://github.com/davetcc/tcMenu/releases), it's available as an executable for Windows, a disk image for MacOS and also as a zip for any platform that can run Java 9 or above such as Linux, Windows or MacOS.

For using the Menu Generator on Linux, install a recent Java (tested on V10) with OpenJFX, and then take the application package instead of the dmg or exe file in the release. 

[UI user guide, getting started and other documentation](https://www.thecoderscorner.com/products/arduino-libraries/tc-menu/)

[Full API embedded documentation](https://www.thecoderscorner.com/ref-docs/tcmenu/html/index.html)

## The Java API

There is a java API for accessing the menu remotely, source includes JavaDoc to help getting started. There is an example JavaFX UI built with it within the above Repo. Include the following into your maven build file:

        <dependency>
            <groupId>com.thecoderscorner.tcmenu</groupId>
            <artifactId>tcMenuJavaAPI</artifactId>
            <version>1.0</version>
        </dependency>

## Major improvement to memory usage in V1.0

A major improvement in memory usage for Arduino Uno and other smaller boards. It reduces memory usage considerably for most cases, by as much as 40% in some case.

For most existing users, you'll just use the UI designer to remake your code from the saved designer file (the CPP and H file). Doing this will keep everything entact in your sketch. Any menu names will not change.

This is what will mean:

* No virtuals in the whole menuitem strucutre, although the signatures are near identical - infact the new signature is better, as it hides away the PROGMEM near completely.
* Removed the interface for the high level remote management, there was no need for it, it was just a cost.
* Removed the need to call menuItemChanged on menu manager, it's done automatically now.
* On smaller boards such as Uno, a reasonably sized menu with Serial and Ethernet now fits again.
* At the same time, the embedded code will be moved into a new project tcMenuArduino, tcMenuAdaGfx and tcMenuLiquidCrystal. This allows it to be installed by library managers once a bit more stable.
* Remote code will be moved into a separate set of files, included as needed, this will reduce the size for people not wanting remote capabilities, or wanting only Serial remote.
* If you previously used the RemoteListener, which was clunky to use, it's now replaced with a callback function that reports connections, disconnections and errors using a status type.
* RemoteMenuItem now allows for feedback of whos connected
* FloatMenuItem allows for read only floating point "status" values

## Types of input supported

* Button based rotary encoder emulation (Up, Down and OK buttons)
* Rotary encoder based input with no need any additional components in many cases.
* No local input facilities if your application is completely controlled remotely.

## Display types that are supported

* LiquidCrystal 20x4 or 16x2 displays - can be either directly connected, i2c or on a shift register.
* Adafruit_GFX - can render onto a display compatible with this library 

## Remote endpoints that are supported

* RS232 endpoint that supports full control of the menu items using a Java API - example app included.
* Ethernet endpoint that supports the Ethernet library specification.

## More information 

MenuItem's are mainly stored in program memory with a small amount of state in RAM. The system also supports loading and saving menu items to/from EEPROM storage. On AVR that will generally be internal EEPROM, on 32 bit boards generally an AT24 i2c EEPROM. 

## Getting started with tcMenu

You start a menu project either by using the provided user interface (recommended), or by coding a menu manually into a sketch. 

## Generating a menu from the UI

When working with menus in the UI, I normally save the menu file into a new sketch directory. The reason for this is
that the generator will generate the sketch for you once you've defined the menus. The Generator as of V0.4 is capable of round trip development too - most of the code is offloaded into a CPP and Header.

Once you've arranged your menu using the UI how you'd like it, choose Code -> ID & Eeprom analyser from the menu
to check that you've not got any overlapping ranges, then choose Code -> Generate from the menu, choose appropriate
hardware arrangements and hit generate.


