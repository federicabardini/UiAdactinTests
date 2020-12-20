# AdactIn UI Tests

## Prerequirements
- Maven installed
- Chrome installed
- At least one build configuration file available in the Resources Package, containing the build url as, for example:

    url.login=http://adactin.com/HotelApp/index.php

## How to run the tests
Write, through command line, the following command:

    ADACTIN_BUILD=build-buggy mvn test

where "build-buggy" is the build id as identified in the config properties file name, as for example:

    src/test/resources/it/fedeb/uiadactintests/config/config-build-buggy.properties