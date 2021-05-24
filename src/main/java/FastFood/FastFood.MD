## Fast Food Order Description

Our goal is to build an order of complex objects that can consist of one or more meals

### Order
*   an order is comprised of 
    *   customer name 
    *   one or more meals
    *   price

### Meal (Builder)
* a meal consists of zero or one
    *   sandwich
    *   side
    *   drink
    *   meal type
    
### Sandwich (Builder)
*   A sandwich consists of
    *   zero or one wrapping type
    *   zero or more protein type
    *   zero or more topping types
    *   zero or more condiment types
    *   a price
    
### Side (Builder)
*   A side consists of
    *   a side_type
    *   an item size
    *   zero or more condiment types
    
### Drink
*   a drink consists of
    *   a drink type
    *   an item size
    *   a drink modification