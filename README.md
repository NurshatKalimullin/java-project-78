### Hexlet tests and linter status:
[![Actions Status](https://github.com/NurshatKalimullin/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/NurshatKalimullin/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/d97a6d7ea71eb936e48e/maintainability)](https://codeclimate.com/github/NurshatKalimullin/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/d97a6d7ea71eb936e48e/test_coverage)](https://codeclimate.com/github/NurshatKalimullin/java-project-78/test_coverage)


java-project-78 is for runtime value parsing and validation by asserting the shape of an existing value.

StringSchema allows to check string values with following validatiors:
 - required – any not empty sctring
 - minLength – string length equal or greater than defined value
 - contains – string contains defined substring

NumberSchema allows to check numeric values with following validatiors:
 - required – any numeric including zero
 - positive – any numeric greater that zero
 - range – value has to be in the defined numeric range includig edges

MapSchema allows to check map values with following validatiors:
 - required – only Map data type
 - sizeof – number of key-value pairs has to be equal to defined dimention
 - shape - allows to define validation rules for key's values in Map object
