

#### 1. Product Hierarchy
```
Product (Abstract)
├── ExpirableProduct (Abstract)
│   ├── ShippableExpirableProduct (implements Shippable)
│   └── NonShippableExpirableProduct
└── NonExpirableProduct (Abstract)
    ├── ShippableNonExpirableProduct (implements Shippable)
    └── NonShippableNonExpirableProduct
```

#### 2. Key Classes
- **`Product`** - Abstract base class for all products
- **`ShoppingCart`** - Manages cart items and quantities
- **`Customer`** - Handles customer information and balance
- **`ECommerceSystem`** - Main system checkout process
- **`ShippingService`** - Processes shipments for physical items

#### 3. Interfaces
- **`Shippable`** - Contract for items that can be shipped
  - `String getName()`
  - `double getWeight()`

## Features

### ✅ Product Management
- **Multi-type Products**: Supports expirable/non-expirable and shippable/non-shippable combinations
- **Inventory Tracking**: Real-time stock quantity management
- **Expiry Validation**: Automatic expiry date checking
- **Weight Management**: Weight tracking for shipping calculations

### ✅ Shopping Cart
- **Add Products**: With quantity validation against available stock
- **Quantity Management**: Prevents overselling
- **Subtotal Calculation**: Automatic price calculation

### ✅ Checkout Process
- **Comprehensive Validation**:
  - Empty cart detection
  - Stock availability checking
  - Product expiry validation
  - Customer balance verification
- **Automatic Inventory Updates**: Reduces stock upon successful purchase
- **Shipping Integration**: Automatically ships physical items
- **Receipt Generation**: Detailed transaction summary

### ✅ Error Handling
- **Business Logic Validation**: Prevents invalid operations
- **Custom Exceptions**: Meaningful error messages
- **Graceful Degradation**: System continues operating after errors

## Usage Examples

### Basic Usage
```java

 shoppingCart cart = new shoppingCart();
cart.add(cheese, 1);
cart.add(tv, 1);
cart.add(scratchCard, 1);
cart.add(biscuits, 1);
EcommerceSystem system = new EcommerceSystem();
system.checkout(customer, cart);
```

### Expected Output
```
** Shipment notice **
1x Cheese 500g
1x TV 5000g
1x Biscuits 700g
Total weight 6.2kg
-------------------------------
** Checkout receipt **
1x Cheese 70
1x TV 1000
1x Mobile Scratch Card 100
1x Biscuits 20
-------------------------------
Subtotal 1190
Shipping 30
Amount 1220
Customer balance after payment: 8780.00
END.
```
### ScreenShots 
The Main to run the system
![Run from the Main]("Screenshots\MainFunction.png")

The output ofter runing the system
![The output1]("Screenshots\RunningProgram.png")


