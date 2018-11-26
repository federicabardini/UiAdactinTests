# AdactIn UI Tests

## Prerequirements
- Maven installed
- Chrome installed
- Chrome driver installed and available in the PATH environment variable
- At least one build configuration file available in the Resources Package, containing the build url as, for example:

                url.login=http://adactin.com/HotelApp/index.php

## How to run the tests
Write, through command line, the following command:

                ADACTIN_BUILD=build1 mvn test

where build1 is the build id as identified in the properties file name, as for example:
                config-build2.properties