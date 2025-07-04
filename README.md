## Overview
- Define products with name, price, and quantity.

- Products can be: Expirable (with expiry check) / Shippable (with weight in kg) / Digital (like Scratch Cards)

- Cart System
    1- Add items to cart with a specific quantity.
    2- Prevent over-adding more than product stock.
    3- Support for:
        - Increasing item quantity.
        - Decreasing item quantity.
        - Removing items.
        - Updating item quantity.

- Shipping Logic
    1- Only shippable items are considered.
    2- Each item’s weight is summed.
    3- Shipping fees are calculated based on total weight.

- Checkout Process
Validates:
    1- Cart is not empty.
    2- No expired product.
    3- All products in stock.
    4- Customer has enough balance.
Deducts from balance.
Reduces product stock.

## Code Example

cart.add(cheese, 3);
cart.add(Biscuits, 2);
cart.add(card, 3);
checkout(customer, cart);


CONSOLE OUTPUT
** Shipment notice **
3x Cheese 500g
2x Biscuits 700g
Total package weight 2.9kg

** Checkout receipt **
3x Cheese 600
2x Biscuits 200
3x Scratch Card 150
----------------------
Subtotal 950
Shipping 29
Amount 979